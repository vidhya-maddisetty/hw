public class Driver {

    public static void main (String [] args) {

	Cypher c = new Cypher ();

	System.out.println (c.encoder ("hello", 3));

	System.out.println (c.encoder ("abcxyz", 3));

	System.out.println (c.encoder ("hi there!", 1));




    }

}
