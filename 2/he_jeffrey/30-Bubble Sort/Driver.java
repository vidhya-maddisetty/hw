import java.util.*;
import java.io.*;

public class Driver {
    public static void main(String[] args) {
	SortN q = new SortN();
	System.out.println(Arrays.toString(q.radix()));
	Bubbles b = new Bubbles();
	System.out.println(Arrays.toString(b.optimizedBubbleSort()));
    }
}
