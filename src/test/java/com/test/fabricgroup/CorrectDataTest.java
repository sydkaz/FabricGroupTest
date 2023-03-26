package com.test.fabricgroup;

import com.geekheights.app.Customer;
import com.geekheights.app.LoadAndParse;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.io.File;
import java.util.TreeMap;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CorrectDataTest {


    @BeforeClass
    public static void beforeClass(){
        System.out.println("Instantiating array list in ParseAndLoadData ...");


    }

    @Test
    public void firstTestCase() throws Throwable {
        Customer c =new Customer();
        LoadAndParse.run("src/test/java/resources/correctData/sample1.txt",c);
        String s= c.getGeneratedBill().stream().map(Object::toString).reduce((t, u) -> t + " " + u).orElse("");
        Assert.assertEquals("","2400 5215",s);
    }

@Test
    public void secondTestCase() throws Throwable {
        Customer c =new Customer();
        LoadAndParse.run("src/test/java/resources/correctData/sample2.txt",c);
        String s= c.getGeneratedBill().stream().map(Object::toString).reduce((t, u) -> t + " " + u).orElse("");
        Assert.assertEquals("","3000 5750",s);
    }

    @Test
    public void thirdTestCase() throws Throwable {
        Customer c =new Customer();
        LoadAndParse.run("src/test/java/resources/correctData/sample3.txt",c);
        String s= c.getGeneratedBill().stream().map(Object::toString).reduce((t, u) -> t + " " + u).orElse("");
        Assert.assertEquals("","900 1200",s);

    }

}
