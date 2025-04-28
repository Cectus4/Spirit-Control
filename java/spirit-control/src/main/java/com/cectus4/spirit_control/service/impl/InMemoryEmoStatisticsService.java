package com.cectus4.spirit_control.service.impl;

import com.cectus4.spirit_control.model.EmoStatistics;
import com.cectus4.spirit_control.repository.InMemoryEmoStatisticsDAO;
import com.cectus4.spirit_control.service.EmoStatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryEmoStatisticsService implements EmoStatisticsService {

    InMemoryEmoStatisticsDAO inMemoryEmoStatisticsDAO;


    @Override
    public List<EmoStatistics> getEmoStatistics() {
        return inMemoryEmoStatisticsDAO.getEmoStatistics();
    }

    @Override
    public EmoStatistics saveEmoStatistics(EmoStatistics emoStatistics) {
        return inMemoryEmoStatisticsDAO.saveEmoStatistics(emoStatistics);
    }

    @Override
    public EmoStatistics findEmoStatisticsById(long id) {
        return inMemoryEmoStatisticsDAO.findEmoStatisticsById(id);
    }

    @Override
    public List<EmoStatistics> findEmoStatisticsByUserId(long userId) {
        return inMemoryEmoStatisticsDAO.findEmoStatisticsByUserId(userId);
    }

}
