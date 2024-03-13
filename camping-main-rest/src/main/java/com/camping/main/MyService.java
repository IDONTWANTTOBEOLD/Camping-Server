package com.camping.main;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private final DAO myRepository;

    @Autowired
    public MyService(DAO myRepository) {
        this.myRepository = myRepository;
    }

    public List<Map<String, Object>> doSomeDatabaseOperation() {
        return myRepository.getAllData();
        // 다른 데이터베이스 작업들을 수행할 수 있습니다.
    }
}