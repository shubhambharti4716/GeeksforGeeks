//{ Driver Code Starts
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
            int[][] mat = new int[n][n];
            String[] S = br.readLine().trim().split(" ");
            int i = 0;
            int j = 0;
            for(int k = 0; k < S.length; k++){
                mat[i][j] = Integer.parseInt(S[k]);
                j++;
                if(j == n){
                    i++;
                    j = 0;
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.matrixDiagonally(mat);
            for(int it = 0; it < ans.length; it++){
                System.out.print(ans[it] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] matrixDiagonally(int[][] mat) {
        int i = 0, j = 0;
        int n = mat.length;
        int[] res = new int[n*n];
        int k = 0;
        int up = 1;
        int down = 0;
        while ( true ) {
            
            if ( i == n - 1 && j == n - 1 ){
                res[k++] = mat[i][j];
                break;
            }
            res[k++] = mat[i][j];
            if ( up == 1 ) {
                i--;
                j++;
                if ( i == -1 && j == n ) {
                    up = 0;
                    down = 1;
                    i = i + 2;
                    j = j - 1;
                }else if ( i == -1 ) {
                    up = 0;
                    down = 1;
                    i++;
                }else if ( j == n ) {
                    up = 0;
                    down = 1;
                    i = i+2;
                    j--;
                }
            }else {
                i++;
                j--;
                if ( i == n && j == -1 ){
                    up = 1;
                    down = 0;
                    i = i - 1;
                    j = j + 2;
                }else if ( j == -1 ) {
                    up = 1;
                    down = 0;
                    j++;
                }else if ( i == n ) {
                    up = 1;
                    down = 0;
                    i--;
                    j = j + 2;
                }
            }
        }
        return res;
    }
}