package bookReturn;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.Period;

public class Book {
	private String title;
	private String actor;
	private String id;
	private LocalDate dueDate;
	private Member issue;
	List<Member> holds = new ArrayList<>();
	List<Transaction> transactions=new ArrayList<>();

	public Book(String title, String actor, String id, List<Member> holds) {
		super();
		this.title = title;
		this.actor = actor;
		this.id = id;
		this.holds = holds;
	}

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Member getIssue() {
		return issue;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public void setIssue(Member issue) {
		this.issue = issue;
	}

	public Book(String title, String actor, String id, LocalDate dueDate, Member issue, List<Member> holds) {
		super();
		this.title = title;
		this.actor = actor;
		this.id = id;
		this.dueDate = dueDate;
		this.issue = issue;
		this.holds = holds;
	}

	public Book(String title, String actor, String id) {
		super();
		this.title = title;
		this.actor = actor;
		this.id = id;
	}

	public Book(String title, String actor, String id, LocalDate dueDate) {
		super();
		this.title = title;
		this.actor = actor;
		this.id = id;
		this.dueDate = dueDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Member> getHolds() {
		return holds;
	}

	public void setHolds(List<Member> holds) {
		this.holds = holds;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", actor=" + actor + ", id=" + id + ", dueDate=" + dueDate + ", holds=" + holds
				+ "]";
	}

	public int dayCalculate() {
		LocalDate startDate = getDueDate();

		LocalDate endDate = LocalDate.now();

		Period result = Period.between(startDate, endDate);
		return result.getDays();
	}

	public void addHold(Member member) {
		holds.add(member);
		setHolds(holds);

	}

	public int computeFine(Member member) {
		int fine = 0;
		if (dayCalculate() >= 10) {
			fine = dayCalculate();
		} else {
			fine = 0;

		}

		fine = member.selectRank(member) * fine;
		if (getHolds().stream().count() != 0) {
			fine = fine * 2;
		}
		
		Transaction newTransaction= new Transaction(id, member.getMemberID());
		newTransaction.payFineBook(member, this);
		transactions.add(newTransaction);
		return fine;

	}

	public void issueBook(Member member, int year, int month, int day) {
		dueDate = LocalDate.of(year, month, day);
		setDueDate(dueDate);
		issue = member;
		setIssue(member);
		Transaction newTransaction= new Transaction(id, member.getMemberID());
		newTransaction.issueBook(member, this);
		transactions.add(newTransaction);
	}
	
	public void notIssueBook() {
		LocalDate dudate=LocalDate.of(0, 1, 1);
		setDueDate(dudate);
	}
}
