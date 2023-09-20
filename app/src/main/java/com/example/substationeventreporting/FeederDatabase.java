package com.example.substationeventreporting;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FeederDatabase extends Application {
    private List<FeederModel> feeders;
    
    public FeederDatabase() {
        feeders = new ArrayList<>();
        feeders.add(FeederModel.builder().feederId("3921").substationOfficeId("3412100").feederName("Feeder No 1").energyMeterNo("WEB19001").voltageLevel(11).feederType(FeederType.OUTGOING_11kV).incoming11kVFeederId("392K").feedingPTRId("392O").feeding33kVFeederId("392Y").isCharged(true).isLoaded(true).build());
        feeders.add(FeederModel.builder().feederId("3922").substationOfficeId("3412100").feederName("Feeder No 2").energyMeterNo("WEB19002").voltageLevel(11).feederType(FeederType.OUTGOING_11kV).incoming11kVFeederId("392K").feedingPTRId("392O").feeding33kVFeederId("392Y").isCharged(true).isLoaded(true).build());
        feeders.add(FeederModel.builder().feederId("3923").substationOfficeId("3412100").feederName("Feeder No 3").energyMeterNo("WEB19003").voltageLevel(11).feederType(FeederType.OUTGOING_11kV).incoming11kVFeederId("392J").feedingPTRId("392N").feeding33kVFeederId("392Y").isCharged(true).isLoaded(true).build());
        feeders.add(FeederModel.builder().feederId("3924").substationOfficeId("3412100").feederName("Feeder No 4").energyMeterNo("WEB19004").voltageLevel(11).feederType(FeederType.OUTGOING_11kV).incoming11kVFeederId("392I").feedingPTRId("392M").feeding33kVFeederId("392Y").isCharged(true).isLoaded(false).build());
        feeders.add(FeederModel.builder().feederId("3926").substationOfficeId("3412100").feederName("Feeder No 5").energyMeterNo("WEB19005").voltageLevel(11).feederType(FeederType.OUTGOING_11kV).incoming11kVFeederId("392I").feedingPTRId("392M").feeding33kVFeederId("392Y").isCharged(true).isLoaded(true).build());
        feeders.add(FeederModel.builder().feederId("3927").substationOfficeId("3412100").feederName("Feeder No 7").energyMeterNo("WEB19006").voltageLevel(11).feederType(FeederType.OUTGOING_11kV).incoming11kVFeederId("392J").feedingPTRId("392N").feeding33kVFeederId("392Y").isCharged(true).isLoaded(true).build());
        feeders.add(FeederModel.builder().feederId("3928").substationOfficeId("3412100").feederName("Colony").energyMeterNo("WEB19007").voltageLevel(11).feederType(FeederType.OUTGOING_11kV).incoming11kVFeederId("392K").feedingPTRId("392O").feeding33kVFeederId("392Y").isCharged(true).isLoaded(true).build());
        feeders.add(FeederModel.builder().feederId("3929").substationOfficeId("3412100").feederName("Panitanki").energyMeterNo("WEB19008").voltageLevel(11).feederType(FeederType.OUTGOING_11kV).incoming11kVFeederId("392H").feedingPTRId("392L").feeding33kVFeederId("392Y").isCharged(true).isLoaded(true).build());
        feeders.add(FeederModel.builder().feederId("392A").substationOfficeId("3412100").feederName("Patheswari").energyMeterNo("WEB19009").voltageLevel(11).feederType(FeederType.OUTGOING_11kV).incoming11kVFeederId("392H").feedingPTRId("392L").feeding33kVFeederId("392Y").isCharged(true).isLoaded(true).build());
        feeders.add(FeederModel.builder().feederId("392B").substationOfficeId("3412100").feederName("Checkpost").energyMeterNo("WEB19010").voltageLevel(11).feederType(FeederType.OUTGOING_11kV).incoming11kVFeederId("392H").feedingPTRId("392L").feeding33kVFeederId("392Y").isCharged(true).isLoaded(true).build());
        feeders.add(FeederModel.builder().feederId("392C").substationOfficeId("3412100").feederName("ISKCON Road").energyMeterNo("WEB19011").voltageLevel(11).feederType(FeederType.OUTGOING_11kV).incoming11kVFeederId("392H").feedingPTRId("392L").feeding33kVFeederId("392Y").isCharged(true).isLoaded(true).build());
        feeders.add(FeederModel.builder().feederId("392D").substationOfficeId("3412100").feederName("Pareshnagar").energyMeterNo("WEB19012").voltageLevel(11).feederType(FeederType.OUTGOING_11kV).incoming11kVFeederId("392H").feedingPTRId("392L").feeding33kVFeederId("392Y").isCharged(true).isLoaded(true).build());
        feeders.add(FeederModel.builder().feederId("392E").substationOfficeId("3412100").feederName("Jyotinagar").energyMeterNo("WEB19013").voltageLevel(11).feederType(FeederType.OUTGOING_11kV).incoming11kVFeederId("392K").feedingPTRId("392O").feeding33kVFeederId("392Y").isCharged(true).isLoaded(true).build());
        feeders.add(FeederModel.builder().feederId("392F").substationOfficeId("3412100").feederName("Mahakalpally").energyMeterNo("WEB19014").voltageLevel(11).feederType(FeederType.OUTGOING_11kV).incoming11kVFeederId("392J").feedingPTRId("392N").feeding33kVFeederId("392Y").isCharged(true).isLoaded(true).build());
        feeders.add(FeederModel.builder().feederId("392G").substationOfficeId("3412100").feederName("North City").energyMeterNo("WEB19015").voltageLevel(11).feederType(FeederType.OUTGOING_11kV).incoming11kVFeederId("392I").feedingPTRId("392M").feeding33kVFeederId("392Y").isCharged(true).isLoaded(true).build());
        feeders.add(FeederModel.builder().feederId("392H").substationOfficeId("3412100").feederName("Incomer 1").energyMeterNo("WEB19016").voltageLevel(11).feederType(FeederType.INCOMING_11kV).incoming11kVFeederId(null).feedingPTRId("392L").feeding33kVFeederId("392Y").isCharged(true).isLoaded(true).build());
        feeders.add(FeederModel.builder().feederId("392I").substationOfficeId("3412100").feederName("Incomer 2").energyMeterNo("WEB19017").voltageLevel(11).feederType(FeederType.INCOMING_11kV).incoming11kVFeederId(null).feedingPTRId("392M").feeding33kVFeederId("392Y").isCharged(true).isLoaded(true).build());
        feeders.add(FeederModel.builder().feederId("392J").substationOfficeId("3412100").feederName("Incomer 3").energyMeterNo("WEB19018").voltageLevel(11).feederType(FeederType.INCOMING_11kV).incoming11kVFeederId(null).feedingPTRId("392N").feeding33kVFeederId("392Y").isCharged(true).isLoaded(true).build());
        feeders.add(FeederModel.builder().feederId("392K").substationOfficeId("3412100").feederName("Incomer 4").energyMeterNo("WEB19019").voltageLevel(11).feederType(FeederType.INCOMING_11kV).incoming11kVFeederId(null).feedingPTRId("392O").feeding33kVFeederId("392Y").isCharged(true).isLoaded(true).build());
        feeders.add(FeederModel.builder().feederId("392L").substationOfficeId("3412100").feederName("PTR1").energyMeterNo("WEB19023").voltageLevel(33).feederType(FeederType.PTR_BAY).incoming11kVFeederId(null).feedingPTRId(null).feeding33kVFeederId("392Y").isCharged(true).isLoaded(true).build());
        feeders.add(FeederModel.builder().feederId("392M").substationOfficeId("3412100").feederName("PTR2").energyMeterNo("WEB19024").voltageLevel(33).feederType(FeederType.PTR_BAY).incoming11kVFeederId(null).feedingPTRId(null).feeding33kVFeederId("392Y").isCharged(true).isLoaded(true).build());
        feeders.add(FeederModel.builder().feederId("392N").substationOfficeId("3412100").feederName("PTR3").energyMeterNo("WEB19025").voltageLevel(33).feederType(FeederType.PTR_BAY).incoming11kVFeederId(null).feedingPTRId(null).feeding33kVFeederId("392Y").isCharged(true).isLoaded(true).build());
        feeders.add(FeederModel.builder().feederId("392O").substationOfficeId("3412100").feederName("PTR4").energyMeterNo("WEB19026").voltageLevel(33).feederType(FeederType.PTR_BAY).incoming11kVFeederId(null).feedingPTRId(null).feeding33kVFeederId("392Y").isCharged(true).isLoaded(true).build());
        feeders.add(FeederModel.builder().feederId("392X").substationOfficeId("3412100").feederName("Siliguri Ckt 1").energyMeterNo("WEB19020").voltageLevel(33).feederType(FeederType.INCOMING_33kV).incoming11kVFeederId(null).feedingPTRId(null).feeding33kVFeederId(null).isCharged(true).isLoaded(false).build());
        feeders.add(FeederModel.builder().feederId("392Y").substationOfficeId("3412100").feederName("Siliguri Ckt 2").energyMeterNo("WEB19021").voltageLevel(33).feederType(FeederType.INCOMING_33kV).incoming11kVFeederId(null).feedingPTRId(null).feeding33kVFeederId(null).isCharged(true).isLoaded(true).build());
        feeders.add(FeederModel.builder().feederId("392W").substationOfficeId("3412100").feederName("Gangadhar").energyMeterNo("WEB19027").voltageLevel(33).feederType(FeederType.INCOMING_33kV).incoming11kVFeederId(null).feedingPTRId(null).feeding33kVFeederId(null).isCharged(true).isLoaded(false).build());
        feeders.add(FeederModel.builder().feederId("392Z").substationOfficeId("3412100").feederName("Housing Ckt 1").energyMeterNo("WEB19022").voltageLevel(33).feederType(FeederType.OUTGOING_33kV).incoming11kVFeederId(null).feedingPTRId(null).feeding33kVFeederId(null).isCharged(true).isLoaded(false).build());
    }

    public List<FeederModel> getFeeders() {
        return feeders;
    }

    public List<FeederModel> getLoadedIncomingSources() {
        return feeders.stream().filter(feederModel ->
                feederModel.getIsLoaded() && feederModel.getFeederType() == FeederType.INCOMING_33kV)
                .collect(Collectors.toList());
    }

    public List<FeederModel> getAllIncomingSources() {
        return feeders.stream().filter(feederModel -> feederModel.getFeederType() == FeederType.INCOMING_33kV)
                .collect(Collectors.toList());
    }

    public List<FeederModel> getPTRsFedByIncomingSource(String feederId) {
        return feeders.stream().filter(feederModel ->
                feederModel.getFeederType() == FeederType.PTR_BAY
                        && feederModel.getFeeding33kVFeederId().equals(feederId))
                .collect(Collectors.toList());
    }

    public String getFeederIdFromName(String feederName) {
        return feeders.stream().
                filter(feederModel -> feederModel.getFeederName().equals(feederName))
                .collect(Collectors.toList()).get(0).getFeederId();
    }

}
