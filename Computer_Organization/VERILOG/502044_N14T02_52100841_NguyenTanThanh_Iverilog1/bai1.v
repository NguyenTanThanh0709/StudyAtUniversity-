//-----------------------------------------------------
// This is my second Verilog Design
// Design Name : first_counter
// File Name : first_counter.v
// Function : This is a 4 bit up-counter with
// Synchronous active high reset and
// with active high enable signal
//-----------------------------------------------------
module first_counter(clock ,reset , enable , counter_out);
// End of port list
//-------------Input Ports-----------------------------
input clock ;
input reset ;
input enable ;
//-------------Output Ports----------------------------
output [2:0] counter_out ;
wire clock ;
wire reset ;
wire enable ;
reg [2:0] counter_out ;
//------------Code Starts Here-------------------------
always @ (posedge clock)
begin : COUNTER 
    if (reset == 1'b1) begin
        counter_out <= #1 3'b000;
    end
    else if (enable == 1'b1) begin
        counter_out <= #1 counter_out + 1;
    end
end 
endmodule 