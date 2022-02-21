#!/bin/bash

ls -l
java -Djavax.net.ssl.trustStore=truststore.jks -Djavax.net.ssl.truststoretype=JKS -Djavax.net.ssl.trustStorePassword=changeit ${JAVA_OPTS} -jar app.jar