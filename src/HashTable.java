import java.util.ArrayList;

public class HashTable {

    public static void main(String[] args){

        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10};

        DataStructure dataStructure = new DataStructure(10);

        dataStructure.insertData(array);

        dataStructure.displayStack();

        dataStructure.findKey(9);
    }

    private static class DataStructure{

        private ArrayList<Integer> arrayList;

        private int maxSize;

        public DataStructure(int size){

            arrayList = new ArrayList<>(size);

            maxSize = size;

            for(int i = 0; i < maxSize; i++){
                arrayList.add(i, 0);
            }
        }

        public void insertData(int[] array){

            for (int num : array) {

                int hashKey = getHashKey(num);

                if (arrayList.get(hashKey) != 0) {

                    int probe = (hashKey + 1) % (maxSize);

                    while (probe != hashKey) {

                        if(arrayList.get(probe) == 0) {

                            arrayList.set(probe, num);

                            break;
                        }else {
                            probe++;
                        }
                    }

                    if(probe == hashKey){
                        System.out.println("Hash Table is Full");
                    }

                } else {

                    arrayList.set(hashKey, num);
                }
            }
        }

        private void findKey(int data){

            int hashKey = getHashKey(data);

            int pointer = hashKey;

            if(arrayList.get(hashKey) !=  data){

                int probe = (hashKey + 1)%maxSize;

                while (arrayList.get(probe) != 0){

                    if(arrayList.get(probe) == data){

                        pointer = probe;

                        break;
                    }else {
                        probe++;
                    }
                }

                if(arrayList.get(probe) == 0){
                    System.out.println("Key is not found");
                }

            }

            System.out.println("Key Found " + pointer);
        }

        private void displayStack(){

            for(int i = 0; i < maxSize; i++){

                if(arrayList.get(i) != null){
                    System.out.println(i + "   " + arrayList.get(i));
                }
            }
        }

        private int getHashKey(int data){
            return data%(maxSize-1);
        }
    }
}
