#!/usr/bin/env bash

ARG_COUNT=$#

if [[ $ARG_COUNT != 2 ]]; then
        echo "Usage: hamming.sh <string1> <string2>"
        exit 1
fi
SEQUENCE1="$1"
SEQUENCE2="$2"

if [[ "${#SEQUENCE1}" != "${#SEQUENCE2}" ]]; then
        echo "strands must be of equal length"
        exit 1
fi

DIFF_COUNTER=0
for index in $(seq 1 ${#SEQUENCE1}); do
        LETTER_IN_SEQ_1=${SEQUENCE1:$index-1:1}
        LETTER_IN_SEQ_2=${SEQUENCE2:$index-1:1}

        if [[ "$LETTER_IN_SEQ_1" != "$LETTER_IN_SEQ_2" ]]; then
                DIFF_COUNTER=$((DIFF_COUNTER+=1))
                #echo "$LETTER_IN_SEQ_1 (seq1) is not equal to $LETTER_IN_SEQ_2 (seq2)"
        fi
done

echo "$DIFF_COUNTER"

exit 0
