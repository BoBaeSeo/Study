package phoneBook;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		PhoneManager manager = new PhoneManager();
		boolean run = true;
		manager.dbConnection();
		while(run) {
			manager.showMenu();
			String menuSel = manager.scan.next();
			switch(menuSel){
				case "1":
					manager.insertData();
					break;
				case "2":
					manager.searchData();
					break;
				case "3":
					manager.updateData();
					break;
				case "4":
					manager.deleteData();
					break;
				case "5":
					manager.printList();
					break;
				case "6":
					System.out.println("프로그램이 종료됩니다.");
					run = false;
					break;
				case "7":
					PhoneInfo info = new PhoneInfo();
					info.toString();
					System.out.println(info);
					break;
				default :
					System.out.println("잘못 입력하셨습니다.");
					break;
			}
		}
	}
}
