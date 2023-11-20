//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            
            System.out.println(ob.sumK(root,k));
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int mod = 1000000007; //constant value for modulo operation
    int ans = 0; //variable to store the final answer
    HashMap<Integer,Integer> mp = new HashMap<>(); //HashMap to store intermediate results
    
    //utility function to calculate the sum of paths with given sum
    public void sumK_util(Node root, int sum, int cur)
    {
        //base case: if root is null, return
        if(root == null)
            return;
        
        //check if cur+root.data - sum exists in the HashMap
        //if yes, add its frequency to the answer
        ans = (ans + (mp.getOrDefault(cur + root.data - sum,0))%mod)%mod;
        
        //check if cur+root.data is equal to sum
        //if yes, increment the answer by 1
        if((cur + root.data) == sum)
            ans = (ans+1)%mod;
        
        //update the frequency of cur+root.data in the HashMap
        mp.put(cur + root.data, (mp.getOrDefault(cur + root.data,0)+1)%mod);
        
        //recursively call the function for left and right subtrees
        sumK_util(root.left, sum, cur+root.data);
        sumK_util(root.right, sum, cur+root.data);
        
        //decrement the frequency of cur+root.data in the HashMap
        mp.put(cur + root.data, ((mp.getOrDefault(cur + root.data,0)-1) + mod)%mod);
    }
    
    //function to calculate the sum of paths with given sum
    public int sumK(Node root,int k)
    {
        //call the utility function
        sumK_util(root, k, 0);
        
        //clear the HashMap after the calculations
        mp.clear();
        
        //store the answer in a temporary variable
        int temp = ans;
        ans = 0; //reset the answer variable
        
        //return the temporary variable as the final answer
        return temp;
    }
}