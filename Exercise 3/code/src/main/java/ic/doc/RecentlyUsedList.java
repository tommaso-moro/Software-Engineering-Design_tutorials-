package ic.doc;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RecentlyUsedList<E> {
  List<E> list = new ArrayList<>();

  public RecentlyUsedList() {};

  public int length() {
    return list.size();
  }

  public void add(E item) {
    if (!(list.contains(item))) {
      list.add(0, item); //adds item at index 0;
    } else {
      list.remove(item);
      add(item); //recursively calls add() again but this time it will go into the first if statement and add the item at index 0
    }
  }

  public boolean contains(E item) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) == item) {
        return true;
      }
    }
    return false;
  }

  public E getItem(E item) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) == item) {
        return list.get(i);
      }
    }
    return null;
  }

  public E getItemByIndex(int index) {
    return list.get(index);
  }

}
