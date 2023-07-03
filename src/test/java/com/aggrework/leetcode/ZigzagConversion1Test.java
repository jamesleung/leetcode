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
* ZigzagConversion1 Tester. 
* 
* @author <Authors name> 
* @since <pre>09/30/2022</pre> 
* @version 1.0 
*/ 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoConfig.class)
public class ZigzagConversion1Test {

    @Autowired
    private ZigzagConversion1 zigzagConversion1;
    
    @Before
    public void before() throws Exception {
        
    }
    
    @After
    public void after() throws Exception {
        
    }
    
    /** 
    * 
    * Method: convert(String s, int numRows) 
    * 
    */ 
    @Test
    public void testConvert() throws Exception {
        String result = "";

        result = zigzagConversion1.convert("PAYPALISHIRING", 3);
        Assert.assertEquals("PAHNAPLSIIGYIR", result);

        result = zigzagConversion1.convert("ABC", 2);
        Assert.assertEquals("ACB", result);

    }    
        
}
