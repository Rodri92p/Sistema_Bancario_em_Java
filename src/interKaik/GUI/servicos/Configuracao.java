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

public class Configuracao extends JFrame {
private static final long serialVersionUID = 1L;
private JPanel contentPane;
private ContaDoCliente conta;	
private ContasGerais sistema;


public Configuracao(ContaDoCliente conta, ContasGerais sistema) {
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
 logoLabel.setBounds(12, 17, 313, 102);
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
 btnSair.setBounds(965, 568, 222, 43);
 panel.add(btnSair);
 
 JPanel panel_2 = new JPanel();
 panel_2.setBounds(39, 131, 1148, 425);
 panel_2.setLayout(null);
 panel.add(panel_2);
 
 JButton botao100 = new JButton("EXCLUIR CONTA");
 botao100.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
    int resposta = JOptionPane.showConfirmDialog(
 	    null,
 	    "Deseja realmente excluir a conta?",
 	    "Confirmação",
     JOptionPane.YES_NO_OPTION );
 		if (resposta == JOptionPane.YES_OPTION) {
 			int resposta2 = JOptionPane.showConfirmDialog(
 			 	    null,
 			 	        "LEMBRANDO, TODOS OS DADOS ESTARÃO PERDIDOS (CASO TENHA SALDO DEVERÁ RETIRÁ-LO ANTES DO CANCELAMENTO).\n"
 			 			+ "\nVOCÊ CONFIRMA QUE ESTÁ CIENTE E QUE DESEJA A EXCLUSÃO DA CONTA?",
 			 	    "Confirmação",
 			        JOptionPane.YES_NO_OPTION );
 			if (resposta2 == JOptionPane.YES_OPTION) {
 				sistema.excluirConta(conta);
 				sistema.salvarContas();
 				JOptionPane.showMessageDialog(null,"CONTA EXCLUIDA COM SUCESSO\n"
 						+ "OBRIGADO POR USAR NOSSOS SERVIÇOS, ATÉ UMA OUTRA HORA.");
 				System.exit(0); 				
 			}
 	}}
 });
 botao100.setBounds(22, 24, 351, 162);
 panel_2.add(botao100);
 }
}
