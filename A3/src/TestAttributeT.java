/**
 * Author: Cassidy Baldin
 * Revised: March 29th, 2021
 * 
 * Description: Testing module for AttributeT class methods
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;


public class TestAttributeT
{
    private AttributeT Test1;
    private AttributeT Test2;
    private AttributeT Space;
    private AttributeT EmptyName;
    private AttributeT MultipleInd;
    private AttributeT NoInd;

    @Before
    public void setUp()
    {
        Test1 = new AttributeT("Test1", new IndicatorT[] {IndicatorT.math, IndicatorT.specEngKnow});
        Test2 = new AttributeT("Test2", new IndicatorT[] {IndicatorT.assumpt});
        Space = new AttributeT(" ", new IndicatorT[] {IndicatorT.math, IndicatorT.openEnded});
        EmptyName = new AttributeT("", new IndicatorT[] {IndicatorT.math, IndicatorT.specEngKnow});
        MultipleInd = new AttributeT("MultipleInd", new IndicatorT[] {IndicatorT.desProcess, IndicatorT.desPrinciples,
                                                                     IndicatorT.openEnded, IndicatorT.ideaGeneration,
                                                                     IndicatorT.openEnded, IndicatorT.desProcess});
        NoInd = new AttributeT("NoInd", new IndicatorT[] {});
    }

    @After
    public void tearDown()
    {
        Test1 = null;
        Test2 = null;
        Space = null;
        EmptyName = null;
        MultipleInd = null;
        NoInd = null;
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
    public void test_chicken()
    {
        assertTrue(!(Test2.getName() == "Chicken :) "));
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
        IndicatorT inds[] = new IndicatorT[] {IndicatorT.assumpt};
        assertTrue(Arrays.equals(Test2.getIndicators(), inds));
    }

    @Test
    public void test_mult_inds()
    {
        IndicatorT inds[] = new IndicatorT[] {IndicatorT.desProcess, IndicatorT.desPrinciples,
                                              IndicatorT.openEnded, IndicatorT.ideaGeneration};
        HashSet<IndicatorT> set1 = new HashSet<IndicatorT>(Arrays.asList(inds));
        HashSet<IndicatorT> set2 = new HashSet<IndicatorT>(Arrays.asList(MultipleInd.getIndicators()));
        assertTrue(set1.equals(set2));
    }

    @Test
    public void test_no_ind()
    {
        IndicatorT inds[] = new IndicatorT[] {};
        HashSet<IndicatorT> set1 = new HashSet<IndicatorT>(Arrays.asList(inds));
        HashSet<IndicatorT> set2 = new HashSet<IndicatorT>(Arrays.asList(NoInd.getIndicators()));
        assertTrue(set1.equals(set2));
    }

    @Test
    public void test_not_ind()
    {
        IndicatorT inds[] = new IndicatorT[] {IndicatorT.assumpt, IndicatorT.math};
        assertTrue(!Arrays.equals(Test2.getIndicators(), inds));
    }

}
