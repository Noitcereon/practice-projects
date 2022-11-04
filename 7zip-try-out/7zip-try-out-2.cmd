@ECHO OFF

SETLOCAL

:: Cannot start the variable with a number else I would've done that.
SET ZIP7_HOME=C:\Program Files\7-Zip
ECHO %ZIP7_HOME%

::SET COMMAND="%ZIP7_HOME%"\7z.exe e ".\DirectoryA\apache-tomcat-8.5.83.tar.gz" -o".\DirectoryA\"
::ECHO Calling %COMMAND%
::CALL %COMMAND%
ECHO 'DIR FIND 7zip-try-out.cmd'
DIR /A "7zip-try-out.cmd"
ENDLOCAL