package com.dao;

import com.common.BaseDao;
import com.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 作者：WangJian
 * @create 创建时间： 2018-05-27 下午 12:54
 **/
public interface NewsDao extends JpaRepository<News,Integer >, JpaSpecificationExecutor<News>, BaseDao<News, Integer> {
}
