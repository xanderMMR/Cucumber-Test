package http;

import com.google.gson.Gson;
import entity.Categoria;
import entity.Producto;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateCategoriaHttp {
    private String url;
    private String path;
    private String method;
    private Response response;
    private List<String> categorias;
    private List<Integer> responseStatusCodes;

    public CreateCategoriaHttp() {
        this.categorias = new ArrayList<String>();
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

    public void createCategoria(Categoria categoria) throws IOException {
        Gson gson = new Gson();
        this.categorias.add(gson.toJson(categoria, Categoria.class));
    }

    public void make() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");

        for (int i = 0; i < this.categorias.size(); i++) {
            RequestBody body = RequestBody.create(this.categorias.get(i), mediaType);

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
