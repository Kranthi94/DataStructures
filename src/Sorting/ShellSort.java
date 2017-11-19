package Sorting;

public class ShellSort {

    private static int[] array = new int[]{9, 4, 19, 1};

    private static int[] sortedArray = new int[array.length];

    private static int operations = 0;

    public static void main(String[] args){

        initializeSortedArray();

        doShellSort(array);

        displayElements(sortedArray);
    }

    private static void doShellSort(int[] array){

        int interval = (array.length + 1)/2;

        while (interval >= 1){

            for(int i = 0; i < array.length; i++){

                int j = i + interval;

                if(j < array.length && array[i] > array[j]){

                    int temp = array[i];

                    array[i] = array[j];

                    array[j] = temp;

                    operations++;
                }
            }

            interval = interval/2;
        }

        doInsertionSort(array);
    }

    private static void initializeSortedArray(){

        for(int i = 0; i < sortedArray.length; i++){
            sortedArray[i] = -1;
        }
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

    private static void displayElements(int[] arrayList){

        for(int i = 0; i < arrayList.length; i++){

            System.out.println(arrayList[i]);
        }

        System.out.println("No of Operations :" + operations);
    }
}
