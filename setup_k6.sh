#!/bin/bash
set -ex

yum clean all
wget https://dl.fedoraproject.org/pub/epel/epel-release-latest-7.noarch.rpm

sudo yum install k6  -y --nogpgcheck