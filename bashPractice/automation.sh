#! /usr/bin/bash

dry=false

while getopts ':d' OPTION; do
    case "$OPTION" in 
    d)
        echo "-d flag triggered"
        dry="true"
        ;;
    ?)
        echo "./$(basename "$0")"
        exit 1
        ;;
    esac
done

function dryRun {
    echo "Dry run: $1"
}

if [[ $dry == true ]];
then
    dryRun date
    dryRun ls
    dryRun 'mkdir "testDir"'
fi
if [[ $dry == false ]];
then
    echo "Starting automation... "
    date
    ls
    mkdir "testDir"
    ls
fi
