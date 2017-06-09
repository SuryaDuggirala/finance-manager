#!/bin/bash

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
