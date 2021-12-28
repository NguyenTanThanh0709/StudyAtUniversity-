module  bai1_adder(
    input A,
    input B,
    input C,
    output F2,
    output F1
    );
    assign F2 = (A&B)|((A|B)&C);
    assign F1 = ((~(A&B)|((A|B)&C))|A|B|C) | A&B&C;

endmodule

module test_1_bit;

    //Inputs
    reg A;
    reg B;
    reg C;

    //Outputs
    wire F2;
    wire F1;

    bai1_adder uut(
        .A(A),
        .B(B),
        .C(C),
        .F2(F2),
        .F1(F1)
    );
    initial begin
    A = 1'b0; B = 1'b0; C = 1'b0; 
    $monitor("A:%b | B:%b | C:%b | F1:%b | F2:%b",A,B,C,F1,F2);
    #25
    $finish;      // Terminate simulation
    end
    always begin
    #5
    A=A+1'b1;
    #5
    B=B+1'b1;
    #5
    C=C+1'b1;
    end

endmodule    