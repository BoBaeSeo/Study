package phoneBook;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneManager {

	Scanner scan = new Scanner(System.in);
	DBSql sql = null;

	public void dbConnection() {
		sql = new DBSql();
		sql.dbConnection();
	}

	public void showMenu() {
		System.out.println("===================================================================");
		System.out.println("| 1.데이터입력 | 2.데이터검색 | 3. 데이터수정 | 4. 데이터삭제 | 5. 리스트출력 | 6.종료 |");
		System.out.println("===================================================================");
		System.out.print("메뉴 선택 >");
	}

	public void insertData() {
		System.out.println("*******************");
		System.out.println("데이터 입력 메뉴입니다.");
		System.out.print("이름 입력 >");
		String name = scan.next();
		System.out.print("전화번호 입력 >");
		String phoneNum = scan.next();
		PhoneInfo info = new PhoneInfo();
		info.setName(name);
		info.setPhoneNum(phoneNum);
		int result = sql.insertData(info);
		result(result);
		System.out.println("*******************");
	}

	public void searchData() {
		System.out.println("*******************");
		System.out.println("데이터 검색 메뉴입니다.");
		System.out.print("검색할 데이터의 이름 입력 >");
		String name = scan.next();
		ArrayList<PhoneInfo> phoneInfo = sql.searchData(name);
		for (int i = 0; i < phoneInfo.size(); i++) {
			if (phoneInfo.get(0).getPhoneNum() == null) {
				System.out.println("이름이 존재하지 않습니다.");
			} else {
				System.out.print("[이름] :" + phoneInfo.get(i).getName());
				System.out.println(" [전화번호] :" + phoneInfo.get(i).getPhoneNum());
			}
		}
		System.out.println("*******************");
	}

	public void updateData() {
		System.out.println("*******************");
		System.out.println("데이터 수정 메뉴입니다.");
		System.out.print("수정할 데이터의 이름 입력 >");
		String name = scan.next();
		ArrayList<PhoneInfo> phoneInfo = sql.searchData(name);
		if (phoneInfo.size() >= 1) {
			System.out.print("수정할 전화번호 입력 >");
			String newPhoneNum = scan.next();
			if (phoneInfo.size() >= 2) {
				for (int i = 0; i < phoneInfo.size(); i++) {
					System.out.print("[" + i + "]" + "[이름] :" + phoneInfo.get(i).getName());
					System.out.println(" [전화번호] :" + phoneInfo.get(i).getPhoneNum());
				}
				System.out.print("수정할 데이터 번호 선택 >");
				int index = scan.nextInt();
				int result = sql.updateDataPhoneNum(phoneInfo.get(index).getName(), phoneInfo.get(index).getPhoneNum(), newPhoneNum);
				result(result);
			} else {
				int result = sql.updateDataname(name, newPhoneNum);
				result(result);
			}
		} else {
			System.out.println("이름이 존재하지 않습니다.");
		}
		System.out.println("*******************");
	}

	public void deleteData() {
		System.out.println("*******************");
		System.out.println("데이터 삭제 메뉴입니다.");
		System.out.print("삭제할 데이터의 이름 입력 >");
		String name = scan.next();
		ArrayList<PhoneInfo> phoneInfo = sql.searchData(name);
		if (phoneInfo.size() >= 1) {
			if (phoneInfo.size() >= 2) {
				for (int i = 0; i < phoneInfo.size(); i++) {
					System.out.print("[" + i + "]" + "[이름] :" + phoneInfo.get(i).getName());
					System.out.println(" [전화번호] :" + phoneInfo.get(i).getPhoneNum());
				}
				System.out.print("삭제할 데이터 번호 선택 >");
				int index = scan.nextInt();
				int result = sql.deletenumData(phoneInfo.get(index).getName(), phoneInfo.get(index).getPhoneNum());
				result(result);
			} else {
				int result = sql.deleteNameData(name);
				result(result);
			}
		} else {
			System.out.println("이름이 존재하지 않습니다.");
		}
		System.out.println("*******************");
	}
	

	public void printList() {
		System.out.println("*******************");
		System.out.println("리스트 출력 메뉴입니다.");
		ArrayList<PhoneInfo> phoneInfo = sql.printList();
		for(int i = 0; i < phoneInfo.size(); i++) {
			System.out.print("[이름] : " + phoneInfo.get(i).getName());
			System.out.println(" [전화번호] : " + phoneInfo.get(i).getPhoneNum());
		}
		System.out.println("*******************");
	}

	public void result(int result) {
		if (result > 0) {
			System.out.println("성공하였습니다.");
		} else {
			System.out.println("실패하였습니다.");
		}
	}
}
