package src;
import java.util.*;

public class MeanCalculator
{
    public static Double meanCalc(ArrayList<Double> seq) {
    	double mean = 0;

    	for (double i : seq) {
            mean = mean + i;
        }
        mean = mean/seq.size();
    	return mean;
    }
}
