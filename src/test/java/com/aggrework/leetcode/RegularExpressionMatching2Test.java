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
* RegularExpressionMatching2 Tester. 
* 
* @author <Authors name> 
* @since <pre>10/22/2022</pre> 
* @version 1.0 
*/ 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoConfig.class)
public class RegularExpressionMatching2Test {

    @Autowired
    private RegularExpressionMatching2 regularExpressionMatching2;
    
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

        result = regularExpressionMatching2.isMatch("a", ".*..");
        Assert.assertFalse(result);

        result = regularExpressionMatching2.isMatch("aaa", "aaaa");
        Assert.assertFalse(result);

        result = regularExpressionMatching2.isMatch("aaa", "ab*ac*a");
        Assert.assertTrue(result);

        result = regularExpressionMatching2.isMatch("aaa", "ab*a*c*a");
        Assert.assertTrue(result);

        result = regularExpressionMatching2.isMatch("aab", "c*a*b");
        Assert.assertTrue(result);

        result = regularExpressionMatching2.isMatch("mississippi", "mis*is*ip*.");
        Assert.assertTrue(result);

        result = regularExpressionMatching2.isMatch("mississippi", "mis*is*p*.");
        Assert.assertFalse(result);

        result = regularExpressionMatching2.isMatch("aa", "a");
        Assert.assertFalse(result);

        result = regularExpressionMatching2.isMatch("abbcbbc", ".*a.*c");
        Assert.assertTrue(result);

        result = regularExpressionMatching2.isMatch("adbdebcdecfg", ".*bd.*c.*e.*");
        Assert.assertTrue(result);

        result = regularExpressionMatching2.isMatch("aa", "a*");
        Assert.assertTrue(result);

        result = regularExpressionMatching2.isMatch("ab", ".*");
        Assert.assertTrue(result);
    }
    
}