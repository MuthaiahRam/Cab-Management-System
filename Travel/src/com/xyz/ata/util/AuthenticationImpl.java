package com.xyz.ata.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xyz.ata.bean.CredentialsBean;
import com.xyz.ata.dao.AtaUtilDAO;
@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)

public class AuthenticationImpl implements Authentication {
@Autowired
AtaUtilDAO ataUtilDAO;
@Transactional(propagation=Propagation.REQUIRED,readOnly=false)

	public boolean authenticate(CredentialsBean credentialsBean) {
		return ataUtilDAO.authenticate(credentialsBean);
	}

@Transactional(propagation=Propagation.REQUIRED,readOnly=false)

	public String authorize(String userID) {
		return ataUtilDAO.authorize(userID);
	}

@Transactional(propagation=Propagation.REQUIRED,readOnly=false)

	public boolean changeLoginStatus(CredentialsBean credentialsBean,
			int loginStatus) {
		return ataUtilDAO.changeLoginStatus(credentialsBean, loginStatus);
	}

}
