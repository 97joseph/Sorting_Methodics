
import student.TestCase;

/**
 * tests methods and fields of record class
 * 
 * @author Ross Manfred
 * @author Ryan Buxton
 */
public class RecordTest extends TestCase {
    private Record record;
    private Record record2;

    /**
     * Sets up for each test
     */
    public void setUp() {
        byte[] data = { 0x12, 0x34, 0x56, 0x78, 0x12, 0x12, 0x34, 0x45,
                0x12, 0x34, 0x56, 0x78, 0x12, 0x12, 0x34, 0x45 };
        record = new Record(data);
        byte[] data2 = { 0x12, 0x34, 0x56, 0x78, 0x12, 0x12, 0x34, 0x45,
                0x22, 0x34, 0x56, 0x78, 0x12, 0x12, 0x34, 0x45 };
        record2 = new Record(data2);
    }

    /**
     * Tests conversion of record to string
     */
    public void testToString() {
        System.out.println(record.toString());
        System.out.println(record.toString());
        System.out.println(record.toString());
        System.out.println(record.toString());
        System.out.println(record2.toString());

        assertNotNull(record.toString());
        assertEquals(-1, record.compareTo(record2));
    }

    // public void testCompare() {
    // Record other = new Record(3520943, 6e9);
    // assertTrue(record.compareTo(other) < 0);
    // }
}
