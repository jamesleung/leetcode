package com.aggrework.leetcode; 

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* MyAtoi1 Tester. 
* 
* @author <Authors name> 
* @since <pre>10/10/2022</pre> 
* @version 1.0 
*/ 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoConfig.class)
public class MyAtoi1Test {

    @Autowired
    private MyAtoi1 myAtoi1;
    
    @Before
    public void before() throws Exception {
        
    }
    
    @After
    public void after() throws Exception {
        
    }
    
    /** 
    * 
    * Method: myAtoi(String s) 
    * 
    */ 
    @Test
    public void testMyAtoi() throws Exception {
        int result;

        result = myAtoi1.myAtoi("  0000000000012345678");
        Assert.assertEquals(12345678, result);

        result = myAtoi1.myAtoi("4193 with words");
        Assert.assertEquals(4193, result);

        result = myAtoi1.myAtoi("-91283472332");
        Assert.assertEquals(-2147483648, result);

        result = myAtoi1.myAtoi("2147483648");
        Assert.assertEquals(2147483647, result);

        result = myAtoi1.myAtoi("   +0 123");
        Assert.assertEquals(0, result);

        result = myAtoi1.myAtoi("words and 987");
        Assert.assertEquals(0, result);

        result = myAtoi1.myAtoi("42");
        Assert.assertEquals(42, result);

        result = myAtoi1.myAtoi("  42");
        Assert.assertEquals(42, result);

        result = myAtoi1.myAtoi("   -42");
        Assert.assertEquals(-42, result);
    }    
        
}
