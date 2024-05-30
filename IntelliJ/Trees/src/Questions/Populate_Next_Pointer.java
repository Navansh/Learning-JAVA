package Questions;

public class Populate_Next_Pointer {
    public static void main(String[] args) {

    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        Node head1 = root;
        while (root.left != null) {
            //hence essentially traverse till the second last level
            Node temp = root;

            while (temp != null) {
                //set for the first node
                temp.left.next = temp.right;
                //set for the bridging nodes
                if(temp.next != null) {
                    temp.right.next = temp.next.left;
                }
                temp = temp.next;
            }

            root = root.left;
            //this is the way we jump to next level

        }
        return head1;
    }
}
