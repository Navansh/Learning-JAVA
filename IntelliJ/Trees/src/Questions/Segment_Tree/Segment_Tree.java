package Questions.Segment_Tree;

public class Segment_Tree {
    public static void main(String[] args) {
        int[] data = {3,8,6,7,-2,-8,4,9};
        segmentTree(data);
        System.out.println(query(1,6));
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

    public static int queryTree(SegmentNode root, int startIndex, int endIndex) {
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

    public void update(SegmentNode root, int index, int value) {
        root.data = updateTree(root, index, value);
    }

    public int updateTree(SegmentNode node, int index, int value) {
        //for the given index, update the value that is present with the passed value

        //first check if the given index is within the range of the tree
        if(index >= node.startInterval && index <= node.endInterval) {
            if(index == node.startInterval && index == node.endInterval) {
                //means we are at the leaf node, which contains just our targetIndex
                //and this is where we update the value of the node, so that its
                //updated in the entire tree

                node.data = value;
            } else {
                //meaning we are in the range and yet to find the leaf node
                //but the range contains our target index
                int leftAns = updateTree(node.left,index, value);
                int rightAns = updateTree(node.right,index, value);

                node.data = leftAns + rightAns;
                return node.data;
            }
        }

        //this is the case when its totally out of bounds from the range
        //of the node
        //hence this node's value won't change even if we update the value
        //of the given target index

        //hence just return the original value
        return node.data;
    }
}
