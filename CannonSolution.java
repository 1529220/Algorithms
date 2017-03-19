package lab10;

import java.util.ArrayList;

public class CannonSolution {
	
	
		//Representation
	private double angle;
	private double velocity;	
		//Creates a new scales solution based on a string parameter
		//The string parameter is checked to see if it contains all zeros and ones
		//Otherwise the random binary string generator is used (n = length of parameter)

		public CannonSolution(double a, double v){
			angle = a;
			velocity = v;
		}
	
		public CannonSolution(){
			
			angle = CS2004.UR(25,55);
			velocity = CS2004.UR(1500,1650);
		}
		
		double GetAngle()
		{
			return(angle);
		}
		
		double GetVelocity()
		{
			return(velocity);
		}
		
		public double CannonFitness()
		{
			
			//double theta = angle;
			//double vzero = velocity;
			//System.out.println("Angle " + GetAngle());
			//System.out.println("Velocity " + GetVelocity());
			double fitness = Cannon.GetMaxRange(angle,velocity);
				
			//System.out.println("1: "+fitness);
			
			return fitness;
			
		}
		public static double TargetCannonFitness(int TargetRange, double theta, double vzero)
		{			
			double range = Cannon.GetMaxRange(theta, vzero);
			double fitness = Math.abs(range-TargetRange);
			
			return fitness;
		}

}
