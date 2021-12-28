module M16BIT(a,b,cin,sum,cout);
input [15:0] a,b;
input cin;
output [15:0]sum;
output cout;
assign {cout,sum}=a+b+cin;
endmodule

module top;

reg [15:0] a;
reg [15:0] b;
reg cin;


wire [15:0] sum;
wire cout;



M16BIT uut (
.a(a),
.b(b),
.cin(cin),
.sum(sum),
.cout(cout)
);

initial
begin
a=0;
b=0;
cin=0;
$monitor("%b + %b = %b (cin = %b) (co = %b)",a,b,sum,cin,cout);

#100

a=0;
b=0;
cin=0;

#100
a=5;
b=1;
cin=1;

#100
a=7;
b=1;
cin=0;

#50 $finish;

end
endmodule