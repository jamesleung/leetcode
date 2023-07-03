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
* RegularExpressionMatching7 Tester. 
* 
* @author <Authors name> 
* @since <pre>04/14/2023</pre> 
* @version 1.0 
*/ 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoConfig.class)
public class RegularExpressionMatching7Test {

    @Autowired
    private RegularExpressionMatching7 regularExpressionMatching7;
    
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
        //TODO: Test goes here... 
    }
    /** 
    * 
    * Method: match(String s, int sBegin, int sEnd, String p, int pBegin, int pEnd) 
    * 
    */ 
    @Test
    public void testMatch() throws Exception {

        boolean result;

        result = regularExpressionMatching7.isMatch("abcbccbcbaabbcbb", "c*a.*ab*.*ab*a*..b*");
        Assert.assertTrue(result);

        result = regularExpressionMatching7.isMatch("abbbaabccbaabacab", "ab*b*b*bc*ac*.*bb*");
        Assert.assertTrue(result);

        result = regularExpressionMatching7.isMatch("aabccbcbacabaab", ".*c*a*b.*a*ba*bb*");
        Assert.assertTrue(result);

        result = regularExpressionMatching7.isMatch("baabbbaccbccacacc", "c*..b*a*a.*a..*c");
        Assert.assertTrue(result);

        result = regularExpressionMatching7.isMatch("babcbbc", ".*a.*c");
        Assert.assertTrue(result);

        result = regularExpressionMatching7.isMatch("a", ".*..");
        Assert.assertFalse(result);

        result = regularExpressionMatching7.isMatch("aaa", "ab*a*c*a");
        Assert.assertTrue(result);

        result = regularExpressionMatching7.isMatch("mississippi", "mis*is*ip*.");
        Assert.assertTrue(result);

        result = regularExpressionMatching7.isMatch("mississippi", "mis*is*p*.");
        Assert.assertFalse(result);

        result = regularExpressionMatching7.isMatch("aab", "c*a*b");
        Assert.assertTrue(result);

        result = regularExpressionMatching7.isMatch("aaa", "ab*ac*a");
        Assert.assertTrue(result);

        result = regularExpressionMatching7.isMatch("aaa", "aaaa");
        Assert.assertFalse(result);

        result = regularExpressionMatching7.isMatch("aa", "a");
        Assert.assertFalse(result);

        result = regularExpressionMatching7.isMatch("adbdebcdecfg", ".*bd.*c.*e.*");
        Assert.assertTrue(result);

        result = regularExpressionMatching7.isMatch("aa", "a*");
        Assert.assertTrue(result);

        result = regularExpressionMatching7.isMatch("ab", ".*");
        Assert.assertTrue(result);
    }
}