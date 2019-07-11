package main.apis;

import java.io.BufferedReader;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import main.conexao.Conexao;

public class Cotacao {
	
	public String getCotacao() {
		Conexao conexao = new Conexao(); 
		String json = conexao.connectionCotacao();	

		System.out.println(json);	
		json = converteJson(json);
		return json;
	}
	
	public String converteJson(String jsonString) {
		String cotacaoMoedas = "";
		try {
			JSONObject json = new JSONObject(jsonString);	
			JSONObject jsonValores = json.getJSONObject("valores");	
			JSONObject jsonDolar = jsonValores.getJSONObject("USD");
			JSONObject jsonBitcoin = jsonValores.getJSONObject("EUR");
			JSONObject jsonEuro = jsonValores.getJSONObject("BTC");
			
			cotacaoMoedas += "\n"+jsonDolar.getString("nome") + ": ";
			cotacaoMoedas += jsonDolar.getDouble("valor") + "\n";
			cotacaoMoedas += jsonEuro.getString("nome") + ": ";
			cotacaoMoedas += jsonEuro.getDouble("valor") + "\n";
			cotacaoMoedas += jsonBitcoin.getString("nome") + ": ";
			cotacaoMoedas += jsonBitcoin.getDouble("valor") + "\n";
			
				
			return cotacaoMoedas;
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return cotacaoMoedas;
	}
}
