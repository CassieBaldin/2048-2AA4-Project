package src;

import java.util.*;

public class ProgramT extends HashSet<CourseT> //implements Measures??
{
    private Set<CourseT> s = new HashSet<CourseT>();

    public double[] measures() 
    {
        throw new UnsupportedOperationException(); 
    }

    public double[] measures(IndicatorT ind) 
    {
        throw new UnsupportedOperationException();
    }

    public double[] measures(Attribute att) 
    {
        double n[] = {0, 0, 0, 0};
        for (CourseT c : s)
        {
            n = sumMeas(n, c.measures(att));
        }
        return Services.normal(n);
    }

    private double[] sumMeas(double[] seq1, double[] seq2)
    {
        //assume the sequences are the same length (4)
        double sum[] = new double[seq1.length];
        for(int i = 0; i < seq1.length; i++)
        {
            sum[i] = seq1[i] + seq2[i];
        }
        return sum;
    }
}
