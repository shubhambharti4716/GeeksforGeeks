//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}
class GfG
{
    static Scanner sc = new Scanner(System.in);
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        
        head = tail = new Node(val);
        
        size--;
        
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
        {
            
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n , m;
                    
                    n = sc.nextInt();
                    m = sc.nextInt();
                    
                    Node head1 = inputList(n);
                    Node head2 = inputList(m);
                    
                    Solution obj = new Solution();
                    
                    Node result = obj.findIntersection(head1, head2);
	    
	                printList(result);
	                System.out.println();
                }
        }
}
// } Driver Code Ends


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution
{
   public static Node findIntersection(Node t1, Node t2)
    {
       Node result = null;
        Node curr = null;

        HashMap<Integer, Integer> set = new HashMap<>();
        while (t1 != null) {
            set.put(t1.data, set.getOrDefault(t1.data, 0) + 1);
            t1 = t1.next;
        }

        while (t2 != null) {
            if (set.containsKey(t2.data) && set.get(t2.data) > 0) {
                set.put(t2.data, set.get(t2.data) - 1);
                if (result == null) {
                    result = new Node(t2.data);
                    curr = result;
                } else {
                    curr.next = new Node(t2.data);
                    curr = curr.next;
                }
            }
            t2 = t2.next;
        }

        return result;
    }
}