package com.smartmotors.ctre;

import com.ctre.phoenix6.configs.TalonFXConfiguration;

public class CTREConfiguration {
    /** The can id of the REV smart motor. */
    public int deviceNumber;

    /** The canbus used by the CTRE smart motor. */
    public String canbus = "";
    // TODO: Zavian - create a String and intialize to ""

    /** The TalonFXConfiguration used by the CTRE smart motor. */
    // TODO: Zavian - create a TalonFXConfiguration object and initialize to new TalonFXConfiguration().
    public TalonFXConfiguration config = new TalonFXConfiguration();


    
}
