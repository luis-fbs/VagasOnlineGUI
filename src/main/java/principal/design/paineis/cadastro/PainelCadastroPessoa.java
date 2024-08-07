package principal.design.paineis.cadastro;

import principal.actionListeners.BotaoCadastrarPessoaActionListener;

import javax.swing.*;
import java.awt.*;

public class PainelCadastroPessoa {
    public static JPanel getPainelCadastroPessoa(){
        JPanel painelCadastroPessoa = new JPanel(new GridLayout(3,1));
        JPanel painelDados = new JPanel(new GridLayout(5,2));
        JPanel painelBotao = new JPanel(new FlowLayout());
        JLabel cadastroLabel = new JLabel("Cadastrar pessoa", JLabel.CENTER);
        cadastroLabel.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        JLabel cpfLabel = new JLabel("CPF:");
        JLabel nomeLabel = new JLabel("Nome:");
        JLabel senhaLabel = new JLabel("Senha:");
        JLabel fotoLabel = new JLabel("Foto:");
        JLabel curriculoLabel = new JLabel("Curriculo:");
        JTextField cpfField = new JTextField();
        JTextField nomeField = new JTextField();
        JTextField senhaField = new JTextField();
        JTextArea curriculoArea = new JTextArea();
        curriculoArea.setLineWrap(true);
        JScrollPane curriculoScrollPane = new JScrollPane(curriculoArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JButton fotoButton = new JButton("Imagem", UIManager.getIcon("FileView.directoryIcon"));
        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new
                BotaoCadastrarPessoaActionListener(cpfField, curriculoArea,
                nomeField, senhaField));

        painelDados.add(cpfLabel);
        painelDados.add(cpfField);
        painelDados.add(nomeLabel);
        painelDados.add(nomeField);
        painelDados.add(senhaLabel);
        painelDados.add(senhaField);
        painelDados.add(curriculoLabel);
        painelDados.add(curriculoScrollPane);
        painelDados.add(fotoLabel);
        painelDados.add(fotoButton);


        painelBotao.add(cadastrarButton);

        painelCadastroPessoa.add(cadastroLabel);
        painelCadastroPessoa.add(painelDados);
        painelCadastroPessoa.add(painelBotao);

        return painelCadastroPessoa;
    }
}
