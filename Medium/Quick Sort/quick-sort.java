//{ Driver Code Starts
import java.util.*;
class Sorting
{
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    
    // Driver program
    public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

			
			new Solution().quickSort(arr,0,n-1);
			printArray(arr);
		    T--;
		}
} }
// } Driver Code Ends




class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int l, int h)
    {
        if(l < h) {
            int pivot = partition(arr, l, h);
            quickSort(arr, l, pivot - 1);
            quickSort(arr, pivot + 1, h);
        }
    }
    
   static int partition(int arr[], int l, int h)
{
    int pivot = arr[l];
    int i = l;
    int j = h;
    while(i < j) { 
        while(i <= h && arr[i] <= pivot) i++;
        while(j >= l && arr[j] > pivot) j--; 
        if(i < j) {
            swap(arr, i, j);
        }
    }
    swap(arr, l, j);
    return j;
} 

    
    static void swap(int arr[], int i, int j)
    {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
