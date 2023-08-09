import java.util.Random;

public class Quicksort {
    static void partition_right(int []arr,int low,int high){
        Random rand=new Random();
        int pivot=rand.nextInt(high-low)+low;
        int temp=arr[pivot];
        arr[pivot]=arr[high];
        arr[high]=temp;
    }
    static int partition_left(int []arr,int low,int high){
        partition_right(arr,low,high);
        int pivot=arr[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;
        return i+1;

    }
    static void sort(int []arr,int low,int high){
        if(low<high){
            int pi=partition_left(arr,low,high);
            sort(arr,low,pi-1);
            sort(arr,pi+1,high);
        }
    }
    static void printarray(int []arr){
        System.out.print("The sorted array is: ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args){
        int []arr={10, 7, 8, 9, 1, 5};
        int n=arr.length;
        sort(arr,0,n-1);        
        printarray(arr);
    }    
}