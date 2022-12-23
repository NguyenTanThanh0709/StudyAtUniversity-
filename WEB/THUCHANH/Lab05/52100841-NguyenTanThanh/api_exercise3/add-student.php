<?php
    require_once ('connection.php');

    if (!isset($_POST['name']) || !isset($_POST['email']) || !isset($_POST['phone'])) {
        die(json_encode(array('status' => false, 'data' => 'Parameters not valid')));
    }

    $name = $_POST['name'];
    $email = $_POST['email'];
    $phone = $_POST['phone'];

    $sql = "INSERT INTO student (name,email,phone)
    VALUES ('$name', '$email', '$phone')";

if (!empty($name) || !empty($email) || !empty($phone) ) {
    if(mysqli_query($connect, $sql)){
        echo "Thêm dữ liệu thành công";
    }else {
        echo "Error: " . $sql . "<br>" . mysqli_error($connect);
    }
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($connect);
}

mysqli_close($connect);
