package com.dao;

import com.common.BaseDao;
import com.model.Industryplan.LeaveMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 作者：WangJian
 * @create 创建时间： 2018-05-27 下午 12:55
 **/
public interface LeaveMessageDao extends JpaRepository<LeaveMessage,Integer >, JpaSpecificationExecutor<LeaveMessage>, BaseDao<LeaveMessage, Integer> {
}
