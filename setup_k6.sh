#!/bin/bash
set -ex

sudo yum install https://dl.k6.io/rpm/repo.rpm -y
sudo yum install k6 -y