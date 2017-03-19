package lab6;

import java.util.ArrayList;

public class lab6 
{
	public static void main(String[] args){
	
	ArrayList<Integer> res = new ArrayList<Integer>();
	//for(int i=0;i<10;i++)
	
	{
	ArrayList<Integer>list = new ArrayList<Integer>();
	ThreeSorts a = new ThreeSorts();
	
	
	list=a.RandomArray(25000);//create random array
	
	//System.out.println("SortA method");
	long timeA = System.nanoTime();
	res = ThreeSorts.SortA(list);
	//ThreeSorts.ShowArray(res);
	System.out.println((System.nanoTime()-timeA));
	//System.out.println("---------");
	//System.out.println();
	
	//System.out.println("SortB method");
	long timeB = System.nanoTime();
	res = ThreeSorts.SortB(list);
	//ThreeSorts.ShowArray(res);
	System.out.println((System.nanoTime()-timeB));
	//System.out.println("---------");
	
	//System.out.println();
	
	//System.out.println("SortC method");
	long timeC = System.nanoTime();
	res = ThreeSorts.SortC(list);
	//ThreeSorts.ShowArray(res);
	System.out.println((System.nanoTime()-timeC));
	//System.out.println("---------");
	
	System.out.println();
	}
	}

	
	
}
