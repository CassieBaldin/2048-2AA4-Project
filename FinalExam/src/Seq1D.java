package src;

public class Seq1D
{
    private double[]s;
    private MeanCalculator meanCalculator;

    public Seq1D(double[] x, MeanCalculator m) {
        if (x.length == 0) {
            throw new IllegalArgumentException("Sequence must be greater than zero");
        }
        s = x;
        meanCalculator = m;
    }

    public void setMeanCalculator(MeanCalculator new_m) {
        meanCalculator = new_m;
    }

    public double mean() {
        return meanCalculator.meanCalc(s);
    }
}