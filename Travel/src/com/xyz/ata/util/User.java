package com.xyz.ata.util;

import com.xyz.ata.bean.CredentialsBean;
import com.xyz.ata.bean.ProfileBean;

public interface User {
	
	public String login(CredentialsBean credentialsBean);
	public boolean logout(String userId) ;
	public String changePassword(CredentialsBean credentialsBean, String newPassword);
	public String register(ProfileBean profileBean);
	


}
