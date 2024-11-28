public class LoanCalc {
	
	static double epsilon = 0.001;  
	static int iterationCount = 1; 
	
	
	public static void main(String[] args) {		
		// Gets the loan data
		double loanAmount = Double.parseDouble(args[0]);
		double interestRate = Double.parseDouble(args[1]);
		int periods = Integer.parseInt(args[2]);
		System.out.println("Loan Amount = " + loanAmount + ", interest rate = " + interestRate + "%, periods = " + periods);
        interestRate = interestRate/100 + 1;

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loanAmount, interestRate, periods, epsilon));
		System.out.println("Number of iterations: " + (iterationCount - 2));

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bisection search: ");
		System.out.println((int) bisectionSolver(loanAmount, interestRate, periods, epsilon));
		System.out.println("Number of iterations: " + iterationCount);
	}
	

    public static double bruteForceSolver(double loanAmount, double interestRate, double periods, double epsilon) {
        double balance = loanAmount;
        double paymentGuess = loanAmount / periods;
        while (balance > 0) {      
            balance = loanAmount;
            for (int i = 0; i < periods; i++) {
                balance = (balance - paymentGuess) * interestRate;          
            }             
            paymentGuess += epsilon;
            iterationCount++;
        }       
        return paymentGuess;
    }

    public static double bisectionSolver(double loanAmount, double interestRate, double periods, double epsilon) {
        iterationCount = 0;
        double balance = loanAmount;
        double highPayment = loanAmount;
        double lowPayment = loanAmount / periods;  
        double paymentGuess = (lowPayment + highPayment) / 2;
        while ((highPayment - lowPayment) > epsilon) {      
            balance = loanAmount;
            for (int i = 0; i < periods; i++) {
                balance = (balance - paymentGuess) * interestRate;          
            }   
            if (balance > 0) { 
                lowPayment = paymentGuess;
                paymentGuess = (lowPayment + highPayment) / 2;
                
            } else { 
                highPayment = paymentGuess;
                paymentGuess = (lowPayment + highPayment) / 2;
            }               
            iterationCount++;
        }            
        return paymentGuess;
    }
}
