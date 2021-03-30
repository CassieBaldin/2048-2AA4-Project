/**
 * Author: Cassidy Baldin
 * Revised: March 29, 2021
 * 
 * Description: Testing module for ProgramT class methods
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class TestProgramT
{
    private IndicatorT[] Ind1 = new IndicatorT[] {IndicatorT.math, IndicatorT.specEngKnow};
    private IndicatorT[] Ind2 = new IndicatorT[] {IndicatorT.desPrinciples};
    private IndicatorT[] Multi = new IndicatorT[] {IndicatorT.desProcess, IndicatorT.desPrinciples,
                                                   IndicatorT.openEnded, IndicatorT.ideaGeneration,
                                                   IndicatorT.openEnded, IndicatorT.desProcess};

    private CourseT Test1 = new CourseT("Test1", Ind1);
    private CourseT Test2 = new CourseT("Test2", Ind2);
    private CourseT Space = new CourseT(" ", Multi);

    private ProgramT T1 = new ProgramT();

    @Before
    public void setUp()
    {
        T1.add(Test1);
        T1.add(Test2);
        T1.add(Space);
    }

    @After
    public void tearDown()
    {
        ProgramT T1 = null;
    }
	
	@Test(expected = UnsupportedOperationException.class)
    public void test_meas()
    {
        T1.measures();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_meas_ind()
    {
        T1.measures(IndicatorT.math);
    }

    @Test
    public void test1_meas_att()
    {
        Norm.setNLOs(false);
        Norm.setNAtt(false);
        LOsT L1 = new LOsT("Recog and follow eng des process", 1, 2, 3, 4);
        LOsT L2 = new LOsT("topic 1", 4, 3, 2, 1);
        Test1.addLO(IndicatorT.math, L1);
        Test1.addLO(IndicatorT.math, L2);
        AttributeT att = new AttributeT("Att", Ind1);
        double meas[] = new double[] {0, 0.05, 0.1, 0.15};
        assertTrue(Arrays.equals(T1.measures(att), meas));
    }

    @Test
    public void test2_meas_att()
    {
        Norm.setNLOs(false);
        Norm.setNAtt(false);
        LOsT L1 = new LOsT("Recog and follow eng des process", 10, 20, 30, 40);
        LOsT L2 = new LOsT("topic 1", 40, 30, 20, 10);
        Test1.addLO(IndicatorT.math, L1);
        Test1.addLO(IndicatorT.math, L2);
        AttributeT att = new AttributeT("Att", Ind1);
        double meas[] = new double[] {0, 0.005, 0.01, 0.015};
        assertTrue(Arrays.equals(T1.measures(att), meas));
    }
}
