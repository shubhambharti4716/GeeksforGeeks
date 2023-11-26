//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine().trim());
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.pattern(N);
            for(int i = 0;i < ans.size();i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
     public List<Integer> pattern(int N){
        // code here
        
        List<Integer> res=new ArrayList<>();
        if(N==0)
        {
            res.add(0);
            return res;
        }
        int temp=N;
        
        caller(N,res,temp,0);
        
        return res;
    }
    
    public void caller(int N,List<Integer> res,int t,int st)
    {
        if(t==N &&st==1)
        {
            res.add(N);
            return;
        }
        
        if(t<=0 && st==0)
        {
            st=1;
            res.add(t);
            caller(N,res,t+5,st);
        }
        
        else if(t>0 && st==0)
        {
            res.add(t);
            caller(N,res,t-5,st);
        }
        else if(t>0 && st==1)
        {
            res.add(t);
            caller(N,res,t+5,st);
        }
    }
}