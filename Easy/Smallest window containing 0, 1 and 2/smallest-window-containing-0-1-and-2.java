//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
     public int smallestSubstring(String S) {
        
        int n = S.length();
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        
        while (right < n) {
            char ch = S.charAt(right);
            
            if (ch == '0') {
                cnt0++;
            }
            else if (ch == '1') {
                cnt1++;
            }
            else if (ch == '2') {
                cnt2++;
            }
            
            while (cnt0 > 0 && cnt1 > 0 && cnt2 > 0) {
                char leftChar = S.charAt(left);
                
                if (leftChar == '0') {
                    cnt0--;
                } else if (leftChar == '1') {
                    cnt1--;
                } else if (leftChar == '2') {
                    cnt2--;
                }
                min = Math.min(min, right - left + 1);
                
                left++; //Move left pointer to shrink the window
            }
            right++; //Move right pointer to shrink the window
        }

        return (min == Integer.MAX_VALUE) ? -1 : min;
    }
};
