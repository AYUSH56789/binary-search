import java.util.HashMap;

public class problem9 {
    // time complexity O(N)+O(logN) with space complexity O(logN)+1
    public static int bruteForceSolution(int arr[]) {
        int ans=-1;
        // step1: create hashmap
        HashMap<Integer,Integer> map=new HashMap<>();
        // step2: entry all elememts into map with T.M. O(N)
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
        }
        // step3: find the pair in which value == 1 -> print key  with T.M O(logN).
        for (Integer key : map.keySet()) {
            if(map.get(key)==1){
                ans=key;
            }
        }
        System.out.println(ans+"a");
        return ans;
    }


    // time complexity O(N) with space complexity O(1)
    public static int betterSolution(int arr[]){
        int ans=-1;
        int n=arr.length;

        //  handle corner case
        if(n==1){
            ans=arr[0];
            return ans;
        }
        for(int i=0;i<n;i++){
            // step1: eliminate from the array
            if(i==0){
                if(arr[i]!=arr[i+1]) {
                    ans=arr[0];
                    break;
                }
            }
            // step2: elimuinate last from the array
            else if(i==n-1 ){
                if(arr[i-1]!=arr[i-2]){
                    ans=arr[i-1];
                    break;
                } 
            }
            // step3: traverse rest elementand check for result
            else{
                if(arr[i]!=arr[i-1] && arr[i]!=arr[i+1]){
                    ans=arr[i];
                    break;
                }
            }
        }
        System.out.println(ans+"b");
        return ans;
    }



    // time complexity O(logN) with space complexity O(1)
    public static int optimalSolution(int arr[]){
        int ans=-1;
        int n=arr.length;

        // handle corner case
        if(n==1){
            ans=arr[0];
            return ans;
        }
        
        if(arr[0]!=arr[1]){
            ans=arr[0];
            return ans;
        }
        if(arr[n-1]!=arr[n-2]){
            ans=arr[n-1];
            return ans;
        }
        int left=1;
        int right=n-2;
        while(left<=right){
            int mid=left+(right-left)/2;
            // if arr[mid] not equal to right element and left element than it is the single element
            if(arr[mid-1]!=arr[mid] && arr[mid+1]!=arr[mid]){
                ans=arr[mid];
                break;
            }
            // if we are on the left side of the single element than we eliminate left side by moving left pointer to mid+1
            else if((((mid-1)%2==0) && (arr[mid]==arr[mid-1]) || (((mid+1)%2!=0) && (arr[mid]==arr[mid+1])))){
                left=mid+1;
            }
            // if we are on the right side than we eliminate right side by moving right pointer to mid-1;
            else{
                right=mid-1;
            }
        }
        System.out.println(ans+"c");
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4, 4, 5, 5};
        // int[] arr = {1};
        bruteForceSolution(arr);
        betterSolution(arr);
        optimalSolution(arr);
    }
}
