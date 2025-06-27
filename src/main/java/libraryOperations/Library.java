package libraryOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    private List<String> books;

    private List<Member> memberList;

    public Library() {
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

    public void addBook(Books book) {
        if (books != null) {
            books.add(book.getName());
        }
    }

    public void removeBook(Books book) {
        if (books != null) {
            books.remove(book);
        }
    }

    public List<String> getAllBooks() {
        return books;
    }
}
