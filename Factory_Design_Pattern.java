
interface Vehicle{
    String getVehicleType();
}
class Car implements Vehicle{
    public String getVehicleType(){
        return "Car fetched";
    }
}
class Bike implements Vehicle{
    public String getVehicleType(){
        return "Bike fetched";
    }
}
class VehicleFactory{
    public static Vehicle getVehicle(String type){
        if(type == "Car") return new Car();
        if(type == "Bike") return new Bike();
        return new Car();
    }
}
public class Main
{
	public static void main(String[] args) {
		Vehicle vehicle = VehicleFactory.getVehicle("Abc");
		System.out.println(vehicle.getVehicleType());
	}
}