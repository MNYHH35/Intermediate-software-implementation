package com.example.movieplanet.controller;


import com.example.movieplanet.dao.HistoryRepository;
import com.example.movieplanet.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/history")
public class HistoryController {

    @Autowired
    private HistoryRepository historyRepository;

    @PostMapping("/addHistoryRecord")
    public ResponseEntity<String> addHistoryRecord(@RequestBody History history) {
        // 直接使用 History 对象进行保存
        historyRepository.save(history);

        return ResponseEntity.ok("History record added successfully.");
    }
}

