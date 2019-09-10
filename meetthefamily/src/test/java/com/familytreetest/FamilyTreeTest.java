package com.familytreetest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FamilyTreeTest extends TestCase
{
    public FamilyTreeTest( String testName )
    {
        super(testName);
    }

    public static Test suite()
    {
        return new TestSuite(FamilyTreeTest.class);
    }

    public void testApp()
    {
        assertTrue( true );
    }
}