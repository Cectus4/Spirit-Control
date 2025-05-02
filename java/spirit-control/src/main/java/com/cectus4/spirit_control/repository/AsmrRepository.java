package com.cectus4.spirit_control.repository;

import com.cectus4.spirit_control.model.Asmr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsmrRepository extends JpaRepository<Asmr, Long> {

    Asmr findAsmrById(long id);

}
