/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.tws2.contfiables.service;

import ec.tws2.tcs.contfiables.model.IDTarifaIva;
import ec.tws2.tcs.contfiables.model.Producto;
import java.util.Arrays;
import java.util.List;
import org.primefaces.shaded.json.JSONException;
import org.primefaces.shaded.json.JSONObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import ec.tws2.contfiables.enviroments.Enviroments;

/**
 *
 * @author marcatoma
 */
public class ProductosRestConsumer {

    private RestTemplate restTemplate;

    private final String serverCrud = Enviroments.SERVER;

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
        ResponseEntity<IDTarifaIva[]> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, IDTarifaIva[].class);
        IDTarifaIva[] responseBody = response.getBody();
        return Arrays.asList(responseBody);
    }

    public List<Producto> obtenerListaProductos() {
        restTemplate = new RestTemplate();
        String url = serverCrud + "/productos/list";
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("idCliente", "101");
        parameters.add("idProducto", "0");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, headers);
        ResponseEntity<List<Producto>> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, new ParameterizedTypeReference<List<Producto>>() {
        });
        List<Producto> responseBody = response.getBody();
        return responseBody;
    }

    public String guardarProducto(Producto pro) {

        try {
            restTemplate = new RestTemplate();
            String url = serverCrud + "/productos/completarRegistro";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            JSONObject jsonCliente = new JSONObject();
            jsonCliente.put("idCliente", 101);

            JSONObject jsonTipoIva = new JSONObject();
            jsonTipoIva.put("idTarifaIva", pro.getIdTarifaIva().getIdTarifaIva());

            JSONObject jsonProducto = new JSONObject();
            jsonProducto.put("idCliente", jsonCliente);

            JSONObject jsonIdProducto = new JSONObject();
            if (pro.getId() != 0) { // validar si existe un codigo o no (actualizar si existe / crear si no existe)
                jsonIdProducto.put("id", pro.getId());
            }

            jsonIdProducto.put("informacionAdicional", pro.getInformacionAdicional());
            jsonIdProducto.put("codigo", pro.getCodigo());
            jsonIdProducto.put("nombreProducto", pro.getNombreProducto());
            jsonIdProducto.put("precioUnitario", pro.getPrecioUnitario());
            jsonIdProducto.put("idTarifaIva", jsonTipoIva);

            jsonProducto.put("idProducto", jsonIdProducto);

            String requestBody = jsonProducto.toString();
            System.out.println("request guardar: " + requestBody);
            HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
            //ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestEntity, String.class);
            System.out.println("response del guardar: " + responseEntity.getBody());
            return responseEntity.getBody();
        } catch (JSONException ex) {
            System.out.println("Error al guardar el producto: " + ex.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return null;
        }
    }

}
