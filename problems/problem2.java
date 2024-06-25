// upper bound
public class problem2 {

    // time comlexity O(lonN) with space complexity O(1)
    public static int optimalSolution(int arr[],int x){
        int n = arr.length;
        int ans=n;
        int left=0;
        int right=n-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid]>x){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        System.out.println(left);
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={1,2,5,7,9};
        int x=2;
        optimalSolution(arr,x);    
    }
}

/*
Uper bound -> smallest number such that arr[i]>X ,you need to return that number index from the error.
if answer is not present than return length of array;
NOTE: Array is in the sorted form.
*/
