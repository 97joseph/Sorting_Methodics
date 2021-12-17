
import java.io.*;

/**
 * Project Runner object run from the command line
 * Provides sorting on provided input and output filenames
 * TODO input machine specs and such 
 * @author Ross Manfred
 * @author Ryan Buxton
 */
public class Externalsort {
    
	/**
	 * Main method automatically called on execution of program
	 * Expects filenames for input and output files for use by program
	 * Calls appropriate objects to accomplish goals of project
	 * pre: input filename is a valid file to use
	 * post: outputFile has records sorted as desired
	 * @param args contains names of input and output files
	 */
    public static void main(String[] args) {
        try {
            RandomAccessFile inputFile = new RandomAccessFile(args[0], "r");
            RandomAccessFile outputFile = new RandomAccessFile("output.bin", "rw");
            outputFile.setLength(0);
            RandomAccessFile runFile = new RandomAccessFile("run.bin", "rw");
            runFile.setLength(0);
            RecordSorter sorter = new RecordSorter(inputFile, outputFile, runFile);
            inputFile.close();
            outputFile.close();
            runFile.close();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Wrong number of arguments: " + e);
        }
        catch (FileNotFoundException e) {
            System.err.println("Could not find file: " + args[0]);
        }
        catch(IOException e) {
            System.err.println("Writing error: " + e);
        }
    }
    

}
