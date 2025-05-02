package com.cectus4.spirit_control.service.impl;


import com.cectus4.spirit_control.model.Asmr;
import com.cectus4.spirit_control.repository.AsmrRepository;
import com.cectus4.spirit_control.service.AsmrService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class AsmrServiceImpl implements AsmrService {
    private final AsmrRepository asmrRepository;

    @Override
    public List<Asmr> getAsmr() {
        return asmrRepository.findAll();
    }

    @Override
    public Asmr saveAsmr(Asmr asmr) {
        return asmrRepository.save(asmr);
    }

    @Override
    public Asmr findAsmrById(long id) {
        return asmrRepository.findAsmrById(id);
    }
}
