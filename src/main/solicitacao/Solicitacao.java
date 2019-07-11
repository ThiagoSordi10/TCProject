package main.solicitacao;

import main.apis.Cep;
import main.apis.Cotacao;
import main.apis.Dicionario;
import main.apis.Tempo;

public class Solicitacao {
	
	public String processaSolicitacao(String mensagem) {
		if(mensagem.contains("/cotacao")) {
			Cotacao cot = new Cotacao();
			return cot.getCotacao();
		}
		if(mensagem.contains("/dicionario")) {
			Dicionario dicionario = new Dicionario();
			String[] palavra = mensagem.split(" ");
			return dicionario.getSignificado(palavra[1]);
		}
		if(mensagem.contains("/cep")) {
			Cep cep = new Cep();
			String[] palavra = mensagem.split(" ");
			return cep.getCidade(palavra[1]);
			
		}
		if(mensagem.contains("/clima")) {
			Tempo tempo = new Tempo();
			String[] palavra = mensagem.split(" ");
			return tempo.getTempo(palavra[1], palavra[2]);
			
		}
		if(mensagem.contains("/sobre")) {
			return "Componentes do grupo: \n Thiago Sordi \n Fernando Aguiar";
		}
		
		return "Conexão encerrada";
	}

}
