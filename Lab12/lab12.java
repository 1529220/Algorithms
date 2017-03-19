package lab12;

public class lab12 
{
	
	public static void main(String args[])
	{
		for(int i=0;i<1;++i)
		{
			//Reset the fitness count
			OneMaxChrome.ClearFC();
			//The following parameters are not very good!
			//These are the ones you should try and optimise!
			int popsize = 100;
			double mrate = 0.001;
			double crate = 0.75;
			//You will not need to change the following
			SimpleGeneticAlgorithm ga = new SimpleGeneticAlgorithm(popsize,500,10000,mrate,crate);
			//Run the GA for 10,000 function calls
			double f = ga.RunSGA(10000,true).GetFitness(); //Change to true to enable logging and print more data (Iteration number, Generation number, Average fitness, Best fitness)
			System.out.println(f);
		}
	}
	
}