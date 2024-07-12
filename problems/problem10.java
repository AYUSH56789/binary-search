public class problem10 {


    // time complexity O(N) with space complexity O(1)
    public static int bruteForceSolution(int nums[]){
        int n = nums.length;
        int ans=-1;
        int min=Integer.MIN_VALUE;

        // if array have only one element
        if(n==1){
            ans=0;
            return 0;
        }
        for(int i=0;i<n;i++){
            if(i==0){
                if(nums[i]>nums[i+1] && nums[i]>min){
                    ans= i;
                    break;
                }
            }
            else if(i==n-1){
                if(nums[i]>nums[i-1] && nums[i]>min){
                    ans= i;
                    break;
                }
            }
            else{
                if(nums[i]>nums[i+1] && nums[i]>nums[i-1]){
                    ans=i;
                    break;
                }
            }
        }
//      print answer
        System.out.println(ans);
        return ans;
    }



    // time complexity O(logN) with space complexity O(1)
    public static int optimalSolution(int nums[]){
        int n = nums.length;
        int min=Integer.MIN_VALUE;
        int ans=-1;

        if(n==1){
            return 0;
        }

        if(nums[0]>nums[1]&&nums[0]>min){
            ans=0;
            return ans;
        }
        if(nums[n-1]>nums[n-2]&&nums[n-1]>min){
            ans=n-1;
            return ans;
        }
        int left=1;
        int right=n-2;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                ans=mid;
                break;
            }
            else if(nums[mid]>nums[mid-1]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        System.out.println(ans);
        return ans;
    }
    public static void main(String[] args) {
        int nums[]={1,2,1,3,5,6,4};
        // int nums[]={1,2,3,1};
        bruteForceSolution(nums);
        optimalSolution(nums);
    }
}

/*
A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 

Constraints:

1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
nums[i] != nums[i + 1] for all valid i.
*/
