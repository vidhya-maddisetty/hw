import java.io.*;
import java.util.*;

public class Coin {
    private String face;
    private int flips,heads,tails;
    private double fairness; 

    public void reset() { 
	flips = 0; 
	heads = 0; 
	tails = 0; 
	fairness = 0.0;
    }
    
    public void getFace() { 
	return face;
    }

}