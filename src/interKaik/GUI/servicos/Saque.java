package interKaik.GUI.servicos;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import interKaik.GUI.inicial.Inicial;
import interKaik.contas.ContaDoCliente;
import interKaik.contas.ContasGerais;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class Saque extends JFrame {
private static final long serialVersionUID = 1L;
private JPanel contentPane;
private ContaDoCliente conta;
private int Valor = 0;	
private JLabel labelValor;
private JPasswordField Senha1;
private JPasswordField Senha2;
private ContasGerais sistema;



public Saque(ContaDoCliente conta, ContasGerais sistema) {
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
 logoLabel.setBounds(907, 17, 313, 102);
 panel.add(logoLabel);
		
JButton btnSair = new JButton("SAIR");
btnSair.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
	 
  int resposta = JOptionPane.showConfirmDialog(
      null,
      "Deseja realmente sair?",
      "Confirmação",
  JOptionPane.YES_NO_OPTION );
    if (resposta == JOptionPane.YES_OPTION) {
    	Inicial novaTela = new Inicial(conta, sistema);
    	novaTela.setVisible(true);
    	novaTela.setLocationRelativeTo(null);
    	dispose();
    	
    }
 }
});
 btnSair.setForeground(Color.BLACK);
 btnSair.setBounds(962, 556, 222, 43);
 panel.add(btnSair);
 
 JPanel panel_1 = new JPanel();
 panel_1.setBounds(34, 37, 252, 59);
 panel_1.setLayout(null);
 panel.add(panel_1);
 
 JLabel label = new JLabel(String.valueOf(conta.getSaldo()));
 label.setFont(new Font("Dialog", Font.BOLD, 25));
 label.setBounds(51, 17, 189, 30);
 panel_1.add(label);
 
 JLabel lblR = new JLabel("R$");
 lblR.setFont(new Font("Dialog", Font.BOLD, 25));
 lblR.setBounds(12, 17, 337, 30);
 panel_1.add(lblR);
 
 JPanel panel_2 = new JPanel();
 panel_2.setBounds(39, 131, 880, 452);
 panel_2.setLayout(null);
 panel.add(panel_2);
 
 JButton botao100 = new JButton("R$ 100,00");
 botao100.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 	  Valor += 100;
 	  labelValor.setText(String.valueOf(Valor));
 	}
 });
 botao100.setBounds(22, 39, 170, 69);
 panel_2.add(botao100);
 
 JButton botao200 = new JButton("R$ 200,00");	
 botao200.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 	  Valor += 200;
 	  labelValor.setText(String.valueOf(Valor));
 	}
 });
 botao200.setBounds(22, 191, 170, 69);
 panel_2.add(botao200);
 
 JButton botao300 = new JButton("R$ 300,00");
 botao300.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 	 Valor += 300;
 	 labelValor.setText(String.valueOf(Valor));
 	}
 });
 botao300.setBounds(22, 353, 170, 69);
 panel_2.add(botao300);
 
 JButton botao400 = new JButton("R$ 400,00");
 botao400.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 	 Valor += 400;
 	 labelValor.setText(String.valueOf(Valor));
 	}
 });
 botao400.setBounds(687, 39, 170, 69);
 panel_2.add(botao400);
 
 JButton botao500 = new JButton("R$ 500,00");
 botao500.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 	 Valor += 500;
 	 labelValor.setText(String.valueOf(Valor));
 	}
 });
 botao500.setBounds(687, 191, 170, 69);
 panel_2.add(botao500);
 
 JButton outros = new JButton("OUTROS");
 outros.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
 	String outro = JOptionPane.showInputDialog(null, "DIGITE O VALOR DESEJADO");
       if (outro != null) { 
          try {
            Valor = Integer.parseInt(outro);
            labelValor.setText(String.valueOf(Valor));
          } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "DIGITE APENAS NUMEROS!");
          }
 }}});
 outros.setBounds(687, 353, 170, 69);
 panel_2.add(outros);
 
 JPanel panel_4 = new JPanel();
 panel_4.setBackground(Color.LIGHT_GRAY);
 panel_4.setBounds(218, 39, 432, 383);
 panel_2.add(panel_4);
 panel_4.setLayout(null);
 
 JLabel lblValor = new JLabel("R$:");
 lblValor.setHorizontalAlignment(SwingConstants.CENTER);
 lblValor.setFont(new Font("Dialog", Font.BOLD, 20));
 lblValor.setBounds(143, 78, 57, 53);
 panel_4.add(lblValor);
 
 labelValor = new JLabel(String.valueOf(Valor));
 labelValor.setHorizontalAlignment(SwingConstants.LEFT);
 labelValor.setFont(new Font("Dialog", Font.BOLD, 20));
 labelValor.setBounds(195, 78, 209, 53);
 panel_4.add(labelValor);
 
 JLabel lblNewLabel = new JLabel("SENHA:");
 lblNewLabel.setBounds(65, 199, 55, 14);
 panel_4.add(lblNewLabel);
 
 JLabel lblConfirmeASua = new JLabel("CONFIRME A SUA SENHA:");
 lblConfirmeASua.setBounds(65, 259, 177, 14);
 panel_4.add(lblConfirmeASua);
 
 Senha1 = new JPasswordField();
 Senha1.setBounds(65, 211, 299, 24);
 panel_4.add(Senha1);
 
 Senha2 = new JPasswordField();
 Senha2.setBounds(65, 272, 299, 24);
 panel_4.add(Senha2);
 
 JButton btnConfirmar = new JButton("CONFIRMAR");
 getRootPane().setDefaultButton(btnConfirmar);
 btnConfirmar.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 	  String senha = new String(Senha1.getPassword());
 	  String confirma = new String(Senha2.getPassword());

 	   if(senha.isEmpty() || confirma.isEmpty()){
 		 JOptionPane.showMessageDialog(null,"PREENCHA LOGIN E SENHA");
 	   return;
 	   }
  	  if(!senha.equals(confirma)){
  		JOptionPane.showMessageDialog(null,"SENHAS NÃO COINCIDEM!");
  	   return;
  	  }
 	   
 	  if(senha.equals(confirma)){
 		if(senha.equals(conta.getSenha())) {
 		  conta.sacar(Valor);
 		  label.setText(String.valueOf(conta.getSaldo()));
 		  sistema.salvarContas();
 		}
 	  }
 	}
 });
 btnConfirmar.setBounds(143, 332, 146, 24);
 panel_4.add(btnConfirmar);
  
 JLabel lblSaque = new JLabel("SAQUE");
 lblSaque.setFont(new Font("Dialog", Font.BOLD, 16));
 lblSaque.setBounds(218, 23, 95, 14);
 panel_2.add(lblSaque);
 
 JPanel foto = new JPanel();
 foto.setBounds(962, 131, 222, 413);
 panel.add(foto);
 
 ImageIcon imgPanel3Original = new ImageIcon(getClass().getResource("/interKaik/GUI/img/saque.jpg"));
 Image imgPanel3 = imgPanel3Original.getImage().getScaledInstance(300, 460, Image.SCALE_SMOOTH);
 ImageIcon imgPanel3Final = new ImageIcon(imgPanel3);
 foto.setLayout(null);

 JLabel labelImgPanel3 = new JLabel(imgPanel3Final);
 labelImgPanel3.setBounds(-29, -13, 281, 440);

 foto.add(labelImgPanel3);
 

		
}
}
