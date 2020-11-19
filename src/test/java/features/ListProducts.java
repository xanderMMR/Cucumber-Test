
package features;

import entity.Producto;
import http.ListProductsHttp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ListProducts {
    private ListProductsHttp listProductsHttp;

    @Before
    public void init() {
        this.listProductsHttp = new ListProductsHttp();
    }

    @Given("que ingreso al API {string}")
    public void que_ingreso_al_API(String string) {
        this.listProductsHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string}")
    public void se_ubico_en_la_ruta(String string) {
        this.listProductsHttp.setPath(string);
    }

    @Given("mediante el metodo {string}")
    public void mediante_el_metodo(String string) {
        this.listProductsHttp.setMethod(string);
    }

    @When("envio su peticion")
    public void envio_su_peticion() throws IOException {
        this.listProductsHttp.make();
    }

    @Then("obtuvo la lista de productos")
    public void obtuvo_la_lista_de_productos() throws IOException {
        List<Producto> productos = this.listProductsHttp.getProducts();
        assertTrue(productos.size() == 23);
    }
}
