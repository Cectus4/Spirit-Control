package com.cectus4.spirit_control.service.impl;

import com.cectus4.spirit_control.model.Asmr;
import com.cectus4.spirit_control.repository.InMemoryAsmrDAO;
import com.cectus4.spirit_control.service.AsmrService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryAsmrService implements AsmrService {

    InMemoryAsmrDAO inMemoryAsmrDAO;

    @Override
    public List<Asmr> getAsmr() {
        return inMemoryAsmrDAO.getAsmr();
    }

    @Override
    public Asmr saveAsmr(Asmr asmr) {
        return inMemoryAsmrDAO.saveAsmr(asmr);
    }

    @Override
    public Asmr findAsmrById(long id) {
        return inMemoryAsmrDAO.findAsmrById(id);
    }
}
