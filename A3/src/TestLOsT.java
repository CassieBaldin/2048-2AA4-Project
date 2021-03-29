/**
 * Author: Cassidy Baldin
 * Revised: March 29, 2021
 * 
 * Description: Testing module for AttributeT class and methods
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;

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
        assertTrue(Test1.equals(Test1));
    }

    @Test
    public void test2_equals()
    {
        assertTrue(!(Test1.equals(Test2)));
    }
}
