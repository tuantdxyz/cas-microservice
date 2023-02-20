#!/bin/sh
echo "kill jar"
kill -KILL `ps aux | grep authentication.jar | awk '{ print $2}' ` &
kill -KILL `ps aux | grep service01.jar | awk '{ print $2}' ` &
kill -KILL `ps aux | grep service02.jar | awk '{ print $2}' ` &
echo "kill completed"
