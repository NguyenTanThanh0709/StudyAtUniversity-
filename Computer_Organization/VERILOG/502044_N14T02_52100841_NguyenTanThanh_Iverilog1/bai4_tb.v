`include "bai4.v"
module bu2moduletb();
reg [7:0] A;
reg reset,clock,enable;
wire [7:0] Y;
initial begin
$monitor ("%g | Input = %b|Reset =%b|Enable=%b| Output = %b", $time,A,reset,enable, Y);
    $dumpfile("dump.vcd");
    $dumpvars(A,reset,Y,enable,clock);
end
initial begin
 clock = 1;       // initial value of clock
 reset = 0;       // initial value of reset
 enable = 0;       // initial value of reset
 A = 8'b00000000;
#5 reset = 1;    // Assert the reset
 #10 reset = 0;   // De-assert the reset
	#10 enable = 1;  // Assert enable
  #100 enable = 0; // De-assert enable
  #5 $finish;      // Terminate simulation
end
// Clock generator
always begin
  #5 clock = ~clock; // Toggle clock every 5 ticks
  A = A+1'b1;
end
bu2_module U_bu2 (
A[7:0] ,
clock ,
reset,
Y,
enable
);
endmodule