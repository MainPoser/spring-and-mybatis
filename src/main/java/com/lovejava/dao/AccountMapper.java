package com.lovejava.dao;

import com.lovejava.domain.User;
import org.apache.ibatis.annotations.Insert;

/**
 * @author:tianyao
 * @date:2019-04-07 10:15
 */
public interface AccountMapper {
    /***
     * 模拟保存账户
     */
    @Insert("insert into user values(null,#{username},#{birthday},#{sex},#{address})")
    void saveAccount(User user);
}
