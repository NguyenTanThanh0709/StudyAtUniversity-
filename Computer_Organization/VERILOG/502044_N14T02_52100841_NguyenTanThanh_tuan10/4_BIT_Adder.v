module  mini_adder(
    input A,
    input B,
    input CIN,
    output S,
    output COUT 
    );
    assign S = A^B^CIN;
    assign COUT = (A&B)|(CIN&(A^B)) ;

endmodule

module four_bit_adder(
    input [3:0]A,
    input [3:0]B,
    input C0,
    output [3:0]S,
    output C4
    );
    wire C1,C2,C3;

    mini_adder fa0 (A[0],B[0],C0,S[0],C1);
    mini_adder fa1 (A[1],B[1],C1,S[1],C2);
    mini_adder fa2 (A[2],B[2],C2,S[2],C3);
    mini_adder fa3 (A[3],B[3],C3,S[3],C4);

endmodule

module test_4_bit;

    //Inputs
    reg [3:0] A;
    reg [3:0] B;
    reg C0;

    //Outputs
    wire [3:0] S;
    wire C4;

    four_bit_adder uut(
        .A(A),
        .B(B),
        .C0(C0),
        .S(S),
        .C4(C4)
    );

    initial begin
    A = 4'b0011; B = 4'b0011; C0 = 1'b0; #100;
    A = 4'b1011; B = 4'b0111; C0 = 1'b1; #100;
    A = 4'b1111; B = 4'b1111; C0 = 1'b1; #100;

    end

endmodule    