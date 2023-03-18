<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <title>Document</title>
    <style>
        html, body {
            height: 100%;
            margin: 0;
        }
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        .table__color{
            width: 350px;
            height: 350px;
            background-color: antiquewhite;
            margin-top: 20px;
            margin-bottom: 20px;
        }


        .container{
            width: 100%;
            background-color: #ffff;
            height: 100%;
            display: flex;
            align-items: center;
            justify-content: center;
            border: 3px solid black;
            border-radius: 0px;
            
        }

        .name__color{
            font-size: 20px;
            font-weight: 900;
            border-radius: 10px;
            background-color: rgba(0,0,0,0.4);
            color: #ffff;
            width: 350px;
            text-align: center;
            cursor: pointer;
            padding: 10px;
        }

        .table__color__child{
            width: 35px;
            height: 35px;
            background-color: #90afa8;
            float: left;
            border: 1px solid black;
            border-radius: 1px;
            
        }

        .messsange{
            font-size: 17px;
            font-weight: 900;
            border-radius: 10px;
            background-color: rgba(73, 180, 148, 0.4);
            color: rgb(81, 82, 60);
            width: 350px;
            text-align: center;
            position: absolute;
        } 

        .temp{
            position: relative;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="temp">
            <div  class="name__color" id="myInput" onclick="copyData(myInput)" ></div>
            <div class="table__color">
                <?php
                    for($i = 0; $i < 10; $i++){
                        for($j = 0; $j < 10; $j++){
                            $rand1 = rand(0,255);
                            $rand2 = rand(0,255);
                            $rand3 = rand(0,255);
                            echo "<div class = 'table__color__child' style = 'background-color:rgb($rand1,$rand2,$rand3);'></div>";
                        }
                    }
                ?>
            </div>
        </div>
    </div>

    <script>
        
        function copyData(containerid) {
            var range = document.createRange();
            range.selectNode(containerid); //changed here
            window.getSelection().removeAllRanges(); 
            window.getSelection().addRange(range); 
            document.execCommand("copy");
            window.getSelection().removeAllRanges();
        }
                
        $(document).ready(function(){
            $(".name__color").text("Hover a cell");

            var check = 1;
            var colorTemp;
            $(".table__color__child").mouseenter(function(){
                let color = $( this ).css( "background-color" );
                $(".container").css("background-color", `${color}`);
                $(".name__color").text(`${color}`);

            }).mouseleave(function() {      
                
                    $(".container").css("background-color", "white");
                
            }).click(function(){
                let color = $( this ).css( "background-color" );
                check  = 1;
                colorTemp = color;
                $(".container").css("background-color", `${color}`);
                $(".temp").append('<div class="messsange">Color has been changed to the background-color!</div>');
                setTimeout(function(){
                    $(".messsange").remove();
                },2500);
            });

            $(".name__color").click(function(){
                $(".temp").append('<div class="messsange">Color has been copied to the clipborad!</div>');
                setTimeout(function(){
                    $(".messsange").remove();
                },2500);
            });

            $('.temp').parent().on('mouseover', function(e){
            if(this===e.target){
                if(check === 1){
                    $(".container").css("background-color", `${colorTemp}`);
                    check = 0;
                }
            }
            });


        });
    </script>
</body>
</html>