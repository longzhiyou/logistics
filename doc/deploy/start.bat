@echo off
cd /d "%~dp0"
start /b java -jar jar\logistics.jar
start iexplore "http://localhost:9002"

