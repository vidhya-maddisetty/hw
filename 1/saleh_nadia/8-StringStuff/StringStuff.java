import java.io.*;
import java.util.*;

public class StringStuff {

    public String capitalize (String name) {
	String a = name.substring (0,1);
	a = a.toUpperCase();
	String finalName = a;
	int x = name.indexOf(" ");
	a = name.substring (1,x);
        finalName = finalName + a;
	a = name.substring(x,x+2);
	a = a.toUpperCase();
	finalName = finalName + a;
	a = name.substring (x+2);
	finalName = finalName + a;
	return finalName;
    }

    public String bondify(String name){
	name = capitalize (name);
	int x = name.indexOf(" ");
        String b  =  name.substring (0,x);
	String c = name.substring (x+1);
	String bonded = c + "," + b + " " + c + ".";
        return bonded;
    }
}