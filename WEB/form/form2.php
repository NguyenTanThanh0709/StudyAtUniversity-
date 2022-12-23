<?php
$address = $hour_working =  "";
$name = $email = $desEXP = $nameWorking = $tech = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
   $name = $_POST['name'];
   $email = $_POST['email'];
   $desEXP = $_POST['desEXP'];
   
   if(isset($_POST['nameWorking'])){
    $nameWorking = $_POST['nameWorking'];
   }
   
   if(isset($_POST['tech'])){
    $tech = $_POST['tech'];
   }else{
    $tech = array();
   }
   
   if(isset($_POST['address'])){
    $address = $_POST['address'];
   }
   
   if(isset($_POST['hourworking'])){
    $hour_working = $_POST['hourworking'];
   }else{
    $hour_working = array();
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
    <table class="table table-hover">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Describe your working experience</th>
            <th>Vị trí ứng tuyển:</th>
            <th>Công nghệ bạn yêu thích:</th>
            <th>Nơi làm việc</th>
            <th>bạn làm việc được vào giờ nào</th>
        </tr>
        <tr>
            <td> <?php echo $name ?> </td>
            <td> <?php echo $email ?> </td>
            <td> <?php echo $desEXP ?> </td>
            <td> <?php echo $nameWorking ?> </td>
            <td> <?php 
                foreach($tech as $each){
                    echo $each . ". ";
                }
            ?> </td>
            <td> <?php echo $address ?> </td>
            <td> <?php foreach($hour_working as $each){
                    echo $each . ". ";
                } ?> </td>
        </tr>
    </table>
</body>
</html>