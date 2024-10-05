import DSListStuff.DSList;
import DSListStuff.DSListException;
//Fusion of tree and linked list -> Tree List!
public class PointList<E extends Comparable<E>> implements DSList<E> {
    protected class Point<E> {
        Point<E> next;
        Point<E> prev;
        E x;
        E y;

        public Point() {
            this.next = null;
            this.prev = null;            
            this.x = null;
            this.y = null;
        }
        public Point(E x, E y, Point<E> ahead) {
            this.next = ahead;
            this.prev = null;            
            this.x = x;
            this.y = y;
        }
        public Point(Point<E> behind, E x, E y) {
            this.next = null;
            this.prev = behind;            
            this.x = x;
            this.y = y;
        }
        public int compareTo(Point<E> other) {
            return -1;
        }
    }   
    int size;
    Point<E> start;
    Point<E> end;
    Point<E> middle;
    public PointList() {
        this.start = new Point<E>();
        this.end = start; this.middle = start;
        size = 1;
    }
    @Override
    public E get(int pos) throws DSListException {
        // linked list get, starting from what's closer.
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }
    @Override
    public boolean contains(E element) {
        // starts from middle, looking for element.
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }
    @Override
    public int postitionOf(E element) {
        // gives position of an element starting from middle
        throw new UnsupportedOperationException("Unimplemented method 'postitionOf'");
    }
    @Override
    public void add(E element) {
        // adds from the middle and places it like a binary tree would
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }
    @Override
    public void add(E element, int postition) throws DSListException {
        throw new UnsupportedOperationException("I will not be implented because this class's a tree!");
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void replace(E element, int postition) throws DSListException {
        // replaces a point via position from the start, middle, end depending on closeness to given int position
        throw new UnsupportedOperationException("I will not be implented because this class's a tree!");
    }
       
}
