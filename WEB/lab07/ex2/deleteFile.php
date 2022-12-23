<?php
    $nameFile = "";
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        if(isset($_POST['delete'])){
            $nameFile = $_POST['delete'];
            $nest = getcwd() . "./upload/" . $nameFile;
           if(is_dir($nest)){
            rmdir($nest);
            header("Location:index.php");
           }else{
            unlink($nest);
            header("Location:index.php");
           }
           echo "can't remove";
        }
      }

?>