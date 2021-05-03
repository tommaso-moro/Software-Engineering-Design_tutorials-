package Q4;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SimpleStatsModelTest {

    SimpleStatsModel model = new SimpleStatsModel();

    @Test
    public void modelComputesMaxCorrectly() {
        int a = 5;
        int b = 7;

        model.addNumber(a);
        model.addNumber(b);
        assertThat(model.getMax(), is(b));

    }

    @Test
    public void modelUpdatesDisplayWhenNewValueIsComputed() {

    }
}
