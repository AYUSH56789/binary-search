// Lower bound
public class problem1 {

    // time complexity O(N) with space complexity O(1) 
    public static int optimalSolution(int arr[],int x){
        int ans=arr.length;
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]>=x){
                ans=mid;
                right=mid-1; //becuase we want smallest element that is greater than X
            }else{
                left=mid+1;
            }
        }
        System.out.println(ans);
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={1,2,5,7,9};
        int x=0;
        optimalSolution(arr,x);
    }
}

/*
Lower bound -> smallest number such that arr[i]>=X ,you need to return that number index from the error.
if X is not present and greater than arr.max.value than return length of array;
NOTE: Array is in the sorted form.
*/
