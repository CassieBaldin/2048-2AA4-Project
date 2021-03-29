/**
 * Author: Cassidy Baldin
 * Revised: March 29, 2021
 * 
 * Description: Testing module for LOsT class methods
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class TestLOsT
{
    // Norm.setNorms(false, false, false);
    private LOsT Test1;
    private LOsT Test2;
    private LOsT Space;
    private LOsT EmptyName;

    @Before
    public void setUp()
    {
        Test1 = new LOsT("Test1", 1, 2, 3, 4);
        Test2 = new LOsT("Test2", 12, 4 ,64, 753);
        Space = new LOsT(" ", 4, 3, 2, 1);
        EmptyName = new LOsT("", 10, 20, 30, 440);
    }

    @After
    public void tearDown()
    {
        LOsT Test1 = null;
        LOsT Test2 = null;
        LOsT Space = null;
        LOsT EmptyName = null;
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
    public void test_pineapple()
    {
        assertTrue(!(Test2.getName() == "Who lives in a pineapple under the sea?"));
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
    public void test_oneZero()
    {
        //this should work according to spec
        LOsT OneZero = new LOsT("OneZero", 100, 200, 300, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_allZero()
    {
        LOsT AllZero = new LOsT("AllZero", 0, 0, 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_oneNeg()
    {
        LOsT OneNeg = new LOsT("OneNeg", 100, -200, 300, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_allNeg()
    {
        LOsT AllNeg = new LOsT("AllNeg", -100, -200, -300, -4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_expMix()
    {
        LOsT AllNeg = new LOsT("AllNeg", -100, 0, 1, -4);
    }

    @Test
    public void test1_equals()
    {
        LOsT Test = new LOsT("Test1", 1, 2, 3, 4);
        assertTrue(Test1.equals(Test));
    }

    @Test
    public void test2_equals()
    {
        LOsT Test = new LOsT("Test", 1, 2, 3, 4);
        assertTrue(!(Test1.equals(Test)));
    }

    @Test
    public void test1_measures()
    {
        Norm.setNorms(false, false, false);
        assertTrue(Arrays.equals(Test1.measures(), new double[] {1, 2, 3, 4}));
    }

    @Test
    public void test2_measures()
    {
        Norm.setNorms(false, false, false);
        assertTrue(Arrays.equals(Test2.measures(), new double[] {12, 4 ,64, 753}));
    }

    @Test
    public void test1_measures_norm()
    {
        Norm.setNorms(true, false, false);
        assertTrue(Arrays.equals(Test1.measures(), new double[] {0.0, 0.1, 0.2, 0.3}));
    }

    @Test
    public void test2_measures_norm()
    {
        Norm.setNorms(true, false, false);
        assertTrue(Arrays.equals(EmptyName.measures(), new double[] {0.0, 0.002, 0.004, 0.006}));
    }

    @Test
    public void test3_measures_change_norm()
    {
        Norm.setNorms(true, false, false);
        Norm.setNLOs(false);
        assertTrue(Arrays.equals(EmptyName.measures(), new double[] {10, 20, 30, 440}));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_meas_ind()
    {
        Test1.measures(IndicatorT.math);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_meas_att()
    {
        AttributeT Test = new AttributeT("Test2", new IndicatorT[] {IndicatorT.math, IndicatorT.assumpt});
        Test1.measures(Test);
    }
}
