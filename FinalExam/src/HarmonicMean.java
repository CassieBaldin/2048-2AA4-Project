package src;

public class HarmonicMean extends MeanCalculator
{
    public static double meanCalc(double[] v) {
        double hmean = 0;
        double recip = 0;

        for (double x : v) {
            recip = recip + 1/x;
        }

        hmean = v.length/recip;
        return hmean;
    }
}