package ic.doc.catalogues;

import ic.doc.BookSearchQuery;

public class BookSearchQueryBuilder {
    private String name1;
    private String name2;
    private String title;
    private Integer date1;
    private Integer date2;

    //private BookSearchQueryBuilder() {}

    public BookSearchQueryBuilder withAuthorName(String name) {
        name1 = name;
        return this;
    }
    public BookSearchQueryBuilder withAuthorSurname(String surname) {
        name2 = surname;
        return this;
    }
    public BookSearchQueryBuilder withTitle(String title) {
        this.title = title;
        return this;
    }
    public BookSearchQueryBuilder withPublishedAfterDate(Integer date) {
        date1 = date;
        return this;
    }
    public BookSearchQueryBuilder withPublishedBeforeDate(Integer date) {
        date2 = date;
        return this;
    }

    public BookSearchQuery build() {
        return new BookSearchQuery(name1, name2, title, date1, date2);
    }
}
