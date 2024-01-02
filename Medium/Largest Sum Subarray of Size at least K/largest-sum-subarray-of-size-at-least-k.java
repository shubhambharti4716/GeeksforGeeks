//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            System.out.println(obj.maxSumWithK(a, n, k));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public long maxSumWithK(long a[], long n, long k)
     {
        long sum=0,max=0,end=0;
        int i=0,j=0;

        while (i < k) 
            sum += a[i++];

        max = sum;

        while (i < n) {
            sum = sum + a[i];
            i++;
            end = end + a[j];
            j++;
            max = Math.max(sum,max);
            if(end<0){
                sum = sum-end;
                end = 0;
                max = Math.max(sum,max);
            }
        }

        return max;
    }
}