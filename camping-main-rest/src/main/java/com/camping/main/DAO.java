package com.camping.main;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DAO {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public DAO(JdbcTemplate jdbcTemplate) {
    	this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Map<String, Object>> getAllData() {
        String sql = "SELECT * FROM TEMP_CAMP "; // 여기에 적절한 테이블 이름을 넣어주세요
        
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        System.out.println("하이");
        System.out.println(rows);
        for (Map<String, Object> row : rows) {
            for (Map.Entry<String, Object> entry : row.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                System.out.printf("%s = %s, ", key, value);
            }
            System.out.println(); // 각 행의 끝을 나타내기 위해 개행
        }
        
        return jdbcTemplate.queryForList(sql);
        
    }

	public List<Map<String, Object>> getTop10Region() {
		String sql = 
				"SELECT region_name "
				+ " FROM ("
				+ " SELECT r.region_name, SUM(sc.search_count) AS total_search_count"
				+ " FROM Regions r JOIN SearchCounts sc ON r.region_id = sc.region_id"
				+ " GROUP BY r.region_name"
				+ " ORDER BY total_search_count DESC"
				+ ")"
				+ " WHERE ROWNUM <= 10"; // 여기에 적절한 테이블 이름을 넣어주세요
        
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        System.out.println("하이");
        System.out.println(rows);
        for (Map<String, Object> row : rows) {
            for (Map.Entry<String, Object> entry : row.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                System.out.printf("%s = %s, ", key, value);
            }
            System.out.println(); // 각 행의 끝을 나타내기 위해 개행
        }
        
        return jdbcTemplate.queryForList(sql);
	}
}
