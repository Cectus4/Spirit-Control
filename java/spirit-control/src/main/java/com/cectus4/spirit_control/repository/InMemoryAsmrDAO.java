package com.cectus4.spirit_control.repository;

import com.cectus4.spirit_control.model.Asmr;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryAsmrDAO {

    private final List<Asmr> ASMRS = new ArrayList<Asmr>();

    public List<Asmr> getAsmr() {
        return ASMRS;
    }

    public Asmr saveAsmr(Asmr asmr) {
        ASMRS.add(asmr);
        return asmr;
    }

    public Asmr findAsmrById(long id) {
        return ASMRS.stream().filter(asmr -> asmr.getId() == id).findFirst().orElse(null);
    }
}
