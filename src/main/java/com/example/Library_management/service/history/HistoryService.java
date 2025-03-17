//package com.example.Library_management.service.history;
//
//import com.example.Library_management.model.history.History;
//import com.example.Library_management.model.history.HistoryFormDTO;
//import com.example.Library_management.model.history.HistoryResponseDTO;
//import com.example.Library_management.repository.books.BookRepository;
//import com.example.Library_management.repository.history.HistoryRepository;
//import com.example.Library_management.repository.users.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.List;
//
//@Service
//public class HistoryService {
//    private final HistoryRepository historyRepository;
//    private final UserRepository userRepository;
//    private final BookRepository bookRepository;
//
//    @Autowired
//    public HistoryService(HistoryRepository historyRepository,
//                          UserRepository userRepository,
//                          BookRepository bookRepository)
//    {
//        this.historyRepository = historyRepository;
//        this.userRepository = userRepository;
//        this.bookRepository = bookRepository;
//    }
//    // 貸出履歴を生成
//    public HistoryResponseDTO createHistory(
//            @RequestBody HistoryFormDTO historyFormDTO)
//    {
//        History history = new History();
//        history.setUser_id(historyFormDTO.getUser_id());
//        history.setBook_id(historyFormDTO.getBook_id());
//
//        History saveHistory = historyRepository.save(history);
//
//        return convertToDTO(saveHistory);
//    }
//
//    //HistoryクラスをDTOクラスにコンバート
//    public HistoryResponseDTO convertToDTO(History history){
//        return new HistoryResponseDTO(
//                history.getUser_id(),
//                history.getBook_id(),
//                history.getCreate_at());
//    }
//
//
//
//}
