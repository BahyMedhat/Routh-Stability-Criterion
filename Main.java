import java.util.Scanner;


public class Main {
	private static Scanner in;
	public static void main(String []args){
		System.out.println("Enter coefficients of the equation in decreasing order of powers :") ;
		in = new Scanner(System.in);
		String s = in.nextLine() ;
		String numbers[] = s.split(" ") ;
		double []input = new double[numbers.length] ;
		for(int i = 0 ; i < numbers.length ; i++){
			input[i] = Double.parseDouble(numbers[i]) ;
		}
		for(int i = 1 ; i < input.length ; i++){
			input[i] /= input[0] ;
		}
		input[0] = 1 ;
		Routh routh = new Routh(input) ;
		Polynomial polynomial = new Polynomial() ;
		int rightRoots = routh.check() ;
		if(rightRoots == 0){
			System.out.println("Stable") ;
			return ; 
		}
		else {
			System.out.println("Unstable") ;
			System.out.println("Number of right roots are : " + rightRoots) ;
		}
		double last = 0.0 ;
		while(rightRoots > 0){
			double lo = last , hi = 100.0 ;
			while(hi-lo > 1e-5){
				double mid = (lo+hi)/2.0 ;
				double arr[] = polynomial.getArr(input, mid) ;
				routh.setEqu(arr);
				int x = routh.check() ;
				if(x >= rightRoots){
					lo = mid ;
				}
				else hi = mid ;
			}
			System.out.printf("%.4f\n",lo) ;
			last = lo ;
			rightRoots --;
		}
	}
}
