package edu.monmouth.vehicle;

public class VehicleConstants {

	private VehicleConstants() {
    }
	
    public static final int MINENGINESIZE = 1;
    public static final int MAXENGINESIZE = 199;
    public static final int MINBOATLENGTH = 1;
    public static final int MAXBOATLENGTH = 1300;
    public static final int MINNUMSEAT = 1;
    public static final int MAXNUMSEAT = 1000;

    public static final String ENGINESIZEERROR = "Engine size must be between " + MINENGINESIZE + " and " + MAXENGINESIZE + ": ";
    public static final String BOATLENGTHERROR = "Boat length must be between " + MINBOATLENGTH + " and " + MAXBOATLENGTH + ": ";
    public static final String NUMSEATERROR = "Number of seat must be between " + MINNUMSEAT + " and " + MAXNUMSEAT + ": ";
    
    public static final String NULLPOWERSOURCE = "Power source must not be null";

}
