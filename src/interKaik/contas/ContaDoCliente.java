package interKaik.contas;

import javax.swing.JOptionPane;

public class ContaDoCliente {

private String login;
private String senha;
private String pix;
private double saldo;
private String[] favoritos = new String[5];

public ContaDoCliente(String login, String senha, String pix) {
  this.login = login;
  this.pix = pix;
  this.senha = senha;
  this.saldo = 0;
}

public ContaDoCliente(String login, String senha, double saldo, String pix) {
  this.login = login;
  this.senha = senha;
  this.saldo = saldo;
  this.pix = pix;
}

public String getLogin() {
	return login;
}

public String getPix() {
	return pix;
}

public void setPix(String pix) {
	this.pix = pix;
}

public String getSenha() {
	return senha;
}

public double getSaldo() {
	return saldo;
}

public void depositar(double valor) {
  if (valor<=0) {
	JOptionPane.showMessageDialog(null,"VALOR INVALIDO");
  return;	
  }
  JOptionPane.showMessageDialog(null,"VALOR DEPOSITADO COM SUCESSO");
  saldo += valor;
}

public void sacar(double valor) {
  if (valor<=0) {
    JOptionPane.showMessageDialog(null,"VALOR INVALIDO");
  return;
  }

  if (valor>saldo) {
   JOptionPane.showMessageDialog(null,"SALDO INSUFICIENTE");
  return;
  }
  
  saldo -= valor;
  JOptionPane.showMessageDialog(null,"VALOR SACADO COM SUCESSO");
}

public void enviar(double valor) {
	  saldo -= valor;
	}

public void receber(double valor) {
	  saldo += valor;
	}
}