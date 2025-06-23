#!/bin/bash
set -x

cd Source/LangSharedTest
php -d short_open_tag=true -d display_errors=true "../../../CodeCrab/CodeCrab.php" "."
cd ../..