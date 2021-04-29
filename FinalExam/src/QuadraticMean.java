package src;
import java.util.*;

public class QuadraticMean extends MeanCalculator
{
    public static double meanCalc(double[] v) {
        double qmean = 0;
        double quad = 0;

        for (double x : v) {
            quad = quad + x*x;
        }

        qmean = Math.sqrt(quad/v.length);
        return qmean;
    }
}