unit AoC2Helper;

interface

uses SysUtils, Generics.Collections;
function ProblemOne(dataIn: TList<String>): Integer;
function ProblemTwo(dataIn: TList<String>): Integer;

implementation

type
  IntegerArray = array of Integer;

procedure SetIntegerArray(dataIn: TList<String>; dataArray: IntegerArray);
var
  Temp: Integer;
  Code: Integer;
  I: Integer;
begin
  for I := 0 to dataIn.Count - 1 do
  begin
    Val(dataIn[I], Temp, Code);
    dataArray[I] := Temp;
  end;
end;

function ProblemOne(dataIn: TList<String>): Integer;
begin
  ProblemOne := 0;
end;

function ProblemTwo(dataIn: TList<String>): Integer;
begin
  ProblemTwo := 0;
end;

end.
