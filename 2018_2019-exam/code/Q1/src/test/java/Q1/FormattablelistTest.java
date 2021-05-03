package Q1;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;

public class FormattableListTest {

    FormattedList htmlFormattedList = new FormattedList(new HtmlList(), "Hi I'm Tommy");
    FormattedList latexFormattedList = new FormattedList(new LaTeXList(), "Hi I'm Tommy");

    @Test
    public void listHeaderFormattedCorrectly() {
        assertThat(htmlFormattedList.formatHeader(), is("<ul>"));
        assertThat(latexFormattedList.formatHeader(), is("\\begin{itemize}"));
    }

    @Test
    public void listFooterFormattedCorrectly() {
        assertThat(htmlFormattedList.formatFooter(), is("</ul>"));
        assertThat(latexFormattedList.formatFooter(), is("\\end{itemize}"));
    }

    @Test
    public void listItemFormattedCorrectly() {
        String item = "test";
        assertThat(htmlFormattedList.formatItem(item), is("  <li>"+item+"</li>"));
        assertThat(latexFormattedList.formatItem(item), is("  \\item " + item));
    }

}
