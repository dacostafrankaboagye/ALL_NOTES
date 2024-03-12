/** 
 * Describes any class whose object can measure other objects
*/
public interface Measurer {
    
    /**
     * 
     * @param anObject the object to be measured
     * @return the measure
     */
    double measure(Object anObject);
}
