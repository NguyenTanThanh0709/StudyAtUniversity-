<?php

$db = new mysqli("localhost","root","","");
if ($db->connect_errno){
    // echo "Failed to connect to MySQL: " . $db->connect_error . "<br>";
    die();
}else{
    // echo "Connect localhost successfullly" . "<br>";
}

$db->set_charset("utf8mb4");

try {
  $sql = "CREATE DATABASE MYDATABASE";
  if ($db->query($sql) === TRUE) {
    // echo "Database created successfully" . "<br>";
  } else {
    // echo "Error creating database: " . $db->error . "<br>";
  }
} catch (\Throwable $th) {
  // echo "database exists" . "<br>";
}

$sql = "USE MYDATABASE";
if (mysqli_query($db, $sql)) {
  // echo "Use database successlly" . "<br>" ;
} else {
  // echo "Error use database: " . mysqli_error($db) . "<br>";
}



try {

  $sql = "CREATE TABLE account (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email VARCHAR(50),
    HoTen VARCHAR(30) NOT NULL,
    GioiTinh VARCHAR(30) NOT NULL,
    NgaySinh varchar(50)
    )";
  
    // use exec() because no results are returned
    if (mysqli_query($db, $sql)) {
      // echo "Table account  created successfully" . "<br>";
    } else {
      // echo "Error creating table: " . mysqli_error($db) . "<br>";
    }

} catch (\Throwable $th) {
  // echo "table exists" . "<br>";
}

// try {
//   $sql = "INSERT INTO account (id,Email, HoTen, GioiTinh, NgaySinh)
// VALUES (1,'john@example.com', 'Doe bumbe', 'male', '01/01/2003')";

// if (mysqli_query($db, $sql)) {
//   // echo "New record created successfully" . "<br>";
// } else {
//   // echo "Error: " . $sql . "<br>" . mysqli_error($db) . "<br>";
// }

// $sql = "INSERT INTO account (id,Email, HoTen, GioiTinh, NgaySinh)
// VALUES (2,'hung@example.com', 'hung bumbe', 'male', '11/011/2003')";

// if (mysqli_query($db, $sql)) {
//   // echo "New record created successfully" . "<br>";
// } else {
//   // echo "Error: " . $sql . "<br>" . mysqli_error($db) . "<br>";
// }

// $sql = "INSERT INTO account (id,Email, HoTen, GioiTinh, NgaySinh)
// VALUES (3,'hanh@example.com', 'hanh bumbe', 'female', '011/012/2003')";

// if (mysqli_query($db, $sql)) {
//   // echo "New record created successfully" . "<br>";
// } else {
//   // echo "Error: " . $sql . "<br>" . mysqli_error($db) . "<br>";
// }
// } catch (\Throwable $th) {
// // echo "du roi" . "<br>";
// }


// THÊM
if(isset($_POST["add"]) && $_SERVER["REQUEST_METHOD"] == "POST"){
  if(!isset($_POST["id"]) || !isset($_POST["email"]) || !isset($_POST["name"])|| !isset($_POST["gender"])||!isset($_POST["birthday"])){
    die();
  }else{
    $id = $_POST['id'];
    $email = $_POST["email"];
    $name = $_POST["name"];
    $gender = $_POST["gender"];
    $birthday = $_POST["birthday"];
    $result = mysqli_query($db, "SELECT COUNT(*) AS `count` FROM `account` where `id` = $id");
    $row = mysqli_fetch_array($result);
    $count = $row['count'];
    $tempCount = $count + 1;
    // echo $tempCount;
    if($tempCount == 1){
      $sql = "INSERT INTO `account` (id,Email, HoTen, GioiTinh, NgaySinh) VALUES ('$id', '$email', '$name', '$gender', '$birthday')";
       mysqli_query($db, $sql);
header("Location:account.html");

    }
  }
}

// XÓA
if(isset($_POST["delete"]) && $_SERVER["REQUEST_METHOD"] == "POST"){
  if(isset($_POST["xoa"])){
    $id = $_POST['xoa'];
    $sql  = "DELETE FROM account WHERE id='$id'";
    mysqli_query($db, $sql);
    header("Location:account.html");
    
  }
}

// UPDATE
if(isset($_POST["update"]) && $_SERVER["REQUEST_METHOD"] == "POST"){
  $id = $_POST['id'];
  $email = $_POST["email"];
  $name = $_POST["name"];
  $gender = $_POST["gender"];
  $birthday = $_POST["birthday"];
  
  $sql = "UPDATE account SET Email='$email' 
                  WHERE id='$id'";
  mysqli_query($db, $sql);
  $sql = "UPDATE account SET HoTen='$name' 
                  WHERE id='$id'";
  mysqli_query($db, $sql);
  $sql = "UPDATE account SET GioiTinh='$gender' 
                  WHERE id='$id'";
  mysqli_query($db, $sql);
  $sql = "UPDATE account SET NgaySinh='$birthday' 
                  WHERE id='$id'";
  mysqli_query($db, $sql);

  header("Location:account.html");  
}



header("Content-Type:application/json");
$res = $db->query("select * from account");
$account = [];
while($r = $res->fetch_assoc()){
    $account[] = ["id"=>$r["id"],"email"=>$r["Email"],"hoten"=>$r["HoTen"],"gioitinh"=>$r["GioiTinh"],"ngaysinh"=>$r["NgaySinh"]];
}
$json_response = json_encode($account);
echo $json_response;

$db->close(); 
//các thao tác: thêm, xóa, sửa

?>