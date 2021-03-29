/**
 * Author: Cassidy Baldin
 * Revised: March 29th, 2021
 * 
 * Description: Testing module for AttributeT class and methods
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;


public class TestAttributeT
{
    private AttributeT Test1;
    private AttributeT Test2;
    private AttributeT MultipleInd;
    private AttributeT Space;
    private AttributeT NoName;
    private AttributeT NoInd;

    @Before
    public void setUp()
    {
        Test1 = new AttributeT("Test1", new IndicatorT[] {IndicatorT.math, IndicatorT.specEngKnow});
        Test2 = new AttributeT("Test2", new IndicatorT[] {IndicatorT.assumpt});
        MultipleInd = new AttributeT("MultipleInd", new IndicatorT[] {IndicatorT.desProcess, IndicatorT.desPrinciples,
                                                                     IndicatorT.openEnded, IndicatorT.ideaGeneration,
                                                                     IndicatorT.healthSafety, IndicatorT.desProcess});
        Space = new AttributeT(" ", new IndicatorT[] {IndicatorT.math, IndicatorT.openEnded});
        NoName = new AttributeT("", new IndicatorT[] {IndicatorT.math, IndicatorT.specEngKnow});
        NoInd = new AttributeT("NoInd", new IndicatorT[] {});
    }

    @After
    public void tearDown()
    {
        Test1 = null;
        Test2 = null;
        MultipleInd = null;
        Space = null;
        NoName = null;
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
    public void test_space_name()
    {
        assertTrue(Space.getName() == " ");
    }

    @Test
    public void test_noName_name()
    {
        assertTrue(NoName.getName() == "");
    }
}
