javac *.java

while [ "$REPLY" != "done" ] ;
do 
    read -p "Analyze: "
    if [ "$REPLY" != "done" ]
    then
        java Main "$REPLY"
    fi
done


