package com.dao;

import com.common.BaseDao;
import com.model.TimeAxis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 作者：WangJian
 * @create 创建时间： 2018-05-27 上午 9:21
 **/
public interface TimeAxisDao extends JpaRepository<TimeAxis,Integer >, JpaSpecificationExecutor<TimeAxis>, BaseDao<TimeAxis, Integer> {
}
