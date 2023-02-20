#!/bin/bash
echo "run jar file"
nohup java -jar authentication.jar & ps axu|grep authentication.jar &
nohup java -jar service01.jar & ps axu|grep service01.jar &
nohup java -jar service02.jar & ps axu|grep service02.jar &
echo "run completed"
