<?php
$mydir = './upload/'; 
$myfiles = scandir($mydir); 
$listArrayFile = array();
foreach($myfiles as $each){
    $icon = is_dir($each) ? "<i class='fa fa-folder'></i>" : "<i class='fas fa-file'></i>" ; 
    $name = $each;
    $type =  strtolower(pathinfo($each, PATHINFO_EXTENSION));
    $getfile = filemtime(getcwd() . "./upload/" . $each);
    $time = date("F d Y H:i:s.", $getfile);
    if(is_file($getfile)){
      $sizeFile = filesize($each);
    }else{
      $sizeFile =0;
    }
    $arrayEach = array($icon,$name, $type,$sizeFile,$time);
    array_push($listArrayFile,$arrayEach);
}
?>
<!DOCTYPE html>
<html lang="en">
   <head>
      <title>Bootstrap Example</title>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
      <link 
         rel="stylesheet"
         href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
         integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
      <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>
      <script src="https://malsup.github.io/jquery.form.js"></script> -->
      <style>
         input{
            outline : none;
         }
         .fa, .fas {
         color: #858585;
         }
         .fa-folder {
         color: rgb(74, 158, 255);
         }
         i.fa, table i.fas {
         font-size: 16px;
         margin-right: 6px;
         }
         i.action {
         cursor: pointer;
         }
         a {
         color: black;
         }
      </style>
   </head>
   <body>
      <div class="container">
         <div  class="btn-group my-3">
            
               <button type="button" class="btn btn-light border">
               <a href="#" data-toggle="modal" data-target="#confirm-createfoder"><i class="fas fa-folder-plus"></i> New folder</a>
               </button>   

            <button type="button" class="btn btn-light border">
                <a href="#" data-toggle="modal" data-target="#new-file-dialog"><i class="fas fa-file"></i> Create text file</a>
            </button>  
         </div>
         <table class="table table-hover border">
            <thead>
               <tr>
                  <th>Icon</th>
                  <th>Name</th>
                  <th>Type</th>
                  <th>Size</th>
                  <th>Last modified</th>
                  <th>Actions</th>
               </tr>
            </thead>
            <tbody>

               <?php
                  foreach($listArrayFile as $each):
                     $count = 0;
                     $nameFILE_FOLDER = "";
               ?>
               <tr>
                  <?php 
                     foreach($each as $item):
                        $count++;
                  ?>

                  <?php if($count == 2){ 
                  $nameFILE_FOLDER = $item;   
                  ?>
                     <td id = "<?php echo $item; ?>">
                        <?php echo $item; ?>
                     </td>
                  <?php }else{ ?>
                     <td>
                        <?php echo $item; ?>
                     </td>
                  <?php } ?>

                  

                  <?php endforeach; ?>
                  <td>
                  <form action = 'deleteFile.php' method = 'post'>
                     <input type="hidden" value = '<?php echo $nameFILE_FOLDER; ?>' name = 'delete'>
                     <span style= "margin-right:31px">chỉ xóa được folder rỗng</span>
                     <button type='submit'><i class="fa fa-trash action"></i></button>
                  </form>

                 <form action = 'rename.php' method = 'post'>
                     <input type="hidden" value = '<?php echo $nameFILE_FOLDER; ?>' name = 'rename'>
                     <input type="text" placeholder = "File: name.txt, Folder: name" name='newname' style= "width:205px">
                     <button type='submit'><i class="fa fa-edit action"></i></button>
                  </form>
                  </td>
                  

               </tr>
               <?php endforeach; ?>
            </tbody>
         </table>
         <div class="border rounded mb-3 mt-5 p-3">
            <h4>File upload</h4>
            <form id="myForm" action="upload.php" method="post" enctype="multipart/form-data">
               <div class="form-group">
                  <div class="custom-file">
                     <input type="file" name="fileToUpload" id="fileToUpload" class="custom-file-input">
                     <label class="custom-file-label" for="customFile">Choose file</label>            
                  </div>
               </div>
               <p>Người dùng chỉ được upload tập tin có kích thước tối đa là 20 MB.</p>
               <p>Các tập tin thực thi (*.exe, *.msi, *.sh) không được phép upload.</p>
               <input type="submit" value="Upload" name="submit" class="btn btn-success px-5">
            </form>
         </div>

      </div>


      <!-- Delete dialog -->
      <div class="modal fade" id="confirm-delete">
        <div class="modal-dialog">
          <div class="modal-content">
          
            <div class="modal-header">
              <h4 class="modal-title">Xóa tập tin</h4>
              <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <div class="modal-body">
              Bạn có chắc rằng muốn xóa tập tin <strong>image.jpg</strong>
            </div>
        
            <div class="modal-footer">
                
                <form action="deleteFile.php" method = 'post'>
                  <button type="submit" class="btn btn-danger">Xóa</button>
                </form>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Không</button>
            </div>            
            </div>
        </div>
        </div>


    <!-- Rename dialog -->
    <div class="modal fade" id="confirm-rename">
        <div class="modal-dialog">
        <div class="modal-content">
        
            <div class="modal-header">
            <h4 class="modal-title">Đổi tên</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <form class="modal-body">
                <p>Nhập tên mới cho tập tin <strong>Document.txt</strong></p>
                <input type="text" placeholder="Nhập tên mới" value="Document.txt" name= 'newname'/>
            </form>
        
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" >Lưu</button>
            </div>            
            </div>
        </div>
        </div>

            <!-- create-folder -->

            <div class="modal fade" id="confirm-createfoder">
            <div class="modal-dialog">
            <div class="modal-content">
            
            <div class="modal-header">
            <h4 class="modal-title">tạo folder</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <form class="modal-body" action = "creatFoder.php", method = 'post'>
               <p>Nhập tên foder <strong>Document</strong></p>
               <input type="text" placeholder="Nhập tên mới" value="Document" name = 'folder'/>
               <input type="submit" class="btn btn-primary"  value = 'Lưu  '/>  
            </form>
      
                 
            
            </div>
         </div>
         </div>


        <!-- New file dialog -->
        <div class="modal fade" id="new-file-dialog">
        <div class="modal-dialog">
        <div class="modal-content">
        
            <div class="modal-header">
            <h4 class="modal-title">Tạo tập tin mới</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <form class="modal-body" action = "createFile.php", method = 'post'>
                <div class="form-group">
                    <label for="name">File Name ( MẶC ĐỊNH LÀ FILE .TXT NÊN CHỈ CẦN GHI TÊN FILE )</label>
                    <input type="text" placeholder="File name"  id="name" name='file'/>
                </div>
                <div class="form-group">
                    <label for="content">Nội dung</label>
                    <textarea rows="10" id="content" placeholder="Nội dung" name = 'content'></textarea>
                </div>
                <button type="submit" class="btn btn-success">Lưu</button>
            </form>
        

                
          
            </div>
        </div>
        </div>

         

   </body>
</html>