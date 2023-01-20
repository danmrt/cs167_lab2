mvn package
hadoop jar target/dmart245_lab2-1.0-SNAPSHOT.jar edu.ucr.cs.cs167.dmart245.App file:///$pwd/AREAWATER.csv file:///$pwd/output.txt
Measure-Command {Copy .\AREAWATER.csv output.txt}
hadoop jar target/dmart245_lab2-1.0-SNAPSHOT.jar edu.ucr.cs.cs167.dmart245.App 'file:///$pwd/AREAWATER.csv' 'hdfs:///user/dmart245/AREAWATER.csv'
hadoop jar target/dmart245_lab2-1.0-SNAPSHOT.jar edu.ucr.cs.cs167.dmart245.App 'hdfs:///user/dmart245/AREAWATER.csv' 'file:///$pwd/AREAWATER_2.csv'
hadoop jar target/dmart245_lab2-1.0-SNAPSHOT.jar edu.ucr.cs.cs167.dmart245.App 'hdfs:///user/dmart245/AREAWATER.csv' 'hdfs:///user/dmart245/AREAWATER2.csv'
