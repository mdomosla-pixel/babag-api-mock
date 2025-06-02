#!/bin/sh

exec java -Djava.net.preferIPv4Stack=true -jar /babag-api-mock-standalone.jar $@
