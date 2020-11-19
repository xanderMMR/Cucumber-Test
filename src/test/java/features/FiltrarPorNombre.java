package features;

import entity.Producto;
import http.FiltrarPorNombreHttp;
import http.ListProductsHttp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FiltrarPorNombre {
    private FiltrarPorNombreHttp filtrarPorNombre;

    @Before
    public void init() {
        this.filtrarPorNombre = new FiltrarPorNombreHttp();
    }

    @Given("que ingreso al API {string} - FN")
    public void que_ingreso_al_API(String string) {
        this.filtrarPorNombre.setUrl(string);
    }

    @Given("se ubico en la ruta {string} - FN")
    public void se_ubico_en_la_ruta(String string) {
        this.filtrarPorNombre.setPath(string);
    }

    @Given("mediante el metodo {string} - FN")
    public void mediante_el_metodo(String string) {
        this.filtrarPorNombre.setMethod(string);
    }

    @When("envio su peticion - FN")
    public void envio_su_peticion() throws IOException {
        this.filtrarPorNombre.make();
    }

    @Then("obtuvo la lista de productos de acuerdo a su filtro - FN")
    public void obtuvo_la_lista_de_productos() throws IOException {
        List<Producto> productos = this.filtrarPorNombre.filtrarProductoPorN();
        assertTrue(productos.size()!=0);

    }
}
