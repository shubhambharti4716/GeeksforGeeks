//{ Driver Code Starts
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Main {
    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            String[] ab = br.readLine().trim().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            GfG g = new GfG();
            System.out.println(g.findDist(root, a, b));
        }
    }
}


// } Driver Code Ends


// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {
    Node LCA(Node root, int n1, int n2) {
        // If the root is null, return null
        if (root == null) return null;

        // If either of the nodes is the root, return the root
        if (root.data == n1 || root.data == n2) return root;

        // Recursively find the LCA in the left and right subtrees
        Node l = LCA(root.left, n1, n2);
        Node r = LCA(root.right, n1, n2);

        // If both left and right LCA are not null, it means both nodes are in different subtrees, so return the root
        if (l != null && r != null) return root;

        // If both left and right LCA are null, it means both nodes are not present in the tree, so return null
        if (l == null && r == null) return null;

        // If only one of the left and right LCA is null, it means both nodes are present in the same subtree, so return the non-null LCA
        return (l != null) ? l : r;
    }

    // Function to find the distance between two nodes in a binary tree
    int findDist(Node root, int a, int b) {
        // Find the path length from the root to node a
        int x = pathLength(root, a) - 1;

        // Find the path length from the root to node b
        int y = pathLength(root, b) - 1;

        // Find the lowest common ancestor (LCA) of a and b
        int lcadata = LCA(root, a, b).data;

        // Find the path length from the root to the LCA
        int lcaDistance = pathLength(root, lcadata) - 1;

        // Return the distance between a and b by subtracting twice the path length to the LCA from the sum of the path lengths to a and b
        return (x + y) - 2 * lcaDistance;
    }

    // Function to find the path length from the root to a given node in a binary tree
    int pathLength(Node root, int n1) {
        // If the root is null, return 0
        if (root == null)
            return 0;
        else {
            // Initialize a variable to store the path length
            int x = 0;

            // If the current node is the target node or if the target node is present in the left or right subtree, update the path length and return it
            if ((root.data == n1) || (x = pathLength(root.left, n1)) > 0 ||
                (x = pathLength(root.right, n1)) > 0)
                return x + 1;
        }

        // If the target node is not found, return 0
        return 0;
    }
}