<?php
require_once ('connection.php');

if (!isset($_POST['id']) || !isset($_POST['name']) || !isset($_POST['email']) || !isset($_POST['phone'])) {
    die(json_encode(array('status' => false, 'data' => 'Parameters not valid')));
}

$id = $_POST['id'];
$name = $_POST['name'];
$email = $_POST['email'];
$phone = $_POST['phone'];

$sql = "UPDATE student set name = '$name', email = '$email', phone = '$phone' where id = '$id'";

$sql1 = "SELECT COUNT(*) as number FROM student where id = '$id'";
$result = mysqli_query($connect, $sql1);
$each = mysqli_fetch_array($result);

if($each['number'] != 0){

    if (!empty($name) || !empty($email) || !empty($phone) ) {
        if(mysqli_query($connect, $sql)){
            echo "update dữ liệu thành công";
        }else {
            echo "Error: " . $sql . "<br>" . mysqli_error($connect);
        }
    } else {
        echo "Error: " . $sql . "<br>" . mysqli_error($connect);
    }
   
}else{
    echo ".  cant update: " . $id . " not in student id!";
}
mysqli_close($connect);

