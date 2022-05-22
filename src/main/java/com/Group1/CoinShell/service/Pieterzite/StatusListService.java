package com.Group1.CoinShell.service.Pieterzite;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Group1.CoinShell.model.Pieterzite.StatusList;
import com.Group1.CoinShell.model.Pieterzite.StatusListDao;



@Service
@Transactional
public class StatusListService {

	@Autowired
	private StatusListDao dao;

	public void save(StatusList stl) {
		dao.save(stl); // stl = StatusList
	}
	// 在狀態列表中找到對應登入天數
	public Integer findById(Integer days) {
		Optional<StatusList> d = dao.findById(days);

		if (d.isPresent()) {
			StatusList statusList = d.get();
			return statusList.getCoin();
		}
		return null;
	}
	
}
