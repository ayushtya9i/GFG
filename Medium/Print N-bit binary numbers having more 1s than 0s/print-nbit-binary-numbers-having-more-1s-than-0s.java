//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<String> NBitBinary(int N) {
        // code here
        ArrayList<String> ans= new ArrayList<>();
        helper(N,"",ans,0,0);
        return ans;
    }
    
    void helper(int n,String s,ArrayList<String> ans,int o,int z){
        if(n==0){
            ans.add(s);
            return;
        }
        helper(n-1,s+"1",ans,o+1,z);
        if(o-z>0){
            helper(n-1,s+"0",ans,o,z+1);
        }
    }
}