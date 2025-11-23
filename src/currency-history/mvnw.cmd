@REM Maven Wrapper Script
@echo off
setlocal

if not "%MAVEN_HOME%" == "" goto haveMavenHome
for %%i in (mvn.cmd) do set "MAVEN_HOME=%%~dp$PATH:i"
if "%MAVEN_HOME%" == "" (
  echo Error: MAVEN_HOME is not set and mvn.cmd is not in PATH
  exit /b 1
)

:haveMavenHome
setlocal enabledelayedexpansion
for /F "usebackq delims== tokens=1,*" %%A in (`"findstr /b /v "@echo" "%~f0""`) do (
  set "maven_CMD_LINE_ARGS=!maven_CMD_LINE_ARGS! %%B"
)

cd /d "%~dp0" || exit /b 1

"%MAVEN_HOME%\bin\mvn.cmd" %maven_CMD_LINE_ARGS%
