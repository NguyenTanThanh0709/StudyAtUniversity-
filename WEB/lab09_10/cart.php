<?php

include "./modals/cart.php";
include "./controls/connect.php";

if(isset($_GET['button_card'])){
    if(isset($_GET['id'])){
        $id = (int) $_GET['id'];
        try {
            $sql = "DELETE  FROM  `cart` where `id` = '$id';";
          if (mysqli_query($conn, $sql)) {
            // echo "Insert account  successfully" . "<br>\n";
          } else {
            // echo "Error account  Insert product " . mysqli_error($conn) . "<br>\n";
          }
          $sql = "DELETE  FROM  `bill` where `id` = '$id';";
          if (mysqli_query($conn, $sql)) {
            // echo "Insert account  successfully" . "<br>\n";
          } else {
            // echo "Error account  Insert product " . mysqli_error($conn) . "<br>\n";
          }
        } catch (\Throwable $th) {
            // echo "error insert account" .  "<br>\n";
        }

    }
  }

$arraylist = array();
$res = $conn->query("select * from cart");
$result = $res->fetch_all();

foreach ($result as $value) {
    $product = new cart($value[0],$value[1],$value[2],$value[3],$value[4]);
    array_push($arraylist, $product);
  }


  

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<style>

</style>
<div class="container">
    <h2>Giỏ hàng</h2>

    <table class="table table-striped">
        <thead>
        <tr>
            <td colspan="7">
                <a href="index.php" class="btn btn-primary">Tiếp tục mua hàng</a>
            </td>
        </tr>
        <tr>
            <th>Ảnh</th>
            <th>ID</th>
            <th>Tên sản phẩm</th>
            <th>Số lượng</th>
            <th>Giá</th>
            <th>Thành tiền</th>
            <th>Xóa</th>
        </tr>
        </thead>
        <tbody>
        <?php foreach($arraylist as $value){?>
            <tr>

            <td><img src="<?php echo $value->image;?>" style="max-height: 50px"></td>
            <td><?php echo $value->id;?></td>
            <td id="name"><?php echo $value->name;?>"</td>
            <td><input type="number" value="1"  id="soLuong" class="soLUONG"></td>
            <td><p ><?php echo $value->price;?></p></td>
            <td class = "total"><?php echo $value->price;?></td>
            <td>
                <form method="get" action="">
                      <input type="submit" value="xoa" name = "button_card"  class="btn btn-danger"/>
                      <input type="hidden" value="<?php echo $value->id; ?>" name = "id" />
                    </form>
            </td>
        </tr>
        <?php } ?>
        


        <tr>
            <td colspan="7" style="text-align: right">
            <button type="button" id="seebill" class="btn btn-primary" data-toggle="modal" data-target="#myModal1" >See bill</button>
            <button type="button" id="_thanhtoan" class="btn btn-danger" data-toggle="modal" data-target="#myModal" >Thanh toán</button>

            </td>
            
        </tr>
        </tbody>
    </table>
</div>



<!-- Delete Confirm Modal -->
    <div id="myModal" class="modal fade" role="dialog">
        <div class="modal-dialog">

     
            <div class="modal-content">
                <div class="modal-header">
                    <hp class="modal-title">Thanh Toán Sản Phẩm</hp>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Bạn có chắc rằng muốn Thanh Toán hết Sản phẩm với số tiền  <span id = 'thanhtoan'></span> ?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <form action = "add_product.php", method = 'post'> 
                        <a href = "index.php" class="btn btn-danger" name="ok">ok</a>
                    </form>
                </div>

            </div>

        </div>
    </div>

    <div id="myModal1" class="modal fade" role="dialog">
        <div class="modal-dialog">

     
            <div class="modal-content">
                <div class="modal-header">
                    <hp class="modal-title">Giỏ Hàng</hp>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <table class="table table-striped">
                    <tr>
            
            <th>Tên sản phẩm</th>
            <th>Số lượng</th>
            <th>tổng</th>
            
        </tr>
                    <?php foreach($arraylist as $value){?>
                    <tr>

                    <td><?php echo $value->name;?>"</td>
                    <td><span class="item_see_bill"></span></td>
                    <td class = " 1item_see_bill"></td>
                    
                </tr>
                <?php } ?>
                    </table>
                    <tr>Tổng tiền cần thanh toán: <span id="tong_thanhToan_">$ </span></tr>
                    <br>
                    <tr>Ngày mua hàng: <?php
                    $mydate=getdate(date("U"));
                    echo "$mydate[weekday], $mydate[month] $mydate[mday], $mydate[year]";
                    ?></tr>
                
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <br>
                    <form action = "export.php", method = 'post'> 
                        <button  class="btn btn-danger" name="ok">Print Bill (export pdf bill)</button>
                    </form>
                </div>

            </div>

        </div>
    </div>


<script>
    $(document).ready(function(){
        $('input[type=number]').change(function(){
            let curr = $(this);
            if(curr.val() < 0){
                curr.val(0)
            }
            let count = curr.val();
            let price = curr.parent().siblings().children().text()*1;

            let toltal = curr.parent().siblings()[4].innerHTML = price * count;
            

        });

        // let tongtien  = $('.total');
        // var tong = 0;
        // for(let i = 0; i < tongtien.length; i++){
         
        //     tong = tong + tongtien[i].innerText*1

        // }
        //     console.log(tong);
        //     $('#thanhtoan')[0].innerText= tong;
        //     $('tong_thanhToan').innerText = tong;
        $('#_thanhtoan').click(function(){
                let tongtien  = $('.total');
            var tong = 0;
            for(let i = 0; i < tongtien.length; i++){
            
                tong = tong + tongtien[i].innerText*1

            }
                console.log(tong);
                $('#thanhtoan')[0].innerText= tong;
                // $('tong_thanhToan').innerText = tong;
        });

        $('#seebill').click(function(){
            let tongtien  = $('.total');
            var tong = 0;
            for(let i = 0; i < tongtien.length; i++){
            
                tong = tong + tongtien[i].innerText*1

            }
            
            $('#tong_thanhToan_')[0].innerText= tong;
            let soluong = $('.soLUONG')
            let soLuong_bill = $('.item_see_bill');
            for(let i = 0; i < soluong.length; i++){
                soLuong_bill[i].innerText = soluong[i].value;

            }

            let tien = $('.1item_see_bill');
            let tongtien1  = $('.total');

            for(let i = 0; i < soluong.length; i++){
                tien[i].innerText = tongtien1[i].innerText;

            }
        });


    });

</script>
</body>
</html>