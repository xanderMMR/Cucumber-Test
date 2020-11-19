package features;

import entity.Producto;
import http.FiltrarPorNombreHttp;
import http.FiltrarPorPrecioHttp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class FiltrarPorPrecio {
    private FiltrarPorPrecioHttp filtrarPorPrecio;

    @Before
    public void init() {
        this.filtrarPorPrecio = new FiltrarPorPrecioHttp();
    }

    @Given("que ingreso al API {string} - FP")
    public void que_ingreso_al_API(String string) {
        this.filtrarPorPrecio.setUrl(string);
    }

    @Given("se ubico en la ruta {string} - FP")
    public void se_ubico_en_la_ruta(String string) {
        this.filtrarPorPrecio.setPath(string);
    }

    @Given("mediante el metodo {string} - FP")
    public void mediante_el_metodo(String string) {
        this.filtrarPorPrecio.setMethod(string);
    }

    @When("envio su peticion - FP")
    public void envio_su_peticion() throws IOException {
        this.filtrarPorPrecio.make();
    }

    @Then("obtuvo la lista de productos de acuerdo a su filtro - FP")
    public void obtuvo_la_lista_de_productos() throws IOException {
        List<Producto> productos = this.filtrarPorPrecio.filtrarProductoPorP();
        assertTrue(productos.size()!=0);

    }
}
