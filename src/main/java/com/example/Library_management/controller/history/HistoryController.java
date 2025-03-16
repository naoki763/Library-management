package com.example.Library_management.controller.history;

import com.example.Library_management.model.history.History;
import com.example.Library_management.model.history.HistoryResponseDTO;
import com.example.Library_management.service.history.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/loans")
public class HistoryController {
    private final HistoryService historyService;

    @Autowired
    public HistoryController(HistoryService historyService){
        this.historyService = historyService;
    }

    public  getHistoryAll(){

    }


}
