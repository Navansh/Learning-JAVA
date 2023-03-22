public class Main {
    private class Node{
        private Node head;
        private Node tail;
        private int size;
        private int value;
        private Node next;

        public Node() {
            this.size = 0;
        }

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Main dj = new Main();
        int[] arr = new int[2];

    }
}