package com.xyz.ata.util;

import com.xyz.ata.bean.CredentialsBean;

public interface Authentication {
	public boolean authenticate(CredentialsBean credentialsBean);
	public String authorize(String userID);
	public boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus);


}


