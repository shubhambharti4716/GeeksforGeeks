//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String str=br.readLine();
    		String[] starr=str.split(" ");
    		
    		//input n and d
    	    int n=Integer.parseInt(starr[0]);
    		int k= Integer.parseInt(starr[1]);
            
            starr = br.readLine().trim().split(" ");
            int[] price = new int[n];
            for(int i = 0; i < n; i++)
                price[i] = Integer.parseInt(starr[i]);
            
            Solution obj = new Solution();
            int res = obj.buyMaximumProducts(n, k, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    static class Product implements Comparable<Product>{
        int price;
        int quan;
        
        public Product(int price,int quan){
            this.price=price;
            this.quan=quan;
        }
        
        @Override
        public int compareTo(Product p){
            return this.price-p.price;
        }
    }
    public static int buyMaximumProducts(int n, int k, int[] price) {
        // code here
        ArrayList<Product> ar=new ArrayList<>();
        for(int i=0;i<n;i++){
            ar.add(new Product(price[i],i+1));
        }
        
        Collections.sort(ar);
        // for(Product i:ar){
        //     System.out.println(i.price);
        // }
        
        int ans=0;
        for(Product i:ar){
        int s=k/i.price;
        if(s>i.quan && k>i.price){
            ans+=Math.min(i.quan,s);
            k-=i.price*i.quan;
        }
        else{
            if(k>=i.price){
                ans+=Math.min(i.quan,s);
                k=k-i.price*s;
            }
          
        }
      
        

    }
        return ans;
}
}
        
