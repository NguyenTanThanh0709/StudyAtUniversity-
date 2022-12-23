<?php
require_once ('connection.php');

$id = $_POST['id'];

$sql = "DELETE FROM student where id = '$id'";
$sql1 = "SELECT COUNT(*) as number FROM student where id = '$id'";
$result = mysqli_query($connect, $sql1);
$each = mysqli_fetch_array($result);
echo "id: " . $id . ". ";


if($each['number'] != 0){
    if (!empty($id) ) {
        if(mysqli_query($connect, $sql)){
            echo "Delete OK";
        }else {
            echo "Error: " . $sql . "<br>" . mysqli_error($connect);
        }
    } else {
        echo "Error: " . $sql . "<br>" . mysqli_error($connect);
    }
}else{
    echo ".  cant delete: " . $id . " not in student id!";
}
mysqli_close($connect);

