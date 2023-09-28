public class LL_Bubble_Sort {
    private Node head;
    private Node tail;

    public LL_Bubble_Sort(Node head, Node tail) {
        this.head = null;
        this.tail = null;
    }

    private void BubbleSort(int row, int col){
        if(row==0){
            return;
        }
        if (col<row){
            Node first = findNode(col);
            Node second = findNode(col+1);

            if (first.value> second.value){
                //swap
                if (first==head){
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second==tail) {
                    Node prev = findNode(col-1);
                    //as col is the current value you are at, hence first will be at value col, second at value col +1
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                } else {
                    Node prev = findNode(col-1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            BubbleSort(row,col+1);
        }else {
            BubbleSort(row-1,0);
        }


    }

    public Node findNode(int value) {
//        returns the ref pointer to node at that particular index
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
        //if there is no node with the passed value, then return null
    }

    public Node getNode(int index) {
//        returns the ref pointer to node at that particular index
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }


    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("END");
    }


    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }


}