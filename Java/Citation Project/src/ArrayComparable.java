public class ArrayComparable<E extends Comparable<E>>{
    public ArrayComparable() {
        
    }
    public int compareTo(E[] arr, E[] other) {
        int total = 0;
        total += arr.length - other.length;
        if(total > 0) {
            E[] expandedOther = expand(arr.length, other);
            for(int i = 0; i < arr.length; i++) {
                total += arr[i].compareTo(expandedOther[i]);
            }
        } else if (total < 0) {
            E[] expandedArr = expand(other.length, arr);
            for(int i = 0; i < other.length; i++) {
                total += expandedArr[i].compareTo(other[i]);
            }
        } else {
            for(int i = 0; i < arr.length; i++) {
                total += arr[i].compareTo(other[i]);
            }
        }
        return total;
    }
    @SuppressWarnings("unchecked")
    public E[] expand(int length, E[] arr) {
        //assumes length is greater than the length of the array
        E[] newArr = (E[])(new Object[length]);
        for(int i = 0; i < length;i++) {
            if(i < arr.length) {
                newArr[i] = arr[i];
            } else {
                newArr[i] = null;
            }
        }
        return newArr;
        
    }
}
