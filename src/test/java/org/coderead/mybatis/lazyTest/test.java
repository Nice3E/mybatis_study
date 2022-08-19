package org.coderead.mybatis.lazyTest;

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
 * @Date: 2022-08-17 16:46
 * @Description:
 */
public class test {
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
        User_Blob user_blob = mapper.selectUserAndBlob(10);
        user_blob.getBlob();
//
//        User_Blob mapper = sqlSession.getMapper(User_Blob.class);
        //org.apache.ibatis.binding.BindingException: Type class org.coderead.mybatis.bean.User_Blob is not known to the MapperRegistry.

    }
}
