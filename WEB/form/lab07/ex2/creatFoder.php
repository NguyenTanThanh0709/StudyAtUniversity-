<?php
    $nameFile = "";
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        if(isset($_POST['folder'])){
            $nameFile = $_POST['folder'];
            $nest = getcwd() . "./upload/" . $nameFile;
            // creating a nested structure directory
            if (!mkdir($nest, 0777, true)) 
            {
                echo('Folders cannot be created recursively');
            }
            else
            {
                echo('Folders created recursively');
                header("Location:index.php");
            }
        }
      }

?>