package com.camping.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CampingMainController {
	
	private final MyService myService;

    @Autowired
    public CampingMainController(MyService myService) {
        this.myService = myService;
    }
	
	@GetMapping("/main_sel_rank_region_search")
	public List<Map<String,Object>> hi1() {
		

		List<Map<String,Object>> list = myService.getTop10Region();
		return list;
	}
	
	@GetMapping("/main_sel_rank_camping_XY")
	public String hi() {
		return "엣다좌표";
	}
	
}
