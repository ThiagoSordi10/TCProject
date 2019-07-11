package main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import main.solicitacao.Solicitacao;

public class Principal {
	public static void main(String[] args) {
		try {
			ServerSocket socketServidor = new ServerSocket(8080, 40);
			
			Scanner scan = new Scanner(System.in);
			String mensagemRecebida = "";
			String mensagemEnviada = "";
			Solicitacao solicitacao = new Solicitacao();
			
			while(true) {
				
				System.out.println("Esperando conexão...");
				Socket conexao = socketServidor.accept();
				System.out.println("Conexão recebida: Cliente com IP: " + conexao.getInetAddress());
			
				InputStream streamEntrada = conexao.getInputStream();
				OutputStream streamSaida = conexao.getOutputStream();
				
				BufferedReader entrada = new BufferedReader(new InputStreamReader(streamEntrada));	
				DataOutputStream saida = new DataOutputStream(streamSaida);
				saida.writeBytes("Conexão feita");
				

				while(!mensagemRecebida.contains("/sair")) {
					mensagemRecebida = entrada.readLine();					
					System.out.println(mensagemRecebida);
					mensagemEnviada = solicitacao.processaSolicitacao(mensagemRecebida);
					System.out.println(mensagemEnviada);
					saida.writeBytes(mensagemEnviada + "\n");
				}	
				
				conexao.close();
			}
		} catch (IOException ex) {
			System.out.println("Erro!");
		}
	}

}
