<?php
include "./controls/query.php";
$error = '';

$user = '';
$pass = '';

session_start();
if (isset($_SESSION['user'])) {
    header('Location: index.php');
    exit();
}

if (isset($_POST['nameLogin']) && isset($_POST['passLogin'])) {
$user = $_POST['nameLogin'];
$pass = $_POST['passLogin'];

$sql = "SELECT COUNT(*) AS `count`, email  FROM `account` where `username` = '$user' AND `password` = '$pass'";
// $sql = "SELECT * FROM `account` Where `user`";
$result = mysqli_query($conn, $sql);
// $result = $conn->query($sql);
$result = $result->fetch_array();   
// print_r($result);
$count = $result[0];
$name = $result[1];
// echo $count . $name;
$conn->close();
if (empty($user)) {
  $error = 'Please enter your username';
}
else if (empty($pass)) {
  $error = 'Please enter your password';
}
else if (strlen($pass) < 6) {
  $error = 'Password must have at least 6 characters';

}else if($count == 1){
          $_SESSION['user'] = $user;
          $_SESSION['name'] = $name;
          // echo "ok";
          header('Location: index.php');
          $conn->close(); 
          exit();
}else {
  $error = 'Invalid username or password';
}
}

    
?>

<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Flat HTML5/CSS3 Login Form</title>
  
  
  
      <link rel="stylesheet" href="css/style.css">

  
</head>

<body>
  <div class="login-page">
  <div class="form">
    <form class="register-form" method="post" action="./controls/add_user.php">
      <input type="text" placeholder="name" name="nameSignIn" />
      <input type="password" placeholder="password" name="passSignIn" />
      <input type="text" placeholder="email address" name="email"/>
      <button>create</button>
      <p class="message">Already registered? <a href="#">Sign In</a></p>
    </form>
    <form class="login-form" method="post" action="">
      <input type="text" placeholder="username" name= "nameLogin"/>
      <input type="password" placeholder="password" name="passLogin"/>
      <button>login</button>
      <p class="message">Not registered? <a href="#">Create an account</a></p>
    </form>
  </div>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script  src="js/index.js"></script>

</body>
</html>
