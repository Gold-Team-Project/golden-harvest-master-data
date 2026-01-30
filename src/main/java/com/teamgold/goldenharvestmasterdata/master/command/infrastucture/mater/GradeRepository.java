package com.teamgold.goldenharvestmasterdata.master.command.infrastucture.mater;

import com.teamgold.goldenharvestmasterdata.master.command.domain.master.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GradeRepository extends JpaRepository<Grade, String> {
    Optional<Grade> findByGradeCode(String gradeCode);

}

