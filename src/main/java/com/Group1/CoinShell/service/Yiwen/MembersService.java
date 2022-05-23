package com.Group1.CoinShell.service.Yiwen;
//package com.Group1.CoinShell.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.Group1.CoinShell.model.Members;
//import com.Group1.CoinShell.model.MembersDao;
//
//
//
//@Service
//@Transactional
//public class MembersService {
//	
//	@Autowired
//	private MembersDao dao;
//	
//	public MembersService() {
//		this.dao = new MembersDao();
//	}
//	
//	public Members checkLogin(String eMail, String password) {
//		Members tempMember = dao.findByNameAndPassword(eMail, password);
//		
//		if(tempMember != null) {
//			return tempMember;
//		}
//		return null;
//		
//	}
//
//}
