//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.recamanSequence(n);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
     static ArrayList<Integer> recamanSequence(int n){
        ArrayList<Integer> ls = new ArrayList<>();
        ls.add(0);
        int curr = 0;
        Set<Integer> s = new HashSet<>();
        s.add(0);
        for(int i = 1; i<n ;i++ ){
            int c= curr-i;
            if(c<0 || s.contains(c)){
            c= curr +i;
            }
            
            ls.add(c);
            s.add(c);
            curr = c;
        }
        return ls;
    }
}