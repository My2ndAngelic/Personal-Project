unit AoC1Helper;

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

function Count(dataArray: IntegerArray): Integer;
begin

end;

function ProblemOne(dataIn: TList<String>): Integer;
type
  Tdata = array of Integer;
var
  dataArray: IntegerArray;
  I: Integer;
  Code: Integer;
  Temp: Integer;
begin
  SetLength(dataArray, dataIn.Count);
  SetIntegerArray(dataIn, dataArray);
  Temp := 0;
  for I := 0 to Length(dataArray) - 2 do
  begin
    if dataArray[I] < dataArray[I + 1] then
      Inc(Temp);
  end;
  ProblemOne := Temp;
end;

function ProblemTwo(dataIn: TList<String>): Integer;
type
  Tdata = array of Integer;
var
  dataArray: IntegerArray;
  I: Integer;
  Code: Integer;
  Temp: Integer;

begin
  ProblemTwo := 0;
end;

end.
