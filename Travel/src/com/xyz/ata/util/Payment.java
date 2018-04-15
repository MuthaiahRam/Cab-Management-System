package com.xyz.ata.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xyz.ata.dao.AtaUtilDAO;

@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class Payment {
@Autowired
AtaUtilDAO ataUtilDAO;
	@SuppressWarnings("unused")
	private String creditCardNumber,validFrom,validTO;
	@SuppressWarnings("unused")
	private double balance;
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public boolean findByCardNumber(String userID, String cardNumber)
	{
		return ataUtilDAO.findByCardNumber(userID, cardNumber);
		
		
		
		
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String process(String cardNumber,double fare)
	{
		return ataUtilDAO.processPayment(cardNumber, fare);
	}
}
