#!/bin/bash

echo "deploying Hospital MS"
java -jar *.jar > /dev/null 2> /dev/null < /dev/null &
echo "done deploying Mudoku-webapp.war"
