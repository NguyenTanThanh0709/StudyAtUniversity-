<?php
    $nameFile = "";
    $fileContent = "";
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        if(isset($_POST['file'])){
            $nameFile = $_POST['file'];
            $nest = getcwd() . "./upload/" . $nameFile . '.txt';
            // creating a nested structure directory
            $myfile = fopen($nest, "w") or die("Unable to open file!");
            $content = $_POST['content'];
            fwrite($myfile, $content);    
            fclose($myfile);
            header("Location:index.php");
        }
      }

?>