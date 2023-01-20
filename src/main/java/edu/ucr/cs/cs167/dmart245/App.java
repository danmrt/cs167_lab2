package edu.ucr.cs.cs167.dmart245;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;

public class App {
    public static void main( String[] args ) throws Exception {
        if (args.length != 2) {
            System.err.println("Incorrect number of arguments! Expected two arguments.");
            System.exit(-1);
        }

        Configuration conf = new Configuration(); //to be used for Path#getFileSystem(configuration)
        Path input = new Path(args[0]); // gets the first argument of the command line : the input file
        Path output = new Path(args[1]); //gets the second argument of command line : the output file location
        FileSystem inFS = input.getFileSystem((conf));
        FileSystem outFS = output.getFileSystem((conf));

        if (!inFS.exists(input)) { //checks if input file user has entered exists or not
            System.err.printf("Output file '%s' does not exists!\n", input);
            System.exit(-1);
        }

        if (outFS.exists(output)) {//checks if output file already exists
            System.err.printf("Output file '%s' already exists!\n", output);
            System.exit(-1);
        }

        FSDataInputStream input_stream = inFS.open(input); //opens and reads user inputted file arg
        FSDataOutputStream output_stream = outFS.create(output);//writes to user outputted file arg

        long startTime = System.nanoTime(); //start of copying file

        byte buffer[] = new byte[2048];
        long bytesCopied = 0;
        int byteReading = 0;

        while ( (byteReading = input_stream.read(buffer)) > 0) { //while we still have bytes left to read
            output_stream.write(buffer);
            bytesCopied = bytesCopied + byteReading;
        }

        input_stream.close();
        output_stream.close();

        //closed the streams
        long endTime = System.nanoTime(); // now we have the time of when we finished as well as when we started

        System.out.printf("Copied %d bytes from '%s' to '%s' in %f seconds\n",
                            bytesCopied, input, output, (endTime - startTime) * 1E-9);


    }
}



