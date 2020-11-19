package features;

import entity.Producto;
import entity.Vendedor;
import http.CreateProductsHttp;
import http.CreateVendedorHttp;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class CreateVendedor {
    private CreateVendedorHttp createVendedorHttp;
    private List<Integer> numbers;
    @Before
    public void init() {
        this.createVendedorHttp = new CreateVendedorHttp();
    }

    @Given("que ingreso al API {string} para agregar - vendedor")
    public void que_ingreso_al_API_para_agregar(String string) {
        this.createVendedorHttp.setUrl(string);
    }

    @Given("se ubico en la ruta {string} para agregar - vendedor")
    public void se_ubico_en_la_ruta_para_agregar(String string) {
        this.createVendedorHttp.setPath(string);
    }

    @Given("mediante el metodo {string} para agregar - vendedor")
    public void mediante_el_metodo_para_agregar(String string) {
        this.createVendedorHttp.setMethod(string);
    }

    @Given("tengo el siguiente vendedor para agregar - vendedor")
    public void tengo_el_siguiente_producto_para_agregar(DataTable dataTable) throws IOException {
        List<Map<String,String>> list = dataTable.asMaps(String.class, String.class);
        for (int i = 0; i < list.size(); i++) {
            Vendedor vendedor = new Vendedor();
            vendedor.setAddress(list.get(i).get("Address"));
            vendedor.setPassword(list.get(i).get("Password"));
            vendedor.setDate(list.get(i).get("Date"));
            vendedor.setDni(list.get(i).get("DNI"));
            vendedor.setEmail(list.get(i).get("Email"));
            vendedor.setN_mobile(list.get(i).get("N_mobile"));
            vendedor.setName(list.get(i).get("Name"));
            vendedor.setUsername(list.get(i).get("Username"));
            vendedor.setLastname(list.get(i).get("Lastname"));
            this.createVendedorHttp.createVendedor(vendedor);
        }
    }

    @When("envio su peticion para agregar - vendedor")
    public void envio_su_peticion_para_agregar() throws IOException {
        this.createVendedorHttp.make();
    }

    @Then("se registro vendedor")
    public void se_inserto_el_vendedor() {
        List<Integer> codes = this.createVendedorHttp.getResponseStatusCodes();

        for (int i = 0; i < codes.size(); i++) {
            System.out.println(codes.get(0));
            assertTrue(codes.get(0) == 200);
        }
    }
}
