#!/usr/bin/env bash

NUMBER_OF_ARGS="$#"

if [[ "$NUMBER_OF_ARGS" = 0 || "$NUMBER_OF_ARGS" -gt 1 ]]; then
    echo "Usage: error_handling.sh <person>"
    exit 1
fi

NAME=$1

printf "Hello, %s\n" "$NAME"
exit 0