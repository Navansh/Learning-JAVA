package Questions;

public class Binary_Tree_Camera {
    public static void main(String[] args) {

    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    int cameras = 0;
    public int minCameraCover(TreeNode root) {
        //do  the postOrder traversal and collect information from the left and right node
        //and then place the camera
        int rootReturn = cameraHelper(root);
        if(rootReturn == 0) {
            //matlab root node bolrha hai ki mein ek leaf node ki tarah hi behave kar rha
            //hai then wahaan par ke camera place karna padega
            cameras++;
        }
        return cameras;
    }

    private int cameraHelper(TreeNode root) {
        //do the postOrder traversal and identify the 3 types of nodes in this process

        if(root == null) {
            return 2;
            //meaning naa toh isse parent ki help chahiye and naa ye parent ki help
            //karsakta
        }

        int left = cameraHelper(root.left);
        int right = cameraHelper(root.right);

        //now we'll handle the parent
        if(left == 0 || right == 0 ) {
            cameras++;
            return 1;
        }

        if(left == 1 || right == 1 ) {
            return 2;
        }

        return 0;


    }
}
