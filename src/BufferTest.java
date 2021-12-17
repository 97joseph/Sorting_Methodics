import java.io.RandomAccessFile;
import student.TestCase;

/**
 * Tests methods and fields of the Buffer class
 * @author Ross Manfred
 * @author Ryan Buxton
 */
public class BufferTest extends TestCase {
    private Buffer buffer;
    private RandomAccessFile file;
    
    /**
     * Sets up for each test
     */
    public void setUp() {
        buffer = new Buffer(file);
    }
}
