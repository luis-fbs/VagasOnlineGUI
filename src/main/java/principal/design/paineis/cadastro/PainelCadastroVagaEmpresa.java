package principal.design.paineis.cadastro;

import javax.swing.*;
import java.awt.*;

public class PainelCadastroVagaEmpresa {
    public static JPanel getPainelCadastroVagaEmpresa(){
        JPanel painelCadastroVagaEmpresa = new JPanel(new GridLayout(3,1));
        JPanel painelDados = new JPanel(new GridLayout(2,2));
        JPanel painelBotao = new JPanel(new FlowLayout());
        JLabel cadastroLabel = new JLabel("Cadastrar vaga");
        cadastroLabel.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        JLabel cargoLabel = new JLabel("Cargo:");
        JLabel descricaoLabel = new JLabel("Descrição:");
        JTextField cargoTextField = new JTextField();
        JTextArea descricaoArea = new JTextArea();
        JScrollPane descricaoJScrollPane = new JScrollPane(descricaoArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JButton cadastrarVagaButton = new JButton("Cadastrar");

        painelDados.add(cargoLabel);
        painelDados.add(cargoTextField);
        painelDados.add(descricaoLabel);
        painelDados.add(descricaoJScrollPane);

        painelBotao.add(cadastrarVagaButton);

        painelCadastroVagaEmpresa.add(cadastroLabel);
        painelCadastroVagaEmpresa.add(painelDados);
        painelCadastroVagaEmpresa.add(painelBotao);

        return painelCadastroVagaEmpresa;
    }
}
