package main.apis;

import org.json.JSONException;
import org.json.JSONObject;

import main.conexao.Conexao;

public class Tempo {
	
	public String getTempo(String estado, String cidade) {
		Conexao conexao = new Conexao(); 
		
		
		String jsonTempo = conexao.connectionTempo();
		String tempo = converteJsonTempo(jsonTempo);
		return tempo;
	}
	
	
	public String converteJsonTempo(String jsonString) {
		String tempo = "";
		try {
			JSONObject json = new JSONObject(jsonString);	
			JSONObject jsonData = json.getJSONObject("data");	

			
			tempo += "\n"+jsonData.getString("condition") + "\n";
			tempo += "Temperatura: "+jsonData.getInt("temperature") + "\n";
			
				
			return tempo;
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return tempo;
	}

}
