<?php
  $num1Err = "";
  $num2Err = "";
  $emptyOperator = "";
 
  $checknum2 = $check1 = $check2 = $check = true;
  $num2 =$add =$Subtract =$Divide =$num1 =$Multipli = "";

  $displayErr = $displaySub = $displayDivide =$displaymulti = $displayAdd = "display: none;";

  // echo $_GET['num1'] . " " . $_GET['num2'];
  // if($_GET['num1'] == ""){
  //   echo"num1";
  // }else{
  //   echo "0 num1";
  // }

  if(isset($_GET['submit']) && !empty($_GET['submit'])) {

  if($_GET['num1'] != ""){
    $num1 = $_GET['num1'];
  }else{
    $check1 = false;
    $num1Err = "<div class='alert alert-danger'>  Error Number 1! </div>";
  }

  if($_GET['num2'] != ""){
    $num2 = $_GET['num2'];
  }else{
    $check2 = false;
    $num2Err = "<div class='alert alert-danger'>  Error Number 2! </div>";
  }
 
  // if(!empty($_GET['num1'])){
  //   $num1 = $_GET['num1'];
  // }else{
  //   $check1 = false;
  //   $num1Err = "<div class='alert alert-danger'>  Error Number 1! </div>";
  // }

  // if(isset($_GET['num2'])){
  //   $num2 = $_GET['num2'];
  //   if(empty($num2)){
  //     $checknum2 =false;
  //     $num2Err = "<div class='alert alert-danger'>  Error Number 2! </div>";
  //   }
  // }else{
  //   $check2 = false;
  //   $num2Err = "<div class='alert alert-danger'>  Error Number 2! </div>";
  // }

  // if(!empty($_GET['num2'])){
  //   $num2 = $_GET['num2'];
  // }else{
  //   $check1 = false;
  //   $num2Err = "<div class='alert alert-danger'>  Error Number 2! </div>";
  // }

 
  if(!isset($_GET['Add']) && !isset($_GET['Subtract']) && !isset($_GET['Divide']) && !isset($_GET['Multipli'])){
    $check = false;
    $emptyOperator = "<div class='alert alert-danger'>  check Operator plzzzzz! </div>";
 
  }
 
  if(isset($_GET['Add']) && $check == true && $check1 == true && $check2 == true){
    $resultAdd = (double)$num1 + (double)$num2;
    $displayAdd = "display: block";
  }
  if(isset($_GET['Subtract']) && $check == true && $check1 == true && $check2 == true){
    $resultsub = (double)$num1 - (double)$num2;
 
    $displaySub = "display: block";
  }
  if(isset($_GET['Divide']) && $check == true && $check1 == true && $check2 == true){
    if($num2 != 0){
      $resultDivide = (double)$num1 / (double)$num2;
    }else{
      $resultDivide = "error! cant divide 0 =>  check number2 plzzzzz!";
    }
    $displayDivide= "display: block";
    
  }
  if(isset($_GET['Multipli']) && $check == true && $check1 == true && $check2 == true){
    $resultmulti = (double)$num1 * (double)$num2;
    $displaymulti = "display: block";
  }

  if($check == false || $check1 == false || $check2 == false){
    $displayErr = "display: block";
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
    <!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
 
</head>
<body>

  <div class="container">
  <div class="row">
              <div class="col-md-6 my-5 mx-auto border rounded px-3 py-3">
                  <h4 class="text-center">Tính toán cơ bản</h4>
      <form method="get">
          <div class="mb-3">
            <label for="num1" class="form-label">number 1</label>
            <input type="text" class="form-control" id="num1" name = "num1" value = "">
          </div>
          <div class="mb-3">
            <label for="num2" class="form-label">number 2</label>
            <input type="text" class="form-control" id="num2" name = "num2" value = "">
          </div>
  
          <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" id="Add" name="Add">
            <label class="form-check-label" for="Add">Add</label>
          </div>
  
          <div class="mb-3 form-check">
              <input type="checkbox" class="form-check-input" id="Subtract" name="Subtract">
              <label class="form-check-label" for="Subtract">Subtract</label>
            </div>
  
            <div class="mb-3 form-check">
              <input type="checkbox" class="form-check-input" id="Divide" name="Divide">
              <label class="form-check-label" for="Divide">Divide</label>
            </div>
  
            <div class="mb-3 form-check">
              <input type="checkbox" class="form-check-input" id="Multipli" name="Multipli">
              <label class="form-check-label" for="Multipli">Multipli</label>
            </div>
  
            <input type="submit" name="submit" value="submit" />
        </form>    
        </div>

      <div class="row">
        <div class="col-md-6 mx-auto px-3 py-3 text-center">
        <div>
        <div style = "<?php echo $displayErr ; ?>">
        <?php
          if($check1 == false){
            echo $num1Err;
          }
          if($check2 == false){
            echo $num2Err;
          }
          if($check == false){
            echo $emptyOperator;
          }
        ?>
      </div>
        <div style = "<?php echo $displayAdd ; ?>" class=" alert alert-success resultADD"><?php echo $num1 . " + " . $num2 . " = ". $resultAdd ?></div>
        <div style = "<?php echo $displaySub ; ?>" class=" alert alert-success resultSubtract"><?php echo $num1 . " - " . $num2 . " = ". $resultsub ?></div>
        <div style = "<?php echo $displayDivide ; ?>" class=" alert alert-success resultDivide"><?php echo $num1 . " / " . $num2 . " = ". $resultDivide?></div>
        <div style = "<?php echo $displaymulti; ?>" class=" alert alert-success resultMultipli"><?php echo $num1 . " * " . $num2 . " = ". $resultmulti ?></div>
      </div>
        </div>
      </div>
  </div>


  
 
 
</body>
</html>
 

