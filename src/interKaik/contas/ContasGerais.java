package interKaik.contas;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
public class ContasGerais {
	
private ArrayList<ContaDoCliente> contas = new ArrayList<>();

public void criarConta(String login, String senha) {
    ContaDoCliente nova = new ContaDoCliente(login, senha);
    contas.add(nova);
}

public ContaDoCliente fazerLogin(String login, String senha) {
 for (ContaDoCliente conta : contas) {
   if (conta.getLogin().equals(login) && conta.getSenha().equals(senha)) {
     return conta;
 }
}
 
 return null;
}

public void excluirConta(ContaDoCliente conta) {
    contas.remove(conta);
 }

public void salvarContas() {
  try {
    FileWriter writer = new FileWriter("contas.txt");
    for (ContaDoCliente conta : contas) {
      writer.write(
        conta.getLogin() + ";" +
        conta.getSenha() + ";" +
        conta.getSaldo() + "\n"
                                 );
    }
    writer.close();
  } catch (IOException e) {
        System.out.println("ERRO AO SALVAR ARQUIVO.");
 }
}

public void carregarContas() {
 try {
   File file = new File("contas.txt");
   Scanner leitor = new Scanner(file);

      while (leitor.hasNextLine()) {
    	String linha = leitor.nextLine();
    	String[] partes = linha.split(";");

    	String login = partes[0];
    	String senha = partes[1];
    	double saldo = Double.parseDouble(partes[2]);

    	ContaDoCliente conta = new ContaDoCliente(login, senha, saldo);

    	while (conta.getSaldo() < saldo) {
          conta.depositar(1);
    	}
      contas.add(conta);
      }
   leitor.close();

 } catch (Exception e) {
  }
}

}