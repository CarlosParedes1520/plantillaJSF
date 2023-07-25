/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.tws2.contfiables.service;

import ec.tws2.tcs.contfiables.model.Cliente;
import ec.tws2.contfiables.enviroments.Enviroments;
import ec.tws2.tcs.contfiables.model.FileSignature;
import ec.tws2.tcs.contfiables.model.IDTipoIdentificacion;
import org.primefaces.shaded.json.JSONException;
import org.primefaces.shaded.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author marcatoma
 */
public class UsuariosRestConsumer {

    private RestTemplate restTemplate;

    private final String serverCrud = Enviroments.SERVER;

    public Cliente obtenerUsuario() {
        restTemplate = new RestTemplate();
        String url = serverCrud + "/getCliente";
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("usuario", "prueba11");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, headers);
        ResponseEntity<Cliente> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Cliente.class);
        Cliente responseBody = response.getBody();
        System.out.println("status: " + response.getStatusCode());
        System.out.println("response: " + response.hasBody());
        return responseBody;
    }

    public String obtenerLogo(String ruc) {
        restTemplate = new RestTemplate();
        String url = serverCrud + "/logo";
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("ruc", "0104282587001");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String responseBody = response.getBody();
        System.out.println("response " + responseBody);
        return responseBody;

    }
    
  public FileSignature actualizarUsuario(FileSignature cli) {
        try {

            restTemplate = new RestTemplate();

            String url = serverCrud + "/actualizarCliente";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            JSONObject jsonCliente = new JSONObject();
            JSONObject jsonFilesignature = new JSONObject();
            jsonCliente.put("idCliente", 118);
            jsonCliente.put("nombres", cli.getCliente().getNombres());
            jsonCliente.put("identification", cli.getCliente().getIdentification());
            jsonCliente.put("apellidos", cli.getCliente().getApellidos());
            jsonCliente.put("ciudad", cli.getCliente().getCiudad());
            jsonCliente.put("telefono", cli.getCliente().getTelefono());
            jsonCliente.put("emailCliente", cli.getCliente().getEmailCliente());
            cli.setFile64("");
            cli.setLogo64("");
            jsonFilesignature.put("cliente", jsonCliente);
            jsonFilesignature.put("logo64", cli.getLogo64());
            jsonFilesignature.put("file64", cli.getFile64());

            String requestBody = jsonFilesignature.toString();
            System.out.println("JSON: " + requestBody);
            HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
            ResponseEntity<FileSignature> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, FileSignature.class);
            System.out.println("Guardar: " + responseEntity.getBody());
            System.out.println("respuesta al guardar: " + responseEntity.getBody());
            return responseEntity.getBody();
        } catch (JSONException ex) {
            System.out.println("Error al actualizar el usuario: " + ex.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return null;
        }
    }

    }

