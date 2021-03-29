/**
 * Author: Cassidy Baldin
 * Revised: March 29th, 2021
 * 
 * Description: Testing module for CourseT class methods
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class TestCourseT
{
    private IndicatorT[] Ind1 = new IndicatorT[] {IndicatorT.math, IndicatorT.specEngKnow};
    private IndicatorT[] Ind2 = new IndicatorT[] {IndicatorT.desPrinciples};
    private IndicatorT[] Multi = new IndicatorT[] {IndicatorT.desProcess, IndicatorT.desPrinciples,
                                                   IndicatorT.openEnded, IndicatorT.ideaGeneration,
                                                   IndicatorT.openEnded, IndicatorT.desProcess};
    private IndicatorT[] NoInd = new IndicatorT[] {};

    private CourseT Test1;
    private CourseT Test2;
    private CourseT Space;
    private CourseT EmptyName;

    @Before
    public void setUp()
    {
        Test1 = new CourseT("Test1", Ind1);
        Test2 = new CourseT("Test2", Ind2);
        Space = new CourseT(" ", Multi);
        EmptyName = new CourseT("", NoInd);
    }

    @After
    public void tearDown()
    {
        CourseT Test1 = null;
        CourseT Test2 = null;
        CourseT Space = null;
        CourseT EmptyName = null;
    }

    @Test
    public void test1_name()
    {
        assertTrue(Test1.getName() == "Test1");
    }

    @Test
    public void test2_name()
    {
        assertTrue(Test2.getName() == "Test2");
    }

    @Test
    public void test_message_to_marker()
    {
        assertTrue(!(Test2.getName() == "I hope you have a nice day! :)"));
    }

    @Test
    public void test_space_name()
    {
        assertTrue(Space.getName() == " ");
    }

    @Test
    public void test_emptyName_name()
    {
        assertTrue(EmptyName.getName() == "");
    }

    @Test
    public void test1_inds()
    {
        IndicatorT inds[] = new IndicatorT[] {IndicatorT.math, IndicatorT.specEngKnow};
        HashSet<IndicatorT> set1 = new HashSet<IndicatorT>(Arrays.asList(inds));
        HashSet<IndicatorT> set2 = new HashSet<IndicatorT>(Arrays.asList(Test1.getIndicators()));
        assertTrue(set1.equals(set2));
    }

    @Test
    public void test2_inds()
    {
        //only one input so do not need a hashset to check order
        IndicatorT inds[] = new IndicatorT[] {IndicatorT.desPrinciples};
        assertTrue(Arrays.equals(Test2.getIndicators(), inds));
    }

    @Test
    public void test_mult_inds()
    {
        IndicatorT inds[] = new IndicatorT[] {IndicatorT.desProcess, IndicatorT.desPrinciples,
                                              IndicatorT.openEnded, IndicatorT.ideaGeneration,
                                              IndicatorT.openEnded, IndicatorT.desProcess};
        HashSet<IndicatorT> set1 = new HashSet<IndicatorT>(Arrays.asList(inds));
        HashSet<IndicatorT> set2 = new HashSet<IndicatorT>(Arrays.asList(Space.getIndicators()));
        assertTrue(set1.equals(set2));
    }

    @Test
    public void test_no_ind()
    {
        IndicatorT inds[] = new IndicatorT[] {};
        HashSet<IndicatorT> set1 = new HashSet<IndicatorT>(Arrays.asList(inds));
        HashSet<IndicatorT> set2 = new HashSet<IndicatorT>(Arrays.asList(EmptyName.getIndicators()));
        assertTrue(set1.equals(set2));
    }

    @Test
    public void test_not_ind()
    {
        IndicatorT inds[] = new IndicatorT[] {IndicatorT.assumpt, IndicatorT.math};
        assertTrue(!Arrays.equals(Test2.getIndicators(), inds));
    }
}
