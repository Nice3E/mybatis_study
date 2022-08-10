package org.coderead.mybatis.cacheTest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.coderead.mybatis.UserMapper;
import org.coderead.mybatis.bean.User;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.sql.SQLException;

/**
 * @Author: 曾祥贺
 * @Date: 2022-08-09 13:24
 * @Description:
 */

public class FirstCacheTest {
    // 初始MyBatis
    private SqlSessionFactory factory;
    private SqlSession sqlSession;

    @Before
    public void init() throws SQLException {
        // 获取构建器
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        // 解析XML 并构造会话工厂
        factory = factoryBuilder.build(FirstCacheTest.class.getResourceAsStream("/mybatis-config.xml"));
        sqlSession = factory.openSession();
    }

    @Test
    public void test(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByPrimaryKey(10);
        sqlSession.commit();
        User user2 = mapper.selectByPrimaryKey(10);
        System.out.println(user == user2);
//        System.out.println(86008l == 86008l);
    }
}
