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
* RegularExpressionMatching6 Tester. 
* 
* @author <Authors name> 
* @since <pre>12/23/2022</pre> 
* @version 1.0 
*/ 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DemoConfig.class)
public class RegularExpressionMatching6Test {

    @Autowired
    private RegularExpressionMatching6 regularExpressionMatching6;
    
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

        result = regularExpressionMatching6.isMatch("abcbccbcbaabbcbb", "c*a.*ab*.*ab*a*..b*");
        Assert.assertTrue(result);

        result = regularExpressionMatching6.isMatch("abbbaabccbaabacab", "ab*b*b*bc*ac*.*bb*");
        Assert.assertTrue(result);

        result = regularExpressionMatching6.isMatch("aabccbcbacabaab", ".*c*a*b.*a*ba*bb*");
        Assert.assertTrue(result);

        result = regularExpressionMatching6.isMatch("baabbbaccbccacacc", "c*..b*a*a.*a..*c");
        Assert.assertTrue(result);

        result = regularExpressionMatching6.isMatch("babcbbc", ".*a.*c");
        Assert.assertTrue(result);

        result = regularExpressionMatching6.isMatch("a", ".*..");
        Assert.assertFalse(result);

        result = regularExpressionMatching6.isMatch("aaa", "ab*a*c*a");
        Assert.assertTrue(result);

        result = regularExpressionMatching6.isMatch("mississippi", "mis*is*ip*.");
        Assert.assertTrue(result);

        result = regularExpressionMatching6.isMatch("mississippi", "mis*is*p*.");
        Assert.assertFalse(result);

        result = regularExpressionMatching6.isMatch("aab", "c*a*b");
        Assert.assertTrue(result);

        result = regularExpressionMatching6.isMatch("aaa", "ab*ac*a");
        Assert.assertTrue(result);

        result = regularExpressionMatching6.isMatch("aaa", "aaaa");
        Assert.assertFalse(result);

        result = regularExpressionMatching6.isMatch("aa", "a");
        Assert.assertFalse(result);

        result = regularExpressionMatching6.isMatch("adbdebcdecfg", ".*bd.*c.*e.*");
        Assert.assertTrue(result);

        result = regularExpressionMatching6.isMatch("aa", "a*");
        Assert.assertTrue(result);

        result = regularExpressionMatching6.isMatch("ab", ".*");
        Assert.assertTrue(result);
    }
}