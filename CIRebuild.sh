#!/bin/bash
set -xeuo pipefail

cd ../Lang
./DevBuildCS.sh
./RebuildCPP.sh

cd ../LangSharedTest
./Rebuild.sh
./TestCPP.sh
./TestCS.sh