//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
    // function to convert a given Gray equivalent n to Binary equivalent.
    public static int grayToBinary(int n) {
        String binaryNum = Integer.toBinaryString(n);
        String grayNum = "";
        char ch = binaryNum.charAt(0);
        grayNum +=  ch;
        int prev = ch - '0';
        for (int i = 1; i < binaryNum.length(); i++) {
            int curr = binaryNum.charAt(i) - '0';
            prev = prev ^ curr;
            grayNum += prev;
        }
        return Integer.parseInt(grayNum, 2);
    }
       
}



//{ Driver Code Starts.

class GFG {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//testcases
		while(t-->0){
		    int n = sc.nextInt();//initializing n
		    
		    Solution obj = new Solution();
		    
		    //calling grayToBinary() function
		    System.out.println(obj.grayToBinary(n));
		}
	}
}

// } Driver Code Ends