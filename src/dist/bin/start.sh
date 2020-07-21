#!/bin/sh

cd `dirname $0`

PID=`pgrep -f @jarname@`

if [ -z "$PID" ]
then
    nohup ./run.sh "$@" > /dev/null 2>&1 &
    echo "Start service of @jarname@"
else
    echo "@jarname@ already running !"
fi
