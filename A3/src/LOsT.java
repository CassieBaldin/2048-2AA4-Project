package src;

public class LOsT<IndicatorT, AttributeT, Measures, Services, Norm>
{
    private String name;
    private int n_blw;
    private int n_mrg;
    private int n_mts;
    private int n_exc;

    public LOsT(String topic, int nblw, int nmrg, int nmts, int nexc)
    {
        if (nblw < 0 || nmrg < 0 || nmts < 0 || nexc < 0) 
        {
            throw new IllegalArgumentException("Arguments cannot be negative");
        }
        if (nblw == 0 && nmrg == 0 && nmts == 0 && nexc == 0) 
        {
            throw new IllegalArgumentException("All arguments cannot be zero");
        }   

        name = topic;
        n_blw = nblw;
        n_mrg = nmrg;
        n_mts = nmts;
        n_exc = nexc;
    }

    public String getName()
    {
        return name;
    }

    public boolean equals(LOsT o)
    {
         return name == o.getName();
    }

    public double[] measures()
    {
        /////FIX TO MATCH OUT IN SPEC/////
        double[] measure = {n_blw, n_mrg, n_mts, n_exc};
        return measure;

        // Norm n = new Norm()
        // if (!n.getNLOs())
        // {
        //     return measure;
        // }
        // else
        // {
        //     return (Services.normal(measure))
        // }
    }

    /////FIX/////
    public double[] measures(IndicatorT ind) 
    {
        throw new UnsupportedOperationException();
    }

    /////FIX/////
    // public double[] measures(AttributeT att) 
    // {
    //     throw new UnsupportedOperationException();
    // }
}
