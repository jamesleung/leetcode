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
* IsPalindrome4 Tester. 
* 
* @author <Authors name> 
* @since <pre>10/14/2022</pre> 
* @version 1.0 
*/ 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoConfig.class)
public class IsPalindrome4Test {

    @Autowired
    private IsPalindrome4 isPalindrome4;
    
    @Before
    public void before() throws Exception {
        
    }
    
    @After
    public void after() throws Exception {
        
    }
    
    /** 
    * 
    * Method: isPalindrome(int x) 
    * 
    */ 
    @Test
    public void testIsPalindrome() throws Exception {
        boolean result;

        result = isPalindrome4.isPalindrome(121);
        Assert.assertTrue(result);

        result = isPalindrome4.isPalindrome(1122);
        Assert.assertFalse(result);

        result = isPalindrome4.isPalindrome(3663);
        Assert.assertTrue(result);

        result = isPalindrome4.isPalindrome(0);
        Assert.assertTrue(result);

        result = isPalindrome4.isPalindrome(-121);
        Assert.assertFalse(result);

        result = isPalindrome4.isPalindrome(10);
        Assert.assertFalse(result);

    }
    
}