package Q1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormattedList {
    private FormattableList formattableList;
    private String[] items;

    public FormattedList(FormattableList formattableList, String... items) {
        this.formattableList = formattableList;
        this.items = items;
    }

    private List<String> content = new ArrayList<>();

    public FormattedList(String... items) {
        content.addAll(Arrays.asList(items));
    }

    public void add(String item) {
        content.add(item);
    }

    public void print() {
        System.out.println(formatHeader());
        for (String item : content) {
            System.out.println(formatItem(item));
        }
        System.out.println(formatFooter());
    }

    protected String formatHeader() {
        return formattableList.formatHeader();
    };

    protected String formatItem(String item) {
        return formattableList.formatItem(item);
    };

    protected String formatFooter() {
        return formattableList.formatFooter();
    };

}

