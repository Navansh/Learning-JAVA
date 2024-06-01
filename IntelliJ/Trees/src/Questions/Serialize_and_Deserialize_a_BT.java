package Questions;

import java.util.Objects;

public class Serialize_and_Deserialize_a_BT {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializer(root, sb);
        return sb.toString();
    }

    private void serializer(TreeNode root, StringBuilder sb) {
        //just do preorder traversal here, but account for null as well
        if(root == null) {
            sb.append("# ");
            return;
        }
        //so preorder : NLR
        sb.append(root.val + " ");
        //we need to add this space, as when we'll deserialize this, then
        //we should know whether this number was a one digit number, or
        //2 digit or how many digits or letters, then only we'll
        //be able to reconstruct it properly
        serializer(root.left, sb);
        serializer(root.right, sb);
    }

    // Decodes your encoded data to tree.
    int i = 0;
    public TreeNode deserialize(String data) {
        //convert this serialized string data to char[] arr, so that
        //we can work on it
        String[] arr = data.split(" ");
        TreeNode root = deSerializer(arr);
        return root;
    }

    private TreeNode deSerializer(String[] arr) {
        if(Objects.equals(arr[i], "#")) {
            //meaning if arr[i] is equal to "#"
            //meaning there was a null node there
            i++;
            return null;
        }

        //going in the preOrder form as that is the way we serialized it
        TreeNode root = new TreeNode(Integer.parseInt(arr[i]));
        i++;
        //as we've utilized this node
        root.left = deSerializer(arr);
        root.right = deSerializer(arr);
        return root;

        //in all this we don't need to check the length of the string array
        //for the overflow condition because our recursion will take care of it
        //it will get over before it goes out of bounds
    }
}
