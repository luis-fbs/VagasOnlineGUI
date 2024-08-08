package principal.design;

import principal.design.paineis.principal.PainelPrincipalPessoa;
import principal.usuario.Pessoa;

import javax.swing.*;

public class DesignPaginaPrincipalPessoa {
    public static JFrame getDesignPaginaPrincipalPessoa(Pessoa pessoa) {
        JFrame janelaPrincipalPessoa = new JFrame("Principal");
        janelaPrincipalPessoa.setSize(850, 480);
        janelaPrincipalPessoa.setLocationRelativeTo(null);
        janelaPrincipalPessoa.setResizable(false);

        JTabbedPane telaDaPessoa = new JTabbedPane();
        telaDaPessoa.add("Principal", PainelPrincipalPessoa.getPainelPrincipalPessoa(pessoa));

        janelaPrincipalPessoa.add(telaDaPessoa);
        janelaPrincipalPessoa.setVisible(true);

        return janelaPrincipalPessoa;
    }
}
