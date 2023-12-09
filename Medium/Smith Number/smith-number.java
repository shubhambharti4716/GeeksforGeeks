//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.smithNum(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int sumofdigit(int n)
    {
        int curr = n , sums=0;
        while(curr > 0)
        {
            sums += curr % 10;
            curr /= 10;
        }
        return sums;
    }    
    
    static int smithNum(int n) 
    {
        int sum=0,curr=sumofdigit(n),res=n;
        for(int i=2;i*i<=n;i++)
        {
            while(n % i == 0)
            {
                sum += sumofdigit(i);
                n /= i;
            }
        }
        if(n > 1)
        {
            sum+=sumofdigit(n);
        }
        if(res == n)
        {
            return 0;
        }
        if(curr == sum)
        {
            return 1;
        }
        return 0;
    }
};