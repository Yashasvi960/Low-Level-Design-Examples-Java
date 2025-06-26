package libraryOperations;

import java.util.List;
import java.util.stream.Collectors;

public class Member {

    private String id;
    private String name;
    private String memberShipType;

    private List<Books> books;

    private List<Member> memberList;

    public Member(String id, String name, String memberShipType) {
        this.id = id;
        this.name = name;
        this.memberShipType = memberShipType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMemberShipType() {
        return memberShipType;
    }

    public void addBooksToMember(Books book) {
        books.add(book);
    }

    public void removeBooksFromMember(Books book) {
        books.remove(book);
    }

    public List<Books> getAllBooksIssued() {
        return books.stream()
                .filter(book -> book != null)
                .collect(Collectors.toList());
    }

//    public List<Books> getOverduedBooks(String days) {
//        if(days>5) {
//
//        }
//    }
}
