package com.example.Library_management.repository.history;

import com.example.Library_management.model.history.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
