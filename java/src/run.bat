@echo off

SET classname=%1

if exist %classname%.class DEL %classname%.class
    
javac %classname%.java

if exist %classname%.class java %*
