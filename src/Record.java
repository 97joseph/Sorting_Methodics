import java.nio.ByteBuffer;

public class Record implements Comparable<Record> {
    private byte[] data; // byte representation of the data

    /**
     * Create a new Record object with the given data.
     * 
     * Pre-condition: data is a byte array with 16 bytes
     * Post-condition: A new Record object has been created with the given data.
     * 
     * @param data
     *             of the new Record object
     */
    public Record(byte[] data) {
        this.data = data;
    }

    /**
     * Compare two Record objects based on the last eight bytes of each Record's
     * data, treated as a double
     * 
     * Pre-condition: Other is a Proper Record object.
     * Post-condition: The int has been
     * 
     * @return 1 if this is greater than other, 0 if they are the same, or -1 if
     *         other is greater than this.
     */
    @Override
    public int compareTo(Record other) {
        if (other == null) {
            return -1;
        }
        Double thisKey = new Double(this.getKey()); // used to compare
        Double otherKey = new Double(other.getKey()); // used to compare
        return thisKey.compareTo(otherKey);
    }

    /**
     * Create a string representation of the Record.
     * 
     * Pre-condition: this is a proper Record.
     * Post-condition: the string representation has been returned.
     * 
     * @return the string representation
     */
    @Override
    public String toString() {
        return String.format("ID: %d Key: %e\n", getID(), getKey());
    }

    /**
     * Get the first 8 bytes of the Record's data and return it as a long.
     * 
     * Pre-condition: this is a proper Record.
     * Post-condition: the ID has been returned.
     * 
     * @return the ID of the Record
     */
    public long getID() {
        // used to read the byte array
        ByteBuffer buffer = ByteBuffer.wrap(data);
        return buffer.getLong();
    }

    /**
     * Get the second 8 bytes of the Record's data and return it as a double.
     * 
     * Pre-condition: this is a proper Record.
     * Post-condition: the key has been returned.
     * 
     * @return the key of the Record
     */
    public double getKey() {
        // used to read the byte array
        ByteBuffer buffer = ByteBuffer.wrap(data);
        return buffer.getDouble(8);
    }

    /**
     * Get the data of the Record.
     * 
     * Pre-condition: this is a proper Record.
     * Post-condition: the key has been returned.
     * 
     * @return the byte array of data
     */
    public byte[] getBytes() {
        return data;
    }

    /**
     * Print the Record's ID and key each followed by a space.
     * 
     * Pre-condition: this is a proper Record.
     * Post-condition: the fields have been printed.
     */
    public void print() {
        System.out.print(getID() + " ");
        System.out.print(getKey() + " ");
    }

}
