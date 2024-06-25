public class IterativeSearch{
    public static int binarySearch(int[] arr, int target){
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(target<arr[mid]){
                right=mid-1;
            }
            else if(target>arr[mid]){
                left=mid+1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // int arr[]={-1,0,3,5,9,12};
        // int target=9;
        int arr[]={-1,0,3,5,9,12};
        int target=2;
        int result=binarySearch(arr,target);
        System.out.println(result);
    }
}