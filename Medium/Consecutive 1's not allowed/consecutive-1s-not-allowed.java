//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            long ans = new Solution().countStrings(n);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
      public long countStrings(int n) {
        long[][] dp = new long[n + 1][2];

        final long mod = 1000000007;

        dp[n][0] = dp[n][1] = 1;

        for (int i = n - 1; i > -1; i--) {
            dp[i][1] = dp[i + 1][0];
            dp[i][0] = (dp[i + 1][1] + dp[i + 1][0]) % mod;
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        int n = 5; // Replace with your desired value
        long result = solution.countStrings(n);
        System.out.println(result);
    }
}