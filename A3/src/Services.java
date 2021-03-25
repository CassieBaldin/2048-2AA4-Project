package src;

public class Services
{
    public static double[] normal(double[] v)
    {
        double[] n = new double[v.length];
        for (int i = 0; i < v.length; i++) 
        {
            n[i] = i/sum(v);
        }
        return n;
    }

    private static double sum(double[] x)
    {
        double total = 0;
        for (double i : x)
        {
            total = total + i;
        }
        return total;
    }
}
