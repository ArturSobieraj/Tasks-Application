call runcrud.bat
if "%ERRORLEVEL%" == "0" goto startchrome
echo.
echo runcrud.bat has errors - terminating
goto errorstop

:startchrome
start "C:\Program Files (x86)\Google\Chrome\Application\chrome.exe" http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo Cannot open chrome
goto errorstop

:errorstop
echo.
echo Process finished with errors

:end
echo.
echo Script completed