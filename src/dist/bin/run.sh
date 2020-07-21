#!/bin/sh

cd `dirname $0`/.. || exit 1

exec java -server \
    -Xms128m \
    -Xmx256m \
    -Xloggc:log/gc.log \
    -Djava.net.preferIPv4Stack=true \
    -XX:+ExplicitGCInvokesConcurrentAndUnloadsClasses \
    -XX:+UseConcMarkSweepGC  \
    -XX:+AggressiveOpts \
    -XX:+ParallelRefProcEnabled \
    -XX:ParallelGCThreads=2 \
    -XX:+TieredCompilation \
    -Dspring.config.location=resources/application.properties \
    -jar @jarname@ "$@"
