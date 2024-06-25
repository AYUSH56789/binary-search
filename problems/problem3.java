// 
public class problem3 {
    

    // time complexity O(N) with space complexity O(1)
    public static int bruteForceSolution(int arr[],int target){
        int position=-1;
        for(int i=0;i<arr.length;i++){
            position= i;
            if(arr[i]==target){
                return position;
            }
            else if(arr[i]>target) {
                return position;
            }
        }
        position=position+1;
        return position;
    }


    // optimal solution: time complexity O(logN) with space complexity O(1)
    public static int optimalSolution(int arr[],int target ){
        // this is based on the lower bound question.
        int left=0;
        int right=arr.length-1;
        int position=arr.length;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]>=target){
                position=mid;
                right=mid-1;                
            }
            else{
                left=mid+1;
            }
        }
        return position;
    }
    public static void main(String[] args) {
        int arr[]={1,3};
        int target=2;
        System.out.println(bruteForceSolution(arr,target));
        System.out.println(optimalSolution(arr,target));
    }
}
/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104

*/