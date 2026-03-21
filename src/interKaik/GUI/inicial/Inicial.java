package interKaik.GUI.inicial;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interKaik.GUI.servicos.Configuracao;
import interKaik.GUI.servicos.Deposito;
import interKaik.GUI.servicos.Saque;
import interKaik.GUI.servicos.Transferencia;
import interKaik.contas.ContaDoCliente;
import interKaik.contas.ContasGerais;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import interKaik.GUI.register.*;

public class Inicial extends JFrame {
private static final long serialVersionUID = 1L;
private JPanel contentPane;
private ContaDoCliente conta;
private ContasGerais sistema;

public Inicial(ContaDoCliente conta, ContasGerais sistema) {
this.conta = conta;
this.sistema = sistema;
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 1280, 720);
setResizable(false);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);
contentPane.setBackground(new Color(198, 199, 199));
		

JPanel panel = new JPanel() {
protected void paintComponent(java.awt.Graphics g) {
 java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
      g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING,
 java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setColor(new Color(232, 231, 229,130	));
      g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
      super.paintComponent(g);
 }
};

panel.setOpaque(false);
panel.setBounds(33, 29, 1220, 624);
setResizable(false);
panel.setLayout(null);
contentPane.add(panel);


	    
ImageIcon iconOriginal = new ImageIcon(getClass().getResource("/interKaik/GUI/img/logo.png"));
Image imagem1 = iconOriginal.getImage().getScaledInstance(260, 80, java.awt.Image.SCALE_SMOOTH);
ImageIcon logoIcon = new ImageIcon(imagem1);

JLabel logoLabel = new JLabel(logoIcon);
 logoLabel.setBounds(921, 27, 260, 80);
 panel.add(logoLabel);
		
JButton Sair = new JButton("SAIR");
Sair.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
    int resposta = JOptionPane.showConfirmDialog(
	  null,
	  "Deseja realmente sair?",
      "Confirmação",
	  JOptionPane.YES_NO_OPTION );
  if (resposta == JOptionPane.YES_OPTION) {
   System.exit(0);
    }
  }
});
 Sair.setForeground(Color.BLACK);
 Sair.setBounds(959, 521, 222, 43);
 panel.add(Sair);
 
 JButton saque = new JButton("SAQUE");
 saque.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
    Saque telaSaque = new Saque(conta, sistema);
 	telaSaque.setVisible(true);
 	telaSaque.setLocationRelativeTo(null);
 	dispose();
 	}
 });
 saque.setForeground(Color.BLACK);
 saque.setFont(new Font("Dialog", Font.BOLD, 12));
 saque.setBounds(44, 119, 293, 133);
 panel.add(saque);
 
 JButton btnDeposito = new JButton("DEPOSITO");
 btnDeposito.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
 	 Deposito telaDeposito = new Deposito(conta, sistema);
 	 telaDeposito.setVisible(true);
 	 telaDeposito.setLocationRelativeTo(null);
 	 dispose();
 	}
 });
 btnDeposito.setForeground(Color.BLACK);
 btnDeposito.setFont(new Font("Dialog", Font.BOLD, 12));
 btnDeposito.setBounds(44, 275, 293, 133);
 panel.add(btnDeposito);
 
 JButton TransferenciaPix = new JButton("TRANSFERENCIA PIX");
 TransferenciaPix.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 	  Transferencia telaDeposito = new Transferencia(conta, sistema);
 	  telaDeposito.setVisible(true);
 	  telaDeposito.setLocationRelativeTo(null);
 	  dispose();
 	}
 });
 TransferenciaPix.setForeground(Color.BLACK);
 TransferenciaPix.setFont(new Font("Dialog", Font.BOLD, 12));
 TransferenciaPix.setBounds(44, 427, 293, 137);
 panel.add(TransferenciaPix);
 
 JButton Extrato = new JButton("EXTRATO BANCARIO");
 Extrato.setForeground(Color.BLACK);
 Extrato.setFont(new Font("Dialog", Font.BOLD, 12));
 Extrato.setBounds(349, 427, 293, 137);
 panel.add(Extrato);
 
 JPanel panel_1 = new JPanel();
 panel_1.setBounds(349, 119, 598, 289);
 panel_1.setLayout(null);
 panel.add(panel_1);

 ImageIcon imgPanel1Original = new ImageIcon(getClass().getResource("/interKaik/GUI/img/fundo.png"));
 Image imgPanel1 = imgPanel1Original.getImage().getScaledInstance(598, 289, Image.SCALE_SMOOTH);
 ImageIcon imgPanel1Final = new ImageIcon(imgPanel1);

 JLabel labelImgPanel1 = new JLabel(imgPanel1Final);
 labelImgPanel1.setBounds(0, 0, 598, 289);

 panel_1.add(labelImgPanel1);
 
 JButton Configuracoes = new JButton("GERENCIAMENTO DA CONTA");
 Configuracoes.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 	Configuracao telaDeposito = new Configuracao(conta, sistema);
 	 telaDeposito.setVisible(true);
 	 telaDeposito.setLocationRelativeTo(null);
 	 dispose();
 	}
 });
 Configuracoes.setForeground(Color.BLACK);
 Configuracoes.setFont(new Font("Dialog", Font.BOLD, 12));
 Configuracoes.setBounds(654, 427, 293, 137);
 panel.add(Configuracoes);
 
 JPanel panel_2 = new JPanel();
 panel_2.setBounds(959, 119, 222, 289);
 panel_2.setLayout(null);
 panel.add(panel_2);

 ImageIcon imgPanel2Original = new ImageIcon(getClass().getResource("/interKaik/GUI/img/atendimento.jpg"));
 Image imgPanel2 = imgPanel2Original.getImage().getScaledInstance(222, 289, Image.SCALE_SMOOTH);
 ImageIcon imgPanel2Final = new ImageIcon(imgPanel2);

 JLabel labelImgPanel2 = new JLabel(imgPanel2Final);
 labelImgPanel2.setBounds(0, 0, 222, 289);

 panel_2.add(labelImgPanel2);
 
 JButton Atendimento = new JButton("ATENDIMENTO");
 Atendimento.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 		JOptionPane.showMessageDialog(null,"               NUMEROS PARA ATENDIMENTO    \n"
 				                         + "CAPITAIS:                                                (11) 4608 8232\n"
 				                         + "DEMAIS LOCALIDADES:                     (11) 0800 800 8909\n"
 				                         + "SAC(24h):                                                (11) 0800 800 8134\n"
 				                         + "\n                HORARIOS PARA ATENDIMENTO \n"
 				                         + "SEGUNDA À SEXTA:                              7:00h ÀS 21:00h.    \n"
 				                         + "SABADO, DOMINGO E FERIADOS:    9:00h ÀS 15:00h.    ");
 	}
 });
 Atendimento.setForeground(Color.BLACK);
 Atendimento.setBounds(959, 427, 222, 82);
 panel.add(Atendimento);
 
 JLabel lblOla = new JLabel("OLA,");
 lblOla.setFont(new Font("Dialog", Font.BOLD, 16));
 lblOla.setBounds(44, 93, 71, 14);
 panel.add(lblOla);
 
 JLabel lblNomeDoCliente = new JLabel(conta.getLogin().toUpperCase(getLocale())+".");
 lblNomeDoCliente.setFont(new Font("Dialog", Font.BOLD, 16));
 lblNomeDoCliente.setBounds(88, 93, 732, 14);
 panel.add(lblNomeDoCliente);
 
 JLabel lblSaldo = new JLabel("SALDO:");
 lblSaldo.setFont(new Font("Dialog", Font.BOLD, 16));
 lblSaldo.setBounds(44, 72, 71, 14);
 panel.add(lblSaldo);
 
 String Saldo = String.valueOf(conta.getSaldo());
 
 JLabel lblOla_2 = new JLabel(Saldo);
 lblOla_2.setFont(new Font("Dialog", Font.BOLD, 16));
 lblOla_2.setBounds(111, 72, 71, 14);
 panel.add(lblOla_2);
		
}
}
