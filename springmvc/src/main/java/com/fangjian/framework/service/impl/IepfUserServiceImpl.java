package com.fangjian.framework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fangjian.framework.dao.IepfUserMapper;
import com.fangjian.framework.po.IepfUser;
import com.fangjian.framework.service.IepfUserService;

@Transactional
@Service(value="iepfUserService")
public class IepfUserServiceImpl implements IepfUserService {
	@Autowired
	private IepfUserMapper iepfUserMapper;
	@Override
	public void saveEntry(IepfUser bo) {
		this.iepfUserMapper.insert(bo);
		
	}

}
