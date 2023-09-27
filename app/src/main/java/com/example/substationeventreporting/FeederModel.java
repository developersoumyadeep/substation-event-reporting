package com.example.substationeventreporting;

import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeederModel implements Serializable {
    private String feederId;
    private String feederName;
    private String substationOfficeId;
    private String energyMeterNo;
    private Integer voltageLevel;
    private FeederType feederType;
    private String incoming11kVFeederId;
    private String feedingPTRId;
    private String feeding33kVFeederId;
    private Boolean isCharged;
    private Boolean isLoaded;

}
