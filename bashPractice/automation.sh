#! /usr/bin/bash

dry=false

while getopts ':d' OPTION; do
    case "$OPTION" in 
    d)
        echo "-d flag triggered"
        dry="true"
        ;;
    ?)
        echo "./$(basename "$0") incorrect usage. Usage: ./automation.sh -d (optional dry run)"
        exit 1
        ;;
    esac
done

function dryRun {
    echo "Dry run: $1 $2"
}
function listDirectory {
    echo "Listing directory content"
    ls
}

if [[ $dry == true ]];
then
    dryRun "listDirectory"
    dryRun "git clone https://github.com/Noitcereon/nina-singh-website.git"
    dryRun "cd nina-singh-website" || exit
    dryRun "npm install"
    dryRun "cd .."
    dryRun "listDirectory"
    dryRun "cd nina-singh-website" || exit
    dryRun "npm run dev"
fi
if [[ $dry == false ]];
then
    echo "Starting automatic install of Nina Singh Website"
    listDirectory
    git clone https://github.com/Noitcereon/nina-singh-website.git || echo "git clone failed, but continuing on the assumption that clone was previously run."
    cd nina-singh-website || exit
    npm install
    cd ..
    listDirectory
    cd nina-singh-website || exit
    echo "Auto install complete. Starting dev server."
    npm run dev
fi
