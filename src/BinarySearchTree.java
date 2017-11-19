
public class BinarySearchTree {

    public static void main(String[] args){

        Node root = new Node();

        root.setData(6);

        root.pushData(5);

        root.pushData(7);

        searchKey(root, 4);

        System.out.println("------------------------");

        inOrderTraversal(root);

        System.out.println("------------------------");

        preOrderTraversal(root);

        System.out.println("------------------------");

        postOrderTraversal(root);
    }

    private static Node searchKey(Node root, int key){

        if(root == null){
            System.out.println("Key Not Found");
            return null;
        }

        if(root.getData() == key){
            System.out.println("Key Found " + root.getData());
            return root;
        }

        if(root.getData() > key){
            searchKey(root.getLeftChild(), key);
        }else {
            searchKey(root.getRightChild(), key);
        }

        return null;
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

    private static class Node{

        private int data = -1;

        private Node leftChild;

        private Node rightChild;

        private Node(){
            leftChild = null;
            rightChild = null;
        }


        private void pushData(int value){
            pushData(this, value);
        }

        private void pushData(Node subTree, int value){

            if(value < data){

                if(subTree.getLeftChild() == null){
                    subTree.setLeftChild(new Node());
                    subTree.getLeftChild().setData(value);
                }else {
                    pushData(subTree.getLeftChild(), value);
                }
            }else {
                if(subTree.getRightChild() == null){
                    subTree.setRightChild(new Node());
                    subTree.getRightChild().setData(value);
                }else {
                    pushData(subTree.getRightChild(), value);
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
    }
}
