package generic;


import java.util.ArrayList;
import java.util.List;

public class AnamalSoundTest {
	
	public static <lists> void printSound(List<Animal> lists) {
		for(Animal list : lists) {
			list.sound();
		}
		
	}
	
	public static void main(String[] args) {
		List<Animal> lists = new ArrayList<>();
		lists.add(new Dog());
		lists.add(new Cat());
		printSound(lists);
	}
}


