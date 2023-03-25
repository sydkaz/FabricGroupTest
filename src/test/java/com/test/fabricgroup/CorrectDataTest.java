package com.test.fabricgroup;

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
        Assert.assertEquals(1,1,0);
    }

@Test
    public void secondTestCase() throws Throwable {

    }

    @Test
    public void thirdTestCase() throws Throwable {


    }



    public String getFileAbsolutePath(String s){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(s).getFile());
        System.out.println("Found Path for "+s+"   "+file.getAbsolutePath());
        return file.getAbsolutePath();
    }

}
