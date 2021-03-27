package src;

import java.util.*;

public class AttributeT<IndicatorT> 
{
    private String name;
    private IndicatorT[] s;

    public AttributeT(String attribName, IndicatorT[] indicators)
    {
        name = attribName;
        s = indicators;
    }

    public String getName() 
    {
        return name;
    }

    public IndicatorT[] getIndicators() 
    {
        /////FIX/////
        //returns array of all indicators (NO REPEATS)
        Set<IndicatorT> set = new HashSet<IndicatorT>();
        for (int i = 0; i < s.length; i++)
        {
            set.add(s[i]);
        }
        IndicatorT inds[] = new IndicatorT[set.size()];
        int index = 0;
        for (IndicatorT j : set)
        {
            inds[i++] = j;
        }
        return inds;
    }

}
