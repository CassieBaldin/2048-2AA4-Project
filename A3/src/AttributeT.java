package src;

import java.util.*;

public class AttributeT 
{
    private String name;
    private T[] s;

    public AttributeT(String attribName, T[] indicators)
    {
        name = attribName;
        s = indicators;
    }


    public String getName() 
    {
        return name;
    }

    public T[] getIndicators() 
    {
        //returns list of all indicators 
        return indicators;
    }

}



