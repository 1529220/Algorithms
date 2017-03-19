package lab10;


import java.util.ArrayList;
import java.util.Arrays;


public class lab10 {
		
	public static void main(String[] args){
		//ex1();
		//ex2();//MAXIMUM & MINIMUM - type TRUE to find MAX, FALSE to find MIN
		//ex3();// TARGETRANGE
		
	
	}
	
	public static void ex1(){


		double r = Cannon.GetMaxRange(40.0,1575.0);
		System.out.println(r);
		ArrayList<Double> xt = Cannon.GetX();
		ArrayList<Double> yt = Cannon.GetY();
		System.out.println(xt.size());
		System.out.println(yt.size());

	}
	
	public static void ex2(){
		int n = 10000;
		double newangle=0;
		double newvelocity =0;
		boolean max = true;
		
			
			CannonSolution sol = new CannonSolution();
			
			double oldsol = sol.CannonFitness();
			double oldangle= sol.GetAngle();
			double oldvelocity= sol.GetVelocity();
			System.out.println("Original");
			System.out.println("Angle " + oldangle);
			System.out.println("Velocity "+ oldvelocity);
			System.out.println("Solution "+ oldsol);
			//random change
			for(int i=0 ; i<n ; i++ ){
				
				int rand = CS2004.UI(0,1);
				 //change angle
				if(rand==0){
					boolean b = true;
					newvelocity = change(oldvelocity, b);
					
				}
				else{
					boolean b = false;
					newangle= change(oldangle, b);
					
					}
				
				CannonSolution sol2 = new CannonSolution(newangle, newvelocity);
				double newsol = sol2.CannonFitness();
				
				
				if(max){
				//maximum			
					if (oldsol<newsol){
								oldsol = newsol;
								oldangle= newangle;
								oldvelocity = newvelocity;
					}
				}else//minimum
				{
					if (oldsol>newsol){
						oldsol = newsol;
						oldangle= newangle;
						oldvelocity = newvelocity;
					}
					
				}
			
		}
			System.out.println("Final!! ");
		System.out.println("Angle " + oldangle);
		System.out.println("Velocity "+ oldvelocity);
		System.out.println("Solution "+ oldsol);
		ArrayList<Double> xt = Cannon.GetX();
		ArrayList<Double> yt = Cannon.GetY();
		System.out.println(xt.size());
		System.out.println(yt.size());
	}	
	public static void ex3(){
		int n = 12000;
		double newangle=0;
		double newvelocity =0;
		//int TargetRange = 75000;
	//	int TargetRange = 65000;
		int TargetRange = 95000;
		
		
		
		System.out.println("Target to hit is " + TargetRange + " metres away");
			CannonSolution sol = new CannonSolution();
			double oldangle= sol.GetAngle();
			double oldvelocity= sol.GetVelocity();
			double oldsol = CannonSolution.TargetCannonFitness(TargetRange, oldangle, oldvelocity);
			
			System.out.println("ORIGINAL");
			System.out.println("Angle " + oldangle);
			System.out.println("Velocity "+ oldvelocity);
			System.out.println("RANGE "+ oldsol);
			//random change
			for(int i=0 ; i<n ; i++ ){
				
				int rand = CS2004.UI(0,1);
				 //change angle
				if(rand==0){
					boolean b = true;
					newvelocity = change(oldvelocity, b);
					
				}
				else{
					boolean b = false;
					newangle= change(oldangle, b);
					
					}
				
				CannonSolution sol2 = new CannonSolution(newangle, newvelocity);
				double newsol = CannonSolution.TargetCannonFitness(TargetRange, newangle, newvelocity);
				//double newsol = sol2.CannonFitness();
				
				//maximum			
				if (newsol<oldsol){
					if(newsol<=TargetRange){
						oldsol = newsol;
						oldangle= newangle;
						oldvelocity = newvelocity;
					}
				}
			}
			System.out.println("FINAL ");
		System.out.println("Angle " + oldangle);
		System.out.println("Velocity "+ oldvelocity);
		System.out.println("RANGE "+ oldsol);
		ArrayList<Double> xt = Cannon.GetX();
		ArrayList<Double> yt = Cannon.GetY();
		System.out.println(xt.size());
		System.out.println(yt.size());
	}	

	public static double checkBoundriesAngle(double tempA){
		
		if (tempA < 25){ tempA = 25.0;}
		if (tempA > 55){tempA = 55.0;}
		
		
		
		return tempA;
	}
	public static double checkBoundriesVelocity(double tempV){
	
		if (tempV < 1500){tempV = 1500.0;}
		if (tempV > 1650){ tempV = 1650.0;}
		
		return tempV;
	}
	
	public static double change(double val, boolean b){
		
		double x = 1;
		if(b){
			//System.out.println("xxxxxxx");
		int velocityChange = CS2004.UI(0,1);
		
					if(velocityChange==0){
						val=val+((1650-1500)*x)/1000D;
						val = checkBoundriesVelocity(val);}
					else {
						val=val-((1650-1500)*x)/1000D;
						val = checkBoundriesVelocity(val);}
		}else{
		//change velocity
			
			int angleChange = CS2004.UI(0,1);
						
						if(angleChange==0){
							val=val + ((55-25)*x/1000D);
							val = checkBoundriesAngle(val);
						}
						else {
							val =val - ((55-25)*x/1000D);
							val = checkBoundriesAngle(val);}
								
		}
	return val;
	}
}
