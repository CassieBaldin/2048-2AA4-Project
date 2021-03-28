package src;

import java.util.*;

public class CourseT
{
    private String name;
    private Map<IndicatorT, Set<LOsT>> m = new HashMap<IndicatorT, Set<LOsT>>();  ///FIX???///

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
        boolean match = false;
        for (IndicatorT i : m.keySet())
        {
            if (i == indicator)
            {
                match = true;
                lost = set_to_seq(m.get(i));
            } 
        }
        if (!match) {return lost;}
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

    public boolean member(IndicatorT indicator, LOsT outcomes)
    {
        for (IndicatorT i : m.keySet())
        {
            if (i == indicator)
            {
                for (LOsT j : m.get(i))
                { if (j == outcomes) {return true;} }
            }
        }
        return false;
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
}