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

    @Test
    public void test1_add_getLOs()
    {
        LOsT L1 = new LOsT("Recog and follow eng des process", 5, 16, 90, 60);
        Test1.addLO(IndicatorT.math, L1);
        LOsT lost[] = new LOsT[] {L1};
        HashSet<LOsT> set1 = new HashSet<LOsT>(Arrays.asList(lost));
        HashSet<LOsT> set2 = new HashSet<LOsT>(Arrays.asList(Test1.getLOs(IndicatorT.math)));
        assertTrue(set1.equals(set2));
    }

    @Test
    public void test2_addmore_getLOs()
    {
        LOsT L1 = new LOsT("Recog and follow eng des process", 5, 16, 90, 60);
        LOsT L2 = new LOsT("topic 1", 23, 45, 56, 89);
        LOsT L3 = new LOsT("topic 2", 15, 6, 78, 4);
        Test1.addLO(IndicatorT.math, L1);
        Test1.addLO(IndicatorT.math, L2);
        Test1.addLO(IndicatorT.math, L3);
        LOsT lost[] = new LOsT[] {L1, L2, L3};
        HashSet<LOsT> set1 = new HashSet<LOsT>(Arrays.asList(lost));
        HashSet<LOsT> set2 = new HashSet<LOsT>(Arrays.asList(Test1.getLOs(IndicatorT.math)));
        assertTrue(set1.equals(set2));
    }

    @Test
    public void test3_add_not_in_ind_getLOs()
    {
        LOsT L1 = new LOsT("Recog and follow eng des process", 5, 16, 90, 60);
        LOsT L2 = new LOsT("topic 1", 23, 45, 56, 89);
        Test1.addLO(IndicatorT.specEngKnow, L1);
        Test1.addLO(IndicatorT.assumpt, L2);
        LOsT lost[] = new LOsT[] {};
        HashSet<LOsT> set1 = new HashSet<LOsT>(Arrays.asList(lost));
        HashSet<LOsT> set2 = new HashSet<LOsT>(Arrays.asList(Test1.getLOs(IndicatorT.math)));
        assertTrue(set1.equals(set2));
    }

    @Test
    public void test4_add_same_ind_getLOs()
    {
        LOsT L1 = new LOsT("Recog and follow eng des process", 5, 16, 90, 60);
        LOsT L2 = new LOsT("topic 1", 23, 45, 56, 89);
        Test1.addLO(IndicatorT.math, L1);
        Test1.addLO(IndicatorT.math, L2);
        Test1.addLO(IndicatorT.math, L1);
        LOsT lost[] = new LOsT[] {L1, L2};
        HashSet<LOsT> set1 = new HashSet<LOsT>(Arrays.asList(lost));
        HashSet<LOsT> set2 = new HashSet<LOsT>(Arrays.asList(Test1.getLOs(IndicatorT.math)));
        assertTrue(set1.equals(set2));
    }

    @Test
    public void test5_del_getLOs()
    {
        LOsT L1 = new LOsT("Recog and follow eng des process", 5, 16, 90, 60);
        LOsT L2 = new LOsT("topic 1", 23, 45, 56, 89);
        LOsT L3 = new LOsT("topic 2", 15, 6, 78, 4);
        Test1.addLO(IndicatorT.math, L1);
        Test1.addLO(IndicatorT.math, L2);
        Test1.addLO(IndicatorT.math, L3);
        Test1.delLO(IndicatorT.math, L2);
        LOsT lost[] = new LOsT[] {L1, L3};
        HashSet<LOsT> set1 = new HashSet<LOsT>(Arrays.asList(lost));
        HashSet<LOsT> set2 = new HashSet<LOsT>(Arrays.asList(Test1.getLOs(IndicatorT.math)));
        assertTrue(set1.equals(set2));
    }

    @Test
    public void test6_del_all_getLOs()
    {
        LOsT L1 = new LOsT("Recog and follow eng des process", 5, 16, 90, 60);
        LOsT L2 = new LOsT("topic 1", 23, 45, 56, 89);
        LOsT L3 = new LOsT("topic 2", 15, 6, 78, 4);
        Test1.addLO(IndicatorT.math, L1);
        Test1.addLO(IndicatorT.math, L2);
        Test1.addLO(IndicatorT.math, L3);
        Test1.delLO(IndicatorT.math, L1);
        Test1.delLO(IndicatorT.math, L2);
        Test1.delLO(IndicatorT.math, L3);
        LOsT lost[] = new LOsT[] {};
        HashSet<LOsT> set1 = new HashSet<LOsT>(Arrays.asList(lost));
        HashSet<LOsT> set2 = new HashSet<LOsT>(Arrays.asList(Test1.getLOs(IndicatorT.math)));
        assertTrue(set1.equals(set2));
    }

    @Test
    public void test7_del_same_getLOs()
    {
        LOsT L1 = new LOsT("Recog and follow eng des process", 5, 16, 90, 60);
        LOsT L2 = new LOsT("topic 1", 23, 45, 56, 89);
        LOsT L3 = new LOsT("topic 2", 15, 6, 78, 4);
        Test1.addLO(IndicatorT.math, L1);
        Test1.addLO(IndicatorT.math, L2);
        Test1.addLO(IndicatorT.math, L3);
        Test1.delLO(IndicatorT.math, L1);
        Test1.delLO(IndicatorT.math, L1);        
        LOsT lost[] = new LOsT[] {L2, L3};
        HashSet<LOsT> set1 = new HashSet<LOsT>(Arrays.asList(lost));
        HashSet<LOsT> set2 = new HashSet<LOsT>(Arrays.asList(Test1.getLOs(IndicatorT.math)));
        assertTrue(set1.equals(set2));
    }

    @Test
    public void test8_del_not_in_set_getLOs()
    {
        LOsT L1 = new LOsT("Recog and follow eng des process", 5, 16, 90, 60);
        LOsT L2 = new LOsT("topic 1", 23, 45, 56, 89);
        LOsT L3 = new LOsT("topic 2", 15, 6, 78, 4);
        Test1.addLO(IndicatorT.math, L1);
        Test1.addLO(IndicatorT.math, L2);
        Test1.addLO(IndicatorT.math, L3);
        Test1.delLO(IndicatorT.assumpt, L1);
        Test1.delLO(IndicatorT.desProcess, L2);
        Test1.delLO(IndicatorT.specEngKnow, L3);
        LOsT lost[] = new LOsT[] {L1, L2, L3};
        HashSet<LOsT> set1 = new HashSet<LOsT>(Arrays.asList(lost));
        HashSet<LOsT> set2 = new HashSet<LOsT>(Arrays.asList(Test1.getLOs(IndicatorT.math)));
        assertTrue(set1.equals(set2));
    }

    @Test
    public void test9_add_del_add_again_getLOs()
    {
        LOsT L1 = new LOsT("Recog and follow eng des process", 5, 16, 90, 60);
        Test1.addLO(IndicatorT.math, L1);
        Test1.delLO(IndicatorT.math, L1);
        Test1.addLO(IndicatorT.math, L1);
        LOsT lost[] = new LOsT[] {L1};
        HashSet<LOsT> set1 = new HashSet<LOsT>(Arrays.asList(lost));
        HashSet<LOsT> set2 = new HashSet<LOsT>(Arrays.asList(Test1.getLOs(IndicatorT.math)));
        assertTrue(set1.equals(set2));
    }

    @Test
    public void test10_member_getLOs()
    {
        LOsT L1 = new LOsT("Recog and follow eng des process", 5, 16, 90, 60);
        LOsT L2 = new LOsT("topic 1", 23, 45, 56, 89);
        LOsT L3 = new LOsT("topic 2", 15, 6, 78, 4);
        Test1.addLO(IndicatorT.math, L1);
        Test1.addLO(IndicatorT.math, L2);
        Test1.addLO(IndicatorT.math, L3);
        //This should be FALSE, TRUE == {L1, L2, L3}
        assertTrue(!Test1.member(IndicatorT.math, new LOsT[] {L1, L2}));
    }

    @Test
    public void test11_member_getLOs()
    {
        LOsT L1 = new LOsT("Recog and follow eng des process", 5, 16, 90, 60);
        LOsT L2 = new LOsT("topic 1", 23, 45, 56, 89);
        LOsT L3 = new LOsT("topic 2", 15, 6, 78, 4);
        Test1.addLO(IndicatorT.math, L1);
        Test1.addLO(IndicatorT.math, L2);
        Test1.addLO(IndicatorT.math, L3);
        assertTrue(Test1.member(IndicatorT.math, new LOsT[] {L1, L2, L3}));
    }

    @Test
    public void test12_not_member_getLOs()
    {
        LOsT L1 = new LOsT("Recog and follow eng des process", 5, 16, 90, 60);
        LOsT L2 = new LOsT("topic 1", 23, 45, 56, 89);
        Test1.addLO(IndicatorT.math, L1);
        Test1.addLO(IndicatorT.specEngKnow, L2);
        assertTrue(!Test1.member(IndicatorT.specEngKnow, new LOsT[] {L1}) && Test1.member(IndicatorT.specEngKnow, new LOsT[] {L2}));
    }

    @Test
    public void test13_ind_not_in_course_getLOs()
    {
        LOsT L1 = new LOsT("Recog and follow eng des process", 5, 16, 90, 60);
        LOsT L2 = new LOsT("topic 1", 23, 45, 56, 89);
        Test1.addLO(IndicatorT.assumpt, L1);
        Test1.addLO(IndicatorT.assumpt, L2);
        assertTrue(!Test1.member(IndicatorT.assumpt, new LOsT[] {L1, L2}));
    }

    @Test
    public void test14_member_add_del_add_getLOs()
    {
        LOsT L1 = new LOsT("Recog and follow eng des process", 5, 16, 90, 60);
        Test1.addLO(IndicatorT.math, L1);
        Test1.delLO(IndicatorT.math, L1);
        Test1.addLO(IndicatorT.math, L1);
        assertTrue(Test1.member(IndicatorT.math, new LOsT[] {L1}));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_meas()
    {
        Test1.measures();
    }

    @Test
    public void test_meas_ind()
    {
        Norm.setNLOs(false);
        LOsT L1 = new LOsT("Recog and follow eng des process", 1, 2, 3, 4);
        LOsT L2 = new LOsT("topic 1", 4, 3, 2, 1);
        LOsT L3 = new LOsT("topic 2", 10, 1, 14, 100);
        Test1.addLO(IndicatorT.math, L1);
        Test1.addLO(IndicatorT.math, L2);
        Test1.addLO(IndicatorT.math, L3);
        double meas[] = new double[] {15, 6, 19, 105};
        assertTrue(Arrays.equals(Test1.measures(IndicatorT.math), meas));
    }

    @Test
    public void test_meas_norm_ind()
    {
        Norm.setNLOs(true);
        LOsT L1 = new LOsT("Recog and follow eng des process", 1, 2, 3, 4);
        LOsT L2 = new LOsT("topic 1", 4, 3, 2, 1);
        LOsT L3 = new LOsT("topic 2", 10, 10, 10, 10);
        Test1.addLO(IndicatorT.math, L1);
        Test1.addLO(IndicatorT.math, L2);
        Test1.addLO(IndicatorT.math, L3);
        //used simple numbers to reduce floating point errors in testing
        double meas[] = new double[] {0, 0.225, 0.45, 0.675};
        assertTrue(Arrays.equals(Test1.measures(IndicatorT.math), meas));
    }

    @Test
    public void test_meas_att()
    {
        Norm.setNLOs(false);
        Norm.setNAtt(false);
        LOsT L1 = new LOsT("Recog and follow eng des process", 1, 2, 3, 4);
        LOsT L2 = new LOsT("topic 1", 4, 3, 2, 1);
        LOsT L3 = new LOsT("topic 2", 10, 10, 10, 10);
        Test1.addLO(IndicatorT.math, L1);
        Test1.addLO(IndicatorT.math, L2);
        Test1.addLO(IndicatorT.math, L3);
        AttributeT att = new AttributeT("Att", Ind1);
        double meas[] = new double[] {15, 15, 15, 15};
        System.out.println(Arrays.toString(Test1.measures(att)));
        assertTrue(Arrays.equals(Test1.measures(att), meas));
    }

    @Test
    public void test_meas_norm_att()
    {
        Norm.setNLOs(true);
        Norm.setNAtt(true);
        LOsT L1 = new LOsT("Recog and follow eng des process", 30, 30, 30, 30);
        LOsT L2 = new LOsT("topic 1", 30, 30, 30, 30);
        Test1.addLO(IndicatorT.math, L1);
        Test1.addLO(IndicatorT.math, L2);
        AttributeT att = new AttributeT("Att", Ind1);
        double meas[] = new double[] {0, 1, 2, 3};
        assertTrue(!Arrays.equals(Test1.measures(IndicatorT.math), meas));
    }

}
