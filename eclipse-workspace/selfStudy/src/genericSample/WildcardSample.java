package genericSample;

public class WildcardSample {

	public static void main(String[] args) {
		WildcardSample sample = new WildcardSample();
		sample.callWildcardMethod();
	}	
	
	public void callWildcardMethod() {
		WildCardGeneric<String> wildcardString = new WildCardGeneric<String>();
		wildcardString.setWildcard("A");
		wildcardStringMethod(wildcardString);
		wildcardMethod(wildcardString);
		WildCardGeneric<Integer> wildcardInt = new WildCardGeneric<Integer>();
		wildcardInt.setWildcard(2);
		wildcardMethod(wildcardInt);
	}
	
	public void wildcardStringMethod(WildCardGeneric<String> c) {
		String value = c.getWildcard();
		System.out.println(value);
	}
	// 제네릭 클래스를 매개변수로 사용할 때 타입을 지정해버리면 다른 타입은 사용할 수 없게된다.
	// 왜냐면 제네릭 클래스의 타입만 바꾼다고 Overloarding이 불가능하기 때문이다.
	
	public void wildcardMethod(WildCardGeneric<?> c) {
		Object value = c.getWildcard();
		System.out.println(value);
	}
	// 타입 선언 부분에 ?를 사용하면 여러 타입을 사용할 수 있게 바뀐다. 
}
