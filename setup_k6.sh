#!/bin/bash
set -ex

yum install epel-release
sudo yum install https://dl.k6.io/rpm/repo.rpm  -y
sudo yum install k6  -y