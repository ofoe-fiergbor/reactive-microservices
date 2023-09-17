#!/usr/bin/env bash

mkdir spring-cloud
cd spring-cloud

spring init \
--boot-version=2.7.15 \
--build=gradle \
--java-version=1.8 \
--packaging=jar \
--name=gateway \
--package-name=se.magnus.spring-cloud \
--groupId=se.magnus.spring-cloud \
--dependencies=actuator \
--version=1.0.0-SNAPSHOT \
--type=gradle-project \
gateway


spring init \
--boot-version=2.7.15 \
--build=gradle \
--java-version=1.8 \
--packaging=jar \
--name=eureka-server \
--package-name=se.magnus.spring-cloud \
--groupId=se.magnus.spring-cloud \
--dependencies=actuator \
--version=1.0.0-SNAPSHOT \
--type=gradle-project \
eureka-server