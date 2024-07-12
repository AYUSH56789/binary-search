public class problem11 {
    // time complexity O(N)
    private static int findMax(int arr[]){
        int max =Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }

    private static int totalTime(int arr[],int i){
        int totalTime=0;
        int n=arr.length;
        for(int j=0;j<n;j++){
            totalTime+=(int)Math.ceil((double)arr[j]/(double)i);
        }
        return totalTime;
    }

    // time complexity O((M*N)+N) with space complexity is O(1)
    public static int bruteForceSolution(int arr[],int h){
        int totalTime=0;
        // time comeplxeity O(N)
        int max=findMax(arr);
        int k=1;
        // time complexity O(M)
        for(int i=1;i<=max;i++){
            k=i;
            // timr complexity O(N)
            totalTime=totalTime(arr,i);
            if(totalTime>h){
                totalTime=0;
            }
            else{
                break;
            }
        }
        System.out.println(k);
        return totalTime;

    }

    
    // time complexity O(N+logN) with space complexity O(1)
    public static int optimalSolution(int arr[],int h){
        int left=1;
        int right=findMax(arr);
        while (left<=right) {
            int mid=(left+right)/2;
            int totalTime=totalTime(arr,mid);
            if(totalTime<=h){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        System.out.println(left);
        return left;
    }



    public static void main(String[] args) {
        // int[] arr = {3,6,7,11};
        // int h=8;
        // int[] arr = {30,11,23,4,20};
        // int h=5;
        int[] arr = {30,11,23,4,20};
        int h=6;
        bruteForceSolution(arr,h);
        optimalSolution(arr,h);
    }
}

/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

 

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23
 

Constraints:

1 <= piles.length <= 10^4
piles.length <= h <= 10^9
1 <= piles[i] <= 10^9
*/
