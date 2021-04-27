package ic.doc;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import ic.doc.catalogues.BookSearchQueryBuilder;
import ic.doc.catalogues.BritishLibraryCatalogue;
import ic.doc.catalogues.LibraryCatalogue;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class BookSearchQueryTest {

  private static final List<Book> BOOKS = Arrays.asList(new Book("A Christmas Carol", "Charles Dickens", 1766));
  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();
  LibraryCatalogue catalogue = context.mock(LibraryCatalogue.class);

  @Test
  public void searchesForBooksInLibraryCatalogueByAuthorSurname() {

    context.checking(new Expectations() {{
      exactly(1).of(catalogue).searchFor("LASTNAME='dickens' "); will(returnValue(BOOKS));
    }});

    List<Book> books = new BookSearchQueryBuilder().withAuthorSurname("dickens").build().execute(catalogue);
  }

  @Test
  public void searchesForBooksInLibraryCatalogueByAuthorFirstname() {

    context.checking(new Expectations() {{
      exactly(1).of(catalogue).searchFor("FIRSTNAME='Jane' ");
    }});

    new BookSearchQueryBuilder().withAuthorName("Jane").build().execute(catalogue);

  }

  //Can keep using mock object tests in the remaining tests and it'll work similarly to the first two

  @Test
  public void searchesForBooksInLibraryCatalogueByTitle() {

    List<Book> books = new BookSearchQueryBuilder().withTitle("Two Cities").build().execute(BritishLibraryCatalogue.getInstance());

    assertThat(books.size(), is(1));
    assertTrue(books.get(0).matchesAuthor("dickens"));
  }

  @Test
  public void searchesForBooksInLibraryCatalogueBeforeGivenPublicationYear() {

    List<Book> books = new BookSearchQueryBuilder().withPublishedBeforeDate(1700).build().execute(BritishLibraryCatalogue.getInstance());

    assertThat(books.size(), is(1));
    assertTrue(books.get(0).matchesAuthor("Shakespeare"));
  }

  @Test
  public void searchesForBooksInLibraryCatalogueAfterGivenPublicationYear() {

    List<Book> books = new BookSearchQueryBuilder().withPublishedAfterDate(1950).build().execute(BritishLibraryCatalogue.getInstance());

    assertThat(books.size(), is(1));
    assertTrue(books.get(0).matchesAuthor("Golding"));
  }

  @Test
  public void searchesForBooksInLibraryCatalogueWithCombinationOfParameters() {

    List<Book> books = new BookSearchQueryBuilder().withAuthorSurname("dickens").withPublishedBeforeDate(1840).build().execute(BritishLibraryCatalogue.getInstance());

    assertThat(books.size(), is(1));
    assertTrue(books.get(0).matchesAuthor("charles dickens"));
  }

  @Test
  public void searchesForBooksInLibraryCatalogueWithCombinationOfTitleAndOtherParameters() {

    List<Book> books = new BookSearchQueryBuilder().withTitle("of").withPublishedAfterDate(1800).withPublishedBeforeDate(2000).build().execute(BritishLibraryCatalogue.getInstance());

    assertThat(books.size(), is(3));
    assertTrue(books.get(0).matchesAuthor("charles dickens"));
  }
}
