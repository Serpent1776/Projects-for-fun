package DSListStuff;
import java.util.Arrays;
import java.util.ArrayList;
public class DSArrayList<E extends Comparable<E>> implements DSList<E>{
    private E[] array; // array that holds them
    private int size; // how many elements live in the array
    @SuppressWarnings("unchecked")
    public DSArrayList() {
        this.array = (E[]) new Comparable[100];
        this.size = 0;
    }
    @SuppressWarnings("unchecked")
    public DSArrayList(int capacity) {
        this.array = (E[]) new Comparable[capacity];
        this.size = 0;
    }
    public E get(int pos) throws DSListException {
        if(size > pos) {
        return array[pos];
        }
        throw new DSListException("you can't get here, the position " + pos + "is too big");
    }
    public void remove(E x) {
       int pos = postitionOf(x);
       //array[pos] = null;
       for(int i = pos; i < size-1; i++) {
        array[i] = array[i+1];
       }
       array[size-1] = null;
       size--;
    }
    public boolean contains(E element) {
        for(int i = 0; i < size; i++) {
            if(array[i].equals(element)) {
                return true;
            }
        }
        
        return false;
    }
    public int postitionOf(E element) {
         for(int i = 0; i < size; i++) {
            if(array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
    private void expand() {
          /*E[] newArr =  (E[]) new Object[this.array.length*2];
          for(int i = 0; i < size; i++) {
            newArr[i] = this.array[i];
          }
          this.array = newArr;
          */
          this.array = Arrays.copyOf(this.array, this.array.length*2);
    }
    public void add(E element) {
        if(size == array.length) {
            expand();
          }
        array[size] = element;
        size++;
        }
    public void add(E[] elements) {
        while(size + elements.length >= array.length) {
            expand();
            
        }
        for(int i = 0; i < elements.length; i++) {
            array[size + i] = elements[i];
        }
        size += elements.length;
    }
    public void add(E element, int postition) throws DSListException {
        if(postition < size && postition > -1) {
          if(size == array.length) {
                   expand();
          }
            if(array[postition] != null) {
                for(int i = size; i > postition - 1; i--) {
                    array[i + 1] = array[i];
                }
                array[postition] = element;
            } else {
                array[postition] = element;
            }
        } else {
            throw new DSListException("you can't add here, the position " + postition + " is too big.");
        }
        size++;
    }
    public int size() {
        return size;
    }
    public void replace(E element, int postition) throws DSListException {
        if(postition < size && postition < array.length) {
            array[postition] = element;
        } else {
            throw new DSListException("you can't replace here, the position" + postition + "is too big");   
        }
    }
/*addSorted - assuming the list is already sorted, add x into the appropriate spot in that list, 
 *shifting all other elements as necessary.
 *You should use the method compareTo, not <, in your code. 
 *It should look like array[i].compareTo(x) < 0 to check if elements[i] is smaller than x.
 *Worst case: O(n)
 */    
    public void addSorted(E x) {
        int addLocation = -1;
        for(int i = 0; i < size; i++) {
            if(array[i].compareTo(x) >= 0) {
                addLocation = i;
                break;
            }
        }
            
        
        if(addLocation != -1) {
            try {
            add(x, addLocation);
            } catch (DSListException e) {
                e.printStackTrace();
            }
        } else {
            add(x);
        }
    }

/*allIndices - returns an ArrayList (the one built into Java) consisting of all the indices where x appears. 
 *For example, if x were 'a' in the list 'r','u','t','a','b','a','g','a':
 *this method would return a list containing 3,5,7. 
 *If x does not appear, return the empty list. Be sure to use equals rather than == for comparison.
 *Worst case: O(n)
 */
    public ArrayList<Integer> allIndices(E x) {
        ArrayList<Integer> indices = new ArrayList<Integer>();
        for(int i = 0; i < size; i++) {
            if(array[i].equals(x)) {
                indices.add(i);
            }
        }
        return indices;
    }
/*clear - removes all elements from the list.
 *Worst case: O(1)
 */
 @SuppressWarnings("unchecked")
    public void clear() {
        int len =  array.length;
        this.array = (E[]) new Comparable[len];
        size = 0;
    } 
/*
 *equals returns true if this list is the same as otherList, 
 *meaning it has the same elements in the same order. 
 *Be sure to use equals, not ==, to compare list elements.
 *Worst case: O(n)
 */
    public boolean equals(DSArrayList<E> otherList) {
        if(otherList.size() != size) {return false;}
        try {
            
        for(int i = 0; i < size; i++) {
            if(!(array[i].equals(otherList.get(i)))) {
                return false;
            }
        }
        } catch (DSListException e) {
            e.printStackTrace();
        }
        return true;
    }

/*rotate() - moves the first element of the list to the end, shifting elements as appropriate. 
You may assume the list will have at least one element. 
For example, rotating 'r','u','t','a','b','a','g','a' gives the list 'u', 't', 'a', 'b', 'a', 'g', 'a', 'r'. 
Worst case - O(n)
*/
    public void rotate() {
        for(int i = 0; i < size-1; i++) {
            if(i != 0) {
                E temp = this.array[i-1];
                this.array[i-1] = this.array[i];
                this.array[i] = temp;
            } else {
                E temp = this.array[size-1];    
                this.array[size-1] = this.array[i];
                this.array[i] = temp;
        }
        }
    }
/*public E getMode() throws DSListException. 
It should return the element that appears most often in the list. 
For example, if the list were [6, 5, 1, 5, 2, 3, 1, 5, 4], 
it would return 5 since there are 3 5s in the list, 2 1s, and every other element appears just once. 
If there is a tie for mode, you could return any one of the tied elements. 
For example, with [6, 5, 1, 5, 2, 3, 1, 5, 1], you could return either 5 or 1. 
If the list is empty, throw an exception.  
Time: O(n^2)*/
    public E getMode() throws DSListException {
        if(size == 0) {throw new DSListException("This function cannot be done on empty lists!");}
        boolean endItAll = false;
        E mode = this.array[0];
        int[] counters = new int[this.size];
            for(int i = 0; i < size; i++) {
                boolean notDupe = true;
                E x = this.array[i];
                for(int d = i-1; d > 0; d--) {
                    if(this.array[d].equals(x)) {
                        
                        notDupe = false;
                    }
                }
                if(notDupe) {
                    for(int u = 0; u < size; u++) {
                        if(this.array[u].equals(x)) {
                            counters[i]++;
                        }
                    }
                }
                for(int l = 0; l < size; l++) {
                    if(counters[l] > this.size/2) {
                        endItAll = true;
                        break;
                    }
                }
                if(endItAll) {break;}
            //System.out.println(counters); this line is just for debugging 
        }
        int greatest = counters[0];
        for(int i = 0; i < size; i++) {
            if(counters[i] > greatest) {
                greatest = counters[i];
                mode = this.array[i];
            }
        }
        return mode;
    }

    public String toString() {
        String arrStr = "[";
        for(int i = 0; i < size; i++) {
            if(i < size - 1) {
                arrStr += this.array[i] + ", ";
            } else {
                arrStr += this.array[i];    
            }
        }
        return arrStr + "]";
    }
}
