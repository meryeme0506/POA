package panel;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 * @author Meryeme HAMAN
 */

public class Panel  extends AbstractList<Integer> implements Iterator<Integer>, Iterable<Integer>{

    private int next;
    private int start;
    private int last;

    /**
     * build a panel
     * @param start, the start of the interval
     * @param last, the last int in the interval
     * @throws IllegalArgumentException
     */
    public Panel(int start,int last) throws IllegalArgumentException{
        if(last<start){
            throw new IllegalArgumentException("Please enter valid arguments !");
        }
        this.start= start;
        this.last= last;
        this.next= start;
    }

    /**
     * returns true if the iterator has a next element, false otherwise
     * @return boolean
     */
    public boolean hasNext(){
        return last>next;
    }

    /**
     * returns the next element in the interval
     * @return an integer
     * @throws NoSuchElementException
     */
    public Integer next() throws NoSuchElementException{
        if(this.hasNext())
            return next++;
        throw new NoSuchElementException();
    }

    /**
     * Generates an interval by using anonymous class
     * @param start, the start of the interval
     * @param last, the last element of the interval
     * @return an iterator of integers
     */
    public static Iterator<Integer> panel1(int start, int last){
        return new Iterator<Integer>(){

            private int next = start;

            public boolean hasNext(){
                return last > next;
            }

            public Integer next() throws NoSuchElementException{
                if(this.hasNext())
                    return next++;
                throw new NoSuchElementException();
            }
        };
    }

    /**
     * Generates an interval with a given start and finish elements
     * with the possibility of the use of the for each method
     * @param start the first integer of the interval
     * @param last the last integer of the interval
     * @return an iterable of integers
     */
    public static Iterable<Integer> panel2(int start,int last){
        return new Panel(start,last+1);
    }

    /**
     * Overrides the method iterator() of Iterable interface
     * @return an iterator of integers
     */
    @Override
    public Iterator<Integer> iterator () {
        return new Panel(start, last);
    }

    /**
     * Overrides the method get(int) of the class AbstractList
     * @param id the given index
     * @return the integer at the given index
     */
    @Override
    public Integer get(int id) {
        return start + id;
    }

    /**
     * Overrides the method get(int) of the class AbstractList
     * @return the size of the interval
     */
    @Override
    public int size() {
        return last-start;
    }

    /**
     * Generates an interval with a given start and finish elements with the AbstractList
     * @param start the start of the interval
     * @param last the finish of the interval
     * @return a list of integers
     */
    public static List<Integer> panel(int start, int last){
        return new Panel(start,last+1);
    }
}
