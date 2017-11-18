package Sorting;

public class InsertionSort {

    private static int[] array = new int[]{9, 4, 19, 1};

    private static int[] sortedArray = new int[array.length];

    private static int operations = 0;

    public static void main(String[] args){

        initializeSortedArray();

        doInsertionSort(array);

        displayElements(sortedArray);
    }

    private static void doInsertionSort(int[] array){

        sortedArray[0] = array[0];

        for(int j = 1; j < array.length; j++) {

            int num = array[j];

            for(int i = 0; i < sortedArray.length; i++){

                if(sortedArray[i] != -1){

                    if(sortedArray[i] > num){

                        int temp = sortedArray[i];

                        for(int k = i + 1; k < sortedArray.length; k++) {

                            int currentValue = sortedArray[k];

                            sortedArray[k] = temp;

                            temp = currentValue;

                            operations++;
                        }

                        sortedArray[i] = num;

                        operations++;

                        break;
                    }

                }else {
                    sortedArray[i] = num;

                    operations++;

                    break;
                }
            }
        }
    }

    private static void initializeSortedArray(){

        for(int i = 0; i < sortedArray.length; i++){
            sortedArray[i] = -1;
        }
    }

    private static void displayElements(int[] arrayList){

        for (int anArrayList : arrayList) {

            System.out.println(anArrayList);
        }

        System.out.println("No of Operations :" + operations);
    }
}
