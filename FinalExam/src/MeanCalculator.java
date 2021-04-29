package src;

public class MeanCalculator
{
    public static double meanCalc(double[] seq) {
    	double mean = 0;

    	for (double i : seq) {
            mean = mean + i;
        }
        mean = mean/seq.length;
    	return mean;
    }
}
