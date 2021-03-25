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
        return this.name;
    }

    public IndicatorT[] getIndicators() 
    {
        //returns list of all indicators 
        return this.s;
    }
}
