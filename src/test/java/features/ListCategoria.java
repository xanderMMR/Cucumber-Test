
package features;

import entity.Categoria;
import entity.Producto;
import http.ListCategoriaHttp;
import http.ListProductsHttp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ListCategoria {
    private ListCategoriaHttp listCategoriaHttp;

    @Before
    public void init() {
        this.listCategoriaHttp = new ListCategoriaHttp();
    }

    @Given("que se ingreso al API {string}")
    public void que_ingreso_al_API_categoria(String string) {
        this.listCategoriaHttp.setUrl(string);
    }

    @Given("y se ubico en la ruta {string}")
    public void se_ubico_en_la_ruta_categoria(String string) {
        this.listCategoriaHttp.setPath(string);
    }

    @Given("mediante un metodo {string}")
    public void mediante_el_metodo_categoria(String string) {
        this.listCategoriaHttp.setMethod(string);
    }

    @When("envio su peticion para listar las categorias")
    public void envio_su_peticion_categoria() throws IOException {
        this.listCategoriaHttp.make();
    }

    @Then("obtuvo la lista de categoria")
    public void obtuvo_la_lista_de_categorias() throws IOException {
        List<Categoria> categoria= this.listCategoriaHttp.getCategoria();
        assertTrue(categoria.size() == 40  );
    }
}
