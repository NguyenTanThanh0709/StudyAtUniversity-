<?php
$serverName = "localhost";
$useName = "root";
$password = "";

$conn = new mysqli($serverName, $useName, $password);
if($conn->connect_error){
    die("Connection failed " . $conn->connect_error);
}else{
    // echo "Connection successfully" . "<br>\n";
}

$conn->set_charset("utf8mb4");

try {
    $sql = "CREATE DATABASE online_marketing";
    if ($conn->query($sql) === TRUE) {
    //   echo "Database created successfully" . "<br>\n";
    } else {
    //   echo "Error creating database: " . $conn->error . "<br>\n";
    }
  } catch (\Throwable $th) {
    // echo "database exists" . "<br>\n";
  }
  
  $sql = "USE online_marketing";
  if (mysqli_query($conn, $sql)) {
    // echo "Use database successlly" . "<br>\n" ;
  } else {
    // echo "Error use database: " . mysqli_error($conn) . "<br>\n";
  }
