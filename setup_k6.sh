#!/bin/bash
set -ex

yum install epel-release
yum install DNF
sudo dnf install https://dl.k6.io/rpm/repo.rpm   
sudo dnf install k6 