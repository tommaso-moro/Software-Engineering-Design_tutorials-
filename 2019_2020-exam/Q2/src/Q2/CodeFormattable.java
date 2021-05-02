package Q2;

import java.util.List;

public interface CodeFormattable {
    List<String> startOfBlock();

    String endOfBlock();

    WhiteSpace tabsOrSpaces();
}
