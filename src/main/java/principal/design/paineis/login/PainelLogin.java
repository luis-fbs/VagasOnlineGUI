package principal.design;

import principal.actionListeners.BotaoCadastrarActionListener;

import javax.swing.*;
import java.awt.*;

public class PainelLogin {
    public static JPanel getPainelDeLogin(){
        JPanel painelDeLogin = new JPanel(new GridLayout(3,1));
        JPanel painelAuxiliar = new JPanel(new GridLayout(3, 3));
        JPanel painelBotoes = new JPanel(new FlowLayout());
        JLabel loginLabel = new JLabel("Login", JLabel.CENTER);
        loginLabel.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        JLabel credencialLabel = new JLabel("Identificação:");
        JLabel senhaLabel = new JLabel("Senha:");
        JTextField credencialField = new JTextField();
        JPasswordField senhaField = new JPasswordField();
        JRadioButton pessoaRadioButton = new JRadioButton("Pessoa");
        JRadioButton empresaRadioButton = new JRadioButton("Empresa");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(pessoaRadioButton);
        buttonGroup.add(empresaRadioButton);
        Button entrarButton = new Button("Entrar");
        Button cadastrarButton = new Button("cadastrar");
        cadastrarButton.addActionListener(new BotaoCadastrarActionListener());

        painelAuxiliar.add(credencialLabel);
        painelAuxiliar.add(credencialField);
        painelAuxiliar.add(senhaLabel);
        painelAuxiliar.add(senhaField);
        painelAuxiliar.add(pessoaRadioButton);
        painelAuxiliar.add(empresaRadioButton);

        painelBotoes.add(entrarButton);
        painelBotoes.add(cadastrarButton);

        painelDeLogin.add(loginLabel);
        painelDeLogin.add(painelAuxiliar);
        painelDeLogin.add(painelBotoes);

        return painelDeLogin;
    }
}
