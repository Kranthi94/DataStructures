package Searching;


public class InterpolationSearch {

    private static int[] array = new int[]{2, 9, 17, 33, 47, 59, 66, 78, 85, 91, 100};

    public static void main(String[] args){

        int index = getIndex(101);

        System.out.println(index != -1 ? "Key Found " + index : "Key Not Found");
    }

    private static int getIndex(int data){

        int key = -1;

        int arraySize = array.length;

        int lowerIndex = 0;

        int higherIndex = arraySize - 1;

        while (lowerIndex <= higherIndex && array[lowerIndex] <= data && array[higherIndex] >= data){

            int pos = lowerIndex + ((data - array[lowerIndex])/(array[higherIndex] - array[lowerIndex]))*(higherIndex - lowerIndex);

            if(array[pos] == data){
                key = pos;
                break;
            }

            if(array[pos] < data){
                lowerIndex = pos + 1;
            }else {
                higherIndex = pos - 1;
            }
        }

        return key;
    }
}
