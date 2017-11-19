package Sorting;

import java.util.ArrayList;

public class QuickSort {

    private static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args){

        arrayList.add(9);
        arrayList.add(20);
        arrayList.add(19);
        arrayList.add(1);

        displayElements(doQuickSort(arrayList));
    }

    private static ArrayList<Integer> merge(ArrayList<Integer> leftArray, ArrayList<Integer> rightArray, int pivot){

        int index = -1;

        ArrayList<Integer> sortedArray = new ArrayList<>();

        if (leftArray != null) {

            for(int j = 0; j < leftArray.size(); j++){

                sortedArray.add(++index, leftArray.get(j));
            }
        }

        sortedArray.add(++index, pivot);

        if (rightArray != null) {

            for(int k = 0; k < rightArray.size(); k++){

                sortedArray.add(++index, rightArray.get(k));
            }
        }

        return sortedArray;
    }

    private static ArrayList<Integer> doQuickSort(ArrayList<Integer> arrayList){

        int pivot = arrayList.get(arrayList.size() - 1);

        ArrayList<Integer> sortedArrayList = new ArrayList<>();

        int smallerIndex = -1;

        int largerIndex = -1;

        ArrayList<Integer> smallerArray = new ArrayList<>();

        ArrayList<Integer> largerArray = new ArrayList<>();

        if(arrayList.size() > 1){

//            if(pivot > arrayList.get(0)){
//
//                sortedArrayList.add(0, arrayList.get(0));
//                sortedArrayList.add(1, pivot);
//
//            }else {
//
//                sortedArrayList.add(0, pivot);
//                sortedArrayList.add(1, arrayList.get(0));
//            }

            for(int i = 0; i < arrayList.size() - 1; i++){

                if(arrayList.get(i) <= pivot){
                    smallerArray.add(++smallerIndex, arrayList.get(i));
                }else {
                    largerArray.add(++largerIndex, arrayList.get(i));
                }
            }

            if(smallerIndex == -1){
                sortedArrayList = merge(null, doQuickSort(largerArray), pivot);
            }else if(largerIndex == -1){
                sortedArrayList = merge(doQuickSort(smallerArray), null, pivot);
            }else {
                sortedArrayList = merge(doQuickSort(smallerArray), doQuickSort(largerArray), pivot);
            }

            return sortedArrayList;

        }else {
            return arrayList;
        }
    }

    private static void displayElements(ArrayList<Integer> arrayList){

        for(int i = 0; i < arrayList.size(); i++){

            System.out.println(arrayList.get(i));
        }

//        System.out.println("No of Operations :" + operations);
    }
}
