
public class Run {

    private long currOffset;
    private long endOffset;
    private int arrayCurr;
    private int arrayEnd;

    /**
     * Creates a new Run object
     * pre: parameters are valid offsets
     * post: an empty run object has been created with curr and endOffset
     * set to appropriate values
     * @param startOffset initial offset of current run
     * @param endOffset ending offset of this run
     */
    public Run(long startOffset, long endOffset) {
        this.currOffset = startOffset;
        this.endOffset = endOffset;
        arrayCurr = 0;
        arrayEnd = 0;
    }

    /**
     * Getter for currOffset field
     * pre: field not null
     * post: field returned
     * @return value of currOffset
     */
    public long getCurrOffset() {
        return this.currOffset;
    }

    /**
     * Getter for endOffset field
     * pre: field not null
     * post: field returned
     * @return value of endOffset
     */
    public long getEndOffset() {
        return this.endOffset;
    }

    /**
     * Getter for arrayCurr field
     * pre: field not null
     * post: field returned
     * @return value of arrayCurr
     */
    public int getArrayCurr() {
        return this.arrayCurr;
    }

    /**
     * Getter for arrayEnd field
     * pre: field not null
     * post: field returned
     * @return value of arrayEnd
     */
    public int getArrayEnd() {
        return this.arrayEnd;
    }

    /**
     * Setter for arrayCurr field
     * pre: field not null
     * post: field revised to parameter value
     * @param position new value for arrayCurr
     */
    public void setArrayCurr(int position) {
        this.arrayCurr = position;
    }

    /**
     * Setter for arrayEnd field
     * pre: field not null
     * post: field revised to parameter value
     * @param end new value for arrayEnd
     */
    public void setArrayEnd(int end) {
        this.arrayEnd = end;
    }
    
    /**
     * Setter for currOffset
     * pre: field not null
     * post: field revised to parameter value
     * @param offset new value for currOffset
     */
    public void setCurrOffset(long offset) {
        this.currOffset = offset;
    }

    /**
     * Determines if end of run has been reached
     * pre: fields are all not null and valid
     * post: boolean given depending on field values
     * @return True if current offset and array index are at their end
     * False otherwise
     */
    public boolean isDone() {
        return this.arrayCurr == this.arrayEnd
            && this.currOffset == this.endOffset;
    }
    
    /**
     * Determine if run is empty
     * pre: array fields are valid
     * post: find out if run is empty
     * @return True if array index is at the end
     * False otherwise
     */
    public boolean isEmpty() {
        return this.arrayCurr == this.arrayEnd;
    }
}
