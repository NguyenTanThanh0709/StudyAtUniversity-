<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<style>


    .A{
        background-color: blue;
        color: black;
    }

    .B{
        background-color: green;
        color: black;
    }

    .C{
        background-color: yellow;
        color: black;
    }

    tr:hover{
        background-color:pink !important;
        color: white !important;
    }
</style>


<table border="1" cellpadding="10" cellspacing="10" style="border-collapse: collapse; width:  300px; margin: auto">
    <?php $count = 1;    ?>
    <?php for($i = 1; $i <= 20; $i++){ 
    if($count === 4){
        $count = 1;
    }     
    ?>
        <tr class="<?php 
            if($count === 1){
                echo "A";
            }elseif ($count === 2){
                echo "B";
            }elseif ($count === 3){
                echo "C";
            }
        ?>">
        <td><?php echo $i; ?></td>
        <?php for($j = 1; $j <= 5; $j++){ ?>
            <td><?php echo "Sinh Viên " . $i . "_" . $j;  ?></td>
        <?php }?>
    </tr>
    
    <?php 
    ++$count;
    }     
    ?>
</table>


<table border="1" cellpadding="10" cellspacing="10" style="border-collapse: collapse; width:  300px; margin: auto">
    <?php $count = 1;
    $img = array("green", "blue", "yellow");    ?>
    <?php for($i = 1; $i <= 15; $i++){ 
        $indexColor = $i % 3;
    ?>
        <tr class="hoverr" style="background-color: <?php echo $img[$indexColor]; ?>; color:black;">
        <td><?php echo $i; ?></td>
        <?php for($j = 1; $j <= 3; $j++){ ?>
            <td><?php echo "Sinh Viên " . $i . "_" . $j;  ?></td>
        <?php }?>
    </tr>
    <?php 
    }     
    ?>
</table>

</body>
</html>