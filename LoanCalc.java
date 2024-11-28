public class LoanCalc {
	
	static double eps = 0.001;  
	static int counter = 1; 

	public static void main(String[] args) {		

		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);
        rate = rate/100 +1;

	
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, eps));
		System.out.println("number of iterations: " + (counter-2));


		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, eps));
		System.out.println("number of iterations: " + counter);
	}
	

    public static double bruteForceSolver(double loan, double rate, double n, double eps) {
        double balance = loan;
        double g = loan/n;
        while (balance > 0) {      
            balance = loan;
            for (int i = 0; i < n; i++) {
                balance = (balance - g)*rate;          
            }             
            g += eps;
            counter++;
        }       
       
        return g;
    }
    

    public static double bisectionSolver(double loan, double rate, double n, double eps) {
        counter=0;
        double balance = loan;
        double hi = loan;
        double lo = loan/n;  
        double g = (lo+hi)/2;
        while ((hi-lo) > eps) {      
            balance = loan;
            for (int i = 0; i < n; i++) {
                balance = (balance - g)*rate;          
            }   
            if (balance > 0) { 
                lo = g;
                g = (lo+hi)/2;
                
            } else { 
                hi = g;
                g = (lo+hi)/2;
            }               
            counter ++;
        }            
        return g;
    }
}