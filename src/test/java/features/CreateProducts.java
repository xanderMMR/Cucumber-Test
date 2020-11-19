package features;

import entity.Producto;
import http.CreateProductsHttp;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableType;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Do;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class CreateProducts {
    private CreateProductsHttp createProductsHttp;
    private List<Integer> numbers;
    @Before
    public void init() {
        this.createProductsHttp = new CreateProductsHttp();
    }

    @Given("que ingreso al API {string} para agregar")
    public void que_ingreso_al_API_para_agregar(String string) {
        this.createProductsHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para agregar")
    public void se_ubico_en_la_ruta_para_agregar(String string) {
        this.createProductsHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para agregar")
    public void mediante_el_metodo_para_agregar(String string) {
        this.createProductsHttp.setMethod(string);
    }

    @Given("tengo el siguiente producto para agregar")
    public void tengo_el_siguiente_producto_para_agregar(DataTable dataTable) throws IOException {
        List<Map<String,String>> list = dataTable.asMaps(String.class, String.class);
        DataTable a= dataTable.subTable(0,3);
        List<Map<String,Double>> list1 = a.asMaps(String.class,double.class);
        for (int i = 0; i < list.size(); i++) {
            Producto producto = new Producto();
            producto.setName(list.get(i).get("Name"));
            producto.setStock(list1.get(i).get("Stock"));
            producto.setDescription(list.get(i).get("Description"));
            producto.setTags(list.get(i).get("Tags"));
            producto.setPrice(list1.get(i).get("Price"));
            this.createProductsHttp.createProduct(producto);
        }
    }

    @When("envio su peticion para agregar")
    public void envio_su_peticion_para_agregar() throws IOException {
        this.createProductsHttp.make();
    }

    @Then("se insertaron los productos")
    public void se_insertaron_los_productos() {
        List<Integer> codes = this.createProductsHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            assertTrue(codes.get(0) == 200);
        }
    }

}
