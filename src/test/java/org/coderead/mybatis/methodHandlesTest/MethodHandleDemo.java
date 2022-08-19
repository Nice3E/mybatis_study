package org.coderead.mybatis.methodHandlesTest;

import org.junit.Test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @Author: 曾祥贺
 * @Date: 2022-08-18 10:54
 * @Description:
 */
public class MethodHandleDemo {

    public String sayHello(String s){
       return "Hello, "+s;
    }

    public static void main(String[] args) throws Throwable {
        MethodHandleDemo subMethodHandleDemo = new SubMethodHandleDemo();
        MethodType methodType = MethodType.methodType(String.class,String.class);
        MethodHandle methodHandle = MethodHandles.lookup().findVirtual(MethodHandleDemo.class, "sayHello", methodType);

        System.out.println(methodHandle.bindTo(subMethodHandleDemo).invokeWithArguments("methodHandleDemo"));

        MethodHandleDemo methodHandleDemo = new MethodHandleDemo();
        System.out.println(methodHandle.bindTo(methodHandleDemo)
                .invokeWithArguments("MethodHandleDemo"));
    }
}
