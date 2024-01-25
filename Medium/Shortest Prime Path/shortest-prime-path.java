//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java
class Solution{
     int mxp; // maximum value for prime numbers
    int[] prime; // array to store prime numbers
    
    Solution(){
        mxp=9999; // initialize maximum value for prime numbers
        prime=new int[10001]; // initialize array for prime numbers
        Arrays.fill(prime,1); // set all elements in prime array to 1
        prime[1]=0; // set the value at index 1 to 0, as 1 is not a prime number
        
        // Seive Of Eratosthenes
        // loop to find prime numbers using Seive Of Eratosthenes algorithm
        for(int i=2;i<=mxp;i++){
            if(prime[i]==1){
                for(int j=2;j*i<=mxp;j++){
                    prime[j*i]=0; // mark current number as non-prime in prime array
                }
            }
        }
    }
    
    int bfs(int source,int destination){
        int[] dp =new int[10001]; // array to store the shortest distance from source to destination
        Arrays.fill(dp,-1); // set all elements in dp array to -1
        int[] vis=new int[10001]; // array to track visited nodes
        Queue<Integer> q = new LinkedList<>(); // queue for BFS traversal 
        q.add(source); // add source to queue
        dp[source]=0; // set the distance of source from itself to 0
        vis[source]=0; // mark source as visited
        while(q.size()>0){
            int current=q.poll(); // get the current node from queue
            if(vis[current]==1)
                continue; // if current node is already visited, continue to next iteration
            vis[current]=1; // mark current node as visited
            String s=Integer.toString(current); // convert current number to string
            for(int i=0;i<4;i++){
                for(char ch='0';ch<='9';ch++){
                    if(ch==s.charAt(i)||(ch=='0'&&i==0))
                        continue; // if the digit in the string is equal to current digit or it is 0 at first position, continue to next iteration
                    String nxt=s;
                    nxt=s.substring(0,i)+ch+s.substring(i+1); // replace digit at index i with ch character in the string
                    int nxtN=Integer.valueOf(nxt); // convert the new string to integer
                    if(prime[nxtN]==1&&dp[nxtN]==-1){
                        // if the new number is prime and it is not visited yet
                        dp[nxtN]=1+dp[current]; // set the shortest distance to the new number
                        q.add(nxtN); // add the new number to queue for traversal
                    }
                }
            }
        }
        return dp[destination]; // return the shortest distance from the source to destination node
    }
    
    int solve(int Num1,int Num2){
        return bfs(Num1,Num2); // solve the problem by finding the shortest distance between Num1 and Num2
    }
}

//{ Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int Num1=Integer.parseInt(input_line[0]);
            int Num2=Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.solve(Num1,Num2));
        }
    }
}
// } Driver Code Ends