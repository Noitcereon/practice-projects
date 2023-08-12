#!/usr/bin/env bash

# The rules of raindrops are that if a given number:

#    has 3 as a factor, add 'Pling' to the result.
#    has 5 as a factor, add 'Plang' to the result.
#    has 7 as a factor, add 'Plong' to the result.
#    does not have any of 3, 5, or 7 as a factor, the result should be the digits of the number.

#set -x
ARG_COUNT=$#

if [[ "$ARG_COUNT" != 1 ]]; then
	echo "Invalid usage."
	echo "Usage: 'raindrops.sh [number]"
	exit 1
fi

A_NUMBER=$1

OUTPUT=""
if (( $A_NUMBER % 3 == 0 )); then
	OUTPUT+="Pling"
fi

if (( $A_NUMBER % 5 == 0 )); then
	OUTPUT+="Plang"
fi

if (( $A_NUMBER % 7 == 0 )); then
	OUTPUT+="Plong"
fi
if [[ $OUTPUT == "" ]]; then
	OUTPUT+="$A_NUMBER"
fi	

echo "$OUTPUT"

exit 0

