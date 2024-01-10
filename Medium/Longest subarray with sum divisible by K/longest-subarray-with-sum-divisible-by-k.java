//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    int longSubarrWthSumDivByK(int a[], int n, int k){
        // Complete the function
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0,max1 = 0;
        
        // Initializing with a dummy entry for easier calculation
        map.put(0, -1);
        
        // Iterate through the array
        for(int i = 0; i<n;i++){
            sum += a[i];
            
            // Calculate the remainder when divided by K (taking care of negative number)
            int rem = (sum % k + k) % k;
            
            // Check if the remainder already exists in the HashMap
            // If it does, update maxLength to the difference between current index and stored index
            if(map.containsKey(rem))  
                max1 = Math.max(max1,i - map.get(rem));
                
            // If remainder is not in the HashMap, store it along with the current index
            else    
                map.put(rem,i);
        }
        return max1;
    }
 
}


//{ Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		   
		    int res = obj.longSubarrWthSumDivByK(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		    
		    
		}
	}
}



// } Driver Code Ends