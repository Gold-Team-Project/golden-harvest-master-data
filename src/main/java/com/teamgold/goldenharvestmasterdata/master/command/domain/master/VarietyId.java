package com.teamgold.goldenharvestmasterdata.master.command.domain.master;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class VarietyId implements Serializable {
    private String produceMaster;
    private String varietyCode;
}