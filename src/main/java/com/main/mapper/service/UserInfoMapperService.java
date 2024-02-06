package com.main.mapper.service;

import com.main.entity.UserInfo;
import com.main.mapper.UserInfoMapper;

public class UserInfoMapperService {

	public UserInfoMapper map(UserInfo userInfo) {
		UserInfoMapper userInfoMapper = new UserInfoMapper();
		userInfoMapper.setId(userInfo.getId());
		userInfoMapper.setFirstName(userInfo.getFirstName());
		userInfoMapper.setLastName(userInfo.getLastName());
		userInfoMapper.setMobileNumber(userInfo.getMobileNumber());
		userInfoMapper.setDesignation(userInfo.getDesignation());
		userInfoMapper.setRoles(userInfo.getRoles());
		userInfoMapper.setAddress(userInfo.getAddress());
		userInfoMapper.setEmail(userInfo.getEmail());
		userInfoMapper.setSiteId(userInfo.getSite().getId());
		userInfoMapper.setSiteName(userInfo.getSite().getName());
		userInfoMapper.setSiteAddress(userInfo.getSite().getAddress());
		userInfoMapper.setTenantId(userInfo.getSite().getTenant().getId());
		userInfoMapper.setTenantName(userInfo.getSite().getTenant().getName());
		return userInfoMapper;
	}
}
