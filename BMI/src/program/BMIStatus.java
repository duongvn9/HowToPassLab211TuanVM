/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program;

/**
 *
 * @author pc
 */
public enum BMIStatus {
    UNDERSTANDARD("UNDER STANDARD"),
    STANDARD("STANDARD"),
    OVERWEIGHT("OVER WEIGHT"),
    FAT("FAT - SHOULD LOSE WEIGHT"),
    VERYFAT("VERY FAT - SHOULD LOSE WEIGHT IMMEDIATELY");

    private final String bmiStatus;

    BMIStatus(String bmiStatus) {
        this.bmiStatus = bmiStatus;
    }

    public String getBmiStatus() {
        return bmiStatus;
    }
}
