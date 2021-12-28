module bu2_module (
A[7:0] ,
clock ,
reset,
Y,
enable
);
input [7:0] A;
input clock ;
input reset;
input enable;
output [7:0] Y;
wire A ;
wire reset;
wire clock;
wire enable;
reg [7:0] Y ;
always @ (posedge clock,A)
begin: bu2
	if (reset == 1'b1) begin
    Y <=  8'b00000000;
	end
    else if(enable == 1'b1)
		begin
		 Y<=  ~A+1'b1;
		end
end
endmodule