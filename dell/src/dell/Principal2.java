package dell;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class Principal2 extends JFrame implements ActionListener {
	JFrame frame;
	private JMenu Inicio;
	private JTextField TfNome;
	private JTextField TfEmail;
	private JTextField TfPreco;
	private JTextField Tfquant;
	private JTextField TfnomeProd;
	private JTextField tFCod;
	private JTextField campoCpf;
	
	JButton btnAdicionar, button, btnEditar, btnExcluir;
	JMenuBar menuBar;
	JMenu Menu, Menu1, Menu2, Menu3;
	JMenuItem NovoProduto, NovoCliente, Logout;

	JPanel panel_CardLayout, panel_CardLayout_produto, panel_CardLayout_cliente, panel1, panel2;
	JLabel Label, Label2, Label3, lblEmail, lblCpf, lblCadastroDeProdutos;
	JLabel lblProduto, lblQuant, lblPreo, lblCodigo;
	JList<Cliente> list;
	JScrollPane scrollPane;
	ClienteDao dao;

	// CONSTRUTOR PADRÃO CHAMANDO MÉTODO INICIALIZAR
	public Principal2() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Principal2.class.getResource("/dell/system-settings-icon_31831.png")));
		setResizable(false);
		getContentPane().setLocation(-6, -180);
		setBounds(100, 100, 572, 500);

		// SETANDO MENU DE OPÇÕES
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		Inicio = new JMenu("Inicio");
		menuBar.add(Inicio);

		Menu = new JMenu("Caixa");
		menuBar.add(Menu);

		Menu1 = new JMenu("Estoque");
		menuBar.add(Menu1);
		NovoProduto = new JMenuItem("Novo Produto");
		NovoProduto.setSelectedIcon(new ImageIcon(Principal2.class.getResource("/dell/plus.png")));
		Menu1.add(NovoProduto);

		Menu2 = new JMenu("Clientes");
		menuBar.add(Menu2);
		NovoCliente = new JMenuItem("Novo Cliente");
		Menu2.add(NovoCliente);
		Menu3 = new JMenu("Sair");
		menuBar.add(Menu3);

		Logout = new JMenuItem("Fechar");
		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		Menu3.add(Logout);
		getContentPane().setLayout(null);

		// ISTANCIÂNDO CARDLAYOUT
		panel_CardLayout = new JPanel();
		panel_CardLayout.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, null, null, null));
		panel_CardLayout.setForeground(Color.WHITE);
		panel_CardLayout.setBounds(10, 11, 540, 164);
		getContentPane().add(panel_CardLayout);
		panel_CardLayout.setLayout(new CardLayout(0, 0));

		panel_CardLayout_produto = new JPanel();
		panel_CardLayout_produto.setBackground(Color.WHITE);
		panel_CardLayout.add(panel_CardLayout_produto, "name_18587918482325");
		panel_CardLayout_produto.setLayout(null);

		// INSTÂNCIANDO CARDLAYOUT DE CADASTRO DE CLIENTES

		Label2 = new JLabel("Cadastro de Cliente");
		Label2.setFont(new Font("Roboto", Font.BOLD, 18));
		Label2.setForeground(Color.DARK_GRAY);
		Label2.setBackground(Color.WHITE);
		Label2.setBounds(167, 4, 227, 26);
		panel_CardLayout_produto.add(Label2);

		// INSTÂNCIANDO JLABELS E TEXTFIELD CLIENTE
		Label = new JLabel("");
		Label.setIcon(new ImageIcon(Principal2.class.getResource("/dell/add_user.png")));
		Label.setBounds(10, 31, 128, 101);
		panel_CardLayout_produto.add(Label);

		Label2 = new JLabel("Nome:");
		Label2.setForeground(Color.GRAY);
		Label2.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 18));
		Label2.setBounds(148, 39, 70, 26);
		panel_CardLayout_produto.add(Label2);

		lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.GRAY);
		lblEmail.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 18));
		lblEmail.setBounds(148, 70, 70, 26);
		panel_CardLayout_produto.add(lblEmail);

		lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(Color.GRAY);
		lblCpf.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 18));
		lblCpf.setBounds(148, 104, 70, 26);
		panel_CardLayout_produto.add(lblCpf);

		// CAMPO NOME CLIENTE
		TfNome = new JTextField();
		TfNome.setBounds(218, 42, 293, 20);
		panel_CardLayout_produto.add(TfNome);
		TfNome.setColumns(10);

		// CAMPO E-MAIL CLEINTE
		TfEmail = new JTextField();
		TfEmail.setColumns(10);
		TfEmail.setBounds(218, 74, 293, 20);
		panel_CardLayout_produto.add(TfEmail);

		// CAMPO CPF
		campoCpf = new JTextField();
		campoCpf.setColumns(10);
		campoCpf.setBounds(218, 104, 196, 20);
		panel_CardLayout_produto.add(campoCpf);

		panel_CardLayout_cliente = new JPanel();
		panel_CardLayout_cliente.setBackground(Color.WHITE);
		panel_CardLayout.add(panel_CardLayout_cliente, "name_18636222739818");
		panel_CardLayout_cliente.setLayout(null);

		// CARDLAYOUT DE CADASTRO DE PRODUTOS
		lblCadastroDeProdutos = new JLabel("Cadastro de Produtos");
		lblCadastroDeProdutos.setForeground(Color.DARK_GRAY);
		lblCadastroDeProdutos.setFont(new Font("Roboto", Font.BOLD, 18));
		lblCadastroDeProdutos.setBackground(Color.WHITE);
		lblCadastroDeProdutos.setBounds(168, 6, 227, 26);
		panel_CardLayout_cliente.add(lblCadastroDeProdutos);

		// INSTÂNCIANDO JLABELS E TEXTFIELD PRODUTO
		Label3 = new JLabel("");
		Label3.setIcon(new ImageIcon(Principal2.class.getResource("/dell/produto.jpg")));
		Label3.setBounds(7, 32, 134, 117);
		panel_CardLayout_cliente.add(Label3);

		lblProduto = new JLabel("Produto:");
		lblProduto.setForeground(Color.GRAY);
		lblProduto.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 18));
		lblProduto.setBounds(146, 39, 78, 26);
		panel_CardLayout_cliente.add(lblProduto);

		lblQuant = new JLabel("Quant.");
		lblQuant.setForeground(Color.GRAY);
		lblQuant.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 18));
		lblQuant.setBounds(154, 70, 70, 26);
		panel_CardLayout_cliente.add(lblQuant);

		lblPreo = new JLabel("Preço.");
		lblPreo.setForeground(Color.GRAY);
		lblPreo.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 18));
		lblPreo.setBounds(154, 104, 70, 26);
		panel_CardLayout_cliente.add(lblPreo);

		// CAIXA DE TEXTO DE PREÇO (CADASTRO DE PRODUTOS )
		TfPreco = new JTextField();
		TfPreco.setColumns(10);
		TfPreco.setBounds(224, 106, 62, 20);
		panel_CardLayout_cliente.add(TfPreco);

		// CAIXA DE TEXTO DE QUANTIDADE (CADASTRO DE PRODUTOS)
		Tfquant = new JTextField();
		Tfquant.setColumns(10);
		Tfquant.setBounds(224, 74, 61, 20);
		panel_CardLayout_cliente.add(Tfquant);

		// CAIXA DE TEXTO DE NOME PRODUTO (CADASTRO DE PRODUTOS)
		TfnomeProd = new JTextField();
		TfnomeProd.setColumns(10);
		TfnomeProd.setBounds(224, 42, 293, 20);
		panel_CardLayout_cliente.add(TfnomeProd);

		lblCodigo = new JLabel("Codigo:");
		lblCodigo.setForeground(Color.GRAY);
		lblCodigo.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 18));
		lblCodigo.setBounds(313, 70, 70, 26);
		panel_CardLayout_cliente.add(lblCodigo);

		// CAIXA DE TEXTO DE CODIGO (CADASTRO DE PRODUTOS)
		tFCod = new JTextField();
		tFCod.setColumns(10);
		tFCod.setBounds(402, 74, 115, 20);
		panel_CardLayout_cliente.add(tFCod);

		panel1 = new JPanel();
		panel1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, null, null, null));
		panel1.setBounds(10, 182, 540, 35);
		getContentPane().add(panel1);
		panel1.setLayout(null);

		// BOTÃO ADCIONAR
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(382, 4, 89, 28);
		btnAdicionar.addActionListener(this);
		panel1.add(btnAdicionar);

		// BOTÃO EDITAR
		btnEditar = new JButton("Limpar");
		btnEditar.setBounds(225, 4, 89, 28);
		btnEditar.addActionListener(this);
		panel1.add(btnEditar);

		// BOTÃO EXCLUIR
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(64, 4, 89, 28);
		btnExcluir.addActionListener(this);
		panel1.add(btnExcluir);

		panel2 = new JPanel();
		panel2.setBounds(10, 223, 540, 213);
		getContentPane().add(panel2);
		panel2.setLayout(null);

		//// ACAO PARA CHARMAR CARDLAYOUT CADASTRO_CLIENTE
		NovoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) panel_CardLayout.getLayout();
				cl.show(panel_CardLayout, "name_18636222739818");
			}
		});
		NovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) panel_CardLayout.getLayout();
				cl.show(panel_CardLayout, "name_18587918482325");
			}
		});

		list = new JList();
		scrollPane = new JScrollPane(list);
		scrollPane.setBounds(0, 0, 538, 213);
		scrollPane.setViewportView(list);
		panel2.add(scrollPane);
		list.setForeground(new Color(119, 136, 153));

		dao = new ClienteDaoJDBC();
		carregarModelo(dao.clientes());
	}

	public void carregarModelo(List<Cliente> clientes) {
		DefaultListModel model = new DefaultListModel();
		for (Cliente cliente : clientes) {
			model.addElement(cliente);
		}
		list.setModel(model);
	}  

	@Override
	public void actionPerformed(ActionEvent e) {
		// AÇÃO DO BOTÃO ADICIONAR
		if (e.getSource() == btnAdicionar) {
			carregarModelo(dao.clientes());
			try {
				String nome = TfNome.getText().trim();
				String email = TfEmail.getText().trim();
				String cpf = campoCpf.getText().trim();
				if (nome.equals("")) {
					JOptionPane.showMessageDialog(null, "O campo não pode ser vazio...");
					return;
				}
				dao.inserir(new Cliente(nome, email, cpf));
			} catch (NumberFormatException nf) {
				JOptionPane.showMessageDialog(null, "O valor do campo é inválido...");
			}
			carregarModelo(dao.clientes());
		}
		// AÇÃO DO BOTÃO EXCLUIR
		if (e.getSource() == btnExcluir) {
			int index = list.getSelectedIndex();
			if (index == -1) {
				JOptionPane.showMessageDialog(null, "Selecione um item para ser removido...");
				return;
			}
			int op = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?",
					"remover o elemento selecionado?", JOptionPane.YES_NO_OPTION);

			if (op == JOptionPane.YES_OPTION) {
				Cliente cliente = (Cliente) list.getSelectedValue();
				dao.remover(cliente.getCpf());
				carregarModelo(dao.clientes());
			}
		}
		// AÇÃO DO BOTÃO limpar
		if (e.getSource() == btnEditar) {

			TfNome.setText(null);
			TfEmail.setText(null);
			campoCpf.setText(null);

		}

	}

	// MÉTODO MAIN
	public static void main(String[] args) {
		JFrame frame = new Principal2();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// encerramento da aplicação e liberação de memória quando a janela for fechada.

	}

}
