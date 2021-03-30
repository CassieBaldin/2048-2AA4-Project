package src;

import java.util.*;

public class ProgramT extends HashSet<CourseT>
{
    public double[] measures() 
    {
        throw new UnsupportedOperationException("Incorrect input type"); 
    }

    public double[] measures(IndicatorT ind) 
    {
        throw new UnsupportedOperationException("Incorrect input type");
    }

    public double[] measures(AttributeT att) 
    {
        double n[] = {0, 0, 0, 0};
        for (CourseT c : this)
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
