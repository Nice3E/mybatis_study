package org.coderead.mybatis;

import org.apache.ibatis.annotations.Param;
import org.coderead.mybatis.bean.Blob;
import org.coderead.mybatis.bean.User;
import org.coderead.mybatis.bean.User_Blob;

import java.util.List;

public interface UserMapper2 {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated
     */
    User selectByPrimaryKey(Integer id);
    Blob selectBlodByPrimaryKey(Integer id);
    User_Blob selectUserAndBlob(Integer id);
    User_Blob selectUserAndBlob2(Integer id);

    User selectByPrimaryKeyAndName(Integer id, String name);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(User record);
    List<User> selectByPrimaryKeySelective(@Param("a") User record, Integer o);
    List<User> selectByPrimaryKeySelective2(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(User record);
}