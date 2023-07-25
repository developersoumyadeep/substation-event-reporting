package com.example.substationeventreporting;

import java.io.Serializable;

public class FeederModel implements Serializable {
    private String feederName;
    private boolean isFeederCharged;
    private FeederType feederType;

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
