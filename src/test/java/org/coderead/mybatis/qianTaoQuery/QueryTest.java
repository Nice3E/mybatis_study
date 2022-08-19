package org.coderead.mybatis.qianTaoQuery;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.coderead.mybatis.UserMapper;
import org.coderead.mybatis.bean.User_Blob;
import org.coderead.mybatis.cacheTest.FirstCacheTest;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @Author: 曾祥贺
 * @Date: 2022-08-16 14:26
 * @Description:
 */
public class QueryTest {
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
        User_Blob user_blob = mapper.selectUserAndBlob2(10);
        System.out.println(user_blob);
    }
}
