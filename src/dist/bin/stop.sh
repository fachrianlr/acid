#!/bin/sh

PID=`pgrep -f @jarname@`

if [ -z "$PID" ]
then
      echo "No Process of @jarname@"
else
      kill $PID
      echo stopping service @jarname@
fi

