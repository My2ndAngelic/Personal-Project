program AoC1;
uses
 Sysutils;

const
  C_FNAME = 'input1.txt';

var
  x: integer;
  i: integer;
  j: integer;
  k: integer;
  l: integer;
  example: array of integer;

  tfIn: TextFile;

begin
  writeln('Hello World');

  SetCurrentDir('../../input');
  writeln(GetCurrentDir);

  AssignFile(tfIn, C_FNAME);

  try
    // Read the file to example array
    reset(tfIn);
    setLength(example, 3);
    i := 0;
    while not(eof(tfIn)) do
    begin
      k := length(example);
      if i >= k then
        setLength(example, i+1);
      readln(tfIn, x);
      example[i] := x;
      i := i+1;
    end;
    CloseFile(tfIn);

  for i := 0 to k-1 do
    for j := i+1 to k do
       if (example[i] + example[j] = 2020) then
          begin
            writeln(example[i],' ', example[j]);
            writeln(example[i]*example[j]);
          end;

  for i := 0 to k-2 do
    for j := i+1 to k-1 do
      for l := j+1 to k do
        if (example[i] + example[j] + example[l] = 2020) then
          begin
            writeln(example[i],' ', example[j], ' ',example[l]);
            writeln(example[i]*example[j]*example[l]);
          end;

  except
    on E: EInOutError do
     writeln('File handling error occurred. Details: ', E.Message);
  end;

  readln;

end.
