import java.util.*;

class Radix{
    static int getmax(int arr[],int n){
        int mx=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]>mx){
                mx=arr[i];
            }    
        }
        return mx;
    }
    static void countsort(int arr[],int n,int pos){
        int[] count=new int[10];
        int[] output=new int[n];
        Arrays.fill(count,0);
        for(int i=0;i<n;i++){
            count[(arr[i]/pos)%10]++;
        }
        for(int i=1;i<10;i++){
            count[i]+=count[i-1];        
        }
        for(int i=n-1;i>=0;i--){
            output[count[(arr[i]/pos)%10]-1]=arr[i];
            count[(arr[i]/pos)%10]--;
        }
        for(int i=0;i<n;i++){
            arr[i]=output[i];
        }

    }
    static void radixsort(int arr[],int n){
        int m=getmax(arr,n);
        for(int pos=1;m/pos>0;pos*=10)
            countsort(arr,n,pos);   
    }
    public static void main(String[] args){
        int []arr={12076,8,2,1,96,76};
        int n=arr.length;
        radixsort(arr,n);
        System.out.println("The sorted number are");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}