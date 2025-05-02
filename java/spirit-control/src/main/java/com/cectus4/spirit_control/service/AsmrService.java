package com.cectus4.spirit_control.service;

import com.cectus4.spirit_control.model.Asmr;

import java.util.List;

public interface AsmrService {

    List<Asmr> getAsmr();
    Asmr saveAsmr(Asmr asmr);
    Asmr findAsmrById(long id);
}
