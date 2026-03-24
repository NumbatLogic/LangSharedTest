#!/bin/bash
set -xeuo pipefail

cd ../Lang
./Bootstrap.sh

cd ../LangSharedTest

./Rebuild.sh --CPP
./Test.sh --CPP

./Build.sh --CS
./Test.sh --CS