package oy.tol.tra;

public class Algorithms {

    public static <T extends Comparable<T>> int binarySearch(T aValue, T [] fromArray, int fromIndex, int toIndex) {
        while (fromIndex<=toIndex){
            int mid = fromIndex +(toIndex - fromIndex)/2;
            int cmp = aValue.compareTo(fromArray[mid]);
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                return binarySearch(aValue, fromArray, fromIndex, mid - 1);
            } else {
                return binarySearch(aValue, fromArray, mid + 1, toIndex);
            }
        }
        return -1;
    }

    public static <E extends Comparable<E>> void fastSort(E [] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static <E extends Comparable<E>> void quickSort(E [] array, int low, int high) {
        if(high <= low) return;
        int j =partition(array,low,high);
        quickSort(array, low, j -1);
        quickSort(array, j+1,high);
    }

    private static <E extends Comparable<E>> int partition(E [] array, int low, int high) {

        int i = low, j  = high +1;
        E v = array [low];
        while(true){
            while (array[++i].compareTo(v)<0) if (i == high) break;
            while(v.compareTo(array[--j])<0) if (j == low) break;
            if(i>=j) break;
            E tmp = array [j];
            array[j] = array[i];
            array[i] = tmp;
        }
        E tmp = array [j];
        array[j] = array[low];
        array[low] = tmp;
        return j;
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    public static <T> void reverse(T[] array) {
        int i = 0;
        while (i < array.length / 2) {
            T temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
            i++;
        }
    }
}
