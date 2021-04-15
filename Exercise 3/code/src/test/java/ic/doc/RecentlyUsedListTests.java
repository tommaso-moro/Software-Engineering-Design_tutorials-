package ic.doc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.NoSuchElementException;

public class RecentlyUsedListTests {

    RecentlyUsedList<Object> list = new RecentlyUsedList<Object>();
    int item1 = 5;
    int item2 = 7;
    int item3 = 9;

    @Test
    public void listIsEmptyWhenInitialized() {
        assertThat(list.length(), is(0));
    }

    @Test
    public void canAddThingsToRecentlyUsedList() {
        int listLengthBeforeAddingItem = list.length();
        assertFalse(list.contains(item1));
        list.add(item1);
        assertTrue(list.contains(item1));
        int listLengthAfteraddingItem = list.length();
        assertThat(listLengthAfteraddingItem, is(listLengthBeforeAddingItem+1));
    }

    @Test
    public void canRetrieveItemFromList() {
        list.add(item1);
        assertThat(list.getItem(item1), is(item1));
    }

    @Test
    public void mostRecentItemIsFirstInTheList() {
        list.add(item1);
        list.add(item2);
        list.add(item3);
        assertThat(list.getItemByIndex(0), is(item3));
    }

    @Test
    public void itemsInTheListAreUnique() {
        list.add(item1);
        list.add(item2);
        list.add(item3);
        assertThat(list.length(), is(3));
        list.add(item1);
        assertThat(list.length(), is(3)); //check list has remained unaltered

        int counter = 0; //keeps track of number of occurrences of item1 in list
        for (int i = 0; i < list.length(); i++) {
            if (list.getItemByIndex(i).equals(item1)) {
                counter++;
            }
        }
        assertThat(counter, is(1)); //there must be only 1 occurrence of item1 in the list

    }

    @Test
    public void duplicatesAreMovedRatherThanAdded() {
        list.add(item1);
        list.add(item2);
        list.add(item3);
        assertThat(list.getItemByIndex(0), is(item3));
        assertThat(list.getItemByIndex(1), is(item2));
        assertThat(list.getItemByIndex(2), is(item1));
        list.add(item1);
        assertThat(list.getItemByIndex(0), is(item1));
        assertThat(list.getItemByIndex(1), is(item3));
        assertThat(list.getItemByIndex(2), is(item2));
    }

}

