import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String[] args) {
	For f = new For();
	System.out.println(f.Reverse("Potato"));
	System.out.println(f.Reverse("I can fly!"));
	System.out.println(f.table(5,3));
	System.out.println(f.table(12,8));
    }
}