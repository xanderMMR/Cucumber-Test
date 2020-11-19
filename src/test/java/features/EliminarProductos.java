package features;

import entity.Categoria;
import entity.Producto;
import http.EliminarProductoHttp;
import http.ListCategoriaHttp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class EliminarProductos {
    private EliminarProductoHttp eliminarProductoHttp;

    @Before
    public void init() {
        this.eliminarProductoHttp = new EliminarProductoHttp();
    }

    @Given("que ingreso al API {string} para eliminar")
    public void que_ingreso_al_API_eliminarproducto(String string) {
        this.eliminarProductoHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para eliminar")
    public void se_ubico_en_la_ruta_producto(String string) {
        this.eliminarProductoHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para eliminar")
    public void mediante_el_metodo_delete(String string) {
        this.eliminarProductoHttp.setMethod(string);
    }

    @When("envio su peticion para eliminar")
    public void envio_su_peticion_eliminar() throws IOException {
        this.eliminarProductoHttp.make();
    }

    @Then("se eliminaron los productos")
    public void eliminoProducto() throws IOException {

        Producto productos = this.eliminarProductoHttp.eliminarProducto();
        assertEquals(productos.getName(),"Prueba");
        assertNotNull(productos);
    }
}
