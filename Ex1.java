package lab4;

import java.math.RoundingMode;
import java.text.DecimalFormat;


public class Ex1 {
	public static void main(String[] args){
		
		//double x[]={7, 3, -1, 2, 9 ,0, 0.8, 52, 2.2, 900};
		
		//random array
		double[]x = new double[160];
		for(int i=0;i<x.length;i++){
			x[i] = (double)(Math.random()*100+1);
			x[i] = Math.round(x[i]);
		}
		
		
		System.out.println("PrefixAverages1");
		for(int i=0;i<5;i++){
		long startTime=System.nanoTime();
		PrefixAverages1(x);
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
		}
		System.out.println("-------------------");
		System.out.println("PrefixAverages2");
		for(int i=0;i<5;i++){
		long startTime2=System.nanoTime();
		PrefixAverages2(x);
		long endTime2 = System.nanoTime();
		long totalTime2 = endTime2 - startTime2;
		System.out.println(totalTime2);
		}
		
	}
	public static void PrefixAverages1(double[] x){
		DecimalFormat df = new DecimalFormat("#.000");//print with 3 decimal places
		//df.setRoundingMode(RoundingMode.CEILING);
		int n = x.length;
		int i;
		int j;
	
		double a[]=new double[n];
		//add one value of x to s for each iteration
		for(i=0;i<n;i++){
			double s= x[0];
			for(j=1;j<n;j++){
				if(j<=i){
					s=s+x[j];
					
				}
			}
			a[i]=s/(i+1);//calculate the average between the values of a
			s=s/(i+1);
			//System.out.println("s: " + s);
			//System.out.print(df.format(a[i]) + " ");
		}
		
	}
	public static void PrefixAverages2(double[] x){
		DecimalFormat df = new DecimalFormat("#.000");
		//df.setRoundingMode(RoundingMode.CEILING);
		int n = x.length;
		int i;
		double s=0;

		double a[]=new double[n];
		for(i=0;i<n;i++){
			s= s+ x[i];
			a[i]=s/(i+1);
			//System.out.print(df.format(a[i])+ " ");
		}
	
	}
}

/* The Time Complexity of the PrefixAverages1 is: O(n^2)
							  PrefixAverages2 is: O(n)
for this reason the second algorithm is more efficient than the first one. 


The Running time for the PrefixAverages1 is: T = 11n+6
					     PrefixAverages2 is: T = 7n +5



*/