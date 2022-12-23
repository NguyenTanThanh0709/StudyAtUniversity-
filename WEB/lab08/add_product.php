<?php
    include 'connect.php';
    $error = '';
    $name = '';
    $price = '';
    $desc = '';
    $img = '';

    if(isset($_POST["add"]) && $_SERVER["REQUEST_METHOD"] == "POST"){

    if (isset($_POST['name']) &&isset($_POST['name']) && isset($_POST['price']) && isset($_POST['desc']))
    {
        $id = $_POST['id'];
        $name = $_POST['name'];
        $price = $_POST['price'];
        $desc = $_POST['desc'];
        if (empty($name)) {
            $error = 'Hãy nhập tên sản phẩm';
        }else if (intval($id) <= 0) {
            $error = 'id sản phẩm không hợp lệ';
        }
        else if (intval($price) <= 0) {
            $error = 'Giá của sản phẩm không hợp lệ';
        }
        else if (intval($price) < 1000000) {
            $error = 'Giá sản phẩm phải trên 1,000,000đ và là bội số của 10,000 đ';
        }
        else if (empty($desc)) {
            $error = 'Hãy nhập mô tả của sản phẩm';
        }
        else if ($_FILES['file']['error'] != UPLOAD_ERR_OK) {
            $error = 'Vui lòng upload ảnh của sản phẩm';
        }
        else {
            $img = $_FILES["file"]["name"];
            $img = 'images/' . $img;
            // echo $id . $name . $price . $desc . $img;
            $sql = "INSERT INTO `product` (`id`, `name`, `price`, `description`, `image`) VALUES ('$id','$name', '$price', '$desc','$img')";
            try {
                mysqli_query($conn, $sql);
                header("Location:index.php");  
            } catch (\Throwable $th) {
                // echo "error insert: maybe duplicate id";
                // <a href = "index.php">'click me de quay lai'</a>
                header("Location:index.php");  
            }
        }
    }
}

// UPDATE
if(isset($_POST["update"]) && $_SERVER["REQUEST_METHOD"] == "POST"){
    $id = $_POST['idupdate'];
    $name = $_POST['nameupdate'];
    $price = $_POST['priceupdate'];
    $desc = $_POST['descupdate'];
    $img = $_FILES["file"]["name"];
    $img = 'images/' . $img;

    $sql = "UPDATE product SET `name` ='$name' 
                    WHERE id='$id'";
    mysqli_query($conn, $sql);
    $sql = "UPDATE product SET price ='$price' 
                    WHERE id='$id'";
    mysqli_query($conn, $sql);
    $sql = "UPDATE product SET `description` ='$desc' 
                    WHERE id='$id'";
    mysqli_query($conn, $sql);
    $sql = "UPDATE product SET `image` ='$img' 
                    WHERE id='$id'";
    mysqli_query($conn, $sql);
  
    header("Location:index.php");  
  }

  // delete
  if(isset($_POST["delete"]) && $_SERVER["REQUEST_METHOD"] == "POST"){
    $id = $_POST['iddelete'];
    $sql  = "DELETE FROM product WHERE id='$id'";
    mysqli_query($conn, $sql);  
    header("Location:index.php");  
  }


header("Content-Type:application/json");
$res = $conn->query("select * from product");
$account = [];
while($r = $res->fetch_assoc()){
    $account[] = ["id"=>$r["id"],"name"=>$r["name"],"price"=>$r["price"],"description"=>$r["description"],"image"=>$r["image"]];
}
$json_response = json_encode($account);
echo $json_response;

$conn->close(); 

?>

