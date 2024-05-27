package Questions.Construction_of_Tree;

import java.util.HashMap;

public class Tree_using_Inorder_and_Postorder {
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        System.out.println(buildTree(inorder, postorder));
    }

    static class TreeNode {
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

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int postStart = 0;
        int postEnd = postorder.length - 1;
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
        return treeConstructor(postorder, postStart, postEnd, inorder, inStart, inEnd, hx);
    }

    private static TreeNode treeConstructor(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> hx) {
        if(postStart > postEnd || inStart > inEnd) {
            return null;
            //another way to write the base case :
            // when preStart == preEnd || inStart == inEnd
            //then just create a node and return it return new TreeNode(preorder[preStart]);

        }
        //make the root Node
        TreeNode root = new TreeNode(postorder[postEnd]);

        //now find this root node's value's corresponding index in the inorder traversal
        int index = 0;
        int rootNodeValue = postorder[postEnd];
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

        //index represents the index value of root node in inorder

        root.left = treeConstructor(postorder,  postStart, postStart + count - 1, inorder, inStart, index - 1, hx);
        //hence preStart will be greater than preEnd only when count == 0, which is only when
        //index == inStart, which means there is only one element and that itself is the start and the root
        root.right = treeConstructor(postorder, postStart + count, postEnd - 1, inorder, index + 1, inEnd, hx);

        return root;


    }
}
