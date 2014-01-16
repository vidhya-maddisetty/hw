import java.io.*;
import java.util.*;

public class Sorts {

    Random r = new Random();
    protected int numDigits = 3;
    protected int numInts = 1000;
    protected int[] array1 = new int[10];
    protected ArrayList[] buckets = new ArrayList[10];

    public void Radix() {
      for (int i=0; i<10; i++) {
          buckets[i] = new ArrayList();
          }
          for (int i=0; i<10; i++) {
              array1[i] = (int)r.nextInt(9000) + 1000;
              }
    }

    public void Radix(int digits,int nums){
        buckets = new ArrayList[nums];
        array1 = new int[nums];
        numDigits = digits;
        numInts = nums;
        for (int i=0; i<nums; i++) {
            buckets[i] = new ArrayList();
        }
        for (int i=0; i<nums; i++) {
            array1[i] = (int)(r.nextInt(9000) + 1000);
        }
    }

    public String toString(int[] a) {
        return Arrays.toString(a);
    }

    public void setArray(int[] a) {
        array1 = a;
        numInts = array1.length;
    }

    public void radixSort() {
        for (int place=0; place<numDigits; place++) {
            for (int i=0; i<numInts; i++) {
                buckets[(int)(array1[i]/(Math.pow(10,place))%10)]
                    .add(array1[i]);
            }
            int arrayIndex = 0;
            for (int j=0; j<numInts; j++) {
                for (int i=0; i<buckets[j].size(); i++) {
                    array1[arrayIndex] = (Integer) buckets[j].get(i);
                    arrayIndex++;
                }
            }
            for (int i=0; i<10; i++) {
                buckets[i].clear();
            }
        }

    }

    public int[] bSort(int[] a){
        int j = 0;
        int temp = 0;
        int swapCount=0;
        int compCount=0;
        while (j < a.length-1){
	    
            for (int i = 0; i< a.length-1; i++) {
                if (a[i] > a[i+1]) {
                    temp = a[i+1];
                    a[i+1] = a[i];
                    a[i] = temp;
                    swapCount++;
                }
                compCount++;
            }
	    j++;
        }
        return a;
    }
    
    
    public int[] bSortOpt(int[] a){
        int j = 0;
        int temp = 0;
        int swapCount=0;
        int compCount=0;
        int currSwaps=0;
        while (j < a.length-1){
	    
            for (int i = 0; i< a.length-1; i++) {
                if (a[i] <= a[i+1]) {
                    currSwaps = 1;
                }
                else {
                    currSwaps = 0;
                    
                    if (currSwaps == 0) {
                        break;
                    }     
		    else return a;
                }
            }
	    
            
            for (int i = 0; i< a.length-1; i++) {
                if (a[i] > a[i+1]) {
                    temp = a[i+1];
                    a[i+1] = a[i];
                    a[i] = temp;
                    swapCount++;
                }
                compCount++;
            }
	    j++;
        }
        return a;
    }
    
    public static void main(String[] args) {
	Sorts s = new Sorts();
	int[] i = {3, 4, 6, 7, 9, 12, 16, 19, 21};
	int[] j = {3, 4, 6, 7, 9, 12, 16, 19, 21};
	int[] k = {1, 7, 4, 8, 11, 4, 17, 22, 14};
	int[] l = {1, 7, 4, 8, 11, 4, 17, 22, 14};

	System.out.println(s.toString(i));
        s.bSort(i);
        System.out.println(s.toString(i) + "\n");

	System.out.println(s.toString(j));
        s.bSortOpt(j);
        System.out.println(s.toString(j) + "\n");

	System.out.println(s.toString(k));
        s.bSort(k);
        System.out.println(s.toString(k) + "\n");

	System.out.println(s.toString(l));
        s.bSortOpt(l);
        System.out.println(s.toString(l) + "\n");
    }	
    
}