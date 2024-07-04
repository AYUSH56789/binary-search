public class problem5 {
    
    // time compexity O(N) with space complexity O(1)
    public static int[] bruteForceSolution(int arr[],int x){
        int[] ans = new int[2];
        int first=-1;
        int last=-1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==x){
                if(first==-1){
                    first=i;
                }
                last=i;
            }
        };
        ans[0]=first;
        ans[1]=last;
        return ans;
    }


    // time complexity O(N) with space complexity O(1)
    public static int[] optimalSolution(int arr[],int x){
        int[] ans = new int[2];
        int first=lowerBound(arr, x);
        int last=upperBound(arr, x)-1;
        if(first== arr.length || arr[first]!=x){
            ans[0]=-1;
            ans[1]=-1;
            return ans;
        }
        ans[0]=first;
        ans[1]=last;
        return ans;
    }

    private static int lowerBound(int arr[],int x){
        int left=0;
        int right=arr.length-1;
        int ans=arr.length;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]>=x){
                ans=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }

    private static int upperBound(int arr[],int x){
        int left=0;
        int right=arr.length-1;
        int ans=arr.length;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]>x){
                ans=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int arr[]={5,7,7,8,8,10};
        int x=8;
        bruteForceSolution(arr,x);
        
        optimalSolution(arr,x);
    }
}

/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
*/
