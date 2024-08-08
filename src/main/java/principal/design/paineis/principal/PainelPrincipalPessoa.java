package principal.design.paineis.principal;

import principal.usuario.Pessoa;

import javax.swing.*;
import java.awt.*;

public class PainelPrincipalPessoa {
    public static JPanel getPainelPrincipalPessoa(Pessoa pessoa){
        JPanel painelPricipalPessoa = new JPanel(new GridLayout(2,1));
        JLabel nome = new JLabel(pessoa.getNome(), JLabel.CENTER);
        nome.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        JLabel curriculo = new JLabel(pessoa.getCurriculo());
        JScrollPane curriculoJScrollPane = new JScrollPane(curriculo, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        painelPricipalPessoa.add(nome);
        painelPricipalPessoa.add(curriculo);

        return painelPricipalPessoa;
    }

}
