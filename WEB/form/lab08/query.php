<?php
  include 'connect.php';
  try {

    $sql = "CREATE TABLE `account` (
        `username` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
        `firstname` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
        `lastname` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
        `email` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
        `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
        `activated` bit(1) DEFAULT (false),
        `activate_token` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL
      ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;";
    
      // use exec() because no results are returned
      if (mysqli_query($conn, $sql)) {
        // echo "Table account  created successfully" . "<br>\n";
      } else {
        // echo "Error account creating table: " . mysqli_error($conn) . "<br>\n";
      }

      $sql = "ALTER TABLE `account`
      ADD PRIMARY KEY (`username`),
      ADD UNIQUE KEY `email` (`email`);";
      if (mysqli_query($conn, $sql)) {
        // echo "Alter account successfully" . "<br>\n";
      } else {
        // echo "Error account Alter account " . mysqli_error($conn) . "<br>\n";
      }
  
  } catch (\Throwable $th) {
    // echo "table account exists" . "<br>\n";
  }


  try {
    $sql = "CREATE TABLE `product` (
        `id` int NOT NULL,
        `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
        `price` int DEFAULT NULL,
        `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
        `image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
      ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;";
    
      // use exec() because no results are returned
      if (mysqli_query($conn, $sql)) {
        // echo "Table product  created successfully" . "<br>\n";
      } else {
        // echo "Error product creating table: " . mysqli_error($conn) . "<br>\n";
      }

      $sql = "ALTER TABLE `product`
      ADD PRIMARY KEY (`id`);";
      if (mysqli_query($conn, $sql)) {
        // echo "Alter product successfully" . "<br>\n";
      } else {
        // echo "Error Alter product " . mysqli_error($conn) . "<br>\n";
      }
  
  } catch (\Throwable $th) {
    // echo "table product exists" . "<br>\n";
  }

try {
    $sql = "ALTER TABLE `product`
    MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
  COMMIT;";
  if (mysqli_query($conn, $sql)) {
    // echo "Alter product id auto identiti successfully" . "<br>\n";
  } else {
    // echo "Error  product id auto identiti Alter product " . mysqli_error($conn) . "<br>\n";
  }
} catch (\Throwable $th) {
    // echo "exist auto identiti" .  "<br>\n";
}


try {
    $sql = "INSERT INTO `account` (`username`, `firstname`, `lastname`, `email`, `password`, `activated`, `activate_token`) VALUES
    ('mvmanh', 'Mai', 'Văn Mạnh', 'mvmanh@gmail.com', '1234567', b'1', '123456'),
    ('tdt', 'Tôn', 'Đức Thắng', 'mvmanh@it.tdt.edu.vn', '12345678', b'1', '123456');";
  if (mysqli_query($conn, $sql)) {
    // echo "Insert account  successfully" . "<br>\n";
  } else {
    // echo "Error account  Insert product " . mysqli_error($conn) . "<br>\n";
  }
} catch (\Throwable $th) {
    // echo "error insert account" .  "<br>\n";
}


try {
    $sql = "INSERT INTO `product` (`id`, `name`, `price`, `description`, `image`) VALUES
    (1, 'iPhone XS MAX 64GB', 24490000, 'Hàng xách tay chính hãng', 'images/iphone-6s-128gb-hong-1-400x450.png'),
    (2, 'Samsung Galaxy J7 Plus', 12990000, 'Bao test bào xài 6 tháng', 'images/samsung-galaxy-j7-plus-1-400x460.png'),
    (3, 'iPhone 7 Plus 128GB Black', 14490000, 'Hàng cũ mới 99%', 'images/iphone-7-plus-128gb-de-400x460.png'),
    (4, 'Oppo F3 Plus', 7990000, 'Hàng chợ Bà Chiểu', 'images/oppo-f3-plus-1-1-400x460.png');";
  if (mysqli_query($conn, $sql)) {
    // echo "Insert product  successfully" . "<br>\n";
  } else {
    // echo "Error product  Insert product " . mysqli_error($conn) . "<br>\n";
  }
} catch (\Throwable $th) {
    // echo "error insert product" .  "<br>\n";
}
