
public class ModelRun {
	//using Euler's method
	public static void main(String[] args) {
		SIREuler(707, 1, 0, 0.001045446, 0.0588, 48, 24);
		SISEuler(707, 1, 0.001045446, 0.0588, 48*4, 24*4);
	}
	public static void SIREuler(double initialS, double initialI, double initialR,
			double infRate, double recRate, int iterations, double finalT) {
		double deltaT = finalT / (double) iterations;
		double s = initialS;
		double i = initialI;
		double r = initialR;
		double tempS, tempI, tempR;
		System.out.println("t\tS\tI\tR\t");
		System.out.printf("0\t" + initialS + "\t" + initialI + "\t" + initialR + "\n");
		//the loop
		for (int j = 0; j < iterations; j++) {
			tempS = s + ((-infRate * s * i) * deltaT);
			tempI = i + (((infRate * s * i) - (recRate * i)) * deltaT);
			tempR = r + (recRate * i * deltaT);
			System.out.printf("%5.3f", deltaT * (j + 1));
			System.out.print("\t");
			System.out.printf("%5.3f", tempS);
			System.out.print("\t");		
			System.out.printf("%5.3f", tempI);
			System.out.print("\t");		
			System.out.printf("%5.3f", tempR);
			s = tempS; 
			i = tempI;
			r = tempR;
			System.out.println();
		}
	}
	public static void SISEuler(double initialS, double initialI,
			double infRate, double recRate, int iterations, double finalT) {
		double deltaT = finalT / (double) iterations;
		double s = initialS;
		double i = initialI;
		double tempS, tempI;
		System.out.println("t\tS\tI\t");
		System.out.printf("0\t" + initialS + "\t" + initialI + "\n");
		//the loop
		for (int j = 0; j < iterations; j++) {
			tempS = s + (((-infRate * s * i) + (recRate * i)) * deltaT);
			tempI = i + (((infRate * s * i) - (recRate * i)) * deltaT);
			System.out.printf("%.3f", deltaT * (j + 1));
			System.out.print("\t");
			System.out.printf("%.3f", tempS);
			System.out.print("\t");		
			System.out.printf("%.3f", tempI);
			s = tempS; 
			i = tempI;
			System.out.println();
		}
	}
}
