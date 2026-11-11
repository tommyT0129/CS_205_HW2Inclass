package edu.monmouth.vehicle;

public class Car implements Vehicle {
    private int engineSize;
    private PowerTypes powerSource;

    public Car(PowerTypes powerSource, int engineSize) throws CarException {
        setPowerSource(powerSource);
        setEngineSize(engineSize);
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) throws CarException {
        if (engineSize < VehicleConstants.MINENGINESIZE || engineSize > VehicleConstants.MAXENGINESIZE) {
            throw new CarException(VehicleConstants.ENGINESIZEERROR + engineSize);
        }
        this.engineSize = engineSize;
    }

    public PowerTypes getPowerSource() {
    	return powerSource;
    }

    public void setPowerSource(PowerTypes powerSource) throws CarException {
    	if (powerSource == null) {
    		throw new CarException(VehicleConstants.NULLPOWERSOURCE);
        }
        this.powerSource = powerSource;
    }

    @Override
    public void go() {
        System.out.println("Car is going");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping");
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
       
        Car other = (Car) obj;
        return engineSize == other.engineSize && powerSource == other.powerSource;
    }
    
    @Override
    public int hashCode() {
        int result = engineSize;
        result += powerSource.hashCode();
        return result;
    }
    
    @Override
    public String toString() {
        return "Car [engineSize=" + engineSize + ", powerSource=" + powerSource + "]";
    }
}
