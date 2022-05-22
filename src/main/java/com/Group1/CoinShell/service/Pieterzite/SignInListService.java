package com.Group1.CoinShell.service.Pieterzite;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Group1.CoinShell.model.Pieterzite.SignInList;
import com.Group1.CoinShell.model.Pieterzite.SignInListDao;


@Service
@Transactional
public class SignInListService {

	@Autowired
	private SignInListDao dao;
	
	// 保存簽到資料
	public void save(SignInList sil) { 
		dao.save(sil); // sil = SignInList
	}
	
	// 利用ID找到使用者,得到簽到時間
	public SignInList findById(Integer id) { 
		Optional<SignInList> time = dao.findById(id);
		
		if(time.isPresent()) {
			SignInList signInList = time.get();
			return signInList;
		}
		return null;
	}
	// 確認登入天數
	public SignInList findBysignIndays(Integer signIndays) {
		Optional<SignInList> days = dao.findById(signIndays);
		
		if(days.isPresent()) {
			SignInList signInList = days.get();
			return signInList;
		}
		return null;
	}
	// 從ID找到使用者狀態
	public SignInList findBystatus(Integer status) {
		Optional<SignInList> st = dao.findById(status);
		
		if(st.isPresent()) {
			SignInList signInList = st.get();
			return signInList;
		}
		return null;
	}

	// 0520 補
	public SignInList save(Integer nsignInList) {
		Optional<SignInList> ns = dao.findById(nsignInList);
		
		if (ns.isPresent()) {
			SignInList signInList = ns.get();
			return signInList;
		}
		return null;
	}
	public List<Map<String,Object>> findlogindaysById(Integer id){
		List<Map<String, Object>> findlogindaysById = dao.findlogindaysById(id);
		return findlogindaysById;
	}
	
}

