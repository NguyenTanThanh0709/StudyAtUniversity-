<?php
    $nameFile = "";
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        if(isset($_POST['rename']) && isset($_POST['newname'])){
            $nameFile = $_POST['rename'];
            $newName = $_POST['newname'];
            $nest = getcwd() . "./upload/" . $nameFile;
            $nestNew = getcwd() . "./upload/" . $newName;
            /* Rename File name */
            if( !rename($nest, $nestNew) ) {  
                echo "File can't be renamed!";  
            }  
            else {  
                echo "File has been renamed!";  
            } 
            header("Location:index.php");
        }
      }

?>