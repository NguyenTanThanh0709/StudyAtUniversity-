<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <title>Document</title>
</head>
<body>
    <table class="table table-striped table-hover table-bordered">
        <tr>
            <th>Bảng cửu chương 1</th>
            <th>Bảng cửu chương 2</th>
            <th>Bảng cửu chương 3</th>
            <th>Bảng cửu chương 4</th>
            <th>Bảng cửu chương 5</th>
            <th>Bảng cửu chương 6</th>
            <th>Bảng cửu chương 7</th>
            <th>Bảng cửu chương 8</th>
            <th>Bảng cửu chương 9</th>
            <th>Bảng cửu chương 10</th>
        </tr>
        <?php for($i = 1;$i <= 10; $i++){ ?>
            <tr>

                <?php for($j = 1;$j <= 10; $j++){ ?>
                    <td> <?php echo $i . " x " . $j . " = " . ($i*$j); ?> </td>

                <?php } ?>

            </tr>

        <?php } ?>
    </table>
</body>
</html>