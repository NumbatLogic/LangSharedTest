#!/bin/bash

./CodeCrab.sh && ./Transpile.sh | cat && cd Project/LangSharedTest/CS && ./Build.sh | cat && ./Run.sh | cat