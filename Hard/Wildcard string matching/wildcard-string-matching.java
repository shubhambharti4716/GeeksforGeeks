//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0)
        {
            String wild = in.readLine();
            String pattern = in.readLine();
            
            Solution ob = new Solution();
            boolean flag = ob.match(wild, pattern);
            if(flag)
            System.out.println("Yes");
            else
            System.out.println("No");
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static Boolean dp[][];
    static boolean rec(int pi,int wi,String p,String w){
        if(dp[pi][wi]!=null) return dp[pi][wi];
        boolean b=false;
        if(pi==p.length() && wi==w.length()) b=true;
        else if(wi==w.length()) b=false;
        else if(pi==p.length()) b=w.charAt(wi)=='*' && rec(pi,wi+1,p,w);
        else if(p.charAt(pi)==w.charAt(wi)||w.charAt(wi)=='?') b=rec(pi+1,wi+1,p,w);
        else if(w.charAt(wi)=='*') b=rec(pi+1,wi,p,w)||rec(pi,wi+1,p,w);
        return dp[pi][wi]=b;
    }
    static boolean match(String wild, String pattern)
    {
        // code here
        int n=wild.length(),m=pattern.length();
        dp=new Boolean[m+1][n+1];
        return rec(0,0,pattern,wild);
    }
}