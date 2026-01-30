package com.teamgold.goldenharvestmasterdata.master.command.infrastucture.mater;

import com.teamgold.goldenharvestmasterdata.master.command.domain.master.Variety;
import com.teamgold.goldenharvestmasterdata.master.command.domain.master.VarietyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VarietyRepository extends JpaRepository<Variety, VarietyId> {
}
