package src;
import java.util.*;

public class Seq1D
{
    private ArrayList<Double> s;
    private MeanCalculator meanCalculator;

    public Seq1D(ArrayList<Double> x, MeanCalculator m) {
        if (x.size() == 0) {
            throw new IllegalArgumentException("Sequence must be greater than zero");
        }
        s = x;
        meanCalculator = m;
    }

    public void setMeanCalculator(MeanCalculator new_m) {
        meanCalculator = new_m;
    }

    public Double mean() {
        return meanCalculator.meanCalc(s);
    }
}