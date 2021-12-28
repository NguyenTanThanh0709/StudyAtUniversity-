//-----------------------------------------------------
module notmodule (
A ,
clock ,
reset,
Y
);
input A;
input clock ;
input reset;
output [1:1] Y;
wire A ;
wire reset;
wire clock;
reg [1:1] Y ;
always @ (posedge clock,A)
begin: NOT_behavioral
	if (reset == 1'b1) begin
    Y <= #1 4'b0;
  end
    else if (A == 1'b0 ) begin
        Y <= 1'b1;
		end
    else if (A == 1'b1) begin
       Y <= 1'b0;
end
end

endmodule