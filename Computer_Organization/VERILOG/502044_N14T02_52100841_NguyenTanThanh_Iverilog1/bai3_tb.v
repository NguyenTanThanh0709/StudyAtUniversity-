`include "bai3.v"
module notmoduledtb();
reg A,reset,clock;wire [1:1] Y;
initial begin
 clock = 1;       // initial value of clock
#5 reset = 1;    // Assert the reset
 #10 reset = 0;   // De-assert the reset
reset = 0;       // initial value of reset
    A = 0;
  #1 A = 1;
  #1 A = 0;
  #5 $finish;      // Terminate simulation
end
initial begin
$monitor ("%g | Input = %b| Output = %b", $time, A, Y);
    $dumpfile("dump.vcd");
    $dumpvars(A, clock, reset,Y);
end
// Clock generator
always begin
  #5 clock = ~clock; // Toggle clock every 5 ticks
end
notmodule U_not_mod (
A,
reset,
clock,
Y
);
endmodule