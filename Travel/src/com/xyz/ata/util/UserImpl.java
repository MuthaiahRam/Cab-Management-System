package com.xyz.ata.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xyz.ata.bean.CredentialsBean;
import com.xyz.ata.bean.ProfileBean;
import com.xyz.ata.dao.AtaUtilDAO;
@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)

public class UserImpl implements User {
@Autowired
AtaUtilDAO ataUtilDAO;
@Autowired
Authentication authentication;
@Transactional(propagation=Propagation.REQUIRED,readOnly=false)

	public String changePassword(CredentialsBean credentialsBean,
			String newPassword) {
		return ataUtilDAO.changePassword(credentialsBean, newPassword);
	}


@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String login(CredentialsBean credentialsBean) {
		String userType=ataUtilDAO.login(credentialsBean);
		System.out.println("in impl"+userType);
		if("A".equals(userType)||"C".equals(userType))
		{
			authentication.authorize(credentialsBean.getUserID());
		}
		return userType;
	}

@Transactional(propagation=Propagation.REQUIRED,readOnly=false)

	public boolean logout(String userId) {
		return ataUtilDAO.logout(userId);
		
	}

@Transactional(propagation=Propagation.REQUIRED,readOnly=false)

	public String register(ProfileBean profileBean) {

		return ataUtilDAO.register(profileBean);
	}




}
