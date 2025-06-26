package libraryOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    private List<Books> books;

    private List<Member> memberList;

    private Library() {
        books = new ArrayList<>();
        memberList = new ArrayList<>();
    }

    public void addMember(Member member) {
        if (memberList != null) {
            memberList.add(member);
        }
    }

    public void removeMember(Member member) {
        if (memberList != null) {
            memberList.remove(member);
        }
    }
}
