@REM ----------------------------------------------------------------------------
@REM Apache Maven Wrapper
@REM Based on: https://github.com/apache/maven-wrapper
@REM Licensed under Apache License 2.0
@REM ----------------------------------------------------------------------------

@echo off
setlocal

if not "%MAVEN_HOME%" == "" goto haveMavenHome
for %%i in (mvn.cmd) do set "MAVEN_HOME=%%~dp$PATH:i"
if "%MAVEN_HOME%" == "" (
  echo Error: MAVEN_HOME is not set and mvn.cmd is not in PATH
  exit /b 1
)

:haveMavenHome
if exist "%MAVEN_HOME%\bin\mvn.cmd" goto init

echo Error: MAVEN_HOME=%MAVEN_HOME% does not point to a valid Maven installation
exit /b 1

:init
setlocal enabledelayedexpansion
for /F "usebackq delims== tokens=1,*" %%A in (`"findstr /b /v "@echo" "%~f0""`) do (
  set "maven_BATCH_SCRIPT_LOC=%%A"
  set "maven_CMD_LINE_ARGS=!maven_CMD_LINE_ARGS! %%B"
)

cd /d "%~dp0" || exit /b 1

"%MAVEN_HOME%\bin\mvn.cmd" %maven_CMD_LINE_ARGS%
