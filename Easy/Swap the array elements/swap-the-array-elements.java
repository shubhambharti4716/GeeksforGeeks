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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] S = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            obj.swapElements(arr, n);
            for(int i = 0; i < n; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void swapElements(int[] arr, int n)
    {
        // Code here
        if(n==1) return;
        int x=arr[0];
        int y=arr[1];
        for(int i=0;i<n-2;i++)
        {
            arr[i]=arr[i+2];
        }
        arr[n-2]=((n-2)%2==0)?x:y;
        arr[n-1]=((n-1)%2==0)?x:y;
    }
}