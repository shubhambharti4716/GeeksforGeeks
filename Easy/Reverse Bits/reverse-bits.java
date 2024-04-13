//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.reversedBits(X));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static Long reversedBits(Long x) {
         long result = 0;
        int bitLength = 32; // Assuming 32-bit representation
        for (int i = 0; i < bitLength; i++) {
            result <<= 1; // Left shift result to make space for next bit
            if ((x & 1) == 1) {
                result |= 1; // Set the least significant bit of result if the corresponding bit in x is 1
            }
            x >>= 1; // Right shift x to move to the next bit
        }
        return result;
    }
};