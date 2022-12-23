<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
        <form action="add-student.php" method="post">
            <caption> Add student</caption>
        <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <input id="name" type="text" class="form-control" name="name" placeholder="name">
        </div>
        <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <input id="email" type="text" class="form-control" name="email" placeholder="email">
        </div>
        <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
            <input id="phone" type="text" class="form-control" name="phone" placeholder="phone">
        </div>
        <input type="submit" value = "add">
        </form>

        <br>
        <br>

        <form action="delete-student.php" method = "post">
            <caption> Delete student from id</caption>
            <div class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                <input id="id" type="number" class="form-control" name="id" placeholder="id">
            </div>
            <input type="submit" value = "delete">
        </form>

        <br>
        <br>

        <form action="update-student.php" method="post">
            <caption> update student from id</caption>
            <div class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                <input id="id" type="number" class="form-control" name="id" placeholder="id">
            </div>
            <div class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                <input id="name" type="text" class="form-control" name="name" placeholder="name">
            </div>
            <div class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                <input id="email" type="text" class="form-control" name="email" placeholder="email">
            </div>
            <div class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                <input id="phone" type="text" class="form-control" name="phone" placeholder="phone">
            </div>
            <input type="submit" value = "update">
        </form>

        <a href="get-students.php" class="btn" style = "font-size:30px">click để xem chi tiết học sinh</a>
</body>
</html>