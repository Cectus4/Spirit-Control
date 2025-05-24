package com.cectus4.spirit_control.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.write.style.HeadStyle;
import jakarta.persistence.*;
import lombok.Data;
import com.alibaba.excel.enums.poi.FillPatternTypeEnum;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "\"emostatistics\"")
public class EmoStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ExcelIgnore
    private long id;
    @Column(nullable = false)
    @ExcelIgnore
    private long userId;
    @Column(nullable = false, length = 1024)
    @ExcelProperty("Эмоция")
    @HeadStyle(fillPatternType = FillPatternTypeEnum.SOLID_FOREGROUND, fillForegroundColor = 9)
    private String emoDict;
    @ExcelProperty("Дата")
    @Column(nullable = false)
    @HeadStyle(fillPatternType = FillPatternTypeEnum.SOLID_FOREGROUND, fillForegroundColor = 9)
    private LocalDate date;
}
