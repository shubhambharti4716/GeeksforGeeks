//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
     public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        //using dp[][] array to store length of shortest common supersequence.
    	int dp[][]=new int[m+1][n+1];
    	
    	//dp[i][j] contains length of SCS of X[0..i-1] and Y[0..j-1].
        
    	for (int i = 0; i <= m; i++)
    	{
    		for (int j = 0; j <= n; j++)
    		{
    		    //if i is 0, dp[i][j] will be equal to size of second string.
        		if (i==0)             
        			dp[i][j] = j;
        			
        		//else if j is 0, dp[i][j] will be equal to size of first string.
        		else if (j==0)
        			dp[i][j] = i;  
        			
        		//if character of both strings are same then dp[i][j]
        		//will be 1+ dp[i-1][j-1].
        		else if (X.charAt(i-1) == Y.charAt(j-1))
        				dp[i][j] = 1 + dp[i-1][j-1]; 
        				
        		 //else dp[i][j] will be 1+ minimum answer without considering
        		 //the current character of 2 strings.
        		else
        				dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
    		}
    	}
        //returning the result.
    	return dp[m][n]; 
    }   
}