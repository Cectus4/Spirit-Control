package com.cectus4.spirit_control.service;

import com.cectus4.spirit_control.model.EmoStatistics;

import java.time.LocalDate;
import java.util.List;

public interface EmoStatisticsService {

    List<EmoStatistics> getEmoStatistics();
    EmoStatistics saveEmoStatistics(EmoStatistics emoStatistics);
    EmoStatistics findEmoStatisticsById(long id);
    List<EmoStatistics> findEmoStatisticsByUserId(long userId);

}
