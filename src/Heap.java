
public class Heap {

    private static final String MIN_HEAP = "MIN_HEAP";

    private static final String MAX_HEAP = "MAX_HEAP";

    private static int[] array = new int[]{35, 33, 42, 10, 14, 19};

    public static void main(String[] args){

        createMaxHeap(array);

        System.out.println("---------------------");

        createMinHeap(array);
    }

    private static void createMinHeap(int[] array){

        Node node = new Node();

        node.setData(array[0]);

        for (int i = 1; i < array.length; i++) {
            node.pushData(array[i], MIN_HEAP);
        }

        preOrderTraversal(node);
    }

    private static void createMaxHeap(int[] array){

        Node node = new Node();

        node.setData(array[0]);

        for (int i = 1; i < array.length; i++) {
            node.pushData(array[i], MAX_HEAP);
        }

        preOrderTraversal(node);
    }

    private static class Node{

        private int data = -1;

        private Node leftChild;

        private Node rightChild;

        private Node(){
            leftChild = null;
            rightChild = null;
        }


        private void pushData(int value, String heapType){
            pushData(this, value, heapType);
        }

        private void pushData(Node node, int value, String heapType){

            if(MIN_HEAP.equalsIgnoreCase(heapType)){

                if(value > node.getData()){

                    if(node.getLeftChild() == null){
                        node.setLeftChild(new Node());
                        node.getLeftChild().setData(value);
                    }else if(node.getRightChild() == null){
                        node.setRightChild(new Node());
                        node.getRightChild().setData(value);
                    }else if(node.getLeftChild().getData() > value){
                        int num = node.getLeftChild().getData();
                        node.getLeftChild().setData(value);
                        pushData(node.getLeftChild(), num, MIN_HEAP);
                    }else if(node.getRightChild().getData() > value){
                        int num = node.getRightChild().getData();
                        node.getRightChild().setData(value);
                        pushData(node.getRightChild(), num, MIN_HEAP);
                    }else {

//                        if(node.getRightChild().getData() > value){
//                            pushData(node.getRightChild(), value, MIN_HEAP);
//                        }else {
//                            pushData(node.getLeftChild(), value, MIN_HEAP);
//                        }

                        if(!node.getLeftChild().hasChilds()){
                            pushData(node.getLeftChild(), value, MIN_HEAP);
                        }else if(!node.getRightChild().hasChilds()){
                            pushData(node.getRightChild(), value, MIN_HEAP);
                        }else {
                            pushData(node.getLeftChild(), value, MIN_HEAP);
                        }
                    }

                }else {
                    int num = node.getData();

                    node.setData(value);

                    if(node.getLeftChild() == null){
                        node.setLeftChild(new Node());
                        node.getLeftChild().setData(num);
                    }else if(node.getRightChild() == null){
                        node.setRightChild(new Node());
                        node.getRightChild().setData(num);
                    }else {
                        pushData(node.getLeftChild(), num, MIN_HEAP);
                    }
                }

            }else if(MAX_HEAP.equalsIgnoreCase(heapType)){

                if(value < node.getData()){

                    if(node.getLeftChild() == null){
                        node.setLeftChild(new Node());
                        node.getLeftChild().setData(value);
                    }else if(node.getRightChild() == null){
                        node.setRightChild(new Node());
                        node.getRightChild().setData(value);
                    }else if(node.getLeftChild().getData() < value){
                        int num = node.getLeftChild().getData();
                        node.getLeftChild().setData(value);
                        pushData(node.getLeftChild(), num, MAX_HEAP);
                    }else if(node.getRightChild().getData() < value){
                        int num = node.getRightChild().getData();
                        node.getRightChild().setData(value);
                        pushData(node.getRightChild(), num, MAX_HEAP);
                    }else {

                        if(!node.getLeftChild().hasChilds()){
                            pushData(node.getLeftChild(), value, MAX_HEAP);
                        }else if(!node.getRightChild().hasChilds()){
                            pushData(node.getRightChild(), value, MAX_HEAP);
                        }else {
                            pushData(node.getLeftChild(), value, MAX_HEAP);
                        }
                    }

                }else {

                    int num = node.getData();

                    node.setData(value);

                    if(node.getLeftChild() == null){
                        node.setLeftChild(new Node());
                        node.getLeftChild().setData(num);
                    }else if(node.getRightChild() == null){
                        node.setRightChild(new Node());
                        node.getRightChild().setData(num);
                    }else {
                        pushData(node.getLeftChild(), num, MIN_HEAP);
                    }
                }

            }
        }

        public void setData(int data){
            this.data = data;
        }

        public int getData(){
            return data;
        }

        private Node getLeftChild(){
            return leftChild;
        }

        private Node getRightChild(){
            return rightChild;
        }

        private void setLeftChild(Node leftChild){
            this.leftChild = leftChild;
        }

        private void setRightChild(Node rightChild){
            this.rightChild = rightChild;
        }

        private boolean hasChilds(){

            return leftChild != null && rightChild != null;
        }

        private boolean hasLeftChild(){

            return leftChild != null;
        }

        private boolean hasRightChild(){

            return rightChild != null;
        }
    }

    private static void inOrderTraversal(Node root){

        if(root == null){
            return;
        }

        inOrderTraversal(root.getLeftChild());

        System.out.println(root.getData());

        inOrderTraversal(root.getRightChild());
    }

    private static void preOrderTraversal(Node root){

        if(root == null){
            return;
        }

        System.out.println(root.getData());

        preOrderTraversal(root.getLeftChild());

        preOrderTraversal(root.getRightChild());
    }

    private static void postOrderTraversal(Node root){

        if(root == null){
            return;
        }

        postOrderTraversal(root.getLeftChild());

        postOrderTraversal(root.getRightChild());

        System.out.println(root.getData());
    }
}
