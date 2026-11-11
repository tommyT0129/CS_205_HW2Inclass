package edu.monmouth.vehicle;

public class Plane implements Vehicle {
    private int numSeat;
    private PowerTypes powerSource;

    public Plane(PowerTypes powerSource, int seat) throws PlaneException {
        setPowerSource(powerSource);
        setNumSeat(seat);
    }

    public int getNumSeat() {
        return numSeat;
    }

    public void setNumSeat(int numSeat) throws PlaneException {
        if (numSeat < VehicleConstants.MINNUMSEAT || numSeat > VehicleConstants.MAXNUMSEAT) {
            throw new PlaneException(VehicleConstants.NUMSEATERROR + numSeat);
        }
        this.numSeat = numSeat;
    }

    public PowerTypes getPowerSource() {
    	return powerSource;
    }

    public void setPowerSource(PowerTypes powerSource) throws PlaneException {
    	if (powerSource == null) {
    		throw new PlaneException(VehicleConstants.NULLPOWERSOURCE);
        }
        this.powerSource = powerSource;
    }

    @Override
    public void go() {
        System.out.println("Plane is going");
    }

    @Override
    public void stop() {
        System.out.println("Plane is stopping");
    }

    @Override
    public PowerTypes powerBy() {
        return powerSource;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        if (this == obj) {
            return true;
        }

        Plane other = (Plane) obj;
        return numSeat == other.numSeat && powerSource == other.powerSource;
    }
    
    @Override
    public int hashCode() {
        int result = numSeat;
        result += powerSource.hashCode();
        return result;
    }
    
    @Override
    public String toString() {
        return "Plane [numSeat=" + numSeat + ", powerSource=" + powerSource + "]";
    }
    
}