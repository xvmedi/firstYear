#!/bin/bash
# BASH SCRIPT CONVERTER: CSV to JSON
# CRISTO VASILAROS 991695069
# 2023-04-03

#input output variables, can change later to i/o for any csv
#vars
input="world_10.csv"
output="world_2023.json"

#override previous file
`cp /dev/null $output`


#------PARSING FILE------------#

#parsing input to array
if [ -r "$input" ]
then
    i=0
    while read -r line
    do
    	#put each line to array
	lines[$i]="$line"
	i=$((i+1)) #next index
 done < $input

	# print number of lines
	echo "${#lines[@]} lines in CSV file..."
else
    echo "Failed to open file. $input"
    exit 1
fi

#----------------------#

# getting value pairs


printf "%s[\n" >> $output #beginning of json structure [

#loop over all lines of input
i=0
for line in "${lines[@]}"
do
	if [ $i -eq 0 ]
	then
		# get keys array, delimited by ","
		IFS="," read -a keys <<< ${lines[0]}
	else
		printf "%5s{\n" >> $output #beginning of json object

		#get delimited values array
		IFS="," read -r -a values <<< "$line"

		#loop over all keys and values concurrently
		j=0
		while [ $j -lt ${#keys[@]} ]
		do
			key=${keys[$j]}
			value=${values[$j]}
			if [ $j -lt $(( ${#keys[@]} - 1 )) ]
			then
				#if the value is number (redirect errors to the void)
				if [ "$value" -eq "$value" 2>/dev/null ]
				then
					printf "%10s\"${key}\" : %.0d${value}%s,\n" >> $output
				else
					printf "%10s\"${key}\" : \"${value}\",\n" >> $output
					#printf "%10s\"${key}\" : %.0d${value}%s,\n" >> $output
				fi
			else
				#if the value is number (redirect errors to the void)
				if [ "$value" -eq "$value" 2>/dev/null ]
				then
					printf "%10s\"${key}\" : %.0d${value}\n\n" >> $output
				else
					printf "%10s\"${key}\" : \"${value}\"\n\n" >> $output
				fi
			fi
			j=$(( j + 1 )) #increment 
		done
		printf "%5s},\n" >> $output # end of json object }
	fi
i=$((i + 1)) #increment program sentinel value, kill program
done



printf "%s]\n" >> $output #end of json structure ]

#-------------PROMPT/NOTIF------------------#

echo "${#keys[@]} keys in CSV file."
# program ended, display the elpased time in seconds
startTime=`date +%s`
endTime=`date +%s`
echo "Elapsed Time: $((endTime - startTime)) seconds"
echo "PROGRAM TERMINATED"
