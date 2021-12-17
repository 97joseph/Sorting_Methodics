

import java.io.EOFException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;


public class RecordSorter {
	
	/**
	 * Creates a new RecordSorter object
	 * manages sort and merge operations on data
	 * pre: files are all valid
	 * post: outputFile is written with proper data in order
	 * @param inputFile	file containing input values
	 * @param outputFile ultimate file for output of data
	 * @param runFile temporary output file storing runs for merge
	 * @throws IOException
	 */
    public RecordSorter(
        RandomAccessFile inputFile,
        RandomAccessFile outputFile,
        RandomAccessFile runFile)
        throws IOException {

        Buffer inputBuffer = new Buffer(inputFile);
        Buffer outputBuffer = new Buffer(runFile);
        Record[] heapArray = null;

        ReplacementSelectionDriver replacementSelection =
            new ReplacementSelectionDriver(inputBuffer, outputBuffer, inputFile,
                runFile);

        ArrayList<Run> runs = replacementSelection.createRuns();
        heapArray = replacementSelection.getHeapMemory();

        MultiwayMergeDriver multiwayMerge = new MultiwayMergeDriver(inputBuffer,
            outputBuffer, inputFile, outputFile, runFile, heapArray, runs);
        multiwayMerge.multiwayMerge();

    }
    
    /**
     * Prints contents of sorter to a provided output file
     * pre: file and writer are valid
     * post: contents are printed properly using FileWriter
     * @param readFile	input file to get records from
     * @param writeFile output file to write records
     * @throws IOException
     */
    public void printFileContents(
        RandomAccessFile readFile,
        FileWriter writeFile)
        throws IOException {
        readFile.seek(0);
        byte[] data = new byte[16];
        int num = 0;
        while (num != -1) {
            try {
                num = readFile.read(data);
                if (num != -1) {
                    Record record = new Record(data);
                    writeFile.write(record.toString());
                }
            }
            catch (EOFException e) {
                return;
            }
        }
    }

}
