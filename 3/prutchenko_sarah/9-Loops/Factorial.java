public class Factorial{
    public int fact(int n){
	if (n > 0){
	    return n * fact(n-1);
	}
	return 1;
	    }
    public int fact2(int n){
	int total = 1;
	while (n > 0){
	    total = total * n;
	    n = n - 1;
	}
	return total;
    }	   
}
