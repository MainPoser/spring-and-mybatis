package com.lovejava.service.impl;

import com.lovejava.dao.AccountMapper;

import com.lovejava.domain.User;
import com.lovejava.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @author:tianyao
 * @date:2019-04-07 10:13
 */
public class AccountServiceImpl implements AccountService {

    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "AccountServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    /*public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }*/
    //依赖问题待解决
    //private AccountMapper accountDao = new AccountDaoImpl();


    /***
     * 模拟保存账号
     */
    @Override
    public void saveAccount() {
        try {
            //解决依赖问题
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = builder.build(is);
            SqlSession sqlSession = build.openSession(true);
            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
            User user = new User();
            user.setUsername("太阳王");
            user.setSex("男");
            user.setBirthday("1995-02-03");
            user.setAddress("灰烬墓地");
            mapper.saveAccount(user);
            System.out.println("保存成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
