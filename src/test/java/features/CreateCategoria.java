package features;

import entity.Categoria;
import entity.Producto;
import http.CreateCategoriaHttp;
import http.CreateProductsHttp;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class CreateCategoria {
    private CreateCategoriaHttp createCategoryHttp;

    @Before
    public void init() {
        this.createCategoryHttp = new CreateCategoriaHttp();
    }

    @Given("que ingreso al API {string} - categoria")
    public void que_ingreso_al_API_para_agregar(String string) {
        this.createCategoryHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para agregar - categoria")
    public void se_ubico_en_la_ruta_para_agregar(String string) {
        this.createCategoryHttp.setPath(string);
    }

    @Given("mediante un metodo {string} para agregar")
    public void mediante_el_metodo_para_agregar(String string) {
        this.createCategoryHttp.setMethod(string);
    }

    @Given("tengo las siguiente categorias para agregar")
    public void tengo_el_siguiente_producto_para_agregar(DataTable dataTable) throws IOException {
        List<Map<String,String>> list = dataTable.asMaps(String.class, String.class);
        for (int i = 0; i < list.size(); i++) {
            Categoria categoria = new Categoria();
            categoria.setName(list.get(i).get("Name"));
            this.createCategoryHttp.createCategoria(categoria);
        }
    }

    @When("envio su peticion para agregar categorias")
    public void envio_su_peticion_para_agregar() throws IOException {
        this.createCategoryHttp.make();
    }

    @Then("se insertaron las categorias")
    public void se_insertaron_las_categorias() {
        List<Integer> codes = this.createCategoryHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            assertTrue(codes.get(0) == 200);
        }
    }
}
