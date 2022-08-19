package org.coderead.mybatis.bean;

/**
 * @Author: 曾祥贺
 * @Date: 2022-08-16 14:14
 * @Description:
 */
public class Blob {
    private Integer id;
    private Integer userid;
    private String context;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "Blob{" +
                "id=" + id +
                ", userid=" + userid +
                ", context='" + context + '\'' +
                '}';
    }
}
