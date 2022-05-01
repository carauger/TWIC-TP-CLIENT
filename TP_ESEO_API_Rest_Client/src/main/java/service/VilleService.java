package service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Ville;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VilleService {
	
	public static final String ADRESSE_SERVER = "http://localhost:8181/";
	
	public List<Ville> getVilles() throws JsonMappingException, JsonProcessingException {
		String url = ADRESSE_SERVER + "VilleAfficher";
		String get = "";
		try {
			HttpClient httpclient = HttpClientBuilder.create().build();
			HttpGet httpget = new HttpGet(url);
			HttpResponse response = httpclient.execute(httpget);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			get = rd.readLine();
		} catch (IOException e) {
			e.getMessage();
		}

		String jsonString = get;
		ObjectMapper mapper = new ObjectMapper();
		List<Ville> villes = mapper.readValue(jsonString, new TypeReference<List<Ville>>(){});
		return villes;
	}
	
	
	public Ville trouverVille(String codeCommune) throws JsonMappingException, JsonProcessingException {
		String url = ADRESSE_SERVER + "VilleAfficher?codeCommune=" + codeCommune;
		String get = "";
		try {
			HttpClient httpclient = HttpClientBuilder.create().build();
			HttpGet httpget = new HttpGet(url);
			HttpResponse response = httpclient.execute(httpget);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			get = rd.readLine();
		} catch (IOException e) {
			e.getMessage();
		}

		String jsonString = get;
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Ville ville = mapper.readValue(jsonString, Ville.class);
		return ville;
	}
	

	public void modifierVille(Ville ville) throws UnsupportedEncodingException {
		String url = ADRESSE_SERVER + "VilleModifier?Code_commune_INSEE=" + ville.getCodeCommuneINSEE()
		+ "&Nom_commune=" + URLEncoder.encode(ville.getNomCommune(), "UTF-8")
		+ "&Code_postal=" + ville.getCodePostal()
		+ "&Libelle_acheminement=" + URLEncoder.encode(ville.getLibelleAcheminement(), "UTF-8")
		+ "&Ligne_5=" + ville.getLigne5()
		+ "&Latitude=" + ville.getLatitude()
		+ "&Longitude=" + ville.getLongitude();
		try {
			HttpClient httpclient = HttpClientBuilder.create().build();
			HttpPut put = new HttpPut(url);
			httpclient.execute(put);
		} catch (IOException e) {
			e.getMessage();
		}
	}
	
	public void ajouterVille(Ville ville) throws UnsupportedEncodingException {
		String url = ADRESSE_SERVER + "VilleAjouter?Code_commune_INSEE=" + ville.getCodeCommuneINSEE()
		+ "&Nom_commune=" + URLEncoder.encode(ville.getNomCommune(), "UTF-8")
		+ "&Code_postal=" + ville.getCodePostal()
		+ "&Libelle_acheminement=" + URLEncoder.encode(ville.getLibelleAcheminement(), "UTF-8")
		+ "&Ligne_5=" + ville.getLigne5()
		+ "&Latitude=" + ville.getLatitude()
		+ "&Longitude=" + ville.getLongitude();
		try {
			HttpClient httpclient = HttpClientBuilder.create().build();
			HttpPost post = new HttpPost(url);
			httpclient.execute(post);
		} catch (IOException e) {
			e.getMessage();
		}
	}
	
	//EN COURS DE DEV
	public void supprimerVille(Ville ville) throws JsonMappingException, JsonProcessingException {
		String url = ADRESSE_SERVER + "VilleSupprimer?codeCommune=" + ville.getCodeCommuneINSEE();

	}
	
	
}