import java.util.ArrayList;
import java.util.Collections;


public class Polynomial {
	private ArrayList<Double>arr = new ArrayList<Double>() ;
	public double[] getArr(double[]input , double x){
		arr.clear(); 
		for(int i = 0 ; i < input.length ; i++){
			arr.add(input[i]) ;
		}
		double ans[] = new double[input.length] ;
		ArrayList<Double>term = new ArrayList<Double>() ;
		term.add(x) ;
		term.add(1.0) ;
		ArrayList<Double>now = new ArrayList<Double>() ;
		Collections.reverse(arr);
		for(int i = 0 ; i < input.length ; i++){
			if(i == 0){
				ans[0] += arr.get(i) ;
				continue ;
			}
			else if(i == 1){
				ans[0] += x*arr.get(1) ;
				ans[1] += arr.get(1) ;
				now.add(x) ;
				now.add(1.0) ;
				continue ;
			}
			now = mul(now,term) ;
			for(int j = 0 ; j < now.size() ; j++){
				ans[j] += arr.get(i)*now.get(j) ;
			}
		}
		for(int i = 0 ; i < ans.length/2 ; i++){
			double xx = ans[i] ;
			ans[i] = ans[ans.length-i-1] ;
			ans[ans.length-i-1] = xx ;
		}
		return ans;
	}
	
	private ArrayList<Double> mul(ArrayList<Double> x, ArrayList<Double>y) {
		int size = x.size()+y.size()-1 ;
		ArrayList<Double>ans = new ArrayList<Double>() ;
		for(int i = 0 ; i < size ; i++)ans.add(0.0) ;
		for(int i = 0 ; i < x.size() ; i++){
			for(int j = 0 ; j < y.size() ; j++){
				ans.set(i+j, ans.get(i+j) + x.get(i)*y.get(j)) ;
			}
		}
		return ans ;
	}
}
