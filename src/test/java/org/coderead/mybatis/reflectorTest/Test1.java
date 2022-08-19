package org.coderead.mybatis.reflectorTest;

import org.apache.ibatis.reflection.*;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.property.PropertyNamer;
import org.apache.ibatis.session.Configuration;
import org.coderead.mybatis.bean.User;
import org.junit.Test;

/**
 * @Author: 曾祥贺
 * @Date: 2022-08-15 11:09
 * @Description:
 */
public class Test1 {
    @Test
    public void test(){
        Reflector reflector = new Reflector(User.class);
    }

    @Test
    public void testReflectorFactory(){
        ReflectorFactory reflectorFactory = new DefaultReflectorFactory();
        Reflector forClass = reflectorFactory.findForClass(User.class);
        Reflector forClass2 = reflectorFactory.findForClass(User.class);
        System.out.println(forClass == forClass2);
    }

    @Test
    public void objectFactoryTest(){
        DefaultObjectFactory defaultObjectFactory = new DefaultObjectFactory();
        User user = defaultObjectFactory.create(User.class);
    }

    @Test
    public void propertyNamer(){
        String getName = PropertyNamer.methodToProperty("getNaMe");
        System.out.println(getName);
    }

    @Test
    public void metaClass(){
        DefaultReflectorFactory defaultReflectorFactory = new DefaultReflectorFactory();
        MetaClass metaClass =  MetaClass.forClass(User.class,defaultReflectorFactory);
//        metaClass.findProperty()
        boolean b = metaClass.hasGetter("age3");
        System.out.println(b);
    }

    @Test
    public void metaObject(){
        User user = new User();
        MetaObject metaObject = new Configuration().newMetaObject(user);
        metaObject.getValue("name");
    }
}
