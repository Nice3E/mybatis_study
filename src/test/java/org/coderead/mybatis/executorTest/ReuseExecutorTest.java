package org.coderead.mybatis.executorTest;

import org.apache.ibatis.executor.ReuseExecutor;
import org.apache.ibatis.executor.SimpleExecutor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: 曾祥贺
 * @Date: 2022-08-09 10:59
 * @Description:
 */
public class ReuseExecutorTest {

    private Configuration configuration;
    private JdbcTransaction jdbcTransaction;
    private SqlSessionFactory factory;
    MappedStatement ms;

    @Before
    public void init() throws SQLException {
        // 获取构建器
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        // 解析XML 并构造会话工厂
        factory = factoryBuilder.build(SimpleExecutorTest.class.getResourceAsStream("/mybatis-config.xml"));
        configuration = factory.getConfiguration();
        jdbcTransaction = new JdbcTransaction(factory.openSession().getConnection());
        // 获取SQL映射
        ms = configuration.getMappedStatement("org.coderead.mybatis.UserMapper.selectByPrimaryKey");
    }

    @Test
    public void test() throws SQLException {
        ReuseExecutor reuseExecutor = new ReuseExecutor(configuration, jdbcTransaction);
        List<Object> objects = reuseExecutor.doQuery(ms, 10, RowBounds.DEFAULT, SimpleExecutor.NO_RESULT_HANDLER, ms.getBoundSql(10));
        List<Object> objects2 = reuseExecutor.doQuery(ms, 10, RowBounds.DEFAULT, SimpleExecutor.NO_RESULT_HANDLER, ms.getBoundSql(10));
        System.out.println(objects == objects2);
    }
}
