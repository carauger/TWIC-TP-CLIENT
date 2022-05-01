package service;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import beans.Ville;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
public class VilleService {
	
	public static final String ADRESSE_SERVER = "http://localhost:8181/";
	
	public List<Ville> getVilles() throws JsonParseException, JsonProcessingException, IOException {
		Client client = Client.create();
		URI uri = UriBuilder.fromUri("http://localhost:8181/").build();
		ClientResponse responseclient = client.resource(uri).path("villes").get(ClientResponse.class);
		String CorpsRepHttp = responseclient.getEntity(String.class);
		ObjectMapper mapper = new ObjectMapper();
		List<Ville> listevilles = mapper.readValue(CorpsRepHttp, new TypeReference<List<Ville>>() {});
		return listevilles;
	}
	
	
	public Ville trouverVille(String codeCommune) throws JsonParseException, JsonProcessingException, IOException {
		Client client = Client.create();
		URI uri = UriBuilder.fromUri("http://localhost:8181/").build();
		ClientResponse responseclient = client.resource(uri).path("ville").queryParam("codeInsee",codeCommune).get(ClientResponse.class);
		String CorpsRepHttp = responseclient.getEntity(String.class);

		ObjectMapper mapper = new ObjectMapper();
		Ville ville = mapper.readValue(CorpsRepHttp, new TypeReference<Ville>() {
		});
		return ville;
	}
	

	public void modifierVille(Ville ville, String code) throws  JsonParseException, JsonProcessingException, IOException {
		OkHttpClient client = new OkHttpClient();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(ville);
		RequestBody body = RequestBody.create(MediaTypeCreator.createMediaType("application/json; charset=utf-8"), json);
		Request request = new Request.Builder()
				.url("http://localhost:8181/ville?codeInsee="+code)
				.method("PUT", body)
				.addHeader("Content-Type", "application/json")
				.build();
		Response response = client.newCall(request).execute();
	}
	
	public void ajouterVille(Ville ville) throws JsonParseException, JsonProcessingException, IOException  {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(ville);
		OkHttpClient client = new OkHttpClient();
				RequestBody body = RequestBody.create(MediaTypeCreator.createMediaType("application/json"), json);
				Request request = new Request.Builder()
				  .url("http://localhost:8181/ville")
				  .method("POST", body)
				  .addHeader("Content-Type", "application/json")
				  .build();
		Response response = client.newCall(request).execute();
	}
	
	public void supprimerVille(Ville ville) throws JsonParseException, JsonProcessingException, IOException  {
		OkHttpClient client = new OkHttpClient();
		RequestBody body = RequestBody.create(MediaTypeCreator.createMediaType("text/plain"), "");
		Request request = new Request.Builder()
				  .url("http://localhost:8181/ville?codeInsee="+ville.getCodeCommuneINSEE())
				  .method("DELETE", body)
				  .build();
		Response response = client.newCall(request).execute();
	}
	
	
	
}