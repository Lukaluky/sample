import java.io.*;
import java.util.*;
public class Mergesort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for( int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        arr = mergesort(arr, arr.length);
        for( int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static int[] mergesort(int[] arr, int size) {
        if( arr.length <= 2) {
            return arr;
        }
        int left = 0;
        int right = size-1;

        int mid = left + (right-left)/2;
        int[] arr1 = new int[mid+1];
        int[] arr2 = new int[right-mid];
        for( int i = 0; i < mid+1; i++) {
            arr1[i] = arr[i];
        }
        int j = 0;
        for( int i = mid+1; i < size; i++) {
            arr2[j] = arr[i];
            j++;
        }
        arr1 = mergesort(arr1, arr1.length);
        arr2 = mergesort(arr2, arr2.length);
        arr = sort(arr1, arr1.length, arr2, arr2.length);
        return arr;
    }
    public static int[] sort(int[] arr1, int size1, int[] arr2, int size2) {
        int[] arr = new int[size1+size2];
        int i = 0;
        int j = 0;
        while( i < size1 || j < size2 ) {
            if( j == size2 || (i < size1 && arr1[i] < arr2[j] )) {
                arr[i+j] = arr1[i];
                i++;
            } else {
                arr[i+j] = arr2[j];
                j++;
            }
        }

        return arr;
    }

}
