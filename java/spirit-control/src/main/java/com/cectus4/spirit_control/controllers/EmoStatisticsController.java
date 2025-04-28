package com.cectus4.spirit_control.controllers;

import com.cectus4.spirit_control.model.EmoStatistics;
import com.cectus4.spirit_control.service.EmoStatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/spirit/emo-statistics")
@AllArgsConstructor
public class EmoStatisticsController {

    private final EmoStatisticsService emoStatisticsService;

    @GetMapping()
    public List<EmoStatistics> getEmoStatistics() {
        return emoStatisticsService.getEmoStatistics();
    }

    @PostMapping("save")
    public String saveEmoStatistics(@RequestBody EmoStatistics emoStatistics) {
        emoStatisticsService.saveEmoStatistics(emoStatistics);
        return "success";
    }

    @GetMapping("find-by-id/{id}")
    public EmoStatistics getEmoStatisticsById(@PathVariable long id) {
        return emoStatisticsService.findEmoStatisticsById(id);
    }

    @GetMapping("find-by-user-id/{userId}")
    public List<EmoStatistics> getEmoStatisticsByUserId(@PathVariable long userId) {
        return emoStatisticsService.findEmoStatisticsByUserId(userId);
    }

}
