package genericSample;

public class CarwildcardSample {

	public static void main(String[] args) {
		CarwildcardSample sample = new CarwildcardSample();
		sample.callBoundedWildcardCarMethod();
		sample.callBoundedWildcardBusMethod();
	}
	
	public void callBoundedWildcardCarMethod() {
		WildCardGeneric<Car> wildcardCar = new WildCardGeneric<Car>();
		wildcardCar.setWildcard(new Car("Mustang"));
		boundedWildcardMethod(wildcardCar);
	}
	
	public void callBoundedWildcardBusMethod() {
		WildCardGeneric<Bus> wildcardBus = new WildCardGeneric<Bus>();
		wildcardBus.setWildcard(new Bus("6900"));
		boundedWildcardMethod(wildcardBus);
	}
	
	public void boundedWildcardMethod(WildCardGeneric<? extends Car> c) {
		Car value = c.getWildcard();
		System.out.println(value);
	}
}
