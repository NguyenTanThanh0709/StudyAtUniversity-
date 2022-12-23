<?php 
session_start();
if(!isset($_SESSION['diem']))
    $_SESSION['diem'] = 0;

if(isset($_POST['submit']) && !empty($_POST['submit'])){
    $A = $_POST['soA'];
    $phepTinh = $_POST['phepTinh'];
    $B = $_POST['soB'];
    $C = $_POST['soC'];
    $C = (float)$C;
    if($phepTinh == "+" && ($A + $B == $C)){
        $_SESSION['diem'] += 10;
    } elseif ($phepTinh == "-" && ($A - $B == $C)){
        $_SESSION['diem'] += 10;
    } elseif ($phepTinh == "*" && ($A * $B == $C)){
        $_SESSION['diem'] += 10;
    } elseif ($phepTinh == "/" ){
        if($B == 0){
            $B = 0.1;
        }
        if(($A / $B == $C)){
            $_SESSION['diem'] += 10;
        }else{
        $_SESSION['diem'] -= 5;
        }
    }else{
        $_SESSION['diem'] -= 5;
    }
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form method="post">

    A:<input type="number" name = "soA" value = "<?php echo rand(0,3)?>">

    <input type="text" name = "phepTinh"
    value = "<?php
        $phepTinh1 = rand(1,4);
        if($phepTinh1 == 1 ){
            echo "+";
        }elseif ($phepTinh1 == 2){
            echo "-";
        }elseif ($phepTinh1 == 3){
            echo "*";
        }elseif ($phepTinh1 == 4){
            echo "/";
        }
    ?>"
    > 

    B: <input type="number" name = "soB" value = "<?php echo rand(0,3)?>"> 

    =C:<input type="text" name = "soC">

    <div>
        <?php 
            echo $_SESSION['diem']
        ?>
    </div>
    <input type="submit" name="submit" value="submit">
    </form>
</body>
</html> 