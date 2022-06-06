program AoC1;

{$APPTYPE CONSOLE}

{$R *.res}

uses
  System.SysUtils,
  Generics.Collections,
  Classes,
  AoCUtilities in 'AoCUtilities.pas',
  AoC1Helper in 'AoC1Helper.pas';

type
  StrArray = array of String;

var
  dataIn: StrArray;
  temp: String;
  TempTLS:  TList<String>;
  Output: Integer;

begin
    try
      SetCurrentDir('../../input/');
      IntToStr(8);
      TempTLS := TList<String>.Create(AoCUtilities.FileReaderToTListString('input1.txt'));
      Output := AoC1Helper.ProblemOne(TempTLS);
      Writeln('Problem 1: ', AoC1Helper.ProblemOne(TempTLS));
      Writeln('Problem 2: ', AoC1Helper.ProblemTwo(TempTLS));
      Readln;
    except
      on E: Exception do
      begin
        WriteLn(E.ClassName+ ': ' + E.Message + ' ' + E.StackTrace);
        Readln;
      end;
    end;
end.

