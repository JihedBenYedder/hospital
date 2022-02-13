#!/bin/bash
set -ex

yum install https://archive.fedoraproject.org/pub/epel/7/x86_64/Packages/e/epel-release-7-11.noarch.rpm
rpm --import /etc/pki/rpm-gpg/*GPG*
sudo yum install https://dl.k6.io/rpm/repo.rpm  -y
sudo yum install k6  -y