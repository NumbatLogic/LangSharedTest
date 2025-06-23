#!/bin/bash

rm -rf Transpiled

./Transpile.sh

cd Project
./RebuildCPP.sh