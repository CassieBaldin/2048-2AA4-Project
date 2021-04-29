package src;
import java.util.*;

public class HarmonicMean implements MeanCalculator
{
    public Double meanCalc(ArrayList<Double> v) {
        double hmean = 0;
        double recip = 0;

        for (double x : v) {
            recip = recip + 1/x;
        }

        hmean = v.size()/recip;
        return hmean;
    }
}