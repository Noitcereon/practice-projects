#! /usr/bin/bash

# declare variable. No spaces!
greeting="Welcome back"
user=$(whoami)
dateAndTime=$(date)

# Simple use of a variable: $variableName
echo "$greeting $user! Today is $dateAndTime."
echo "Your Bash shell version is: $BASH_VERSION. Enjoy!"
echo
# Get the length of a String variable: ${#variableName}
echo "greeting is ${#greeting} in length"
echo "user is ${#user} in length"

# If syntax. Spaces matter! (identation doesn't). 'If' syntax ends with fi
if [ ${#user} == ${#user} ]; 
    then
        echo "They're the same!"
    fi
