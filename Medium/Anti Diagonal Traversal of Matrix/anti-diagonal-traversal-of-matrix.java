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
            
            String input_line[] = br.readLine().trim().split("\\s+");
            int[][] matrix = new int[n][n];
            for(int i=0; i<n; i++) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = Integer.parseInt(input_line[i * n + j]); 
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.antiDiagonalPattern(matrix);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
     public int[] antiDiagonalPattern(int[][] matrix) {
        int n = matrix.length;
        int[][] b = new int[2 * n - 1][2];

        for (int i = 0; i < n; i++) {
            b[i][0] = 0;
            b[i][1] = i;
        }
        for (int j = 1; j < n; j++) {
            b[j + n - 1][0] = j;
            b[j + n - 1][1] = n - 1;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int x, y;
        for (int i = 0; i < 2 * n - 1; i++) {
            x = b[i][0];
            y = b[i][1];
            while (x < n && y >= 0) {
                ans.add(matrix[x][y]);
                x += 1;
                y -= 1;
            }
        }

        // Convert ArrayList to array
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}