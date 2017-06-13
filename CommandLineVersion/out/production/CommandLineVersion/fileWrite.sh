#!/bin/bash
while true; do
    read -p "Category =>
                'food'
                'groceries'
                'travel'
                'misc': "
    echo "$REPLY" >> expenses.txt

    read -p "Place: "
    echo "$REPLY" >> expenses.txt

    read -p "Description: "
    echo $REPLY >> expenses.txt

    read -p "Price: "
    echo "$REPLY" >> expenses.txt

    read -p "Finished? (y/n) "
    if [ "$REPLY" = "y" ] 
    then exit 2
    fi
done
