package d5;
/**
 * @author Alexander Karg
 */
public class DuplicateEntryException extends Exception {

    /**
     *
     * @param errorMessage
     */
    public DuplicateEntryException(String errorMessage){
        super(errorMessage);
    }
}
