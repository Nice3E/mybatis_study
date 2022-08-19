package org.coderead.mybatis.methodHandlesTest;

/**
 * @Author: 曾祥贺
 * @Date: 2022-08-18 10:57
 * @Description:
 */
public class SubMethodHandleDemo extends MethodHandleDemo {

    @Override
    public String sayHello(String s) {
        return "Sub Hello, " + s;
    }
}
