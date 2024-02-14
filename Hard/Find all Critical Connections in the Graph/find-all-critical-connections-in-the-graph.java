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
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> ans = obj.criticalConnections(V, adj);
            for(int i=0;i<ans.size();i++)
                System.out.println(ans.get(i).get(0) + " " + ans.get(i).get(1));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<ArrayList<Integer>> al;
    int time;
    
    public ArrayList<ArrayList<Integer>> criticalConnections(int V, ArrayList<ArrayList<Integer>> adj)
    {
        al = new ArrayList<>();
       	boolean visited[] = new boolean[V]; 
		int disc[] = new int[V]; 
		int low[] = new int[V]; 
		int parent[] = new int[V]; 
        time = 0; 
 
		for (int i = 0; i < V; i++) 
		{ 
			parent[i] = 0; 
			visited[i] = false; 
		} 


		for (int i = 0; i < V; i++) 
			if (visited[i] == false) 
				bridgeUtil(i, visited, disc, low, parent, adj); 
				
				
        Collections.sort(al, (a, b) -> {
            int compareResult = a.get(0).compareTo(b.get(0));
            return compareResult != 0 ? compareResult : a.get(1).compareTo(b.get(1));
        });
		return al;
    }
    
    void bridgeUtil(int u, boolean visited[], int disc[], int low[], int parent[], ArrayList<ArrayList<Integer>> adj) 
	{ 

		visited[u] = true; 

		disc[u] = low[u] = ++time; 
 
		 Iterator<Integer> i = adj.get(u).iterator();
		while (i.hasNext()) 
		{ 
			int v = i.next(); 

			if (!visited[v]) 
			{ 
				parent[v] = u; 
				bridgeUtil(v, visited, disc, low, parent, adj); 

	
				low[u] = Math.min(low[u], low[v]); 

				 
				if (low[v] > disc[u]) {
			    if (u < v)  // Ensure the smaller vertex is added first
                    al.add(new ArrayList<>(Arrays.asList(u, v)));
                else
                    al.add(new ArrayList<>(Arrays.asList(v, u)));
                }
			} 

		
			else if (v != parent[u]) 
				low[u] = Math.min(low[u], disc[v]); 
		} 
	}
}