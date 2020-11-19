package http;

import com.google.gson.Gson;
import entity.Categoria;
import entity.Producto;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EliminarProductoHttp {
    private String url;
    private String path;
    private String method;
    private Response response;
    private Producto producto;
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

    public void make() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(this.buildUrl())
                .method(this.method, null)
                .build();
        this.response = client.newCall(request).execute();
    }

    public Producto eliminarProducto() throws IOException {
        Gson gson = new Gson();
        ResponseBody responseBody = this.response.body();
        return gson.fromJson(responseBody.string(), Producto.class);
    }

    private String buildUrl(){
        return this.url + this.path;
    }
}
