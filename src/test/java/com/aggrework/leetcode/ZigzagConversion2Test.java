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
* ZigzagConversion2 Tester. 
* 
* @author <Authors name> 
* @since <pre>09/30/2022</pre> 
* @version 1.0 
*/ 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoConfig.class)
public class ZigzagConversion2Test {

    @Autowired
    private ZigzagConversion2 zigzagConversion2;
    
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

        result = zigzagConversion2.convert("PAYPALISHIRING", 5);
        Assert.assertEquals("PHASIYIRPLIGAN", result);

        result = zigzagConversion2.convert("ABCDEFGHIJKLMNOPQ", 4);
        Assert.assertEquals("AGMBFHLNCEIKOQDJP", result);

        result = zigzagConversion2.convert("PAYPALISHIRING", 3);
        Assert.assertEquals("PAHNAPLSIIGYIR", result);

        result = zigzagConversion2.convert("ABC", 2);
        Assert.assertEquals("ACB", result);
    }    
        
}
