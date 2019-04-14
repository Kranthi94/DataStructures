package Algorithms.Recursion;

public class SortedArray {

    public static void main(String[] args) {

        int[] arr = {2, 3, 7, 5, 6};

        System.out.println(isArraySorted(arr,4));
    }

    private static boolean isArraySorted(int[] array, int index) {

        if(array.length == 1 || index == 0) {

            return true;
        }

        if(array[index] >= array[index - 1]) {

            return isArraySorted(array, index - 1);

        }else {

            return false;
        }
    }
}
