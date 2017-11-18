package Sorting;

public class SelectionSort {

    private static int[] array = new int[]{9, 4, 19, 1};

    private static int operations = 0;

    public static void main(String[] args){

        doSelectionSort(array);

        displayElements(array);
    }

    private static void doSelectionSort(int[] array){

        for(int i = 0; i < array.length; i++) {

            int index = i;

            for(int j = i + 1; j < array.length; j++) {

                operations++;

                if(array[j] < array[index]){

                    index = j;
                }
            }

            int temp = array[i];

            array[i] = array[index];

            array[index] = temp;
        }
    }

    private static void displayElements(int[] arrayList){

        for(int i = 0; i < arrayList.length; i++){

            System.out.println(arrayList[i]);
        }

        System.out.println("No of Operations :" + operations);
    }
}
