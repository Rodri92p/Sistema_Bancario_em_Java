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
import javax.swing.JFormattedTextField;

public class Transferencia extends JFrame {
private static final long serialVersionUID = 1L;
private JPanel contentPane;
private ContaDoCliente conta;
private ContasGerais sistema;
private JPasswordField Senha;
private JPasswordField ConfirmarSenha;



public Transferencia(ContaDoCliente conta, ContasGerais sistema) {
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
 btnSair.setBounds(962, 556, 222, 43);
 panel.add(btnSair);
 
 JPanel panel_1 = new JPanel();
 panel_1.setBounds(39, 38, 252, 59);
 panel_1.setLayout(null);
 panel.add(panel_1);

 
 JLabel lblR = new JLabel("R$");
 lblR.setFont(new Font("Dialog", Font.BOLD, 25));
 lblR.setBounds(12, 17, 337, 30);
 panel_1.add(lblR);
 
 JPanel panel_2 = new JPanel();
 panel_2.setBounds(39, 131, 880, 468);
 panel_2.setLayout(null);
 panel.add(panel_2);
 
 JPanel panel_4 = new JPanel();
 panel_4.setBackground(Color.LIGHT_GRAY);
 panel_4.setBounds(37, 43, 432, 402);
 panel_2.add(panel_4);
 panel_4.setLayout(null);
 
 JLabel Destinatario = new JLabel("");
 Destinatario.setFont(new Font("Dialog", Font.BOLD, 16));
 Destinatario.setBounds(121, 36, 299, 14);
 panel_4.add(Destinatario);
 
 JFormattedTextField PixDestino = new JFormattedTextField();
 PixDestino.setBounds(27, 155, 374, 27);
 panel_4.add(PixDestino);
 PixDestino.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {

	    public void insertUpdate(javax.swing.event.DocumentEvent e) {
	        atualizarDestinatario();
	    }

	    public void removeUpdate(javax.swing.event.DocumentEvent e) {
	        atualizarDestinatario();
	    }

	    public void changedUpdate(javax.swing.event.DocumentEvent e) {
	        atualizarDestinatario();
	    }

	    private void atualizarDestinatario() {
	        String pix = PixDestino.getText();
	        ContaDoCliente c = sistema.buscarContaPorPix(pix);

	        if (c != null) {
	            Destinatario.setText(c.getLogin());
	        }
	        else {
	            Destinatario.setText(" ");
	        }}}
 );
 
 JFormattedTextField formattedTextField_1 = new JFormattedTextField();
 formattedTextField_1.setBackground(new Color(255, 255, 255));
 formattedTextField_1.setBounds(27, 220, 374, 27);
 panel_4.add(formattedTextField_1);
 
 JLabel label = new JLabel(String.valueOf(conta.getSaldo()));
 label.setFont(new Font("Dialog", Font.BOLD, 25));
 label.setBounds(51, 17, 189, 30);
 panel_1.add(label);
 
 JLabel lblDestinatario = new JLabel("CHAVE PIX:");
 lblDestinatario.setBounds(27, 140, 94, 14);
 panel_4.add(lblDestinatario);
 
 JLabel lblValor = new JLabel("VALOR:");
 lblValor.setBounds(27, 205, 94, 14);
 panel_4.add(lblValor);
 

 
 JLabel lblDestino = new JLabel(" DESTINO:");
 lblDestino.setFont(new Font("Dialog", Font.BOLD, 16));
 lblDestino.setBounds(27, 36, 358, 14);
 panel_4.add(lblDestino);
 
 JLabel lblSaque = new JLabel("PIX");
 lblSaque.setFont(new Font("Dialog", Font.BOLD, 16));
 lblSaque.setBounds(37, 25, 95, 14);
 panel_2.add(lblSaque);
 
 JPanel panel_5 = new JPanel();
 panel_5.setBackground(Color.LIGHT_GRAY);
 panel_5.setBounds(481, 43, 387, 48);
 panel_2.add(panel_5);
 panel_5.setLayout(null);
 
 JLabel suaChave = new JLabel(conta.getPix());
 suaChave.setFont(new Font("Dialog", Font.BOLD, 16));
 suaChave.setBounds(12, 18, 363, 14);
 panel_5.add(suaChave);
 
 JPanel panel_6 = new JPanel();
 panel_6.setBackground(Color.LIGHT_GRAY);
 panel_6.setBounds(481, 172, 387, 271);
 panel_2.add(panel_6);
 panel_6.setLayout(null);
 
 Senha = new JPasswordField();
 Senha.setBounds(50, 66, 288, 27);
 panel_6.add(Senha);
 
 JLabel lblInsiraASenha = new JLabel("INSIRA A SENHA:");
 lblInsiraASenha.setBounds(52, 53, 122, 14);
 panel_6.add(lblInsiraASenha);
 
 ConfirmarSenha = new JPasswordField();
 ConfirmarSenha.setBounds(50, 136, 288, 27);
 panel_6.add(ConfirmarSenha);
 
 JLabel lblValor_2 = new JLabel("CONFIRME A SENHA:");
 lblValor_2.setBounds(50, 122, 137, 14);
 panel_6.add(lblValor_2);
 
 
 JButton btnConfirmar = new JButton("CONFIRMAR");
 btnConfirmar.setBounds(50, 187, 288, 72);
 panel_6.add(btnConfirmar);
 getRootPane().setDefaultButton(btnConfirmar);
 btnConfirmar.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 		
 	String pixDestino = PixDestino.getText();
    String valor = formattedTextField_1.getText();
    String senha = new String(Senha.getPassword());
    String confirme = new String(ConfirmarSenha.getPassword());
    
     if (pixDestino.isEmpty() || valor.isEmpty() || senha.isEmpty() || confirme.isEmpty()) {
       JOptionPane.showMessageDialog(null, "PREENCHA OS DADOS CORRETAMENTES!");
     return;
     }
        
    ContaDoCliente destino = sistema.buscarContaPorPix(pixDestino);
    double ValorAtual = Double.parseDouble(valor);
    
        
     if (destino == null) {
       JOptionPane.showMessageDialog(null, "PIX NÃO ENCONTRADO!");
     return;
     }
        
     if (destino.getPix().equals(conta.getPix())) {
       JOptionPane.showMessageDialog(null, "VOCÊ NÃO PODE TRANSFERIR PARA SI MESMO!");
     return;
     }
     
     if(!senha.equals(confirme)) {
       JOptionPane.showMessageDialog(null, "AS SENHAS NÃO ESTÃO IGUAIS!");
     return; 
     }
     
     if(ValorAtual > conta.getSaldo()) {
         JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE!");
     return;     	 
     }
     
     if(ValorAtual <= 0) {
         JOptionPane.showMessageDialog(null, "VALOR INVALIDO!");
     return;     	 
     }
    conta.enviar(ValorAtual);
    destino.receber(ValorAtual);
    label.setText(String.valueOf(conta.getSaldo()));
    sistema.salvarContas();
    JOptionPane.showMessageDialog(null, "TRANSFERENCIA REALIZADA COM SUCESSO!");
    }
 });
 
 JLabel lblSuaChave = new JLabel("SUA CHAVE:");
 lblSuaChave.setFont(new Font("Dialog", Font.BOLD, 15));
 lblSuaChave.setBounds(481, 27, 118, 14);
 panel_2.add(lblSuaChave);
 
 JPanel foto = new JPanel();
 foto.setBounds(962, 131, 222, 413);
 panel.add(foto);
 
 ImageIcon imgPanel3Original = new ImageIcon(getClass().getResource("/interKaik/GUI/img/pix.jpg"));
 Image imgPanel3 = imgPanel3Original.getImage().getScaledInstance(300, 460, Image.SCALE_SMOOTH);
 ImageIcon imgPanel3Final = new ImageIcon(imgPanel3);
 foto.setLayout(null);

 JLabel labelImgPanel3 = new JLabel(imgPanel3Final);
 labelImgPanel3.setBounds(-29, -13, 281, 440);

 foto.add(labelImgPanel3);
 
 	
}
}
