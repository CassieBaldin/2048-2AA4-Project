/**
 * Author: Cassidy Baldin
 * Revised: March 29th, 2021
 * 
 * Description: CourseT class
 */

package src;

import java.util.*;


/**
* @brief This class represents a course containing indicators that are populated with learning outcomes.
* @details It is assumed that the programmer will not use CourseT until the indicators have been populated
*          with learning outcomes (addLO needs to be called at least once for each indicator in the course).
*/

public class CourseT
{
    private String name;
    private Map<IndicatorT, Set<LOsT>> m = new HashMap<IndicatorT, Set<LOsT>>();

   /**
    * @brief Initializes a CourseT object
    * @param courseName String representing the name of the course
    * @param indicators List of indicators representing the indicators in the course
    */
    public CourseT(String courseName, IndicatorT[] indicators)
    {
        name = courseName;
        for (int i = 0; i < indicators.length; i++)
        {
            IndicatorT ind = indicators[i];
            Set<LOsT> lost = new HashSet<LOsT>();
            m.put(ind, lost);
        }
    }

   /**
    * @brief Gets the name of the course
    * @return The name of the course
    */
    public String getName()
    {
        return name;
    }

   /**
    * @brief Gets the indicators in the course
    * @return The list of all indicators in the course (no repeats)
    */
    public IndicatorT[] getIndicators()
    {
        IndicatorT[] ind = new IndicatorT[m.size()];
        int index = 0;
        for (IndicatorT i : m.keySet())
        {
            ind[index++] = i;
        }
        return ind;
    }

   /**
    * @brief Gets the learning outcomes from the indicator in the course
    * @param indicator The desired indicator in which the learning outcomes in that indicator will be returned
    * @return The list of all learning outcomes in the specified indicator in the course. If the indicator
    *         is not in the course, it returns an empty list. 
    */
    public LOsT[] getLOs(IndicatorT indicator)
    {
        LOsT[] lost = new LOsT[m.size()];
        int index = 0;
        for (IndicatorT i : m.keySet())
        {
            if (i == indicator)
            {
                lost = set_to_seq(m.get(i));
            } 
        }
        return lost;
    }

   /**
    * @brief Adds the learning outcomes to the specified indicator in the course
    * @param indicator The desired indicator in which the learning outcomes in that indicator will be added
    * @param outcome The learning outcome to be added to the indicator in the course
    */
    public void addLO(IndicatorT indicator, LOsT outcome)
    {
        for (IndicatorT i : m.keySet())
        {
            if (i == indicator)
            {
                m.get(i).add(outcome);
            }
        }
    }

   /**
    * @brief Removes the learning outcomes to the specified indicator in the course
    * @param indicator The desired indicator in which the learning outcomes in that indicator will be removed
    * @param outcome The learning outcome to be removed from the indicator in the course
    */
    public void delLO(IndicatorT indicator, LOsT outcome)
    {
        for (IndicatorT i : m.keySet())
        {
            if (i == indicator)
            {
                m.get(i).remove(outcome);
            }
        }
    }

   /**
    * @brief Checks if the indicator and subsequent learning outcomes are in the course
    * @param indicator The desired indicator in which the learning outcomes in that indicator will be checked
    * @param outcome The learning outcomes to be checked in the indicator in the course
    * @return True if all input learning outcomes are in the indicator, else false
    */
    public boolean member(IndicatorT indicator, LOsT[] outcomes)
    {
        int in_set = 0;
        for (IndicatorT i : m.keySet())
        {
            if (i == indicator)
            {
                for (LOsT j : outcomes)
                { 
                    if (m.get(i).contains(j)) {in_set++;} 
                }
            }
        }
        if (in_set ==  getLOs(indicator).length) {return true;}
        return false;
    }

   /**
    * @brief A measure of the learning outcomes in the course
    * @details Throws UnsupportedOperationException as input is of incorrect type
    */
    public double[] measures()
    {
        throw new UnsupportedOperationException("Incorrect input type");
    }

   /**
    * @brief A measure of the learning outcomes in the course at a certain indicator
    * @param ind The indicator in which the learning outcome measures will be summed
    * @return The sum of all learning outcomes in the specified indicator
    */
    public double[] measures(IndicatorT ind) 
    {
        double measureInd[] = {0, 0, 0, 0};
        if (getLOs(ind) == new LOsT[] {}) {return measureInd;}
        for (IndicatorT i : m.keySet())
            {
                if (i == ind)
                {
                    for (LOsT j : m.get(i))
                    {
                        measureInd = sumMeas(measureInd, j.measures());
                    }
                }
            }
        if (Norm.getNInd()) {return Services.normal(measureInd);}
        return measureInd;
    }

   /**
    * @brief A measure of the learning outcomes in the course at a certain indicator
    * @param att Attribute filled with indicators in which all learning outcome measures will be summed
    * @return The sum of all learning outcomes in all indicators in the input attribute
    */
    public double[] measures(AttributeT att) 
    {
        double measureInd[] = {0, 0, 0, 0};
        if (att.getIndicators() == new IndicatorT[] {}) {return measureInd;}

        for (IndicatorT i : att.getIndicators()) 
        {
            measureInd = sumMeas(measureInd, measures(i));
        }

        if (Norm.getNAtt()) {return Services.normal(measureInd);}
        return measureInd;
    }

   /**
    * @brief Turns a set of learning outcomes into a sequence
    * @param s Set of learning outcomes
    * @return A sequence (array) of all learning outcomes in the input set
    */
    private LOsT[] set_to_seq(Set<LOsT> s)
    {
        LOsT lost[] = new LOsT[s.size()];
        int index = 0;
        for (LOsT i : s)
        {
            lost[index++] = i;
        }
        return lost;
    }

   /**
    * @brief Gets the sum of two sequences 
    * @details Assumes input arrays will be of the same length (4)
    * @param seq1 First input sequence to be summed
    * @param seq2 Second input sequence to be summed
    * @return Array of sum of all elements in the two sets
    */
    private double[] sumMeas(double[] seq1, double[] seq2)
    {
        double sum[] = new double[seq1.length];
        for(int i = 0; i < seq1.length; i++)
        {
            sum[i] = seq1[i] + seq2[i];
        }
        return sum;
    }
}