package bookReturn;

import java.time.LocalDate;

public class Transaction {
	private String memberID;
	private String bookID;
	private LocalDate transactionDate;
	private Events event;

	public enum Events {
		ISUUE, RETURNBOOK, PAYFINE
	}

	public Transaction(String memberID, String bookID, LocalDate transactionDate, Events event) {
		super();
		this.memberID = memberID;
		this.bookID = bookID;
		this.transactionDate = transactionDate;
		this.event = event;
	}

	public Transaction(String memberID, String bookID, LocalDate transactionDate) {
		this.memberID = memberID;
		this.bookID = bookID;
		this.transactionDate = transactionDate;
	}

	public Transaction(String memberID, String bookID) {
		super();
		this.memberID = memberID;
		this.bookID = bookID;
	}

	public Events getEvent() {
		return event;
	}

	public void setEvent(Events event) {
		this.event = event;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public void issueBook(Member memberID, Book bookID) {
		setBookID(getBookID());
		setMemberID(getMemberID());
		setTransactionDate(LocalDate.now());
		setEvent(event.ISUUE);
	}

	public void returnBook(Member memberID, Book bookID) {
		setBookID(getBookID());
		setMemberID(getMemberID());
		setTransactionDate(LocalDate.now());
		setEvent(event.RETURNBOOK);
	}

	public void payFineBook(Member memberID, Book bookID) {
		setBookID(getBookID());
		setMemberID(getMemberID());
		setTransactionDate(LocalDate.now());
		setEvent(event.PAYFINE);
	}
}
