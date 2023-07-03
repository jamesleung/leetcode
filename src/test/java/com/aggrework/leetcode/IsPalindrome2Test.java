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
* IsPalindrome2 Tester. 
* 
* @author <Authors name> 
* @since <pre>10/13/2022</pre> 
* @version 1.0 
*/ 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoConfig.class)
public class IsPalindrome2Test {

    @Autowired
    private IsPalindrome2 isPalindrome2;
    
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

        result = isPalindrome2.isPalindrome(1122);
        Assert.assertEquals(false, result);

        result = isPalindrome2.isPalindrome(121);
        Assert.assertEquals(true, result);

        result = isPalindrome2.isPalindrome(3663);
        Assert.assertEquals(true, result);

        result = isPalindrome2.isPalindrome(0);
        Assert.assertEquals(true, result);

        result = isPalindrome2.isPalindrome(-121);
        Assert.assertEquals(false, result);

        result = isPalindrome2.isPalindrome(10);
        Assert.assertEquals(false, result);

    }
    
}