//{ Driver Code Starts
import java.util.*;

class Distinct_Occurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			Solution ob = new Solution();
			System.out.println(ob.subsequenceCount(S,T));
			t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method*/

class Solution
{
     static int solve(int i, int j, String s, String t,
                     int dp[][])
    {
        // base case
        // if second string completed then we found the
        // matching pattern
        if (j == t.length()) {
            return 1;
        }
        // if first string is completed we can not find any
        // matching pattern.
        if (i == s.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // if character at i'th place is equal to character
        // at j'th place then
        // we can either take it or not take it.
        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j]
                = (solve(i + 1, j + 1, s, t, dp)
                       % 1000000007
                   + solve(i + 1, j, s, t, dp) % 1000000007)
                  % 1000000007;
        }
        // if characters are not equal then we will increase
        // only first string
        return solve(i + 1, j, s, t, dp) % 1000000007;
    }

    int subsequenceCount(String S, String T)
    {
        int dp[][]
            = new int[S.length() + 1][T.length() + 1];
        for (int i = 0; i < S.length() + 1; i++)
            Arrays.fill(dp[i], -1);

        return solve(0, 0, S, T, dp) % 1000000007;
    }
}