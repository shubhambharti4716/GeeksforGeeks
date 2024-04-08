//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class OptimalStrategy
{
    public static void main (String[] args) {
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking number of elements
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            //inserting the elements
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
                
           //calling the countMaximum() method of class solve
           System.out.println(new solve().countMaximum(n, arr)); 
        }
    }
    
    
}
// } Driver Code Ends



class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int n, int arr[])
    {
        // Your code here
        int[][] dp = new int[n][n];
        
        // Loop through all possible subarrays of different lengths
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) {
                    // When there is only one coin, choose it
                    dp[i][j] = arr[i];
                } else if (g == 1) {
                    // When there are two coins, choose the maximum value
                    dp[i][j] = Math.max(arr[i], arr[j]);
                } else {
                    // When there are more than two coins, consider two scenarios:
                    // 1. If the player chooses the coin at index i
                    // 2. If the player chooses the coin at index j
                    // The player selects the option that maximizes their winning amount
                    dp[i][j] = Math.max(arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]), 
                                        arr[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]));
                }
            }
        }
        
        // Return the maximum possible amount of money the first player can win
        return dp[0][n - 1];
    }
}
