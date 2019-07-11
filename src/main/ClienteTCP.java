package main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {
	public static void main(String[] args) {
		try {
			System.out.println("Solicitando conexão...");
			Socket conexao = new Socket("192.168.7.146", 8080);
			System.out.println("Conexão estabelecida...");
			
			Scanner scan = new Scanner(System.in);
			String mensagemRecebida = "";
			String mensagemEnviada = "";
			
			while(true) {
				
				InputStream streamEntrada = conexao.getInputStream();
				OutputStream streamSaida = conexao.getOutputStream();
				
				BufferedReader entrada = new BufferedReader(new InputStreamReader(streamEntrada));	
				DataOutputStream saida = new DataOutputStream(streamSaida);
				
				do {
					
					mensagemRecebida = entrada.readLine();
					System.out.println(mensagemRecebida);
					
					System.out.print(">> ");
					mensagemEnviada = scan.nextLine();
					saida.writeBytes(mensagemEnviada + "\n");
					
					
				} while(!mensagemRecebida.equals("end") && !mensagemEnviada.equals("end"));
				
				conexao.close();
			}
		} catch (IOException ex) {
			System.out.println("Erro!");
		}
	}
}
