package genericSample;

public class Car {

	protected String name;

	public Car(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + "]";
	}


}

class Bus extends Car{
	
	public Bus(String name) {
		super(name);
	}
	
	@Override
	public String toString() {
		return "Bus [name=" + name + "]";
	}
}
