package es.upm.grise.profundizacion.control_1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

public class LibraryTest {
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("Preparando test para Library");
	}
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("Ejecuto test");
	}
	
	//Test de addBook
	
	@Test
	@DisplayName("añado un libro")
	public void addBook_Test() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException {
		Library library = new Library();
		Book book = new Book("Narnia");
			
		library.addBook(book);

		assertEquals(book, library.getBook("Narnia"));
	}
	
	
	@Test
	@DisplayName(" añado 3 libros ")
	public void AddthreeBooks_Test() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException {
		Library library = new Library();
		
		Book book1 = new Book("Narnia");
		Book book2 = new Book("Superman");
		Book book3 = new Book("spiderman");
		
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		
		assertEquals(library.getBook("Narnia").getTitle(), book1.getTitle());
		assertEquals(library.getBook("Superman").getTitle(), book2.getTitle());
		assertEquals(library.getBook("spiderman").getTitle(), book3.getTitle());
	}
	
	@Test
	@DisplayName(" añado libro repetido ")
	public void addBook_Repeated_test() {
		
		Library library = new Library();
		String title = "Narnia";
		Book book1 = new Book(title);
		Book book2 = new Book(title);

		assertThrows(DuplicatedBookException.class, () -> {
			library.addBook(book1);
			library.addBook(book2);
		});
	}
	
	//Test de removeBook
	
	@Test
	@DisplayName(" elimino un libro de la libreria ")
	public void removeBook_test() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException {
		
		Library library = new Library();
		Book book1 = new Book("Narnia");
		Book book2 = new Book("Superman");
		Book book3 = new Book("spiderman");
		
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
				
		assertEquals(library.getBook("Narnia").getTitle(), book1.getTitle());
		
	
		library.removeBook(book1);
		assertThrows(NonExistingBookException.class, () -> library.getBook("Narnia").getTitle());
	}
	
	@Test
	@DisplayName(" elimino libro de una libreria vacia ")
	public void removeBook_Empty_Test() {
		Library library = new Library();
		Book book = new Book("Narnia");
		String title = "Narnia";
		
		assertThrows(EmptyLibraryException.class, () -> {
			library.addBook(book); library.removeBook(book); library.getBook(title);
		});
	}
	
	//Test de getBook
	
	@Test
	@DisplayName(" localizo libro en libreria vacia. Salta exception ")
	public void getBook_Empty_Test() {
		
		Library library = new Library();
		String title = "Superman";
		assertThrows(EmptyLibraryException.class, () -> {
			library.getBook(title);
		});
	}
	
	@Test
	@DisplayName(" busco un libro que no está. Salta excepción")
	public void getBook_NonExisting_Test() {
		
		Library library = new Library();
		Book book = new Book("Narnia");
		String title = "Superman";
		
		assertThrows(NonExistingBookException.class, () -> {
			library.addBook(book);
			library.getBook(title);
		});
	}
	
	
	@Test
	@DisplayName(" busco un libro que si está ")
	public void test_getBook2() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException {
		Library library = new Library();
		Book book = new Book("Narnia");
		
			library.addBook(book);
			assertEquals( book, library.getBook("Narnia"));
	}

	@AfterEach
	public void afterEach() {
		System.out.println("Test terminado");
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("Tests finalizados");
	}
	
}
