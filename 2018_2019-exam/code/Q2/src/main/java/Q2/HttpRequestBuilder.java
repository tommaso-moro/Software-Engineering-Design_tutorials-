package Q2;

import java.util.List;

public class HttpRequestBuilder {
    private String url;
    private String body;
    private List<String> params;
    private HttpRequest.Method method;
    private List<String> headers;

    public HttpRequestBuilder HttpRequest() {
        return new HttpRequestBuilder();
    }

    public HttpRequestBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    public HttpRequestBuilder withBody(String body) {
        this.body = body;
        return this;
    }

    public HttpRequestBuilder withParams(List<String> params) {
        this.params = params;
        return this;
    }

    public HttpRequestBuilder withMethod(HttpRequest.Method method) {
        this.method = method;
        return this;
    }

    public HttpRequestBuilder withHeaders(List<String> headers) {
        this.headers = headers;
        return this;
    }

    public HttpRequest build() {
        return new HttpRequest(url, method, params, headers, body);
    }
}
