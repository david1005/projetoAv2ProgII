package dell;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
	private boolean login_sistema;
	private JFrame LoginDeSistema;
	private JTextField textField;
	private JPasswordField passwordField;

	// MÉTODO MAIN
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.LoginDeSistema.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// CONSTRUTOR PADRÃO
	public Login() {
		inicializar();
	}

	// MÉTODO DE INICIALIZAÇÃO
	private void inicializar() {
		LoginDeSistema = new JFrame();
		LoginDeSistema
				.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/dell/send-user.png")));
		LoginDeSistema.setTitle("Login de Sistema");
		LoginDeSistema.setResizable(false);
		LoginDeSistema.setBounds(100, 100, 459, 234);
		LoginDeSistema.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LoginDeSistema.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, null, null, null));
		panel.setBounds(0, 0, 453, 206);
		LoginDeSistema.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		// lblNewLabel.setIcon(new ImageIcon("C:\\dell\\SALVATORY\\Desktop\\img.png"));
		lblNewLabel.setBounds(24, 11, 140, 163);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Digite seu Login e Senha");
		lblNewLabel_1.setForeground(UIManager.getColor("Button.disabledForeground"));
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 18));
		lblNewLabel_1.setBounds(174, 28, 261, 29);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2.setBounds(168, 82, 102, 37);
		panel.add(lblNewLabel_2);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 30));
		lblSenha.setBounds(164, 129, 102, 37);
		panel.add(lblSenha);

		textField = new JTextField();
		textField.setBounds(273, 85, 151, 25);
		panel.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(273, 132, 151, 25);
		panel.add(passwordField);

		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().equalsIgnoreCase("davi")
						&& passwordField.getText().equalsIgnoreCase("100510")) {
					login_sistema = true;
					LoginDeSistema.dispose();
					Principal2 p = new Principal2();
					p.setVisible(true);
					// windows.frame.setVisible(true);

				} else if (!textField.getText().equalsIgnoreCase("davi")
						|| !passwordField.getText().equalsIgnoreCase("100510")) {
					JOptionPane.showMessageDialog(null, "Usuario e senha incorreto");
				}
			}
		});

		btnLogar.setBounds(335, 168, 89, 23);
		panel.add(btnLogar);

		JButton btnLimpar = new JButton("Limpar");

		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField.setText("");
				passwordField.setText("");

			}
		});
		btnLimpar.setBounds(232, 168, 89, 23);
		panel.add(btnLimpar);
	}

	public boolean islogin_sistema() {
		return login_sistema;
	}

}
