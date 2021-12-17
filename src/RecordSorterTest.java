import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import student.TestCase;

/**
 * Tests methods and fields of RecordSorter class
 * 
 * @author Ross Manfred
 * @author Ryan Buxton
 */
public class RecordSorterTest extends TestCase {
    private RecordSorter sorter;
    private RandomAccessFile inputFile;
    private RandomAccessFile outputFile;
    private RandomAccessFile runFile;
    private FileWriter textFile;
    private FileWriter otherFile;

    /**
     * Sets up for each test method
     * 
     * @throws IOException
     */
    public void setUp() throws IOException {
        inputFile = new RandomAccessFile("src/test200.bin", "r");
        outputFile = new RandomAccessFile("output.bin", "rw");
        outputFile.setLength(0);
        runFile = new RandomAccessFile("run.bin", "rw");
        runFile.setLength(0);
        sorter = new RecordSorter(inputFile, outputFile, runFile);
        textFile = new FileWriter("run.txt");
        otherFile = new FileWriter("output.txt");
    }

    /**
     * Prints reference data to output file for verification
     * 
     * @throws IOException
     */
    public void test() throws IOException {
        sorter.printFileContents(outputFile, otherFile);
        sorter.printFileContents(runFile, textFile);

        inputFile.close();
        outputFile.close();
        runFile.close();
        textFile.close();
        otherFile.close();
    }

    // public void test() throws IOException {
    // sorter.readInputBufferData(inputFile);
    // sorter.writeInputBufferData(runFile);
    //
    // inputFile.close();
    // outputFile.close();
    // runFile.close();
    // }

    // public void test3() throws IOException {
    // //sorter.printFileContents(inputFile, outputFile);
    // textFile.write("hey");
    // inputFile.close();
    // outputFile.close();
    // runFile.close();
    // textFile.close();
    // }

}
