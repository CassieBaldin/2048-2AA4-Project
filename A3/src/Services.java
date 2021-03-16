package src;

public static Services
{
	public double[] normal(double[] v)
	{
		double[] n = [v.length]
		for (double i : v) 
		{
			n[i] = i/sum(v);
		}
		return n;
	}
}

public double sum(double[] x)
{
	total = 0;
	for (double i : x)
	{
		total = total + i;
	}
	return total;
}
