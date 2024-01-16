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
            String input_line[] = read.readLine().trim().split("\\s+");
            int m = Integer.parseInt(input_line[0]);
            int n = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.numberSequence(m, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int numberSequence(int m, int n)
    {
        // code here
        int[][] dp = new int[n][m + 1];

        for (int i = 1; i < m + 1; i++) {
            dp[n - 1][i] = 1;
        }

        for (int i = n - 2; i > -1; i--) {
            for (int j = 1; j < m + 1; j++) {
                for (int k = 2 * j; k < m + 1; k++) {
                    dp[i][j] += dp[i + 1][k];
                }
            }
        }

        return Arrays.stream(dp[0]).sum();

    }
}