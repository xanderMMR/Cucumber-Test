package features;

import entity.Factura;
import entity.Producto;
import http.ListProductsHttp;
import http.ObtenerFacturaHttp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ObtenerFactura {
    private ObtenerFacturaHttp listFacturaHttp;

    @Before
    public void init() {
        this.listFacturaHttp = new ObtenerFacturaHttp();
    }

    @Given("que ingreso al API {string} - vendedor_factura")
    public void que_ingreso_al_API(String string) {
        this.listFacturaHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} - vendedor_factura")
    public void se_ubico_en_la_ruta(String string) {
        this.listFacturaHttp.setPath(string);
    }

    @Given("mediante el metodo {string} - vendedor_factura")
    public void mediante_el_metodo(String string) {
        this.listFacturaHttp.setMethod(string);
    }

    @When("envio su peticion - vendedor_factura")
    public void envio_su_peticion() throws IOException {
        this.listFacturaHttp.make();
    }

    @Then("obtuvo la lista de facturas - vendedor_factura")
    public void obtuvo_la_lista_de_factura() throws IOException {
        List<Factura> factura = this.listFacturaHttp.getFactura();
        assertNotNull(factura);
    }
}
