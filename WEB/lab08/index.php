<?php
    session_start();
    if (!isset($_SESSION['user'])) {
        header('Location: login.php');
        exit();
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Trang chủ - Danh sách sản phẩm</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

    <style>
        body{
            padding-top: 50px;
        }
        table{
            width: 80%;
            text-align: center;
        }
        td{
            padding: 10px;
        }
        tr.item{
            border-top: 1px solid #5e5e5e;
            border-bottom: 1px solid #5e5e5e;
        }

        tr.item:hover{
            background-color: #d9edf7;
        }

        tr.item td{
            min-width: 150px;
        }

        tr.header{
            font-weight: bold;
        }

        a{
            text-decoration: none;
        }
        a:hover{
            color: deeppink;
            font-weight: bold;
        }

        td img {
            max-height: 100px;
        }
    </style>


    <script>

        function get_accounts(){
            $.ajax({
                url: 'add_product.php',
                dataType: 'json',
                type: "GET",
                success: function (data) {
                    data = 
                    show_data(data);
                },
                error: function (error) {
                    console.log(error)
                }
            })
        }
        function show_data(data){
            let tbody = $('#tbdata > tbody')
            for(let i=0;i<data.length;i++){
                let row = data[i]
                let tr = `        <tr class="item">
                <td>${row.id}</td>
            <td><img src="${row.image}"></td>
            <td>${row.name}</td>
            <td>${row.price}</td>
            <td>${row.description}</td>
            <td><button href="" id="${row.id}" data-toggle="modal" data-target="#update-dialog" onclick="Update(this)">Edit</button> | 
                <form action = "add_product.php" method = 'post'>
                    <input value="${row.id}" name="iddelete" required class="form-control" type="hidden" placeholder="So id san pham" id="iddelete">
                    <input type="submit" value="delete" name="delete" ">
                </form>
            </td>
        </tr>`
                tbody.append(tr)
            }
        }
        $(function(){
            get_accounts()
        })



        $(document).ready(function () {
            $(".delete").click(function () {

                $('#myModal').modal({
                    backdrop: 'static',
                    keyboard: false
                });
            });
        });
    </script>


    <table id="tbdata" cellpadding="10" cellspacing="10" border="0" style="border-collapse: collapse; margin: auto">
        <thead>
            <tr class="control" style="text-align: left; font-weight: bold; font-size: 20px">
                <td colspan="4">
                    <a href="" data-toggle="modal" data-target="#add-dialog">Thêm sản phẩm</a>
                </td>
                <td class="text-right">
                    <a href="logout.php">Đăng xuất</a>
                </td>
            </tr>
        </thead>
        <tbody>

        </tbody>
        <!-- <tr class="control" style="text-align: right; font-weight: bold; font-size: 17px">
            <td colspan="5">
                <p>Số lượng sản phẩm: 2</p>
            </td>
        </tr> -->
    </table>


    <!-- New  dialog -->
    <div class="modal fade" id="add-dialog" class="modal-body" >
        <div class="modal-dialog">
        <div class="modal-content">
        
            <div class="modal-header">
            <h4 class="modal-title">Thêm Sản Phẩm</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <form class="" action = "add_product.php", method = 'post' enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="id">Tên sản phẩm</label>
                        <input value="" name="id" required class="form-control" type="number" placeholder="So id san pham" id="id">
                    </div>
                    <div class="form-group">
                        <label for="name">Tên sản phẩm</label>
                        <input value="" name="name" required class="form-control" type="text" placeholder="Tên sản phẩm" id="name">
                    </div>
                    <div class="form-group">
                        <label for="price">Giá bán</label>
                        <input value="" name="price" required class="form-control" type="number" placeholder="Giá bán" id="price">
                    </div>
                    <div class="form-group">
                        <label for="desc">Mô tả</label>
                        <textarea id="desc" name="desc" rows="4" class="form-control" placeholder="Mô tả"> </textarea>
                    </div>
                    <div class="form-group">
                        <div class="custom-file">
                            <input name="file" type="file" class="custom-file-input" id="customFile" accept="image/gif, image/jpeg, image/png, image/bmp">
                            <label class="custom-file-label" for="customFile">Ảnh minh họa</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <input type="submit" value="add" name="add" class="btn btn-primary">
                    </div>
            </form>
            </div>
        </div>
        </div>


    <!-- Delete Confirm Modal -->
    <!-- <div id="myModal" class="modal fade" role="dialog">
        <div class="modal-dialog">

     
            <div class="modal-content">
                <div class="modal-header">
                    <hp class="modal-title">Xóa sản phẩm</hp>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Bạn có chắc rằng muốn xóa <strong>iPhone XS MAX</strong> ?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <form action = "add_product.php", method = 'post'> 
                        <button type="submit" class="btn btn-danger" name="delete">Xóa</button>
                    </form>
                </div>

            </div>

        </div>
    </div> -->


     <!-- edit  dialog -->
     <div class="modal fade" id="update-dialog" class="modal-body" >
        <div class="modal-dialog">
        <div class="modal-content">
        
            <div class="modal-header">
            <h4 class="modal-title">Chỉnh Sửa Sản Phẩm</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <form class="" action = "add_product.php", method = 'post' enctype="multipart/form-data">
                    <div class="form-group">
                        <input value="" name="idupdate" required class="form-control" type="hidden" placeholder="So id san pham" id="idupdate">
                    </div>
                    <div class="form-group">
                        <label for="name">Tên sản phẩm</label>
                        <input value="" name="nameupdate" required class="form-control" type="text" placeholder="Tên sản phẩm" id="nameupdate">
                    </div>
                    <div class="form-group">
                        <label for="price">Giá bán</label>
                        <input value="" name="priceupdate" required class="form-control" type="number" placeholder="Giá bán" id="priceupdate">
                    </div>
                    <div class="form-group">
                        <label for="desc">Mô tả</label>
                        <textarea id="descupdate" name="descupdate" rows="4" class="form-control" placeholder="Mô tả"> </textarea>
                    </div>
                    <div class="form-group">
                        <div class="custom-file">
                            <input name="file" type="file" class="custom-file-input" id="customFileupdate" accept="image/gif, image/jpeg, image/png, image/bmp">
                            <label class="custom-file-label" for="customFile">chon anh khac di</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <input type="submit" value="update" name="update" class="btn btn-primary">
                    </div>
            </form>
            </div>
        </div>
        </div>

    <script>
    // Add the following code if you want the name of the file appear on select
    $(".custom-file-input").on("change", function() {
        var fileName = $(this).val().split("\\").pop();
        $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
    });

    function Update(element){
                let updateID = element.id;
                
                $("#idupdate").val(updateID);
                let parent = $(element).parent();
                let siblings = parent.siblings();
                // console.log(siblings[2].innerText);
                // console.log(siblings[3].innerText);
                // console.log(siblings[4].innerText);

                $("#nameupdate").val(siblings[2].innerText);
                $("#priceupdate").val(siblings[3].innerText);
                $("#descupdate").val(siblings[4].innerText);
            
            }

    </script>

</body>
</html>