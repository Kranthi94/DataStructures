package Searching;

public class LinearSearch {

    private static int[] array = new int[]{2, 9, 17, 33, 47, 59, 66, 78, 85, 91, 100};

    public static void main(String[] args){

        int index = getIndex(9);

        System.out.println(index != -1 ? "Key Found " + index : "Key Not Found");
    }

    private static int getIndex(int data){

        int key = -1;

        for(int i = 0; i < array.length; i++){
            if(data == array[i]){
                key = i;
                return key;
            }
        }

        return key;
    }
}
