package com.cectus4.spirit_control.repository;

import com.cectus4.spirit_control.model.EmoStatistics;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryEmoStatisticsDAO {

    private final List<EmoStatistics> EMOSTATISTICS = new ArrayList<EmoStatistics>();

    public List<EmoStatistics> getEmoStatistics() {
        return EMOSTATISTICS;
    }

    public EmoStatistics saveEmoStatistics(EmoStatistics emoStatistics) {
        EMOSTATISTICS.add(emoStatistics);
        return emoStatistics;
    }

    public EmoStatistics findEmoStatisticsById(long id) {
        return EMOSTATISTICS.stream().filter(emoStatistic -> emoStatistic.getId() == id).findFirst().orElse(null);
    }

    public List<EmoStatistics> findEmoStatisticsByUserId(long userId) {
        return EMOSTATISTICS.stream().filter(emoStatistics -> emoStatistics.getUserId()==userId).toList();
    }

}
