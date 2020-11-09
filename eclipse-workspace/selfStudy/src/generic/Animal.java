package generic;

public interface Animal {
	
	void sound();
}

class Dog implements Animal{
	public void sound() {
		System.out.println("멍멍");
	}
}

class Cat implements Animal{
	public void sound() {
		System.out.println("냐옹");
	}
}
