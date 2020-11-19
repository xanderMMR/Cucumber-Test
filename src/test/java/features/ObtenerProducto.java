package features;

import entity.Producto;
import http.ObtenerFacturaHttp;
import http.ObtenerProductoHttp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ObtenerProducto {
    private ObtenerProductoHttp obtenerProductoHttp;

    @Before
    public void init() {
        this.obtenerProductoHttp = new ObtenerProductoHttp();
    }

    @Given("que ingreso al API {string} para obtener")
    public void que_ingreso_al_API(String string) {
        this.obtenerProductoHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para obtener")
    public void se_ubico_en_la_ruta(String string) {
        this.obtenerProductoHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para obtener")
    public void mediante_el_metodo(String string) {
        this.obtenerProductoHttp.setMethod(string);
    }

    @When("envio su peticion para obtener por ID")
    public void envio_su_peticion() throws IOException {
        this.obtenerProductoHttp.make();
    }

    @Then("obtuvo el producto")
    public void obtuvo_el_Producto() throws IOException {
        Producto producto = this.obtenerProductoHttp.obtenerProducto();
        assertEquals(producto.getName(),"InkaCola");
    }
}
