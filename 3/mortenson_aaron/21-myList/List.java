import java.io.*;
import java.util.*;

public class List {
       private int[] data;
       private int numItems;

       public List() {
          data = new int[5];
	  numItems = 0;
       }


    public boolean isFull() {
	return numItems >= data.length;
    }

    public void grow() {
	int[] tmpArray = new int[data.length+data.length/2];
	for (int i=0;i<data.length;i++) {
	    tmpArray[i]=data[i];
	}
	data = tmpArray;
    }

    public void add(int d) {
	if (isFull()) {
	    grow();
    }

	data[numItems] = d;
	numItems=numItems+1;
    }


    public String toString() {
	String s = Arrays.toString(data)+" : "+numItems;
	return s;
    }


    public int remove(int pos) {
	int result = data[pos];
	for (;pos<numItems-1;pos++)
	    data[pos]=data[pos+1];
	numItems--;
	return result;
    }
}

}