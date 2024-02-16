//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class GFG
{
    public static void printList(Node head) {
        while (head != null) {
            if (head.left != null)
                System.out.print("-1 ");
            System.out.print(head.data + " ");
            head = head.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String str = sc.nextLine();
            Node root = buildTree(str);
            Solution ob = new Solution();
            Node ans = ob.flattenBST(root);
            printList(ans);
        }
        sc.close();
    }

    private static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N')
            return null;

        String[] ip = str.split("\\s+");
        int index = 0;

        Node root = new Node(Integer.parseInt(ip[index++]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty() && index < ip.length) {
            Node currNode = queue.poll();

            String currVal = ip[index++];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }

            if (index >= ip.length)
                break;
            currVal = ip[index++];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
        }

        return root;
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    public Node flattenBST(Node root) {
        // Code here
        if (root == null) {
            return null;
        }
        List<Node> nodes=new ArrayList<>();
        inOrderTraversal(root, nodes);
        for(int i=0;i<nodes.size()-1;i++)
        {
            nodes.get(i).left=null;
            nodes.get(i).right=nodes.get(i+1);
        }
         nodes.get(nodes.size() - 1).left = null;
        nodes.get(nodes.size() - 1).right = null;
        return nodes.get(0);
    }
    public static void inOrderTraversal(Node node, List<Node> nodes)
        {
            if(node==null)
            {
                return;
            }
            inOrderTraversal(node.left, nodes);
            nodes.add(node);
            inOrderTraversal(node.right, nodes);
    }
}
