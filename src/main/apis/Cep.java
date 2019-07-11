package main.apis;

import org.json.JSONException;
import org.json.JSONObject;

import main.conexao.Conexao;

public class Cep {
	
	public String getCidade(String cep) {
		Conexao conexao = new Conexao(); 
		String json = conexao.connectionCep(cep);		
		json = converteJson(json);
		return json;
	}
	
	public String converteJson(String jsonString) {
		String endereco = "";
		try {
			JSONObject json = new JSONObject(jsonString);	
			endereco += "\n"+json.getString("localidade");
			endereco += "/"+json.getString("uf") + "\n";
							
			return endereco;
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return endereco;
	}


}
