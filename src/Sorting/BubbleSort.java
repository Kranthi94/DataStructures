package Sorting;

public class BubbleSort {

    private static int[] array = new int[]{9, 4, 19, 1};

    private static int operations = 0;

    public static void main(String[] args){

        doBubbleSort(array);

        displayElements(array);
    }

    private static void doBubbleSort(int[] array){

        for(int j = 0; j < array.length - 1; j++) {

            for(int i = 0; i < array.length - 1; i++){

                if(array[i] > array[i + 1]){

                    int temp = array[i];

                    array[i] = array[i+1];

                    array[i+1] = temp;

                    operations++;
                }
            }
        }
    }

    private static void displayElements(int[] arrayList){

        for(int i = 0; i < arrayList.length; i++){

            System.out.println(arrayList[i]);
        }

        System.out.println("No of Operations :" + operations);
    }
}
