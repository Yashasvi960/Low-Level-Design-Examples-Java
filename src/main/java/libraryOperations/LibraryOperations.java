package libraryOperations;

import java.util.List;

public class LibraryOperations {

    private Library library;

    public LibraryOperations(Library library) {
        this.library = library;
    }

    public void addBookToMember(Books book, Member member) {
        if(member.getAllBooksOverDued(20)>2 && member.getAllBooks()>5) {
            System.out.println("please return the books first");
        } else {
            List<String> str = library.getAllBooks();
            if(library.getAllBooks().contains(book.getName())) {
                member.addBook(book, 5 );
                System.out.println("Book added to member's account: " + book.getName());
            }
        }

    }
}
