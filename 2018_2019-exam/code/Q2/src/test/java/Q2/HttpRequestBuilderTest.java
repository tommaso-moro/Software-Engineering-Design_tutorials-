package Q2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HttpRequestBuilderTest {

    @Test
    public void canConstructHttpRequestUsingBuilder() {
        List<String> headers = new ArrayList<String>();
        headers.add("Date=02-05-2019");
        HttpRequest myRequest = new HttpRequestBuilder().withMethod(HttpRequest.Method.POST).withBody("mark=100").withUrl("http://exams.imperial.ac.uk/575 ").withHeaders(headers).build();

    }
}
