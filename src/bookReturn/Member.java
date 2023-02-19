package bookReturn;

import java.util.ArrayList;
import java.util.List;

public class Member {
	private String name;
	private String memberID;
	private String adress;
	private String phone;
	private String rank;
	List<Book> booksOnHold = new ArrayList<>();
	List<Transaction> transection = new ArrayList<>();

	public Member(String name, String memberID, String adress, String phone, String rank, List<Book> booksOnHold,
			List<Transaction> transection) {
		super();
		this.name = name;
		this.memberID = memberID;
		this.adress = adress;
		this.phone = phone;
		this.rank = rank;
		this.booksOnHold = booksOnHold;
		this.transection = transection;
	}

	public Member(String name, String memberID, String adress, String phone, String rank) {
		super();
		this.name = name;
		this.memberID = memberID;
		this.adress = adress;
		this.phone = phone;
		this.rank = rank;
	}

	public Member() {
		super();
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Book> getBoooksOnHold() {
		return booksOnHold;
	}

	public void setBoooksOnHold(List<Book> boooksOnHold) {
		this.booksOnHold = boooksOnHold;
	}

	public List<Transaction> getTransection() {
		return transection;
	}

	public void setTransection(List<Transaction> transection) {
		this.transection = transection;
	}

	public String getMemberID() {
		return memberID;
	}



	@Override
	public String toString() {
		return "Member [name=" + name + ", memberID=" + memberID + ", adress=" + adress + ", phone=" + phone + ", rank="
				+ rank + ", booksOnHold=" + booksOnHold + ", transection=" + transection + "]";
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public int selectRank(Member newMember) {
		if (newMember.getRank() == "student") {
			return 2;
		} else {
			return 3;
		}
	}


}
