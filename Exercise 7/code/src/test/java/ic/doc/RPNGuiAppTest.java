package ic.doc;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class RPNGuiAppTest {

    RPNModel rpnModel = new RPNModel();

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();
    Updatable observer = context.mock(Updatable.class);

    @Test
    public void observersAreNotifiedOfNewResult() {

        context.checking(new Expectations() {{
            exactly(1).of(observer).update(5);
        }});

        rpnModel.addObserver(observer);
        rpnModel.addValue(5);
    }

    @Test
    public void additionWorksCorrectly() {
        context.checking(new Expectations() {{
            ignoring(observer).update(5);
            ignoring(observer).update(4);
            exactly(1).of(observer).update(9);
        }});

        rpnModel.addObserver(observer);
        rpnModel.addValue(5);
        rpnModel.addValue(4);
        rpnModel.performOperation(RPNGuiApp.Operator.PLUS);
    }


}
