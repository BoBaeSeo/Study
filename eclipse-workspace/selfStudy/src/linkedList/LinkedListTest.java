package linkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
		final int list_number = 3;
		LinkedList<Integer> linkedList = new LinkedList<>();
		final List<Integer> list = Arrays.asList(1, 2, 3);

		// add
		for (int i = 0; i < list_number; i++) {
			linkedList.add(i + (i + 2) + 10);
		}
		System.out.print("값 추가 후 리스트 : ");
		printList(linkedList);
		System.out.print("2번에 111 추가 후 리스트");
		linkedList.add(2, 111);
		printList(linkedList);
		System.out.print("처음에 100 끝에 200 추가 후 리스트 : ");
		linkedList.addFirst(100);
		linkedList.addLast(200);
		printList(linkedList);
		System.out.print("리스트 list를 추가 후 리스트 : ");
		linkedList.addAll(list);
		printList(linkedList);
		System.out.println();
		
		//get()
		System.out.println("3번 위치의 값 : " + linkedList.get(3));
		System.out.println("처음 위치의 값 : " + linkedList.getFirst());
		System.out.println("마지막 위치의 값 : " + linkedList.getLast());
		System.out.println();
		
		// indexOf()
		final int search = 42;
		System.out.println(search + " 값의 위치 : " + linkedList.indexOf(search));
		System.out.println();
		
		// remove()	
		System.out.println("첫 요소 제거 : " + linkedList.remove());
		System.out.print("제거 후 리스트 : ");
		printList(linkedList);
		final int remove = 4;
		if(linkedList.get(remove) != -1) {
			System.out.println(remove + " 위치의 값 제거 : " + linkedList.remove(remove));
			System.out.print("제거 후 리스트 : ");
			printList(linkedList);
		}
		System.out.print("첫 요소(" + linkedList.removeFirst() + ")와 끝 요소(" + linkedList.removeLast() + 
				") 제거 후 리스트 : ");
		printList(linkedList);
		System.out.println();
		
		// set()
		final int set = 2, changeValue = 12345;
		if(linkedList.get(set) != -1) {
			linkedList.set(set, changeValue);
			System.out.print(set + " 위치의 값 " + changeValue + "로 변경 후 리스트 : ");
			printList(linkedList);
			System.out.println();
		}
		
		// size()
		System.out.println("현재 리스트의 길이 : " + linkedList.size());
		System.out.println();
	}

	public static void printList(LinkedList<Integer> linkedList) {
		for (int i = 0; i < linkedList.size(); i++) {
			System.out.print(linkedList.get(i) + ", ");
		}
		System.out.println();
	}
}
