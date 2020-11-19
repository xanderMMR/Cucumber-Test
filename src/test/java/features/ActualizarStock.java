package features;

import entity.Producto;
import http.ActualizarProductoHttp;
import http.ActualizarStockHttp;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class ActualizarStock {
    private ActualizarStockHttp actualizarStockHttp;

    @Before
    public void init() {
        this.actualizarStockHttp = new ActualizarStockHttp();
    }

    @Given("que ingreso al API {string} para actualizar mi stock")
    public void que_ingreso_al_API_para_agregar(String string) {
        this.actualizarStockHttp.setUrl(string);
    }

    @Given("se ubica en la ruta {string} para actualizar stock")
    public void se_ubico_en_la_ruta_para_agregar(String string) {
        this.actualizarStockHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para actualizar stock")
    public void mediante_el_metodo_para_agregar(String string) {
        this.actualizarStockHttp.setMethod(string);
    }

    @Given("tengo el siguiente producto para actualizar mi stock")
    public void tengo_el_siguiente_producto_para_agregar(DataTable dataTable) throws IOException {
        List<Map<String,Double>> list = dataTable.asMaps(String.class,Double.class);
        for (int i = 0; i < list.size(); i++) {
            Producto producto = new Producto();
            //producto.setStock(list.get(i).get("Stock"));
            this.actualizarStockHttp.actualizarStock(producto);
        }
    }

    @When("envio su peticion para actualizar stock de producto")
    public void envio_su_peticion_para_agregar() throws IOException {
        this.actualizarStockHttp.make();
    }

    @Then("se actualiza el stock del prodducto")
    public void se_actualiza_stock() {
        List<Integer> codes = this.actualizarStockHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            assertTrue(codes.get(0) == 200);
        }
    }
}
