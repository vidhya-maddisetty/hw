import java.io.*;
import java.util.*;

public class Driver{

    public static void main(String[] args){

	CaesarCipher c = new CaesarCipher();

	System.out.println(c.encode("hello",3));
	System.out.println(c.encode("abcxyz",3));
	System.out.println(c.encode("hi there!",1));

    }
}