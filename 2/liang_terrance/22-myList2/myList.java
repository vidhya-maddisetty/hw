import java.io.*;
import java.util.*;

public class myList {
    private int[] data;
    private int numItems;
	    
    public myList() {
	data = new int[5];
	numItems=0;
    }

    public boolean isFull() {
	return numItems >= data.length;
    }

    public void grow() {
	// "grow" the array by creating a new one and copying over
	int[] tmpArray = new int[data.length+data.length/2];
	for (int i=0;i<data.length;i++) 
	    tmpArray[i]=data[i];
	data = tmpArray;
    }

    public void add(int d) {
	if (isFull()){
	    grow();
	}
	data[numItems]=d;
	numItems = numItems + 1;
    }
	    
    public String toString() {
	String s = Arrays.toString(data)+" : "+numItems;
	return s;
    }
	
    public void add(int pos, int d) {
	if (numItems >= data.length){
	    int[] newdata = new int[data.length + 1];
	    for (int i = 0; (i < numItems); i++){
		if (i<pos){
		    newdata[i] = data[i];
		}
		else{
		    newdata[i+1]=data[i];
		}
	    }
	    data = newdata;
	}
	else {
	    for (int i = numItems-1;(i >= pos); i --){
	        data[i+1]=data[i];
	    }
	}
	data[pos]=d;
	numItems = numItems + 1;
    }

    public void add2(int d){
	if (numItems >= data.length){
	    int[] temp = new int[numItems + 1];
	    for (int i = 0; (i < numItems); i ++){
		temp[i]=data[i];
	    }
	    data = temp;
	}
	data[numItems] = d;
    }

    public void remove(int pos) {
	for (int i = pos; i < data.length - 1; i++) {
            data[i] = data[i + 1];
        }
        data[numItems - 1] = 0;
        numItems = numItems - 1;
    }


    public int size() {
	return numItems;
    }
    public int get(int pos) {
        return data[pos];
    }
    public int set(int pos, int d) {
	return data[pos]=d;
    }
}
