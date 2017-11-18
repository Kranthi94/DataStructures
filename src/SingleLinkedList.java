
public class SingleLinkedList {

    public static void main(String[] args){

        LinkedList linkedList = new LinkedList();

        linkedList.insertAtFirst(1);

        linkedList.insertAtFirst(2);

        linkedList.insertAtFirst(3);

        linkedList.insertAtPosition(0, 4);

        linkedList.insertAtEnd(5);

        linkedList.deleteAtPosition(2);

        linkedList.displayContents();
    }

    private static class LinkedList{

        private Node head;

        private Node tail;

        private int size;

        public LinkedList(){
            head = null;
            tail = null;
            size = 0;
        }

        private boolean isEmpty(){
            return head == null;
        }

        private int getSize(){
            return size;
        }

        public void insertAtFirst(int data){

            Node node = new Node(data, null);

            size++;

            if(isEmpty()){

                head = node;

                tail = head;
            }else{

                node.setLink(head);

                head = node;
            }
        }

        public void insertAtEnd(int data){

            Node node = new Node(data, null);

            size++;

            if(isEmpty()){

                head = node;

                tail = head;
            }else{

                tail.setLink(node);

                tail = node;
            }
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

            Node node = new Node(data, null);

            Node startNode = head;

            for(int i = 1; i <= getSize(); i++){

                if(i == position){

                    Node temp = startNode.getLink();

                    startNode.setLink(node);

                    node.setLink(temp);

                    break;
                }

                startNode = startNode.getLink();
            }

            size++;
        }

        public Node deleteAtPosition(int position){

            if(position > size && position < 0){
                return null;
            }

            if(position == 1 || getSize() == 1){

                head = head.getLink();

                size--;

                return head;
            }

            Node startNode = head.getLink();

            Node endNode = head;

            for(int i = 1; i <= getSize(); i++){

                if(i == position){

                    Node temp = startNode.getLink();

                    endNode.setLink(temp);

                    break;
                }

                endNode = startNode;

                startNode = startNode.getLink();
            }

            size--;

            return startNode;
        }

        public Node searchNode(int data){

            Node node = head;

            for(int i = 1; i <= getSize(); i++){

                if(node.getData() == data){
                    return node;
                }

                node = node.getLink();
            }

            return null;
        }

        public void displayContents(){

            Node node = head;

            for(int i = 1; i <= getSize(); i++){

                System.out.println(node.getData());

                node = node.getLink();
            }
        }
    }

    private static class Node{

        private Node link;

        private int data;

        public Node(){
            link = null;
            data = 0;
        }

        public Node(int data, Node link){
            this.data = data;
            this.link = link;
        }

        public void setLink(Node link){
            this.link = link;
        }

        public void setData(int data){
            this.data = data;
        }

        public Node getLink(){
            return link;
        }

        public int getData(){
            return data;
        }
    }
}
