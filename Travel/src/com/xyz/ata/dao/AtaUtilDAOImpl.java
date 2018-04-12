package com.xyz.ata.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xyz.ata.bean.CredentialsBean;
import com.xyz.ata.bean.ProfileBean;
import com.xyz.ata.util.Authentication;
@Repository
public class AtaUtilDAOImpl implements AtaUtilDAO {
	@Autowired
	SessionFactory sessionfactory;
	@Autowired
	Authentication authentication;

	
	public boolean authenticate(CredentialsBean credentialsBean) {
		boolean isAvailable=false;
		CredentialsBean bean = (CredentialsBean) sessionfactory.getCurrentSession().get(
				CredentialsBean.class,credentialsBean.getUserID());
	    if(credentialsBean.getPassword().equals(bean.getPassword())){
	    	isAvailable=true;
	    }
		return isAvailable;
	}

	
	public String authorize(String userID) {
		String authorizeStatus = "NOT AUTHORIZED";
		Session session = sessionfactory.getCurrentSession();
		Query query = session
				.createSQLQuery("update ATA_TBL_User_Credentials set Loginstatus=1 where userId=:id");
		query.setParameter("id", userID);
		int rowsUpdated = query.executeUpdate();
		if (rowsUpdated == 1) {
			authorizeStatus = "AUTHORIZED";
		}
		return authorizeStatus;
	}

	
	public boolean changeLoginStatus(CredentialsBean credentialsBean,
			int loginStatus) {
		boolean isloginStatusChanged = false;
		Session session = sessionfactory.getCurrentSession();
		Query query = session
				.createSQLQuery("update ATA_TBL_User_Credentials set Loginstatus=:status where userId=:id");
		query.setParameter("status", loginStatus);
		query.setParameter("id", credentialsBean.getUserID());
		int rowsUpdated = query.executeUpdate();
		if (rowsUpdated == 1) {
			isloginStatusChanged = true;
		}
		return isloginStatusChanged;
	}

	
	public String changePassword(CredentialsBean credentialsBean,
			String newPassword) {
		String changePasswordStatus="NOT CHANGED";
		Session session=sessionfactory.getCurrentSession();
		Query query=session.createQuery("from CredentialsBean where Userid=:id");
		query.setParameter("id",credentialsBean.getUserID());
		CredentialsBean bean=(CredentialsBean) query.list().get(0);
		if(bean.getPassword().equals(credentialsBean.getPassword()))
		{
		bean.setPassword(newPassword);
		session.update(bean);
		changePasswordStatus="CHANGED";
		}
		return changePasswordStatus;
		
		
	}

	
	public String login(CredentialsBean credentialsBean) {
		String UserType="";
		boolean isPasswordAvail=false;
		CredentialsBean cBean=null;
		String hqlAuthID = "from CredentialsBean where userID=:userID";
		Query queryAuthID = sessionfactory.getCurrentSession().createQuery(
				hqlAuthID);
		queryAuthID.setParameter("userID", credentialsBean.getUserID());
		if(queryAuthID.list().size()!=0)
		{
		 cBean=(CredentialsBean) queryAuthID.list().get(0);
		System.out.println("in dao"+cBean.getUserID());
		}

		if(cBean==null)
		{
			UserType="FAIL";
		}
		else
		{
		isPasswordAvail=authentication.authenticate(credentialsBean);
		if(isPasswordAvail==false)
		{
			UserType = "INVALID";
		}
		else
		{
			UserType=cBean.getUserType(); 
		}
		}
		
		
		return UserType;
		
	}

	
	public boolean logout(String userId) {
		Session session=sessionfactory.getCurrentSession();

		CredentialsBean credentialsBean=(CredentialsBean) session.get(CredentialsBean.class,userId);
		return changeLoginStatus(credentialsBean,0);
		
	}

	
	public String register(ProfileBean profileBean) {
		CredentialsBean credentialsBean=new CredentialsBean();
		credentialsBean.setUserID(profileBean.getFirstName().substring(0, 2).toUpperCase().concat(String.valueOf(getUserID())));
		credentialsBean.setPassword(profileBean.getPassword());
		credentialsBean.setUserType("C");
		credentialsBean.setLoginStatus(0);
		Session session = sessionfactory.getCurrentSession();
		session.save(credentialsBean);
		profileBean.setUserID(credentialsBean.getUserID());
		String userID= (String)session.save(profileBean);
		return userID;
		

	}
	@SuppressWarnings("deprecation")
	
	public long getUserID() {
		long key = 0L;
		Connection connection = sessionfactory.getCurrentSession().connection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt
					.executeQuery("select ATA_SEQ_USERID.nextval from dual");
			if (rs.next()) {
				key = Long.parseLong(rs.getString(1));

			}
		} catch (NumberFormatException eNumForm) {
			return 0;

		} catch (SQLException eSQL) {
			return 0;
		}
		return key;
	}


	@SuppressWarnings("unchecked")
	public boolean findByCardNumber(String userID, String cardNumber) {
		boolean isCardAvailable=false;
		Session session=sessionfactory.getCurrentSession();
		
		Query query=session.createSQLQuery("select CREDITCARDNUMBER from ATA_TBL_CREDITCARD where USERID=:id");
		query.setParameter("id",userID);
		
		
	List<String> credit=query.list();
	if(credit.size()>0)
	{
	if(cardNumber.equals(credit.get(0).toString()))
	{
	isCardAvailable=true;
	}
	}
return isCardAvailable;
	}

	public String processPayment(String cardNumber, double fare) {
		String paymentStatus="UNPAID";
		Session session=sessionfactory.getCurrentSession();
		Query fetchBalance=session.createSQLQuery("select CREDITBALANCE from ATA_TBL_CREDITCARD where CREDITCARDNUMBER=:number");
		fetchBalance.setParameter("number",cardNumber);
		double balance=Double.valueOf(fetchBalance.list().get(0).toString());
		if(balance>fare)
		{
		Query query=session.createSQLQuery("update ATA_TBL_CREDITCARD set CREDITBALANCE=:balance where CREDITCARDNUMBER=:number");
		query.setParameter("balance",balance-fare);
		query.setParameter("number",cardNumber);
		int updateCount=query.executeUpdate();
		if(updateCount==1)
		{
			paymentStatus="PAID";
		}
		}
		return paymentStatus;
	}


	
	
			
		


	

}
