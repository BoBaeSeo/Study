package arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		/* isEmpty */
		if(arrayList.isEmpty()) {
			System.out.println("arrayList_int는 비어있습니다.");
		}
		
		// add
		arrayList.add(4);
		arrayList.add(19);
		arrayList.add(15);
		arrayList.add(21);
		System.out.print("add 호출 후 : ");
		printList(arrayList);
		
		// contains
		final int var_contains = 19;
		if(arrayList.contains(var_contains)) {
			System.out.println("19를 가지고 있다.");
		}
		
		// get & set
		final int var_getIndex = 3;
		final int var_set = 81;
		if(arrayList.get(var_getIndex) != null) {
			System.out.println(var_getIndex + "번 위치에 " + arrayList.get(var_getIndex) + "가 존재한다.");
			arrayList.set(var_getIndex, var_set);
			System.out.print(var_getIndex + "번의 값을 변경 한 후 : ");
			printList(arrayList);
		}
		
		// remove
		final int var_removeIndex = 1;
		if(arrayList.get(var_removeIndex) != null) {
			System.out.print(var_removeIndex + "번의 위치의 값 " + arrayList.remove(var_removeIndex) + "제거 후 :");
			printList(arrayList);
		}
		
		// addAll
		final List<Integer> arrayList_2 = Arrays.asList(11, 22, 33, 44, 55);
		arrayList.addAll(arrayList_2);
		printList(arrayList);
		
		// clear
		System.out.println("arrayList_int 비우기!");
		arrayList.clear();
		if(arrayList.isEmpty()) {
			System.out.println("arrayList_int가 비어있다!");
		}
		
		
	}
	
	public static void printList(ArrayList<Integer> arrayList) {
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i) + ", ");
		}
		System.out.println();
	}
}
