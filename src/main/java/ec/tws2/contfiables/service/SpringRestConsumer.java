/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.tws2.contfiables.service;

/**
 *
 * @author juanc
 */
import ec.tws2.tcs.contfiables.model.IDTarifaIva;
import ec.tws2.tcs.contfiables.model.Producto;
import java.util.List;
import org.primefaces.shaded.json.JSONObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import ec.tws2.contfiables.enviroments.Enviroments;

public class SpringRestConsumer {

    private RestTemplate restTemplate;

    private final String serverCrud = Enviroments.SERVER;

    public String guardarUsuario(String file64,
            String identificacion,
            String password,
            String nombres,
            String apellidos,
            String clave,
            String ciudad,
            String telefono,
            int idTipoIdentificacion,
            String emailCliente,
            String user,
            String logo64) {
        restTemplate = new RestTemplate();
        String url = serverCrud + "/registro";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject json = new JSONObject();
        JSONObject jsonCliente = new JSONObject();
        JSONObject jsonTipoIdentificacion = new JSONObject();
        json.put("file64", file64);
        json.put("logo64", logo64);
        json.put("password", password);
        json.put("cliente", jsonCliente);
        jsonCliente.put("identification", identificacion);
        jsonCliente.put("nombres", nombres);
        jsonCliente.put("apellidos", apellidos);
        jsonCliente.put("clave", clave);
        jsonCliente.put("ciudad", ciudad);
        jsonCliente.put("telefono", telefono);
        jsonCliente.put("emailCliente", emailCliente);
        jsonCliente.put("user", user);
        jsonCliente.put("idTipoIdentificacion", jsonTipoIdentificacion);
        jsonTipoIdentificacion.put("id", idTipoIdentificacion);
        String requestBody = json.toString();
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        return responseEntity.getBody();
    }

    public String obtenerUsuario(String usuario) {
        restTemplate = new RestTemplate();
        String url = serverCrud + "/getCliente";
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("usuario", usuario);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String responseBody = response.getBody();
        System.out.println(responseBody);
        return responseBody;

    }

    // -------- rest de productos--------
    
    
    public Producto obtenerProducto(String valor) {
        restTemplate = new RestTemplate();
        String url = serverCrud + "/productos/producto";
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("idProducto", valor);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, headers);
        ResponseEntity<Producto> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, new ParameterizedTypeReference<Producto>() {
        });
        Producto responseBody = response.getBody();
        return responseBody;
    }

    public List<IDTarifaIva> obtenerListaIva() {
        restTemplate = new RestTemplate();
        String url = serverCrud + "/productos/listaIva";
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, headers);
        ResponseEntity<List<IDTarifaIva>> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, new ParameterizedTypeReference<List<IDTarifaIva>>() {
        });
        List<IDTarifaIva> responseBody = response.getBody();
        return responseBody;
    }

    public List<Producto> obtenerListaProductos() {
        restTemplate = new RestTemplate();
        String url = serverCrud + "/productos/list";
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("idCliente", "91");
        parameters.add("idProducto", "0");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, headers);
        ResponseEntity<List<Producto>> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, new ParameterizedTypeReference<List<Producto>>() {
        });
        List<Producto> responseBody = response.getBody();
        return responseBody;
    }

}
