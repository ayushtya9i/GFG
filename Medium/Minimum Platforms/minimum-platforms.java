//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}



// } Driver Code Ends



class Train {
    int arrivalTime;
    int departureTime;
    
    public Train(int arrivalTime, int departureTime) {
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }
}

class TimeComparator implements Comparator<Train> {
    @Override
    public int compare(Train t1, Train t2) {
        return t1.arrivalTime - t2.arrivalTime;
    }
}

class Solution {
    // Function to find the minimum number of platforms required.
    static int findPlatform(int[] arr, int[] dep, int n) {
        // Convert arrival and departure times from HHMM format to minutes.
        int[] arrival = convertToMinutes(arr);
        int[] departure = convertToMinutes(dep);
        
        ArrayList<Train> trains = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            trains.add(new Train(arrival[i], departure[i]));
        }
        
        Collections.sort(trains, new TimeComparator());
        
        PriorityQueue<Integer> departureTimes = new PriorityQueue<>();
        int platformsNeeded = 0;
        
        for (Train train : trains) {
            if (!departureTimes.isEmpty() && departureTimes.peek() < train.arrivalTime) {
                departureTimes.poll();
            } else {
                platformsNeeded++;
            }
            departureTimes.offer(train.departureTime);
        }
        
        return platformsNeeded;
    }
    
    // Helper function to convert HHMM format to minutes.
    static int[] convertToMinutes(int[] timeArray) {
        int[] minutesArray = new int[timeArray.length];
        for (int i = 0; i < timeArray.length; i++) {
            minutesArray[i] = timeArray[i] / 100 * 60 + timeArray[i] % 100;
        }
        return minutesArray;
    }
}
