package src;

public class Score
{
    private static int score;

    public static void set_score(int s)
    {
        score = s;
    }

    public static int get_score()
    {
    	return score;
    }

    public static void reset_score()
    {
    	score = 0;
    }
}
