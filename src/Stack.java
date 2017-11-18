import java.util.ArrayList;

public class Stack {

    public static void main(String[] args){

        DataStructure dataStructure = new DataStructure(10);

        dataStructure.push(10);

        dataStructure.push(9);

        dataStructure.push(11);

        dataStructure.pop();

        dataStructure.displayContents();
    }

    private static class DataStructure{

        private ArrayList<Integer> arrayList;

        private int pointer;

        public DataStructure(int size){
            arrayList = new ArrayList<>(size);
            pointer = 0;
        }

        public void push(int data){
            arrayList.add(pointer, data);
            pointer++;
        }

        public int pop(){

            if(pointer > 0){
                return arrayList.get(--pointer);
            }else{
                return 0;
            }
        }

        public void displayContents(){
            for(int i = pointer - 1; i >= 0; i--){
                System.out.println(arrayList.get(i));
            }
        }
    }
}
