package http;

import com.google.gson.Gson;
import entity.Comprador;
import entity.Vendedor;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateCompradorHttp {
    private String url;
    private String path;
    private String method;
    private Response response;
    private List<String> comprador;
    private List<Integer> responseStatusCodes;

    public CreateCompradorHttp() {
        this.comprador = new ArrayList<String>();
        this.responseStatusCodes = new ArrayList<Integer>();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void createComprador(Comprador comprador) throws IOException {
        Gson gson = new Gson();
        this.comprador.add(gson.toJson(comprador, Comprador.class));
    }

    public void make() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");

        for (int i = 0; i < this.comprador.size(); i++) {
            RequestBody body = RequestBody.create(this.comprador.get(i), mediaType);

            Request request = new Request.Builder()
                    .url(this.buildUrl())
                    .addHeader("Content-Type", "application/json")
                    .method(this.method, body)
                    .build();

            this.response = client.newCall(request).execute();
            this.responseStatusCodes.add(this.response.code());
        }
    }
    private String buildUrl() {
        return this.url + this.path;
    }

    public List<Integer> getResponseStatusCodes() {
        return this.responseStatusCodes;
    }
}
