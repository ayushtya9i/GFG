//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    for(int i=0;i<t;i++){
	        int n = Integer.parseInt(br.readLine());
	        String l = br.readLine();
    		String[] sarr = l.split(" ");
    		int[] arr = new int[sarr.length];
    		for(int i1=0;i1<arr.length;i1++){
    			arr[i1] = Integer.parseInt(sarr[i1]);
    		}
    		
            Solution obj = new Solution();
            
            int[] res = obj.twoRepeated(arr, n);
            System.out.println(res[0] + " " + res[1]);
	    }
	}
}
// } Driver Code Ends


//User function template for JAVA

class Solution {
    // Function to find two repeated elements.
    public int[] twoRepeated(int arr[], int n) {
        HashSet<Integer> set = new HashSet<>();
        int ans[] = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) { // If the element is already in the set, it's repeated.
                if (ans[0] == -1) { // If the first repeated element is not yet found.
                    ans[0] = arr[i];
                } else { // If the first repeated element is already found, then this is the second repeated element.
                    ans[1] = arr[i];
                    break; // No need to continue, we found both repeated elements.
                }
            } else {
                set.add(arr[i]); // Add the element to the set if it's not already present.
            }
        }
        
        return ans;
    }
}