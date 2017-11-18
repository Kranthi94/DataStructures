
public class CircularLinkedList {

    public static void main(String[] args){

        LinkedList linkedList = new LinkedList();

        linkedList.insertAtFirst(1);

        linkedList.insertAtFirst(2);

        linkedList.insertAtEnd(3);

        linkedList.insertAtPosition(1, 4);

        linkedList.deleteAtPosition(4);

        linkedList.displayContents();
    }

    public static class LinkedList{

        private Node head;

        private Node tail;

        private int size;

        public LinkedList(){
            head = null;
            tail = null;
            size = 0;
        }

        public boolean isEmpty(){
            return head == null;
        }

        public int getSize(){
            return size;
        }

        public void insertAtFirst(int data){

            Node node = new Node(data, null, null);

            if(isEmpty()){

                head = node;

                tail = head;

            }else {

                node.setAfterNode(head);

                head.setPreviousNode(node);

                head = node;

                tail.setPreviousNode(head);
            }

            size++;
        }

        public void insertAtEnd(int data){

            Node node = new Node(data, null, null);

            if(isEmpty()){

                head = node;

                tail = head;
            }else {

                tail.setAfterNode(node);

                node.setPreviousNode(tail);

                node.setAfterNode(head);

                head.setPreviousNode(node);

                tail = node;
            }

            size++;
        }

        public void insertAtPosition(int position, int data){

            if(position > size || position < 0){
                return;
            }

            if(position == getSize()){
                insertAtEnd(data);
                return;
            }

            if(position == 0){
                insertAtFirst(data);
                return;
            }

            Node node = new Node(data, null, null);

            Node startNode = head;

            for(int i = 1; i <= getSize(); i++){

                if(i == position){

                    Node afterNode = startNode.getAfterNode();

                    startNode.setAfterNode(node);

                    node.setPreviousNode(startNode);

                    node.setAfterNode(afterNode);

                    afterNode.setPreviousNode(node);

                    break;
                }

                startNode = startNode.getAfterNode();
            }

            size++;
        }

        public Node deleteAtPosition(int position){

            if(position > size || position < 0){
                return null;
            }

            if(position == 1 || getSize() == 1){

                head = head.getAfterNode();

                size--;

                return head;
            }

            if(position == getSize()){

                Node prevNode = tail.getPreviousNode();

                prevNode.setAfterNode(head);

                head.setPreviousNode(prevNode);

                size--;

                return tail;
            }

            Node startNode = head;

            for(int i = 1; i <= getSize(); i++){

                if(i == position){

                    Node previousNode = startNode.getPreviousNode();

                    Node afterNode = startNode.getAfterNode();

                    previousNode.setAfterNode(afterNode);

                    afterNode.setPreviousNode(previousNode);

                    break;
                }

                startNode = startNode.getAfterNode();
            }

            size--;

            return startNode;
        }

        public void displayContents(){

            Node node = head;

            for(int i = 1; i <= getSize(); i++){

                System.out.println(node.getData());

                node = node.getAfterNode();
            }
        }
    }

    private static class Node{

        private Node previousNode;

        private Node afterNode;

        private int data;

        public Node(){
            previousNode = null;
            this.afterNode = null;
            data = 0;
        }

        public Node(int data, Node previousNode, Node afterNode){
            this.data = data;
            this.previousNode = previousNode;
            this.afterNode = afterNode;
        }

        public void setPreviousNode(Node previousNode){
            this.previousNode = previousNode;
        }

        public void setAfterNode(Node afterNode){
            this.afterNode = afterNode;
        }

        public void setData(int data){
            this.data = data;
        }

        public Node getAfterNode(){
            return afterNode;
        }

        public Node getPreviousNode(){
            return previousNode;
        }

        public int getData(){
            return data;
        }
    }
}
