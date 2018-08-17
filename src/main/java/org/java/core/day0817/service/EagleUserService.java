package org.java.core.day0817.service;

import org.java.core.day0817.db.entity.EagleUser;
import org.java.core.day0817.db.repository.EagleUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xiaoyu.wang
 *
 */

@Service
public class EagleUserService {

	@Autowired
	private EagleUserMapper eagleUserMapper;

	@Transactional(value = "eagleTxManager", propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public int insert(EagleUser eagleUser) {
		int insert = eagleUserMapper.insert(eagleUser);
		if (insert == 1) {
			throw new RuntimeException();
		}
		return insert;
	}

	/*
	 * @Transactional(value = "eagleTxManager", propagation = Propagation.REQUIRED,
	 * readOnly = false, noRollbackFor = ClassCastException.class)
	 * 
	 * @Override public int updateByPrimaryKeySelective(EagleUser eagleUser) { int
	 * update = eagleUserRepository.updateByPrimaryKeySelective(eagleUser); if
	 * (update == 1) { throw new ClassCastException(); } return update; }
	 */

	// @Transactional(value = "eagleTxManager", propagation = Propagation.REQUIRED, readOnly = false)
	public int updateByPrimaryKeySelective(EagleUser eagleUser) {
		int update = this.update(eagleUser);// this調用非代理調用 而是被代理對象調用
		return update;
	}

	@Transactional(value = "eagleTxManager", propagation = Propagation.REQUIRED, readOnly = false)
	public int update(EagleUser eagleUser) {
		int update = eagleUserMapper.updateByPrimaryKeySelective(eagleUser);
		if (update == 1) {
			throw new RuntimeException("update(EagleUser eagleUser)执行更新异常");
		}
		return update;
	}

	@Transactional(value = "eagleTxManager", propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)
	public EagleUser selectByPrimaryKey(Long id) {
		return eagleUserMapper.selectByPrimaryKey(id);
	}
}
