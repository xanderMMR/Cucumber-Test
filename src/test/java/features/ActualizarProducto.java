package features;

import entity.Categoria;
import entity.Producto;
import http.ActualizarProductoHttp;
import http.CreateCategoriaHttp;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.io.IOException;
import java.nio.DoubleBuffer;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class ActualizarProducto {
    private ActualizarProductoHttp actualizarProductoHttp;

    @Before
    public void init() {
        this.actualizarProductoHttp = new ActualizarProductoHttp();
    }

    @Given("que ingreso al API {string} para actualizar productos")
    public void que_ingreso_al_API_para_agregar(String string) {
        this.actualizarProductoHttp.setUrl(string);
    }

    @Given("se ubica en la ruta {string} para actualizar productos")
    public void se_ubico_en_la_ruta_para_agregar(String string) {
        this.actualizarProductoHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para actualizar productos")
    public void mediante_el_metodo_para_agregar(String string) {
        this.actualizarProductoHttp.setMethod(string);
    }

    @Given("tengo el siguiente producto para actualizarlo")
    public void tengo_el_siguiente_producto_para_agregar(DataTable dataTable) throws IOException {

        List<Map<String,String>> list = dataTable.asMaps(String.class, String.class);
        //Map<String,Double> list1 = dataTable.columns(2).asMap(String.class,Double.class);
        DataTable a= dataTable.subTable(0,3);
        List<Map<String,Double>> list1 = a.asMaps(String.class,double.class);

        for (int i = 0; i < list.size(); i++) {
            Producto producto = new Producto();
            producto.setName(list.get(i).get("Name"));
            producto.setDescription(list.get(i).get("Description"));
            producto.setPrice(list1.get(i).get("Price"));
            producto.setStock(list1.get(i).get("Stock"));
            producto.setTags(list.get(i).get("Tags"));
            this.actualizarProductoHttp.actualizarProduct(producto);
        }
    }

    @When("envio su peticion para actualizar producto")
    public void envio_su_peticion_para_agregar() throws IOException {
        this.actualizarProductoHttp.make();
    }

    @Then("se actualiza el producto")
    public void se_insertaron_las_categorias() {
        List<Integer> codes = this.actualizarProductoHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            assertTrue(codes.get(0) == 200);
        }
    }
}
