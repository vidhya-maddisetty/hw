import java.io.*;
import java.util.*;

public class Driver {
    public static void main (String[] args) {
	For f = new For();

	System.out.println(f.diag(3));
	System.out.println(f.diag(5));

	System.out.println(f.diagWord("Novelty"));
	System.out.println(f.diagWord("Deus"));

	System.out.println(f.fence(5, 10));
	System.out.println(f.fence(7, 17));

    }
}
