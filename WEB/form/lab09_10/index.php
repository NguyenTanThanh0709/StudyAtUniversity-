<?php
  session_start();
  if (!isset($_SESSION['user'])) {
      header('Location: login.php');
      exit();      
}
include "./modals/products.php";
include "./controls/connect.php";
$arraylist = array();
$res = $conn->query("select * from product");
$result = $res->fetch_all();

foreach ($result as $value) {
    $product = new products($value[0],$value[1],$value[2],$value[3],$value[4],$value[5],$value[6]);
    array_push($arraylist, $product);
  }

  $check = 0;

  if (isset($_GET['Iphone']))  {
    $check = (int)$_GET['Iphone'];
  }else if(isset($_GET['SamSung'])){
    $check = (int)$_GET['SamSung'];

  }else if(isset($_GET['Nokia']) ){
    $check = (int)$_GET['Nokia'];

  }else if(isset($_GET['Google']) ){
    $check = (int)$_GET['Google'];
    
  }else if(isset($_GET['Oppo']) ){
    $check = (int)$_GET['Oppo'];
  }else if(isset($_GET['All'])){
    $check = (int)$_GET['All'];
  }

  if(isset($_GET['button_card'])){
    if(isset($_GET['id'])){
      $id = (int)$_GET['id'];
      foreach ($result as $value) {
        if($id === (int)$value[0]){
          try {
            $sql = "INSERT INTO `cart` (`id`, `name`, `price`, `count`, `image`) VALUES
            ('$value[0]', '$value[1]', '$value[2]', 1, '$value[5]');";
          if (mysqli_query($conn, $sql)) {
            // echo "Insert account  successfully" . "<br>\n";
          } else {
            // echo "Error account  Insert product " . mysqli_error($conn) . "<br>\n";
          }


          
          $sql = "INSERT INTO `bill` (`id`, `total`, `count`) VALUES
            ('$value[0]', '$value[2]', 1);";
          if (mysqli_query($conn, $sql)) {
            // echo "Insert account  successfully" . "<br>\n";
          } else {
            // echo "Error account  Insert product " . mysqli_error($conn) . "<br>\n";
          }

        } catch (\Throwable $th) {
            // echo "error insert account" .  "<br>\n";
        }
        }
      }

    }
  }

?>

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shop Homepage - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- Custom styles for this template -->
    <link href="css/shop-homepage.css" rel="stylesheet">

  </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Shop Mall</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="index.php">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
              <li class="nav-item">
                  <a class="nav-link" href="cart.php">Carts</a>
              </li>
            <li class="nav-item">
              <a class="nav-link" href="./controls/logOUT.php">Log out</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">

      <div class="row">

        <div class="col-lg-3 ">

          <h1 class="my-4">Shop Mall</h1>
           <form class="list-group">
            <button type = "submit" value = "0" name= "All" class="btn list-group-item">All</button>
              <button type = "submit" value="1" name= "Iphone" class="btn list-group-item">Iphone</button>
              <button type = "submit" value="2" name= "SamSung" class="btn list-group-item">SamSung</button>
              <button type = "submit" value="3" name= "Nokia" class="btn list-group-item">Nokia</button>
              <button type = "submit" value="4" name= "Google" class="btn list-group-item">Google</button>
              <button type = "submit" value="5" name= "Oppo" class="btn list-group-item">Oppo</button>
           </form>



        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

        

          <div class="row">

          <?php
            foreach($arraylist as $value){
              
              if($check === 1){
                $pos = strpos($value->name, "iPhone");
                if ($pos !== false) {
                //Tìm thấy
                } else {
                // Không tìm thấy
                continue;
                }

              }else if($check === 2){
                $pos = strpos($value->name, "Samsung");
                if ($pos !== false) {
                //Tìm thấy
                } else {
                // Không tìm thấy
                continue;
                }
              }else if($check === 3){
                $pos = strpos($value->name, "Nokia");
                if ($pos !== false) {
                //Tìm thấy
                } else {
                // Không tìm thấy
                continue;
                }
              }else if($check === 4){
                $pos = strpos($value->name, "Google");
                if ($pos !== false) {
                //Tìm thấy
                } else {
                // Không tìm thấy
                continue;
                }
              }else if($check === 5){
                $pos = strpos($value->name, "Oppo");
                if ($pos !== false) {
                //Tìm thấy
                } else {
                // Không tìm thấy
                continue;
                }
              }else if($check === 0){

              }
          ?>
          
          <div class="col-lg-4 col-md-6 mb-4">
            <!-- <input type="hidden" value="<?php echo $value->id; ?>" /> -->
              <div class="card h-100">
                <a href="#"><img class="card-img-top" src="<?php echo $value->image;?>" alt=""></a>
                <div class="card-body">
                  <h4 class="card-title">
                    <a href="#"><?php echo $value->name; ?></a>
                  </h4>
                  <h5 style="color: #f47442"><?php echo $value->description; ?></h5>
                  <p class="card-text"><?php echo $value->price; ?></p>
                  <small class="text-muted"><?php 
                      for($i = 0; $i < $value->vote; $i++){
                        echo '&#9733;' ;
                      }
                    ?></small>
                </div>
                <div class="card-footer">
                    <form method="get" action="">
                      <input type="submit" value="Add to card" name = "button_card"  class="btn btn-primary m-1"/>

                      <input type="hidden" value="<?php echo $value->id; ?>" name = "id" />
                    </form>
                    <form method="get" action="product_detail.php">
                      <input type="submit" value="Quick View" name = "quick_view"  class="btn btn-primary m-1"/>
                      <input type="hidden" value="<?php echo $value->id; ?>" name = "idView" />
                    </form>
                    


                </div>
              </div>
            </div>


            
          <?php } ?>
            
            


          </div>
          <!-- /.row -->

        </div>
        <!-- /.col-lg-9 -->

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    

  </body>

  <!-- <script>
    $(document).ready(function(){
            $('.teeeeee').click(function(){
                let curr = $(this);
                sibling = curr.siblings();
                console.log(sibling.val());
            });
        });


        
  </script> -->

</html>
