//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String s = sc.next();
            int k = sc.nextInt();
            int answer = new Solution().kSubstrConcat(n,s,k);
    		System.out.println(answer);
        }
        
    }
}

// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int kSubstrConcat(int n, String s, int k){
        if(n % k != 0){
            return 0;
        }

        HashSet<String> set = new HashSet<>();
        int ei = k;
        for(int i=0; i<=n-k; i+=k){
            String str = s.substring(i, ei);
            ei += k;
            set.add(str);
        }

        if(set.size() > 2){
            return 0;
        }
        return 1;
    }
}