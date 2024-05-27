package Questions.Construction_of_Tree;

import java.util.HashMap;

public class Tree_using_Preorder_and_Inorder {
    public static void main(String[] args) {
        //https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preStart = 0;
        int preEnd = preorder.length - 1;
        int inStart = 0;
        int inEnd = inorder.length - 1;
        //instead of modifying the original preOrder and inorder array, we're gonna
        //use these pointers to signify the start and end of the array
        //for a particular node
        HashMap<Integer, Integer> hx = new HashMap<>();
        //here we create the mapping of values of inorder and their indexes
        for (int i = 0; i < inorder.length; i++) {
            hx.put(inorder[i], i);
        }
        return treeConstructor(preorder, preStart, preEnd, inorder, inStart, inEnd, hx);
    }

    private TreeNode treeConstructor(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> hx) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
            //another way to write the base case :
            // when preStart == preEnd || inStart == inEnd
            //then just create a node and return it return new TreeNode(preorder[preStart]);

        }
        //make the root Node
        TreeNode root = new TreeNode(preorder[preStart]);

        //now find this root node's value's corresponding index in the inorder traversal
        int index = 0;
        int rootNodeValue = preorder[preStart];
//        for (int i = inStart; i <= inEnd; i++) {
//            if(inorder[i] == rootNodeValue) {
//                //we found the index
//                index = i;
//                break;
//            }
//        }

        //instead of doing the above function I just use the HashMap
        index = hx.get(rootNodeValue);
        //this will give me the index of root node in the inorder array

        int count = index - inStart;
        //not (index - inStart + 1) as root ko include nhi karna
        //this will give the number of elements in the left side of the node
        //and rest will be for right side of the node
        //and count of nodes in inorder for a particular side say right is
        //equal to count of nodes in preOrder for right side
        //hence ham

        root.left = treeConstructor(preorder, preStart + 1, preStart + count, inorder, inStart, inStart + count - 1, hx);
        //hence preStart will be greater than preEnd only when count == 0, which is only when
        //index == inStart, which means there is only one element and that itself is the start and the root
        root.right = treeConstructor(preorder, preStart + count + 1, preEnd, inorder, inStart + count + 1, inEnd, hx);

        return root;


    }
}
