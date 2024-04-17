//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(n, n, sb, ans);
        return ans;
    }
    
    void helper(int o, int c, StringBuilder sb, List<String> ans){
        if (o == 0 && c == 0) {
            ans.add(sb.toString());
            return;
        }
        
        if (o > 0) {
            helper(o - 1, c, sb.append('('), ans);
             sb.deleteCharAt(sb.length() - 1);
        }
        
        if (c > o) {
            helper(o, c - 1, sb.append(')'), ans);
             sb.deleteCharAt(sb.length() - 1);
        }
    }
}
