package com.example.substationeventreporting;

public class FeederModel {
    private String feederName;
    private boolean isFeederCharged;

    public FeederModel(String feederName, boolean isFeederCharged) {
        this.feederName = feederName;
        this.isFeederCharged = isFeederCharged;
    }

    public String getFeederName() {
        return feederName;
    }

    public void setFeederName(String feederName) {
        this.feederName = feederName;
    }

    public boolean isFeederCharged() {
        return isFeederCharged;
    }

    public void setFeederCharged(boolean feederCharged) {
        isFeederCharged = feederCharged;
    }
}
