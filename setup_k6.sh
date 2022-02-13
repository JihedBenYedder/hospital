#!/bin/bash
set -ex

yum clean all

sudo yum install k6  -y --nogpgcheck