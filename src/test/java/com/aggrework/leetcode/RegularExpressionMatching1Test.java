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
* RegularExpressionMatching1 Tester. 
* 
* @author <Authors name> 
* @since <pre>10/15/2022</pre> 
* @version 1.0 
*/ 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoConfig.class)
public class RegularExpressionMatching1Test {

    @Autowired
    private RegularExpressionMatching1 regularExpressionMatching1;
    
    @Before
    public void before() throws Exception {
        
    }
    
    @After
    public void after() throws Exception {
        
    }
    
    /** 
    * 
    * Method: isMatch(String s, String p) 
    * 
    */ 
    @Test
    public void testIsMatch() throws Exception {
        boolean result;

        result = regularExpressionMatching1.isMatch("aa", "a");
        Assert.assertFalse(result);
    }
    
}