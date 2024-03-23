package oy.tol.tra;

public class Algorithms {
    public static <T extends Comparable<T>> int binarySearch(T aValue, T [] fromArray, int fromIndex, int toIndex) {
        // TODO: you will implement this in step 2 below.
        int len = fromArray.length;
        return 0;
    }
    public static <T extends Comparable<T>> void sort(T [] array) {
        for (int i=0; i < array.length-1; i++) {
            for (int j=0; j < array.length-1; j++) {
               if(array[j].compareTo(array[j+1])>0) {
               T tmp = array[j];
               array[j] = array[j+1];
               array[j+1] = tmp;
               }
            }
        }
    }  
    public static <T> void reverse(T [] array) {
        int i = 1;
        while (i <= array.length/2) {
            T temp = array[i-1];
            array[i-1] = array[array.length-i];
            array[array.length-i] = temp;
            i++;
        }
    }
}