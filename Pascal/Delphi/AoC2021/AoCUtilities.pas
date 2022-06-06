unit AoCUtilities;

interface

uses SysUtils, Generics.Collections;
function DoubleIt(Value: Integer): Integer;
function FileReaderToTListString(fileDir: String): TList<String>;
procedure SayHello(input: String);

implementation

function DoubleIt(Value: Integer): Integer;
begin
  DoubleIt := Value * 2;
end;

function FileReaderToTListString(fileDir: String): TList<String>;
var
  MyFile: TextFile;
  MyReturn: TList<String>;
  TempStr: String;
begin
  MyReturn := TList<String>.Create;
  try
    AssignFile(MyFile, fileDir);
    Reset(MyFile);
    while (not eof(MyFile)) do
    begin
      Readln(MyFile, TempStr);
      MyReturn.add(TempStr);
    end;
    Close(MyFile);
    FileReaderToTListString := MyReturn;
  except
    on E: Exception do
      Writeln('File at ' + fileDir + ' not found.');
  end;
end;

procedure SayHello(input: String);
begin
  Writeln('Hello ', input);
end;

end.
