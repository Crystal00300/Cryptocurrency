package com.Group1.CoinShell.model.Yiwen;
//package com.Group1.CoinShell.model;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class MembersDao {
//	
//	@Autowired
//	private SessionFactory factory;
//
//	public Members findByNameAndPassword(String eMail, String password) {
//		Session session = factory.getCurrentSession();
//		
//		String hql = "from Member m where m.memberName = :name and m.memberPwd = :pwd";
//		
//		try {
//			Members result = session.createQuery(hql, Members.class)
//					.setParameter("name", eMail)
//					.setParameter("pwd", password)
//					.getSingleResult();
//			if(result != null) {
//				return result;
//			}
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//		
//		return null;
//	}
//
//}
