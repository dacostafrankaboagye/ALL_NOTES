
/**
 * Computes information about a set of data values
 */


public class DataSet{

    private double sum;
    private Measurable maximum;
    private int count;

    /**
     * Constructs an empty dataset
     */
    public DataSet() {
        sum = 0;
        count = 0;
        // maximum = 0;
    }

  
    public void add(Measurable x) {
        sum = sum + x.getMeasure();
        if (count == 0 || maximum.getMeasure() < x.getMeasure()) {
            maximum = x;
        }
        count++;
    }

    /**
     * Gets the average of the added data
     * 
     * @return the average or 0 if no data has been added
     */
    public double getAverage() {
        if (count == 0) {
            return 0;
        } else {
            return sum / count;
        }
    }


    public Measurable getMaximum() {
        return maximum;
    }

}
