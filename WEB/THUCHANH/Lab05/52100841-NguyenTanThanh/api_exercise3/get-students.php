<?php
    require_once ('connection.php');
    $sql = "SELECT * FROM student";
    $result = mysqli_query($connect, $sql);
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
    <title>Document</title>
</head>
<body>
<div class="container mt-3">  
  <table class="table table-striped">

    <thead>
      <tr>
        <th>id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
      </tr>
    </thead>

    <tbody>
        
      <?php foreach($result as $each): ?>
        <tr>
            <td> <?php echo $each['id'] ?> </td>
            <td> <?php echo $each['name'] ?> </td>
            <td> <?php echo $each['email'] ?> </td>
            <td> <?php echo $each['phone'] ?> </td>
        </tr>
      <?php endforeach; ?>

    </tbody>
  </table>
</body>
</html>