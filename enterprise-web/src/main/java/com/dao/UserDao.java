package com.dao;

import com.common.BaseDao;
import com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @author 作者：WangJian
 * @create 创建时间： 2018-05-26 下午 5:27
 **/
public interface UserDao extends JpaRepository<User,Integer >, JpaSpecificationExecutor<User>, BaseDao<User, Integer> {
    @Query(value = "SELECT * FROM USER u WHERE u.`username`=?1 AND u.`password`=?2 limit 1",nativeQuery = true)
    User login(String username,String password);

}
