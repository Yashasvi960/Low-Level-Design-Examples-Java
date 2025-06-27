package libraryOperations;

import java.util.*;
import java.util.stream.Collectors;

public class Member {

    private String id;
    private String name;
    private String memberShipType;

    private Map<String, Integer> books;

    private List<Member> memberList;

    public Member(String id, String name, String memberShipType) {
        this.id = id;
        this.name = name;
        this.memberShipType = memberShipType;
        books = new HashMap<>();
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

    public void addBook(Books book, int issuedDate) {
        books.put(book.getName(), issuedDate);
    }



    public int getAllBooksOverDued(int todayDate) {
        int count = 0;
        for(Map.Entry<String, Integer> entry: books.entrySet()) {
            if(todayDate-entry.getValue()>14) {
                count++;
            }
        }
        return count;
    }

    public int getAllBooks() {
       return books.size();
    }
}
