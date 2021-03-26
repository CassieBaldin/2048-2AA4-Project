package src;

import java.util.*;

public class CourseT<IndicatorT, AttributeT, Measures, Services, Norm, LOsT>
{
    private String name;
    private HashMap<IndicatorT, Set<LOsT>> m;  ///FIX???///

    public CourseT(String courseName, IndicatorT[] indicators)
    {
        name = courseName;
        for (int i = 0; i < indicators.length; i++)
        {
            m.put(indicators[i]);
        }
    }

    public String getName()
    {
        return name;
    }

    // public IndicatorT[] getIndicators()
    // {
    //     System.out.println(m); //PROBABLY NEED TO CHANGE
    //     return new IndicatorT[]
    // }

    // public LOsT[] getLOs(IndicatorT indicator)
    // {

    // }

    // public void addLO(IndicatorT indicator, LOsT outcome)
    // {

    // }

    // public void delLO(IndicatorT indicator, LOst outcome)
    // {

    // }

    // public boolean member(IndicatorT indicator, LOsT outcomes)
    // {

    // }
}