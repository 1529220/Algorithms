package lab7;

import java.lang.reflect.Array;
import java.util.Random;


public class lab7 {
	
static Random rand = new Random();
	public static void main(String[] args) {
		
		//Example Exercise 1
//		
//		double g[][] = {{0,1,2},{1,0,3},{2,3,0}};
//		PrintArray(g);
//		System.out.println();
//		double mst[][] = MST.PrimsMST(g);
//		PrintArray(mst);
//		System.out.println();
//		
		//Example Exercise 2
		
//		double g[][] = {{0,1,2,3,0},{1,0,6,0,5},{2,6,0,4,1},{3,0,4,0,2},{0,5,1,2,0}};
//		PrintArray(g);
//		System.out.println();
//		double mst[][] = MST.PrimsMST(g);
//		PrintArray(mst);
//		System.out.println();
		
//		//Example Exercise 3
//		int n=100;
//		//for(int i = 0;i< 5 ; i++){
//		double[][] array = RandomArray(n);
//		long nanos = System.nanoTime();
//		// execute your stuff
//		double mst[][] = MST.PrimsMST(array);
//		long duration = System.nanoTime() - nanos;
//		int seconds = (int) (duration / 1000000000);
//		int milliseconds = (int) (duration / 1000000) % 1000;
//		int nanoseconds = (int) (duration % 1000000);
//		System.out.println();
//		System.out.printf(" %d seconds, %d milliseconds, %d nanoseconds \n",seconds, milliseconds, nanoseconds);
//		System.out.println();
//		//}
//		PrintArray(mst);
	}
	
	public static void PrintArray(double array[][]){
		
		for (int i = 0; i < array.length; i++) {
		    for (int j = 0; j < array[i].length; j++) {
		        System.out.print(array[i][j] + " ");
		    }
		    System.out.println();
		}
		
	}
	public static double[][] RandomArray(int n){
		
	int temp;
	double[][] list = new double [n][n];

		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				temp = Math.abs(rand.nextInt() % 101);
				list[i][j] = temp;
				list[j][i] = temp;
	
				if(i==j)
				{
					list[i][j] = 0;
				}
			}
		}
	
	System.out.println();
	PrintArray(list);
				
		return(list);
	}

}
