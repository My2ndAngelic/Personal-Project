program power;
const n=100;
type digit = 0..9;
var i,k,r: integer;
    d: array [1..n] of digit;
begin
  for k := 1 to n do
  begin
    write('.');
    r := 0;
    for i:= 1 to k-1 do
      begin
          r:= 10*r+d[i];
          d[i] := r div 2;
          r:= r-2*d[i];
          write(chr(d[i]+ord('0')))
      end;
    d[k] := 5;
    writeln(d[k]);
  end;
  readln;
end.
