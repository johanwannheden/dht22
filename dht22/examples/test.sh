#!/bin/bash
regex='"name":"([a-zA-Z.@]+)"'
input='"name":"internal.action.retry.queue@temp"'

if [[ $input =~ $regex ]]
then
    echo "$input matches regex $regex"
    for (( i=0; i<${#BASH_REMATCH[@]}; i++))
    do
        echo -e "\tGroup[$i]: ${BASH_REMATCH[$i]}"
    done
else
    echo "$input does not match regex $regex"
fi
