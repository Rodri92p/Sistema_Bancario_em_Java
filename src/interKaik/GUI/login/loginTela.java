package interKaik.GUI.login;

import javax.swing.ImageIcon;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import interKaik.GUI.inicial.Inicial;
import interKaik.GUI.register.RegistroTela;
import interKaik.contas.ContaDoCliente;
import interKaik.contas.ContasGerais;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loginTela extends JFrame {
private static final long serialVersionUID = 1L;
private JPanel contentPane;
private JPasswordField SENHA;
private ContasGerais sistema;


public static void main(String[] args) {

ContasGerais sistema = new ContasGerais();
EventQueue.invokeLater(new Runnable() {
  
public void run() {
 try {
	 sistema.carregarContas();
     loginTela frame = new loginTela(sistema);
     frame.setVisible(true);
     frame.setLocationRelativeTo(null);
     
 } catch (Exception e) {
     e.printStackTrace();
 }
}
});
}

public loginTela(ContasGerais sistema) {
	this();
    this.sistema = sistema;
}


public loginTela() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 450, 487);
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
panel.setBounds(34, 34, 392, 390);
setResizable(false);
panel.setLayout(null);
contentPane.add(panel);
		
JFormattedTextField USER = new JFormattedTextField();
USER.setBounds(23, 168, 338, 23);
panel.add(USER);
	    
ImageIcon iconOriginal = new ImageIcon(getClass().getResource("/interKaik/GUI/img/logo.png"));
Image imagem = iconOriginal.getImage().getScaledInstance(260, 80, java.awt.Image.SCALE_SMOOTH);
ImageIcon logoIcon = new ImageIcon(imagem);

JLabel logo = new JLabel(logoIcon);
 logo.setBounds(62, 37, 260, 80);
 panel.add(logo);
	    	
 SENHA = new JPasswordField();
 SENHA.setBounds(23, 217, 338, 23);
 panel.add(SENHA);
		
JLabel Senha = new JLabel("SENHA:");
 Senha.setFont(new Font("Dialog", Font.BOLD, 13));
 Senha.setForeground(Color.BLACK);
 Senha.setBounds(23, 203, 55, 14);
 panel.add(Senha);
		
JLabel login = new JLabel("LOGIN:");
 login.setFont(new Font("Dialog", Font.BOLD, 13));
 login.setForeground(Color.BLACK);
 login.setBounds(23, 156, 55, 14);
 panel.add(login);
		
JLabel SemConta = new JLabel("AINDA NÃO TEM CONTA?");
SemConta.setFont(new Font("Dialog", Font.PLAIN, 12));
 SemConta.setForeground(Color.BLACK);
 SemConta.setBounds(62, 250, 158, 14);
 panel.add(SemConta);
		
JButton CliqueAqui = new JButton("CLIQUE AQUI");
CliqueAqui.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
  RegistroTela novaTela = new RegistroTela(sistema);
  novaTela.setVisible(true);
  novaTela.setLocationRelativeTo(null);

  dispose();
	}
});
CliqueAqui.setFont(new Font("Dialog", Font.BOLD, 12));
 CliqueAqui.setForeground(Color.BLACK);
 CliqueAqui.setBounds(217, 248, 124, 19);
 panel.add(CliqueAqui);
 
JButton btnSair = new JButton("SAIR");
 btnSair.addActionListener(new ActionListener() {
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
 
 btnSair.setForeground(Color.BLACK);
 btnSair.setBounds(116, 354, 158, 24);
 panel.add(btnSair);
 
JButton Entrar = new JButton("ENTRAR");
getRootPane().setDefaultButton(Entrar);
 Entrar.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
  String login = USER.getText();
  String senha = new String(SENHA.getPassword());

   if(login.isEmpty() || senha.isEmpty()){
     JOptionPane.showMessageDialog(null,"PREENCHA LOGIN E SENHA");
   return;
   }
    
   ContaDoCliente conta = sistema.fazerLogin(login, senha);

   if(conta != null){
     Inicial novaTela = new Inicial(conta, sistema);
     novaTela.setVisible(true);
     novaTela.setLocationRelativeTo(null);

     dispose();
   } 
   else {
     JOptionPane.showMessageDialog(null,"LOGIN E SENHA INCORRETOS");
   }
  }
 });
 Entrar.setForeground(Color.BLACK);
 Entrar.setBounds(94, 286, 199, 24);
 panel.add(Entrar);
		
}
}
