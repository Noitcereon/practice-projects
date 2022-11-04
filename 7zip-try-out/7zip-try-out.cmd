@ECHO OFF

SETLOCAL

:: Cannot start the variable with a number else I would've done that.
SET ZIP7_HOME="C:\Program Files\7-Zip\7z.exe"
ECHO %ZIP7_HOME%

SET COMMAND=%ZIP7_HOME%
ECHO Calling %COMMAND%
CALL %COMMAND%

ENDLOCAL