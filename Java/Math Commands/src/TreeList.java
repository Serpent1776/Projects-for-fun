import DSListStuff.DSList;
import DSListStuff.DSListException;
//Fusion of tree and linked list -> Tree List!
public class TreeList<E extends Comparable<E>> implements DSList<E> {
    protected class Point<E extends Comparable<E>> {
        Point<E> next;
        Point<E> prev;
        E data;
        public Point(E data) {
            this.next = null;
            this.prev = null;            
            this.data = data;
        }
        public Point(E data, Point<E> ahead) {
            this.next = ahead;
            this.prev = null;            
            this.data = data;
        }
        public Point(Point<E> behind, E data) {
            this.next = null;
            this.prev = behind;            
            this.data = data;
        }
        public int compareTo(Point<E> other) {
            return this.data.compareTo(other.data);
        }
    }   
    int size;
    Point<E> start;
    Point<E> end;
    Point<E> middle;
    public TreeList(E data) {
        this.start = new Point<E>(data);
        this.end = start; this.middle = start;
        size = 1;
    }
    @Override
    public E get(int pos) throws DSListException {
        // linked list get, starting from what's closer.
        if(pos == size-1) {
            return end.data;
        }
        if(pos == (int)(Math.round(size/2.0))) {
            return middle.data;
        }
        if(pos == 0) {
            return start.data;
        }
        if(pos > (int)(Math.round(size/2.0))) {
            Point<E> p2 = middle;
            int posi = (int)(Math.round(size/2.0));
            if(p2 != null || posi == pos) {
                p2 = p2.next;
                posi++;
            }
        } else {
            Point<E> p2 = middle;
            int posi = (int)(Math.round(size/2.0));
            if(p2 != null || posi == pos) {
                p2 = p2.prev;
                posi--;
            }
        }
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }
    @Override
    public boolean contains(E element) {
        // starts with constants
        if(start.data.equals(element)) {
            return true;
        }
        if(middle.data.equals(element)) {
            return true;
        }
        if(end.data.equals(element)) {
            return true;
        }
        //then middle searching for O(n/2)
        Point<E> navi = middle;
        if(middle.data.compareTo(element) < 0) {
            while(navi != null && element.compareTo(navi.data) <= 0) {
                navi = navi.prev;
            }
            if(navi == null) {
                return false;
            }
            return true;
        } else {
            while(navi != null && element.compareTo(navi.data) >= 0) {
                navi = navi.next;
            }
            if(navi == null) {
                return false;
            }
            return true;
        }
        
    }
    @Override
    public int postitionOf(E element) {
        // gives position of an element starting from start
        Point<E> p1 = start;
        int pos = 0;
        while(p1.data.equals(element) && p1 != null) {
            pos++;
        }
        return pos;
    }
    @Override
    public void add(E element) {
        // adds from the middle and places it like a binary tree would
        Point<E> p = new Point<E>(element);
        if(start == end && start == middle) {
             if(start.compareTo(p) >= 0) {
                p = end.next;
                p = end;
                end.prev = middle;
                middle.next = p;
                middle = start;
             } else {
                p = start.next;
                p = start;
                start.next = middle;
                middle.prev = p;
                end = middle;
             }
        } else if (middle == end) {
            if(middle.compareTo(p) >= 0) {
                p = end.next;
                p = end;
                end.prev = middle;
                middle.next = p;
             } else {
                middle.prev = p;
                start.next = p;
                p.next = middle;
                p.prev = start;
                end = middle;
             }
        } else if (middle == start) {
            if(middle.compareTo(p) <= 0) {
                p = start.next;
                p = start;
                middle.prev = p;
                start.next = middle;
             } else {
                middle.next = p;
                end.prev = p;
                p.next = end;
                p.prev = middle;
                middle = start;
            }
        } else { 
            Point<E> navi = middle;
            if (middle.compareTo(p) <= 0) { 
            while(navi != null && p.compareTo(navi) <= 0) {
                navi = navi.prev;
            }
            p.prev = navi;
            p.next = navi.next;
            navi.next = p;
        } else {
            while(navi != null && p.compareTo(navi) >= 0) {
                navi = navi.next;
            }
            p.prev = navi.prev;
            navi.prev = p;
            p.next = navi;
        }
    }
    size++;
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
