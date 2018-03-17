package com.fangjian.framework.dao;

import com.fangjian.framework.po.IepfUser;


public interface IepfUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IepfUser record);

    int insertSelective(IepfUser record);

    IepfUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IepfUser record);

    int updateByPrimaryKey(IepfUser record);
}