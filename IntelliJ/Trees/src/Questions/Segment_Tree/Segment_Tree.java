package Questions.Segment_Tree;

public class Segment_Tree {
    public static void main(String[] args) {

    }

    private static class SegmentNode {
        int data;
        int startInterval;
        int endInterval;
        SegmentNode left;
        SegmentNode right;

        public SegmentNode(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }
    static SegmentNode root;
    public static void segmentTree(int[] data) {
        root = constructTree(data,0, data.length - 1);
    }

    private static SegmentNode constructTree(int[] data,int start, int end) {
        if(start == end) {
            //meaning we are at the leaf node
            SegmentNode leaf = new SegmentNode(start, end);
            leaf.data = data[start];
            //or data end as both are same anyways
            return leaf;
        }

        //now we're given the root node
        SegmentNode temp = new SegmentNode(start, end);
        int mid = start + (end - start) /2;

        temp.left = constructTree(data, start, mid);
        temp.right = constructTree(data, mid + 1, end);
        temp.data = temp.left.data + temp.right.data;

        return temp;
    }

    public void display() {
        displayTree(root);
    }

    private void displayTree(SegmentNode root) {
        StringBuilder str = new StringBuilder();

        //print the values and the interval
    }

    public static int query(int startIndex, int endIndex) {
        return queryTree(root, startIndex, endIndex);
    }

    private static int queryTree(SegmentNode root, int startIndex, int endIndex) {
        if(root.startInterval >= startIndex && root.endInterval <= endIndex) {
            //node is completely lying inside the query
            return root.data;
        } else if(root.startInterval > endIndex || root.endInterval < startIndex) {
            //completely outside, hence not what we want
            return 0;
        } else {
            //ask the left and right nodes to give more precise value
            return queryTree(root.left, startIndex, endIndex) + queryTree(root.right, startIndex, endIndex);
        }
    }

    public void update(int index, int value) {
        //for the given index, update the value that is present with the passed value

        //first check if the given index is within the range of the tree
        if(index >= root.startInterval && index <= root.endInterval) {
            if(index == root.startInterval && index == root.endInterval) {
                //means we are at the leaf node, which contains just our targetIndex
                //and this is where we update the value of the node, so that its
                //updated in the entire tree

                root.data = value;

            }
        }
    }
}
