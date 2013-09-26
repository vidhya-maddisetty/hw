import java.io.*;
import java.util.*;

public class Greeter {

    /* We can initialize an instance variable
       when we declare it like this:
    */
    //private String greeting="Go away"; 


    private String greeting;
    public String happygreeting,sadgreeting; 

    public Greeter(String g) {
	setGreeting(g);
    }

    public Greeter() {
	setGreeting("Hello");
	happygreeting = "Welcome";
	sadgreeting = "Begone";
    }	

    public Greeter(String happygreeting, String sadgreeting) {
	setHappy(happygreeting);
	setSad(sadgreeting);
    }

    public void setGreeting(String greet) {
	greeting = greet;
    }

    public void setHappy(String happygreet) {
	happygreeting = happygreet;
    }

    public void setSad(String sadgreet) {
	sadgreeting = sadgreet;
    }

    public String greet(String name) {
	String message;
	message = greeting + " " + name;
	return message;
    }

    public String happyGreet(String name) {
	String message;
	message = happygreeting + " " + name;
	return message;
    }

    public String sadGreet(String name) {
	String message;
	message = sadgreeting + " " + name;
	return message;
    }


    /* 
       Examples of method overloading. 
       Notice that each method has a
       unique signature, that is, the order and types of the
       parameters are unique. 
       Java doesn't care about the parameter names
    */
    public void f() {
    }
    public void f(String name1)  {
    }
    public void f(String name1, String name2) {
    }
    public void f(String name1, int name2) {
    }
    public void f(int name1, String name) {
    }
    /*
      This one doesn't work because we already
      have a method f with a String, String 
      signature

    public void f(String name2, String name1) {
    }
    */


}

