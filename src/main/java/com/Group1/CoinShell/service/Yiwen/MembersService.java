package com.Group1.CoinShell.service.Yiwen;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Group1.CoinShell.model.Yiwen.Members;
import com.Group1.CoinShell.model.Yiwen.MembersRepository;

@Service
public class MembersService {

	@Autowired
	private MembersRepository membersDao;

	public void insert(Members members) {
		membersDao.save(members);
	}
	
	public Members checkLogin(String eMail, String password) {
		Members tempMember = membersDao.findByEMailAndPassword(eMail, password);
				
		if(tempMember != null) {
			return tempMember;
		}
		return null;
	}
	
	public Members findById(Integer memId) {
		Optional<Members> option = membersDao.findById(memId);
		
		if(option.isPresent()) {
			return option.get();
		}
		return null;
	}
	
	public void deleteById(Integer memId) {
		membersDao.deleteById(memId);
	}
}

// findAllMembers, findByPage, getLatest 不會用到，略
