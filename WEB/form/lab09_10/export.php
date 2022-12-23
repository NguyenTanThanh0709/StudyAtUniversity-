<?php
include "./controls/connect.php";
require('fpdf.php');
$res = $conn->query("select * from bill");
$result = $res->fetch_all();

// print_r($result);


$pdf=new FPDF();
$pdf->AddPage();
$pdf->SetFont('Arial','I',10);
$pdf->Cell(45, 10, 'ID product', 1, 0);
$pdf->Cell(45, 10, 'price of product', 1, 0);
$pdf->Cell(45, 10, 'number of product', 1, 0);
$pdf->Cell(45, 10, 'date buy product', 1, 1);
$total = 0;
foreach ($result as $value) {
    // $product = new products($value[0],$value[1],$value[2],$value[3],$value[4],$value[5],$value[6]);
    // array_push($arraylist, $product);
    $pdf->Cell(45, 10, $value[0], 1, 0);
    $pdf->Cell(45, 10, $value[1], 1, 0);
    $total += $value[1];
    $pdf->Cell(45, 10, $value[2], 1, 0);
    $pdf->Cell(45, 10, $value[3], 1, 1);
  }
  $pdf->Cell(45, 10, 'Total prices: ', 1, 0);
    $pdf->Cell(45, 10, $total, 1, 0);

$pdf->Output();
?>