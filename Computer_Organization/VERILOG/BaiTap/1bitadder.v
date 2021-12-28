module  adder(
    input A,
    input B,
    input CIN,
    output S,
    output COUT 
    );
    assign S = A^B^CIN;
    assign COUT = (A&B)|(CIN&(A^B)) ;

endmodule

module 1bit;

    //Inputs
    reg A;
    reg B;
    reg CIN;

    //Outputs
    wire S;
    wire COUT;

    adder uut(
        .A(A),
        .B(B),
        .CIN(CIN),
        .S(S),
        .COUT(COUT)
    );
    initial begin
    A = 1'b0; B = 1'b0; CIN = 1'b0; 
	$monitor("%b + %b = %b (cin = %b) (co = %b)",A,B,S,CIN,COUT);
	#25
	$finish;      // Terminate simulation
	end
    always begin
	#5
	A=A+1'b1;
	#5
	B=B+1'b1;
    end

endmodule    