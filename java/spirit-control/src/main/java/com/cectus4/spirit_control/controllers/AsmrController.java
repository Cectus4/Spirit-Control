package com.cectus4.spirit_control.controllers;

import com.cectus4.spirit_control.model.Asmr;
import com.cectus4.spirit_control.model.EmoStatistics;
import com.cectus4.spirit_control.service.AsmrService;
import com.cectus4.spirit_control.service.EmoStatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/spirit/asmr")
@AllArgsConstructor
public class AsmrController {

    private final AsmrService asmrService;

    @GetMapping()
    public List<Asmr> getAsmr() {
        return asmrService.getAsmr();
    }

    @PostMapping("save")
    public String saveAsmr(@RequestBody Asmr asmr) {
        asmrService.saveAsmr(asmr);
        return "success";
    }

    @GetMapping("find-by-id/{id}")
    public Asmr getAsmrById(@PathVariable long id) {
        return asmrService.findAsmrById(id);
    }
}
