package com.xyz.ata.dao;

import com.xyz.ata.bean.CredentialsBean;
import com.xyz.ata.bean.ProfileBean;

public interface AtaUtilDAO {
public 	boolean authenticate(CredentialsBean credentialsBean); 
public String authorize(String userID);
public boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus);
public String login(CredentialsBean credentialsBean);
public boolean logout(String userId);
public String changePassword(CredentialsBean credentialsBean, String newPassword);
public String register(ProfileBean profileBean);
public long getUserID();
public boolean findByCardNumber(String userID, String cardNumber);
public String processPayment(String CardNumber,double fare);

}
