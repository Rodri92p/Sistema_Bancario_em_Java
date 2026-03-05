package ContaSimples;

import java.util.Scanner;
public class Sistema {
Scanner scan = new Scanner(System.in);

private ContasGerais gerencia = new ContasGerais();
private ContaDoCliente conta = null;

int opcao;
int opcaoInicio;

public void inicio() {
 do {
  gerencia.carregarContas();
   System.out.println("[1] LOGIN");
   System.out.println("[2] REGISTRO");
   System.out.println("[3] SAIR");
   System.out.println(); 
   System.out.print("OP: ");
   opcaoInicio = scan.nextInt();
   
   switch(opcaoInicio) {
   case 1: login(); break;
   case 2: criarconta(); break;
   case 3: sair(); break;
   default: System.out.println("OPÇÃO INVALIDA!");
   }
 } while(opcaoInicio != 3);
}

private void login() {
  System.out.println("-----------------------");
  System.out.println("+   BANCO  INTERKAIK  +");
  System.out.println("-----------------------");
  System.out.println();
  System.out.print("LOGIN: ");
  String login = scan.next();
  System.out.print("SENHA: ");
  String senha = scan.next();

  conta = gerencia.fazerLogin(login, senha);

  if (conta != null) {
	  menu();
  }
  
  else {
	System.out.println();
	System.out.println("CONTA INVALIDA OU NÃO EXISTE.");
	System.out.println();
  }
}

private void criarconta() {
  System.out.print("LOGIN: ");
  String login = scan.next();
  System.out.print("SENHA: ");
  String senha = scan.next();
  
  gerencia.criarConta(login, senha);
  System.out.println();
  System.out.println("CONTA CRIADA!");
  System.out.println();
  
  login();
}

private void menu() {
do {
 System.out.println("-----------------------");
 System.out.println("+   BANCO  INTERKAIK  +");
 System.out.println("-----------------------");
 System.out.println();
 System.out.println("[1] SAQUE");
 System.out.println("[2] DEPOSITO");
 System.out.println("[3] MOSTRAR SALDO");
 System.out.println("[4] SAIR");
 System.out.println("[5] EXCLUIR CONTA");
 System.out.println();
 System.out.print("OP: ");
 opcao = scan.nextInt();

  switch(opcao) {
  case 1: saque(); break;
  case 2: deposito(); break;
  case 3: exibirSaldo(); break;
  case 4: sair(); break;
  case 5: excluir(); break;
  default: System.out.println("OPCAO INVALIDA!");
  }
 }while (opcao != 4);
}

private void exibirSaldo() {
	System.out.println();
	System.out.println("SEU SALDO ATUALIZADO: "+conta.getSaldo());
}

private void saque() {
  System.out.println();
  System.out.println("---------------------");
  System.out.println("+       SAQUE       +");
  System.out.println("---------------------");
  System.out.println("SEU SALDO: "+conta.getSaldo());
  System.out.println();
  System.out.print("VALOR: ");
  double valor = scan.nextDouble();
  conta.sacar(valor);
}

private void deposito() {
  System.out.println();
  System.out.println("---------------------");
  System.out.println("+      DEPOSITO     +");
  System.out.println("---------------------");
  System.out.println("SEU SALDO: "+conta.getSaldo());
  System.out.println();
  System.out.print("VALOR: ");
  double valor = scan.nextDouble();
  conta.depositar(valor);
}

private void excluir() {
  System.out.println("VOCÊ TEM CERTEZA DISSO?[S/N]");
  String certeza = scan.next();
  
  if(certeza.equalsIgnoreCase("S")) {
    gerencia.excluirConta(conta);
    System.out.println();
    System.out.println("CONTA EXCLUIDA COM SUCESSO.");
    System.out.println();
    sair();
    opcao = 4;
    return;
  }
}

private void sair() {
 gerencia.salvarContas();
 System.out.println();
 opcaoInicio = 3;
 System.out.println("OBRIGADO POR USAR NOSSO BANCO!");	
 }
}
