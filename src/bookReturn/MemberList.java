package bookReturn;

import java.util.ArrayList;
import java.util.List;

public class MemberList {
	List<Member> members=new ArrayList<>();

	public MemberList() {
		super();
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "MemberList [members=" + members + "]";
	}

	public Member searchmember(String id) {
		Member member = members.stream().filter(m -> m.getMemberID().equals(id)).findAny().orElse(null);
		if (member != null) {
			return member;

		}
		return null;

	}
	
	public List<Member> addMember(Member member) {
		members.add(member);
		setMembers(members);
		return members;
	}
}
