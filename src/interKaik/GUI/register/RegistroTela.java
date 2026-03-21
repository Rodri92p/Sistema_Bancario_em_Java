package interKaik.GUI.register;

import javax.swing.ImageIcon;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interKaik.GUI.login.loginTela;
import interKaik.contas.ContasGerais;

public class RegistroTela extends JFrame {
private static final long serialVersionUID = 1L;
private JPanel contentPane;
private JPasswordField Senha;
private JPasswordField RepetirSenha;
private ContasGerais sistema;

public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
 try {
   RegistroTela frame = new RegistroTela();
   frame.setVisible(true);
   frame.setLocationRelativeTo(null);
 } catch (Exception e) {
   e.printStackTrace();
   }
}
});
}
public RegistroTela(ContasGerais sistema) {
	this();
    this.sistema = sistema;
}

public RegistroTela() {
this.sistema = new ContasGerais();
	
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setResizable(false);
setBounds(100, 100, 450, 487);
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
panel.setBounds(34, 34, 392, 390);
setResizable(false);
panel.setLayout(null);
contentPane.add(panel);
		
JFormattedTextField Pix = new JFormattedTextField();
Pix.setBounds(23, 168, 338, 23);
panel.add(Pix);


	    
ImageIcon iconOriginal = new ImageIcon(getClass().getResource("/interKaik/GUI/img/logo.png"));
Image imagem2 = iconOriginal.getImage().getScaledInstance(260, 80, java.awt.Image.SCALE_SMOOTH);
ImageIcon logoIcon = new ImageIcon(imagem2);

JLabel logoLabel = new JLabel(logoIcon);
 logoLabel.setBounds(72, 12, 240, 80);
 panel.add(logoLabel);
	    	
 Senha = new JPasswordField();
 Senha.setBounds(23, 214, 338, 23);
 panel.add(Senha);
		
JLabel labelSenha = new JLabel("SENHA:");
 labelSenha.setFont(new Font("Dialog", Font.BOLD, 13));
 labelSenha.setForeground(Color.BLACK);
 labelSenha.setBounds(23, 199, 55, 14);
 panel.add(labelSenha);
		
JLabel labelLogin = new JLabel("PIX:");
 labelLogin.setFont(new Font("Dialog", Font.BOLD, 13));
 labelLogin.setForeground(Color.BLACK);
 labelLogin.setBounds(23, 153, 55, 14);
 panel.add(labelLogin);
		
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
 Sair.setBounds(116, 354, 158, 24);
 panel.add(Sair);
 
 JLabel labelRPT = new JLabel("REPITA A SUA SENHA:");
 labelRPT.setForeground(Color.BLACK);
 labelRPT.setFont(new Font("Dialog", Font.BOLD, 13));
 labelRPT.setBounds(23, 249, 167, 14);
 panel.add(labelRPT);
 
 RepetirSenha = new JPasswordField();
 RepetirSenha.setBounds(23, 265, 338, 23);
 panel.add(RepetirSenha);
 
 JFormattedTextField Login = new JFormattedTextField();
 Login.setBounds(23, 118, 338, 23);
 panel.add(Login);
 
 JButton Confirmar = new JButton("CONFIRMAR");
 getRootPane().setDefaultButton(Confirmar);
 Confirmar.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
	  String login = Login.getText();
	  String pix = Pix.getText();
	  String senha = new String(Senha.getPassword());
	  String repete = new String(RepetirSenha.getPassword());

   if(login.isEmpty() || senha.isEmpty() || repete.isEmpty() || pix.isEmpty() ){
	 JOptionPane.showMessageDialog(null,"PREENCHA OS DADOS CORRETAMENTE.");
   return;
   }
	    
   if(!senha.equals(repete)) {
	 JOptionPane.showMessageDialog(null,"AS SENHAS NÃO CONFEREM");
   return; 
   }
     sistema.criarConta(login, senha, pix);
     sistema.salvarContas();
     JOptionPane.showMessageDialog(null,"CADASTRO FEITO COM SUCESSO");
     loginTela novaTela = new loginTela(sistema);
     novaTela.setVisible(true);
     novaTela.setLocationRelativeTo(null);

     dispose();
   }
 });
 Confirmar.setForeground(Color.BLACK);
 Confirmar.setBounds(88, 300, 212, 24);
 panel.add(Confirmar);
 
 JLabel labelLogin_1 = new JLabel("LOGIN:");
 labelLogin_1.setForeground(Color.BLACK);
 labelLogin_1.setFont(new Font("Dialog", Font.BOLD, 13));
 labelLogin_1.setBounds(23, 104, 55, 14);
 panel.add(labelLogin_1);
 

		
}
}
