#!/bin/bash

while true; do 
    read -p "Analytics: " cmd
    if [ "$cmd" = "exit" ] 
    then 
        exit 2
        clear
    else
        java Main $cmd
    fi
done

