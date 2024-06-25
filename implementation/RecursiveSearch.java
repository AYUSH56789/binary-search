public class RecursiveSearch{
    public static int binarySearch(int[] arr, int target,int left ,int right){
        if(left>right){
            return -1;
        }
        int mid = left + (right - left) / 2;
        if(arr[mid] == target){
            return mid;
        }
        else if(arr[mid] < target){
            return binarySearch(arr, target, mid + 1, right);   
        }
        else{
            return binarySearch(arr, target, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        // int arr[]={-1,0,3,5,9,12};
        // int target=9;
        int arr[]={-1,0,3,5,9,12};
        int target=10;
        int result=binarySearch(arr,target,0,arr.length-1);
        System.out.println(result);
    }
}