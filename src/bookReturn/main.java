package bookReturn;

import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Library library = new Library();
		Book book1 = new Book("Simyacı", "Paulo Coelho", "1");

		Book book2 = new Book("Da Vinci Şifresi", "Dan Brown", "2");
		Book book3 = new Book("1984", "George Orwell", "3");
		Book book4 = new Book("İstanbul Hatırası", "Orhan Pamuk", "4");
		Book book5 = new Book("Savaş Sanatı", "Sun Tzu", "5");

		Catalog books = new Catalog();
		books.addBooks(book1);
		books.addBooks(book2);
		books.addBooks(book3);
		books.addBooks(book4);
		books.addBooks(book5);

		Member member1 = new Member("Ahmet", "1", "Bornova", "054346347", "student");
		Member member2 = new Member("Ali", "2", "Buca", "053427342", "student");
		Member member3 = new Member("Bora", "3", "Bayraklı", "0544564545", "student");
		Member member4 = new Member("Gamze", "4", "Karşıyaka", "053848844", "teacher");
		Member member5 = new Member("Sedef", "5", "Bostanlı", "05498765", "teacher");

		MemberList members = new MemberList();
		members.addMember(member1);
		members.addMember(member2);
		members.addMember(member3);
		members.addMember(member4);
		members.addMember(member5);

		book3.addHold(member3);
		book5.addHold(member5);

		book1.issueBook(member1, 2022, 6, 14);
		book2.issueBook(member2, 2022, 5, 10);
		book3.issueBook(member2, 2022, 5, 10);
		book4.issueBook(member4, 2022, 8, 18);
		book5.issueBook(member4, 2022, 11, 1);

		library.setBooks(books);
		library.setMemberList(members);
		int a = 1;
		while (a < 2) {
			Scanner scanner1 = new Scanner(System.in);
			System.out.print("Give yours book id: ");
			String bookID = scanner1.nextLine();

			Scanner scanner2 = new Scanner(System.in);
			System.out.print("Give yours member id: ");
			String memberID = scanner2.nextLine();
			System.out.println(library.returnBook(bookID, memberID));
			Scanner scanner3 = new Scanner(System.in);
			System.out.println("Dou you want to pay?(Y/N)");
			String pay = scanner3.nextLine();
			if (pay.equals("Y") || pay.equals("y")) {
				library.books.searchBook(bookID).notIssueBook();
				System.out.println("Debt paid");
			}
			Scanner scanner4 = new Scanner(System.in);
			System.out.println("is there any other book(Y/N)");
			String another = scanner4.nextLine();
			if (another.equals("N") || another.equals("n")) {
				
				a = 3;
			}

		}
		System.out.println("Signed out of the system");
	}

}
