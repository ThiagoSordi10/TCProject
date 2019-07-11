package main.apis;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import main.conexao.Conexao;

public class Dicionario {
	
	public String getSignificado(String palavra) {
		Conexao conexao = new Conexao(); 
		String json = conexao.connectionDicionario(palavra);	

		System.out.println(json);	
		json = converteJson(json);
		return json;
	}
	
	public String converteJson(String jsonString) {
		String significado = "";
		try {
			JSONObject json = new JSONObject(jsonString);
			JSONArray jsonResults = new JSONArray("results");
			JSONObject jsonForm = jsonEntry.getJSONObject("sense");	
			/*JSONObject jsonBitcoin = jsonValores.getJSONObject("EUR");
			JSONObject jsonEuro = jsonValores.getJSONObject("BTC");*/
			
			significado += "\n"+jsonForm.getString("def");
			/*cotacaoMoedas += jsonDolar.getDouble("valor") + "\n";
			cotacaoMoedas += jsonEuro.getString("nome") + ": ";
			cotacaoMoedas += jsonEuro.getDouble("valor") + "\n";
			cotacaoMoedas += jsonBitcoin.getString("nome") + ": ";
			cotacaoMoedas += jsonBitcoin.getDouble("valor") + "\n";*/
			System.out.println(significado);
			return significado;
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return significado;
	}

}
