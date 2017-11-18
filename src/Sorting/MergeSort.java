package Sorting;

public class MergeSort {

    private static int[] array = new int[]{3, 2, 9, 5, 19};

    public static void main(String[] args){

        doMergeSort(array, 0, array.length - 1);

        displayElements(array);
    }

    private static void doMergeSort(int[] array, int leftIndex, int rightIndex){

        if(leftIndex < rightIndex){

            int middleIndex = (leftIndex + rightIndex)/2;

            doMergeSort(array, leftIndex, middleIndex);

            doMergeSort(array, middleIndex + 1, rightIndex);

            merge(array, leftIndex, middleIndex, rightIndex);
        }
    }

    private static void merge(int[] array, int l, int m, int r){

        int leftSize = m - l + 1;

        int rightSize = r - m;

        int[] leftArray = new int[leftSize];

        int[] rightArray = new int[rightSize];

        for(int i = 0; i < leftSize; i++){
            leftArray[i] = array[l + i];
        }

        for(int j = 0; j < rightSize; j++){
            rightArray[j] = array[m + 1 + j];
        }

        int leftIndex = 0, rightIndex = 0;

        int k = l;

        while (leftIndex < leftSize && rightIndex < rightSize){

            if(leftArray[leftIndex] < rightArray[rightIndex]){
                array[k] = leftArray[leftIndex];
                leftIndex++;
            }else {
                array[k] = rightArray[rightIndex];
                rightIndex++;
            }
            k++;
        }

        while (rightIndex < rightSize){
            array[k] = rightArray[rightIndex];
            rightIndex++;
            k++;
        }

        while (leftIndex < leftSize){
            array[k] = leftArray[leftIndex];
            leftIndex++;
            k++;
        }
    }

    private static void displayElements(int[] arrayList){

        for(int i = 0; i < arrayList.length; i++){

            System.out.println(arrayList[i]);
        }

//        System.out.println("No of Operations :" + operations);
    }
}
