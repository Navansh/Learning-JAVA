package Questions.AVL_Tree;

public class AVL_Tree {
    public static void main(String[] args) {
        int[] data = {3,8,6,7,-2,-8,4,9};
        for (int i = 0; i < 1000; i++) {
            insert(i);
        }
        System.out.println(height());
    }

    private static class AVLNode {
        int value;
        public int height;
        AVLNode left;
        AVLNode right;

        public AVLNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }
    static AVLNode root;
    public static void insert(int value) {
        root = insert(value,root);
    }

    private static AVLNode insert(int value, AVLNode node) {
        if(node == null) {
            node = new AVLNode(value);
            return node;
        }

        //now we'll add firstly to the leaf node always
        //and then call the rotate function from the node
        //and check if by adding, we unbalanced any subtree
        //if yes, then rotate function will handle it
        //and return the root node

        if(value < node.value) {
            node.left = insert(value, node.left);
        }

        if(value > node.value) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
        //this will call the rotate function on every node till we reach our target
        //node, but it will only affect the one node which caused the unbalancing
        //and leave others as it is
        //won't affect TC
    }

    private static AVLNode rotate(AVLNode node) {
        if(height(node.left) - height(node.right) > 1) {
            //means this is left heavy tree
            if(height(node.left.left) - height(node.left.right) > 0) {
                //left left case, as the height of left tree is greater
                return rightRotate(node);
            } else if(height(node.left.left) - height(node.left.right) < 0){
                //this is the left right case
                //so first do left rotate on child 
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if(height(node.left) - height(node.right) < -1) {
            //if it would be in range of 1 to -1, then its balanced already
            //means this is right heavy tree
            if(height(node.right.left) - height(node.right.right) < 0) {
                //right right case
                return leftRotate(node);
            } else if(height(node.right.left) - height(node.right.right) > 0){
                //this is the right left
                //so first do right rotate on child
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        //in default case, when heights are within range that is 
        //0, 1, and -1, we don't need to do anything
        //and just return the node itself
        return node;
    }

    private static AVLNode leftRotate(AVLNode node) {
        //we'll get the child node here
        AVLNode parent = node.right;
        AVLNode t2 =parent.left;

        parent.left = node;
        node.right = t2;

        parent.height = Math.max(height(parent.left), height(parent.right) + 1);
        node.height = Math.max(height(node.left), height(node.right) + 1);

        return parent;
    }

    private static AVLNode rightRotate(AVLNode node) {
        //what we'll get is the parent node
        AVLNode child = node.left;
        AVLNode t2 =child.right;

        child.right = node;
        node.left = t2;

        node.height = Math.max(height(node.left), height(node.right) + 1);
        child.height = Math.max(height(child.left), height(child.right) + 1);

        return child;
        //child will be the parent node now

    }

    public static int height() {
        return height(root);
    }
    private static int height(AVLNode node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public static void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
          insert(nums[i]);
        }
    }
    
    public static void populatedSorted(int[] nums) {
        populatedSorted(nums, 0, nums.length);
    }
    
    private static void populatedSorted(int[] nums, int start, int end) {
        if (start >= end) {
          return;
        }
    
        int mid = (start + end) / 2;
    
        insert(nums[mid]);
        populatedSorted(nums, start, mid);
        populatedSorted(nums, mid + 1, end);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(AVLNode node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }


}
