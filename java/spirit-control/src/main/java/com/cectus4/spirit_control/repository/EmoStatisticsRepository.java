package com.cectus4.spirit_control.repository;

import com.cectus4.spirit_control.model.EmoStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EmoStatisticsRepository extends JpaRepository<EmoStatistics, Long> {

    List<EmoStatistics> findEmoStatisticsByUserId(long userId);
    EmoStatistics findEmoStatisticsById(long id);
}