package com.test.fabricgroup;

import com.geekheights.app.util.TankerRules;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.File;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TankerRulesTest {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Instantiating array list in ParseAndLoadData ...");
    }

    @Test
    public void firstTestCase() throws Throwable {
        double returnedData = TankerRules.calculatePrice(1500);
        Assert.assertEquals(4000,returnedData,0);
    }

    @Test
    public void secondTestCase() throws Throwable {
        double returnedData = TankerRules.calculatePrice(1820);
        Assert.assertEquals(4960,returnedData,0);
    }

    @Test
    public void thirdTestCase() throws Throwable {
        double returnedData = TankerRules.calculatePrice(15325);
        Assert.assertEquals(103100,returnedData,0);

    }

    @Test
    public void fourthTestCase() throws Throwable {
        double returnedData = TankerRules.calculatePrice(321654);
        Assert.assertEquals(2553732,returnedData,0);

    }

    @Test
    public void fifthTestCase() throws Throwable {
        double returnedData = TankerRules.calculatePrice(0);
        Assert.assertEquals(0,returnedData,0);

    }

    @Test
    public void sixthTestCase() throws Throwable {
        double returnedData = TankerRules.calculatePrice(9);
        Assert.assertEquals(18,returnedData,0);

    }

}
