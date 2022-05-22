package com.Group1.CoinShell.controller.Pieterzite;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Group1.CoinShell.model.Pieterzite.SignInList;
import com.Group1.CoinShell.model.Pieterzite.StatusList;
import com.Group1.CoinShell.service.Pieterzite.SignInListService;


@Controller
public class SignInListController {

	@Autowired
	private SignInListService service;

	@GetMapping("/SignInListGetCoin")
	public String GetCoin(@RequestParam("id") int GetCoin) {

//		parse -->字串轉成時間, 格式:yyyy-MM-dd HH:mm:ss
//		Date nowdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2004-03-26 13:31:40");

		Date nowTime = new Date(); // nt = 這次時間 (now time)
		SignInList lastCheckinTime = service.findById(GetCoin); // lt = 上次時間 (last time)

		if (lastCheckinTime == null) { // 第一次簽到 //沒有上次的簽到記錄
			SignInList newSignInList = new SignInList(); // nsignInList = new signInList //建立新的list裝載簽到後的資料
			newSignInList.setId(GetCoin);
			newSignInList.setSign_in_time(nowTime);
			newSignInList.setStatus(1); //第一天
			
			new SignInListService().save(newSignInList);
			
			
		} else { // 不是第一次簽到
			long i = nowTime.getTime() - lastCheckinTime.getSign_in_time().getTime(); // 現在的時間 - 上次的時間
			long oneDay = i / 1000 / 60 / 60 / 24; // 最小單位毫秒 //1秒=1000毫秒, 一分鐘60秒, 一小時60分鐘, 一天24小時

			if (oneDay < 1) { //簽到完還沒達到一天 
				StatusList days = new StatusList(); 
				days.getCoin();
				
			} else if (oneDay > 1 && oneDay < 2) { 
				SignInList nsignInList = new SignInList();
				lastCheckinTime.setStatus(lastCheckinTime.getStatus()+1); // 連續簽到的天數 // lt = 上次的簽到的時間, +1 = 今天的時間
				
				StatusList days = new StatusList(); 
				days.getCoin();
				
				
			} else if (oneDay > 2) { //超過兩天沒有簽到 = 沒有連續簽到
				SignInList nsignInList = new SignInList();
				lastCheckinTime.setStatus(1); 
				StatusList days = new StatusList(); 
				days.getCoin();
				
//				SignInList nsignInList = new SignInList();
//				Integer continuiteDay = nsignInList.getStatus(); // continuiteDay = 連續天數
//				continuiteDay = 1;
//				nsignInList.setStatus(continuiteDay);
//				new SignInListService().save(nsignInList);
//
//				int coin = new StatusListService().findById(continuiteDay);
			}
		}
		return "getCoinbutton";
	}
	@GetMapping("/findlogindaysById")
	@ResponseBody
	public List<Map<String,Object>> findlogindaysById(@RequestParam("id")Integer id){
		List<Map<String, Object>> findlogindaysById = service.findlogindaysById(id);
		return findlogindaysById;
	}

}
