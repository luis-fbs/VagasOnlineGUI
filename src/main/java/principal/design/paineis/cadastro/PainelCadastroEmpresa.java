package principal.design.paineis.cadastro;

import principal.actionListeners.BotaoCadastrarEmpresaActionListener;

import javax.swing.*;
import java.awt.*;

public class PainelCadastroEmpresa {
    public static JPanel getPainelCadastroEmpresa(){
        JPanel painelCadastroEmpresa = new JPanel(new GridLayout(3,1));
        JPanel painelDados = new JPanel(new GridLayout(4,2));
        JPanel painelBotao = new JPanel(new FlowLayout());
        JLabel cadastroLabel = new JLabel("Cadastrar empresa", JLabel.CENTER);
        cadastroLabel.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        JLabel cnpjLabel = new JLabel("CNPJ:");
        JLabel nomeLabel = new JLabel("Nome:");
        JLabel senhaLabel = new JLabel("Senha:");
        JLabel fotoLabel = new JLabel("Foto:");
        JTextField cnpjField = new JTextField();
        JTextField nomeField = new JTextField();
        JTextField senhaField = new JTextField();
        JButton fotoButton = new JButton("Imagem", UIManager.getIcon("FileView.directoryIcon"));
        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new
                BotaoCadastrarEmpresaActionListener(cnpjField, nomeField, senhaField));

        painelDados.add(cnpjLabel);
        painelDados.add(cnpjField);
        painelDados.add(nomeLabel);
        painelDados.add(nomeField);
        painelDados.add(senhaLabel);
        painelDados.add(senhaField);
        painelDados.add(fotoLabel);
        painelDados.add(fotoButton);

        painelBotao.add(cadastrarButton);

        painelCadastroEmpresa.add(cadastroLabel);
        painelCadastroEmpresa.add(painelDados);
        painelCadastroEmpresa.add(painelBotao);

        return painelCadastroEmpresa;
    }
}
