@echo off
cd /d "%~dp0"
java -jar jar\logistics.jar
start iexplore "http://localhost:9002"

