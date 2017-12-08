package com.zhaoxuan.dao;

import com.zhaoxuan.annotation.MyBatisDao;
import com.zhaoxuan.base.CrudDao;
import com.zhaoxuan.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhaoxuan
 * 2017/12/7 14:37
 */
@MyBatisDao
public interface UserDao extends CrudDao<User>{
    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 获取所有用户列表
     * @return
     */
    List<User> listAllUser();

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User getUserById(@Param("id") Integer id);

    /**
     * 更新用户的信息
     * @param user
     */
    int updateUser(User user);

    /**
     * 根据id删除指定的用户
     * @param id
     */
    void deleteUserById(@Param("id") Integer id);

    /**
     * 批量添加用户
     * @param list
     */
    void batchSaveUser(List<User> list);

    /**
     * 批量删除用户
     * @param ids
     */
    void batchDeleteUser(String[] ids);
}
