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
    	//NEED TO ADD EXCEPTION HERE

        name = topic;
        n_blw = nblw;
        n_mrg = nmrg;
        n_mts = nmts;
        n_exc = nexc;
    }

    public static String getName()
    {
    	return this.name;
    }

    public static boolean equals(LOsT o)
    {
    	return this.name == o.getName();
    }
}
