package ContaSimples;

public class ContaDoCliente {

private String login;
private String senha;
private double saldo;

public ContaDoCliente(String login, String senha) {
  this.login = login;
  this.senha = senha;
  this.saldo = 0;
}

public ContaDoCliente(String login, String senha, double saldo) {
  this.login = login;
  this.senha = senha;
  this.saldo = saldo;
}

public String getLogin() {
	return login;
}

public String getSenha() {
	return senha;
}

public double getSaldo() {
	return saldo;
}

public void depositar(double valor) {
  if (valor<=0) {
   System.out.println();
   System.out.println("VALOR INVALIDO!");
   System.out.println();
  return;	
  }

  saldo += valor;
   System.out.println();
   System.out.println("DEPOSITO REALIZADO COM SUCESSO!");
   System.out.println();
}

public void sacar(double valor) {
  if (valor<=0) {
    System.out.println();
    System.out.println("VALOR INVALIDO!");
    System.out.println();
  return;
  }

  if (valor>saldo) {
	System.out.println();
	System.out.println("VALOR INSUFICIENTE!");
	System.out.println();
  return;
  }
  
  saldo -= valor;
  System.out.println();
  System.out.println("SAQUE REALIZADO COM SUCESSO!");
  System.out.println();
}
}