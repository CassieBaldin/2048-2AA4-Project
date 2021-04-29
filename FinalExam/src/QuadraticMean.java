package src;
import java.util.*;

public class QuadraticMean extends MeanCalculator
{
    public static Double meanCalc(ArrayList<Double> v) {
        double qmean = 0;
        double quad = 0;

        for (double x : v) {
            quad = quad + x*x;
        }

        qmean = Math.sqrt(quad/v.size());
        return qmean;
    }
}