//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine().trim();
            Solution ob = new Solution();
            ArrayList<String> ans = new ArrayList<String>();
            ans = ob.permutation(S);
            
            for(int i=0;i<ans.size();i++){
                System.out.print("("+ans.get(i)+")");
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java



class Solution{
    
    ArrayList<String> permutation(String S){
        // Code Here
        
        ArrayList<String> ans = new ArrayList<>();
        helper(S, S.charAt(0)+"", ans, 1);
        // Collections.sort(ans); 
        return ans;
        
    }
     void helper(String s,String ds,ArrayList<String> ans,int i){
        if(i>=s.length()){
            ans.add(ds);
            return;
        }
        
        helper(s,ds+" "+s.charAt(i),ans,i+1);
        helper(s,ds+""+s.charAt(i),ans,i+1);
        
    }
    
}