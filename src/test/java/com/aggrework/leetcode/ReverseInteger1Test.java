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
* ReverseInteger1 Tester. 
* 
* @author <Authors name> 
* @since <pre>10/05/2022</pre> 
* @version 1.0 
*/ 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoConfig.class)
public class ReverseInteger1Test {

    @Autowired
    private ReverseInteger1 reverseInteger1;
    
    @Before
    public void before() throws Exception {
        
    }
    
    @After
    public void after() throws Exception {
        
    }
    
    /** 
    * 
    * Method: reverse(int x) 
    * 
    */ 
    @Test
    public void testReverse() throws Exception {
        int result;

        result = reverseInteger1.reverse(-2147483648);
        Assert.assertEquals(0, result);

        result = reverseInteger1.reverse(120);
        Assert.assertEquals(21, result);

        result = reverseInteger1.reverse(123);
        Assert.assertEquals(321, result);

        result = reverseInteger1.reverse(-123);
        Assert.assertEquals(-321, result);

        result = reverseInteger1.reverse(1534236469);
        Assert.assertEquals(0, result);

        result = reverseInteger1.reverse(0);
        Assert.assertEquals(0, result);

        result = reverseInteger1.reverse(5);
        Assert.assertEquals(5, result);
    }
        
}
