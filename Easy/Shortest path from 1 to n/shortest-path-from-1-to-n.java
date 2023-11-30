//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minStep(n));
        }
    }
}
// } Driver Code Ends


class Solution{
    public int minStep(int n)
    {
        int ans = 0;
        //loop until n is greater than 1.
        while(n > 1){
            //if n is divisible by 3, reduce n to one-third its value and increment ans.
            if(n % 3 == 0){
                ans++;
                n /= 3;
            }
            //if n is not divisible by 3, reduce n by 1 and increment ans.
            else{
                n--;
                ans++;
            }
        }
        //return the minimum steps required to reach 1 from n.
        return ans;
    }
}
