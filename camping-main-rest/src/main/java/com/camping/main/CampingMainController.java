package com.camping.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CampingMainController {

	@GetMapping("/main_sel_rank_region_search")
	public String hi1() {
		return "Rank1~10";
	}
	
	@GetMapping("/main_sel_rank_camping_XY")
	public String hi() {
		return "엣다좌표";
	}
}
