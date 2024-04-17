//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();  
            System.out.println(obj.countPairs(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {  
    static int countPairs(int arr[], int n) 
    {
         // Your code goes here
          int[] a=new int[n];
         int ans=0;
         
         for(int i=0;i<n;i++)
            a[i]=i*arr[i];
        
        for(int i=n-1;i>0;i--){
            for(int j=i-1;j>=0;j--){
                if(a[j]>a[i])
                    ans++;
            }
        }
         
        return ans;
    }
}
