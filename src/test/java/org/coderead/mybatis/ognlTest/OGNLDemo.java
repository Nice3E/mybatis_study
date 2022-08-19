package org.coderead.mybatis.ognlTest;

import org.apache.ibatis.scripting.xmltags.ExpressionEvaluator;
import org.coderead.mybatis.bean.User_Blob;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author: 曾祥贺
 * @Date: 2022-08-19 8:30
 * @Description:
 */
public class OGNLDemo {

    @Test
    public void demo(){
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        User_Blob user_blob = new User_Blob();

        boolean b = expressionEvaluator.evaluateBoolean("id == null && blob.id == null", user_blob);
        System.out.println(b);
    }
}
