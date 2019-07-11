package main.conexao;

import java.io.*;
import java.net.*;

public class Conexao {
	
	public String connectionCotacao() {
		try {
			URL url = new URL("https://api.promasters.net.br/cotacao/v1/valores");
			URLConnection con = url.openConnection();
			con.addRequestProperty("User-Agent", "Mozilla/4.76");
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	                                    con.getInputStream()));
	        String inputLine;
	        String json = "";
	        while ((inputLine = in.readLine()) != null) 
	            json += inputLine;
	        in.close();
	        return json;
			
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public String connectionDicionario(String palavra) {
		try {
			URL url = new URL("https://od-api.oxforddictionaries.com:443/api/v1/entries/en/"+palavra);
			URLConnection con = url.openConnection();
			con.setRequestProperty("Accept", "application/json");
			con.setRequestProperty("app_id", "6fb404c6");
			con.setRequestProperty("app_key", "ba84e8790e1136ae6874fdec18a5b478");
			con.addRequestProperty("User-Agent", "Mozilla/4.76");
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	                                    con.getInputStream()));
	        String inputLine;
	        String json = "";
	        while ((inputLine = in.readLine()) != null) 
	            json += inputLine;
	        in.close();
	        return json;
			
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
		
	public String connectionTempo() {
		try {
			URL url = new URL("https://apiadvisor.climatempo.com.br/api/v1/weather/locale/5425/"
					+ "current?token=5b7c5c86e19096ece82f98647aea8758");
			URLConnection con = url.openConnection();
			con.addRequestProperty("User-Agent", "Mozilla/4.76");
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	                                    con.getInputStream()));
	        String inputLine;
	        String json = "";
	        while ((inputLine = in.readLine()) != null) 
	            json += inputLine;
	        in.close();
	        return json;
			
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	public String connectionCep(String cep) {
		try {
			
			URL url = new URL("https://viacep.com.br/ws/"+cep+"/json/");
			URLConnection con = url.openConnection();
			con.addRequestProperty("User-Agent", "Mozilla/4.76");
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	                                    con.getInputStream()));
	        String inputLine;
	        String json = "";
	        while ((inputLine = in.readLine()) != null) 
	            json += inputLine;
	        in.close();
	        return json;
			
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
