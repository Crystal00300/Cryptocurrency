package com.Group1.CoinShell.controller.Hoxton;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Group1.CoinShell.model.Hoxton.Commodity;

@Controller
@RequestMapping("/administrator")
public class backendPageController {

	//這個class都是用來控制後臺頁面跳轉的地方
	@GetMapping("/store")
	public String changePageInsertCommodity() {
		return "backend/store/administrator-store";
	}
	
	@GetMapping("store/addCommodity")
	public String changePageAddCommodity() {
		return "backend/store/addCommodity";
	}
	
	@GetMapping("store/deleteCommodity")
	public String changePageDeleteCommodity() {
		return "backend/store/deleteCommodity";
	}
	
	@GetMapping("store/findCommodity")
	public String changePageFindCommodity() {
		return "backend/store/findCommodity";
	}
	
	@GetMapping("store/updateCommodity")
	public String changePageUpdateCommodity() {
		return "backend/store/updateCommodity";
	}
	
}
