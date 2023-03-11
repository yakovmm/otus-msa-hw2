#!/usr/bin/env sh

kubectl create ns hw2
helm upgrade --install -n hw2 otus-msa-hw2 helm/chart