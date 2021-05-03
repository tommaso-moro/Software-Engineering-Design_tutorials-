package ic.doc;

import org.junit.Test;

public class RPNGuiAppTest {

    RPNModel rpnModel = new RPNModel();

    @Test
    void additionWorksCorrectly() {
        rpnModel.addValue(5);
        rpnModel.addValue(8);
        //assertThat(rpnModel.performAddition(), )
    }
}
