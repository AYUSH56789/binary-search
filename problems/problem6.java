public class problem6 {


    // time complexity O(N) with space complexity O(1)
    public static int bruteForceSolution(int arr[],int target){
        int ans=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                ans=i;
                break;
            }
        }
        System.out.println(ans);
        return ans;
    }


    // time comeplexity O(logN) with space complexity O(1)
    public static int betterSolution(int arr[],int target){
        int left=0;
        int right=arr.length;
        int ans=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==target){
                ans=mid;
                break;
            }
            else if(arr[left]<=arr[mid]){
                if(target>=arr[left] && target<arr[mid]){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            else{
                if(target>arr[mid]&& target<=arr[right]){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        int nums[]={4,5,6,7,0,1,2};
        int target=0;
        bruteForceSolution(nums,target);
        betterSolution(nums,target);
    }
}
/*

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
*/
