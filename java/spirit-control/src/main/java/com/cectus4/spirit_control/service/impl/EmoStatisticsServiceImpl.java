package com.cectus4.spirit_control.service.impl;

import com.cectus4.spirit_control.model.EmoStatistics;
import com.cectus4.spirit_control.repository.EmoStatisticsRepository;
import com.cectus4.spirit_control.service.EmoStatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class EmoStatisticsServiceImpl implements EmoStatisticsService {

    private final EmoStatisticsRepository emoStatisticsRepository;

    @Override
    public List<EmoStatistics> getEmoStatistics() {
        return emoStatisticsRepository.findAll();
    }

    @Override
    public EmoStatistics saveEmoStatistics(EmoStatistics emoStatistics) {
        return emoStatisticsRepository.save(emoStatistics);
    }

    @Override
    public EmoStatistics findEmoStatisticsById(long id) {
        return emoStatisticsRepository.findEmoStatisticsById(id);
    }

    @Override
    public List<EmoStatistics> findEmoStatisticsByUserId(long userId) {
        return emoStatisticsRepository.findEmoStatisticsByUserId(userId);
    }

}
