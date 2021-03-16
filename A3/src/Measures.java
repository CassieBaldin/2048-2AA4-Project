package src;

//returns [below expectations, marginal, meets expectations, exceeds expectations]

interface Measures 
{
    public double[] measures() throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException;
    }

    public double[] measures(IndicatorT ind) throws UnsupportedOperationException 
    {
        throw new UnsupportedOperationException;
    }

    public double[] measures(AttributeT att) throws UnsupportedOperationException 
    {
        throw new UnsupportedOperationException;
    }
}