<?php

$name = $email = $gender = $os =  "enter your input";
$search = array();

if ($_SERVER["REQUEST_METHOD"] == "POST") {

   $os = $_POST['OS'];

   if(!empty( $_POST['yourname'])){
    $name = $_POST['yourname'];
   }

   if(!empty( $_POST['email'])){
    $email = $_POST['email'];
   }

   if(isset( $_POST['gender'])){
    $gender = $_POST['gender'];
   }

   if(isset( $_POST['name'])){
    $name = $_POST['name'];
   }


   if(isset($_POST['search'])){
    $search = $_POST['search'];
   }else{
    $search = array();
   }

}

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <title>Document</title>
</head>
<body>
<table class="table table-hover table-bordered">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Favorite web browsers</th>
        <th>Prefered Operating System</th>
    </tr>
    <tr>
        <td> <?php echo $name ?> </td>
        <td> <?php echo $email ?> </td>
        <td> <?php echo $gender ?> </td>
        <td> <?php foreach($search as $each){
                    echo $each . " <br>";
                } ?> </td>
        <td> <?php echo $os ?> </td>
    </tr>
</table>
</body>
</html>