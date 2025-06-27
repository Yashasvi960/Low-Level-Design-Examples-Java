package libraryOperations;

public class LibraryMain {

    public static void main(String[] args) {
        Books book1 = new Books("1", "1984", "George Orwell", "Dystopian");
        Books book2 = new Books("2", "To Kill a Mockingbird", "Harper Lee", "Fiction");
        Books book3 = new Books("3", "The Great Gatsby", "F. Scott Fitzgerald", "Classic");

        Member member = new Member("1", "Alice", "SpecialBook");

        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.addMember(member);

        LibraryOperations operations = new LibraryOperations(library);
        operations.addBookToMember(book1, member);

    }
}
