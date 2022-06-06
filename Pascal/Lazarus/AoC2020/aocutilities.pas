unit AoCUtilities;

{$mode objfpc}{$H+}

interface

procedure SayHello(AMessage: String);
function ReadFileToString(ADirectory: String): String;

implementation

procedure SayHello(AMessage:String);
begin
  writeln(AMessage);
end;

function ReadFileToString(ADirectory: String): String;
begin

end;

end.

