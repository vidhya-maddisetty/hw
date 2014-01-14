import java.util.Random;

public class Driver {

    public static void main(String[] args) {
        Cipher c = new Cipher();
        Random r = new Random();
        if (args.length == 0) {
            System.out.println(c.encode("hello", 3));
            System.out.println(c.encode("abcxyz", 3));
            System.out.println(c.encode("Hello World! How are you?? WELCOME TO MY CAVE! PLEASE DON'T DESTROY ME D:\nBreak you with this \"", 13));
            System.out.println(c.encode(c.encode("Hello World! How are you?? WELCOME TO MY CAVE! PLEASE DON'T DESTROY ME D:\nBreak you with this \"", 13), 13));

            System.out.println(c.decrypt(c.encode("Hello World! How are you?? WELCOME TO MY CAVE! PLEASE DON'T DESTROY ME D:\nBreak you with this \"", 13)));
        }
        else if (args.length == 2) {
            System.out.println(c.decrypt(c.encode(args[0], r.nextInt(26)), args[1]));
        }
        else {
            System.out.println(c.decrypt(c.encode(args[0], r.nextInt(26))));
        }
    }
}