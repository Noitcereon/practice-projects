#! /usr/bin/bash

function removeChar() {
    inputArg1=${1}
    lengthOfString=${#1}
    if [ $lengthOfString -lt 2 ];
    then
    echo "returning"
    return 0
    fi
    indexOfSecondLastCharacter=$((lengthOfString-2))
    # Takes the substring of inputArg1 between 2nd char till the secondLastChar
    subString=${inputArg1:1:$indexOfSecondLastCharacter}
    echo $subString
    return 0
}

removeChar "abc"