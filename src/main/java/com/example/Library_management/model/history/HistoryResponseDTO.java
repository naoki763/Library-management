package com.example.Library_management.model.history;

import lombok.Data;


import java.time.LocalDateTime;


@Data
public class HistoryResponseDTO {
    private Long user_id;
    private Long book_id;
    private LocalDateTime create_at;

    public HistoryResponseDTO(Long user_id, Long book_id, LocalDateTime create_at){
        this.user_id = user_id;
        this.book_id = book_id;
        this.create_at =create_at;
    }
}
