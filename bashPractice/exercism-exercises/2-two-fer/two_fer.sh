#!/usr/bin/env bash

FRIENDS=("$@")

NAME="$1"

for FRIEND in "${FRIENDS[@]}"; do
  if [[ $NAME = "$FRIEND" ]]; then
	echo "One for $NAME, one for me."
	exit 0;
  fi
done

echo "One for you, one for me.";
exit 0;