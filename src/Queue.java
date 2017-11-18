import java.util.ArrayList;

public class Queue {

    public static void main(String[] args){

        DataStructure dataStructure = new DataStructure(10);

        dataStructure.enQueue(10);

        dataStructure.enQueue(9);

        dataStructure.enQueue(8);

        dataStructure.deQueue();

        dataStructure.displayContents();
    }

    private static class DataStructure{

        private ArrayList<Integer> arrayList;

        private int pointer;

        private int maxSize;

        public DataStructure(int size){
            arrayList = new ArrayList<>(size);
            pointer = -1;
            maxSize = size;
        }

        public void enQueue(int data){

            pointer++;

            if(pointer <= maxSize - 1){
                arrayList.add(pointer, data);
            }else {
                System.out.println("Maximum Limit Reached");
            }
        }

        public int deQueue(){

            if(arrayList.isEmpty()){
                return -1;
            }else {

                for(int i = 0; i < maxSize; i++){

                    if(arrayList.get(i) != null){

                        int num = arrayList.get(i);

                        arrayList.remove(i);

                        pointer--;

                        return num;
                    }
                }

                return -1;
            }
        }

        public void displayContents(){

            for (int i = 0; i <= pointer; i++){

                if(arrayList.get(i) != null){
                    System.out.println(arrayList.get(i));
                }
            }
        }
    }
}
