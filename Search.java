import java.util.*;

public class Search {
    public static int linearsearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                System.out.println("Number found at " + i + " index");
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int []arr,int low,int high,int x){
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==x){
            System.out.println("Number found at "+mid +" index");
            return mid;
            }
            if(arr[mid]<x){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
    }
    return -1;
}

    public static int exponentialsearch(int []arr,int low,int n,int x){
        if(arr[0]==x){
            System.out.print("Number found at index "+arr[0]);
            return 1;
        }
        else{
            int i=1;
            while(i<n && arr[i]<=x){
                if(arr[i]==x){
                    System.out.println("Number found at index "+i);
                    return i;
                }
                i*=2;
            }
            return binarySearch(arr, i/2, n, x);

        }



    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int[] arr = { 1,2,3,4,5,6};
        Arrays.sort(arr);
        int a = linearsearch(arr, 3);
        int b=binarySearch(arr,0,arr.length,1);
        System.out.println("Enter the number to be searched");
        int num=input.nextInt();
        exponentialsearch(arr,0,arr.length,num);
        if (b==-1 || a==-1) {
            System.out.println("The number is not present");
        }
        input.close();
    }
}