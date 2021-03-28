package src;

import java.util.*;

public class CourseT
{
    private String name;
    private Map<IndicatorT, Set<LOsT>> m = new HashMap<IndicatorT, Set<LOsT>>();

    public CourseT(String courseName, IndicatorT[] indicators)
    {
        name = courseName;
        for (int i = 0; i < indicators.length; i++)
        {
            IndicatorT ind = indicators[i];
            Set<LOsT> lost = new HashSet<LOsT>();
            m.put(ind, lost);
        }
    }

    public String getName()
    {
        return name;
    }

    public IndicatorT[] getIndicators()
    {
        IndicatorT[] ind = new IndicatorT[m.size()];
        int index = 0;
        for (IndicatorT i : m.keySet())
        {
            ind[index++] = i;
        }
        return ind;
    }

    public LOsT[] getLOs(IndicatorT indicator)
    {
        LOsT[] lost = new LOsT[m.size()];
        int index = 0;
        for (IndicatorT i : m.keySet())
        {
            if (i == indicator)
            {
                lost = set_to_seq(m.get(i));
            } 
        }
        return lost;
    }

    public void addLO(IndicatorT indicator, LOsT outcome)
    {
        for (IndicatorT i : m.keySet())
        {
            if (i == indicator)
            {
                m.get(i).add(outcome);
            }
        }
    }

    public void delLO(IndicatorT indicator, LOsT outcome)
    {
        for (IndicatorT i : m.keySet())
        {
            if (i == indicator)
            {
                m.get(i).remove(outcome);
            }
        }
    }

    public boolean member(IndicatorT indicator, LOsT[] outcomes)
    {
        int in_set = 0;
        for (IndicatorT i : m.keySet())
        {
            if (i == indicator)
            {
                for (LOsT j : outcomes)
                { 
                    //if set of LOsT contains the LOsT in outcomes, return true
                    if (m.get(i).contains(j)) {in_set++;} 
                }
            }
        }
        if (in_set == outcomes.length) {return true;}
        return false;
    }

    public double[] measures()
    {
        throw new UnsupportedOperationException();
    }

    public double[] measures(IndicatorT ind) 
    {
        double measureInd[] = {0, 0, 0, 0};
        //add meas and lost(measures) together each loop until a final sum is reached
        for (IndicatorT i : m.keySet())
            {
                if (i == ind)
                {
                    if (getLOs(ind) == null) {return measureInd;} ///DOESNT WORK !!!
                    for (LOsT j : m.get(i))
                    {
                        measureInd = sumMeas(measureInd, j.measures());
                    }
                }
            }
        if (Norm.getNInd()) {return Services.normal(measureInd);}
        return measureInd;
    }

    public double[] measures(AttributeT att) 
    {
        double measureInd[] = {0, 0, 0, 0};
        if (att.getIndicators() == null) {return measureInd;}

        for (IndicatorT i : att.getIndicators()) {measureInd = measures(i);}

        if (Norm.getNAtt()) {return Services.normal(measureInd);}
        return measureInd;
    }

    private LOsT[] set_to_seq(Set<LOsT> s)
    {
        LOsT lost[] = new LOsT[s.size()];
        int index = 0;
        for (LOsT i : s)
        {
            lost[index++] = i;
        }
        return lost;
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