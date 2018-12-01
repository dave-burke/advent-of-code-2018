#!/bin/bash

set -e

./gradlew clean build install
./build/install/aoc-2018/bin/aoc-2018 $1 $2