package bookReturn;

import java.util.ArrayList;
import java.util.List;

public class Library {

	MemberList memberList;
	Catalog books;
	List<Transaction> transactions = new ArrayList<>();

	public Library(MemberList memberList, Catalog books) {
		super();
		this.memberList = memberList;
		this.books = books;
	}

	public Library() {
		// TODO Auto-generated constructor stub
	}

	public MemberList getMemberList() {
		return memberList;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public void setMemberList(MemberList memberList) {
		this.memberList = memberList;
	}

	public Catalog getBooks() {
		return books;
	}

	public void setBooks(Catalog books) {
		this.books = books;
	}

	public String returnBook(String bookID, String memberID) {

		Book newBook = getBooks().searchBook(bookID);
		if (newBook == null) {
			System.out.println("Böyle bir kitap bulunmadı");
		} else {
			Member newMember = getMemberList().searchmember(memberID);
			if (newMember == null) {
				System.out.println("Böyle bir üye bulunmadı");
			} else {
				Transaction newTransaction=new Transaction( memberID, bookID);
				newTransaction.returnBook(newMember, newBook);
				transactions.add(newTransaction);
				return "Book fine:" + newBook.computeFine(newMember);
				
			}
		}
		return Exception.class.descriptorString();
	}

}
