# Lab 2

## Student information
* Full name: Daniel Martinez Garzon
* E-mail: dmart245@ucr.edu
* UCR NetID: dmart245
* Student ID: 862179627

## Answers

* (Q1) Verify the file size and report the running time.

`Copied 2,271,210,910 bytes from 'AREAWATER.csv' to 'output.txt' in 26.060490 seconds`

* (Q2) Report the running time of the copy command (windows)

	```
  Measure-Command {Copy "C:\cs167\workspace\dmart245_lab2\AREAWATER.csv" -Destination "C:\cs167\workspace\dmart245_lab2\file2.txt" }
	Days              : 0
	Hours             : 0
	Minutes           : 0
	Seconds           : 15
	Milliseconds      : 815
	Ticks             : 158154185
	TotalDays         : 0.000183048825231481
	TotalHours        : 0.00439317180555555
	TotalMinutes      : 0.263590308333333
	TotalSeconds      : 15.8154185
	TotalMilliseconds : 15815.4185```
  
  15.815 seconds

* (Q3)How do the two numbers in (Q1) and (Q2) compare? (The running times of copying the file through your program and the operating system.) Explain IN YOUR OWN WORDS why you see these results.

My program took 10 seconds longer than the copy command found on the Windows Powershell. Reasoning for why the java program took longer than the powershell can be because the powershell is more efficient in copying text. As opposed to my program which uses multiple libraries fromm hadoop and classes to getFileStreams as opposed to the powershell.

* (Q4) Does the program run after you change the default file system to HDFS? What is the error message, if any, that you get?

Program does not run after changing the default file system to HDFS. I get the error message: Output file 'AREAWATER.csv' does not exists!

* (Q5) Use your program to test the following cases and report the running time for each case.

*i*.Copy a file from local file system to HDFS
`Copied 2271210910 bytes from 'file:/C:/cs167/workspace/dmart245_lab2/AREAWATER.csv' to 'hdfs:/user/dmart245/AREAWATER.csv' in 17.824414 seconds`

*ii*.Copy a file from HDFS to local file system
`Copied 2271211520 bytes from 'hdfs:/user/dmart245/AREAWATER.csv' to 'file:/C:/cs167/workspace/dmart245_lab2/AREAWATER_2.csv' in 26.026642 seconds`

*iii*.Copy a file from HDFS to HDFS
`Copied 2271211520 bytes from 'hdfs:/user/dmart245/AREAWATER.csv' to 'hdfs:/user/dmart245/AREAWATER2.csv' in 27.939696 seconds`

File System Copying | Time(seconds)
--- | --- 
Local to HDFS | 17.82
HDFS to Local | 26.03
HDFS to HDFS  | 27.94
