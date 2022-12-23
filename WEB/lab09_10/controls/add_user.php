<?php
    include 'connect.php';
    $email = '';
    $user = '';
    $pass = '';
    
    if (isset($_POST['nameSignIn']) && isset($_POST['passSignIn']) && isset($_POST['email']))
    {
        $email = $_POST['email'];
        $user = $_POST['nameSignIn'];
        $pass = $_POST['passSignIn'];

        $sql = "SELECT COUNT(*) AS `count` FROM `account` where `username` = '$user' OR `email` = '$email'";
        $result = mysqli_query($conn,$sql);
        $result = mysqli_fetch_array($result);
        // print_r($result);
        $count = $result['count'];

        if (empty($email)) {
            $error = 'Please enter your email';
            header('Location: ../login.php');
        }
        else if (filter_var($email, FILTER_VALIDATE_EMAIL) == false) {
            $error = 'This is not a valid email address';
            header('Location: ../login.php');
        }
        else if (empty($user)) {
            $error = 'Please enter your username';
            header('Location: ../login.php');
        }
        else if (empty($pass)) {
            $error = 'Please enter your password';
            header('Location: ../login.php');
        }
        else if (strlen($pass) < 6) {
            $error = 'Password must have at least 6 characters';
            header('Location: ../login.php');
        }
        else {
            if($count == 1){
                $error = 'Eror: Duplicate email or user';

                header('Location: ../login.php');
            }else{
                echo "ok";
                $sql = "INSERT INTO `account` (`username` , `email`, `password`) VALUES ('$user', '$email', '$pass')";
                mysqli_query($conn, $sql);
                session_start();
                $_SESSION['user'] = $user;
                header('Location: ../login.php');
                $conn->close(); 
                exit();
            }
        }
    }
?>