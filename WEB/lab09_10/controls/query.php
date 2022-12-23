<?php
  include 'connect.php';


  try {

    $sql = "CREATE TABLE `account` (
        `username` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
        `email` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
        `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL
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
    $sql = "CREATE TABLE `bill` (
      `id` int(11) primary key,
      `total` int(11) NOT NULL,
      `count` int(11) NOT NULL,
      `date` DATETIME DEFAULT CURRENT_TIMESTAMP
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;";
    
      // use exec() because no results are returned
      if (mysqli_query($conn, $sql)) {
        // echo "Table product  created successfully" . "<br>\n";
      } else {
        // echo "Error product creating table: " . mysqli_error($conn) . "<br>\n";
      }

  
  } catch (\Throwable $th) {
    // echo "table product exists" . "<br>\n";
  }

  


  try {
    $sql = "CREATE TABLE `product` (
      `id` int(11) NOT NULL,
      `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
      `price` int(11) NOT NULL,
      `description` varchar(254) COLLATE utf8_unicode_ci NOT NULL,
      `vote` int(11) NOT NULL,
      `image` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
      `type` int(11) NOT NULL
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
  $sql = "CREATE TABLE `bill_details` (
    `id` int(11) primary key,
    `product_id` int(11) NOT NULL,
    `quantity` int(11) NOT NULL,
    `bill_id` int(11) NOT NULL
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;";
  
    // use exec() because no results are returned
    if (mysqli_query($conn, $sql)) {
      // echo "Table product  created successfully" . "<br>\n";
    } else {
      // echo "Error product creating table: " . mysqli_error($conn) . "<br>\n";
    }


} catch (\Throwable $th) {
  // echo "table product exists" . "<br>\n";
}

try {
  $sql = "CREATE TABLE `cart` (
     `id` int(11) NOT NULL,
      `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
      `price` int(11) NOT NULL,
      `count` int(11) NOT NULL,
      `image` varchar(100) COLLATE utf8_unicode_ci NOT NULL
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;";
  
    // use exec() because no results are returned
    if (mysqli_query($conn, $sql)) {
      // echo "Table product  created successfully" . "<br>\n";
    } else {
      // echo "Error product creating table: " . mysqli_error($conn) . "<br>\n";
    }


} catch (\Throwable $th) {
  // echo "table product exists" . "<br>\n";
}

try {
  $sql = "CREATE TABLE `category` (
    `id` int(11) NOT NULL primary key,
    `name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
    `note` varchar(30) COLLATE utf8_unicode_ci NOT NULL
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;";
  
    // use exec() because no results are returned
    if (mysqli_query($conn, $sql)) {
      // echo "Table product  created successfully" . "<br>\n";
    } else {
      // echo "Error product creating table: " . mysqli_error($conn) . "<br>\n";
    }


} catch (\Throwable $th) {
  // echo "table product exists" . "<br>\n";
}


try {
    $sql = "INSERT INTO `account` (`username`, `email`, `password`) VALUES
    ('admin', 'a@gmail.com', '1234567'),
    ('tanthanh', 'b@gmail.com', '1234567');";
  if (mysqli_query($conn, $sql)) {
    // echo "Insert account  successfully" . "<br>\n";
  } else {
    // echo "Error account  Insert product " . mysqli_error($conn) . "<br>\n";
  }
} catch (\Throwable $th) {
    // echo "error insert account" .  "<br>\n";
}


try {
    $sql = "INSERT INTO `product` (`id`, `name`, `price`, `description`, `vote`, `image`, `type`) VALUES
    (1, 'iPhone 7', 10990000, 'Stay connected either on the phone or the Web with the [iphone 7] from Samsung. With 16 GB of memory and a 4G connection, this phone stores precious photos and video and lets you upload them to a cloud or social network at', 4, 'images/iphone-7-plus-128gb-de-400x460.png', 1),
    (2, 'Samsung Galaxy J3', 8490000, 'Stay connected either on the phone or the Web with the [Samsung Galaxy J3] from Samsung. With 16 GB of memory and a 4G connection, this phone stores precious photos and video and lets you upload them to a cloud or social network at', 3, 'images/samsung-galaxy-j3-2017-2-400x460-1.png', 2),
    (3, 'Samsung Galaxy J5', 5490000, 'Stay connected either on the phone or the Web with the [Samsung Galaxy J5] from Samsung. With 16 GB of memory and a 4G connection, this phone stores precious photos and video and lets you upload them to a cloud or social network at', 4, 'images/samsung-galaxy-j3-2017-2-400x460.png', 2),
    (4, 'Samsung Galaxy J7', 3490000, 'Stay connected either on the phone or the Web with the [Samsung Galaxy J7] from Samsung. With 16 GB of memory and a 4G connection, this phone stores precious photos and video and lets you upload them to a cloud or social network at', 2, 'images/samsung-galaxy-j7-plus-1-400x460.png', 2),
    (5, 'Samsung Galaxy Note 5', 6990000, 'Stay connected either on the phone or the Web with the [Samsung Galaxy Note 5] from Samsung. With 16 GB of memory and a 4G connection, this phone stores precious photos and video and lets you upload them to a cloud or social network at', 2, 'images/samsung-galaxy-note-5-2-400x460.png', 2),
    (6, 'iPhone 6S', 8500000, 'Stay connected either on the phone or the Web with the [iPhone 6S] from Samsung. With 16 GB of memory and a 4G connection, this phone stores precious photos and video and lets you upload them to a cloud or social network at', 5, 'images/iphone-6s-128gb-hong-1-400x450.png', 1),
    (7, 'Oppo F3 Plus', 2500000, 'Stay connected either on the phone or the Web with the [Oppo F3 Plus] from Samsung. With 16 GB of memory and a 4G connection, this phone stores precious photos and video and lets you upload them to a cloud or social network at', 5, 'images/oppo-f3-plus-1-1-400x460.png', 3),
    (8, 'Oppo A7', 12500000, 'Stay connected either on the phone or the Web with the [Oppo A7] from Samsung. With 16 GB of memory and a 4G connection, this phone stores precious photos and video and lets you upload them to a cloud or social network at', 3, 'images/oppo-a71-400x460.png', 3),
    (9, 'Google Redmi 4X', 10500000, 'Stay connected either on the phone or the Web with the [Google Redmi 4X] from Samsung. With 16 GB of memory and a 4G connection, this phone stores precious photos and video and lets you upload them to a cloud or social network at', 3, 'images/xiaomi-redmi-4x-400-400x460.png', 4),
    (10, 'Google Mi A1', 7500000, 'Stay connected either on the phone or the Web with the [Google Mi A1] from Samsung. With 16 GB of memory and a 4G connection, this phone stores precious photos and video and lets you upload them to a cloud or social network at', 3, 'images/xiaomi-mi-a12-400x460.png', 4),
    (11, 'Nokia 8', 6300000, 'Stay connected either on the phone or the Web with the [Nokia 8] from Samsung. With 16 GB of memory and a 4G connection, this phone stores precious photos and video and lets you upload them to a cloud or social network at', 3, 'images/nokia-8-1-400x460.png', 5),
    (12, 'Nokia 3', 4300000, 'Stay connected either on the phone or the Web with the [Nokia 3] from Samsung. With 16 GB of memory and a 4G connection, this phone stores precious photos and video and lets you upload them to a cloud or social network at', 3, 'images/nokia-3-2-400x460.png', 5);";
  if (mysqli_query($conn, $sql)) {
    // echo "Insert product  successfully" . "<br>\n";
  } else {
    // echo "Error product  Insert product " . mysqli_error($conn) . "<br>\n";
  }
} catch (\Throwable $th) {
    // echo "error insert product" .  "<br>\n";
}
