package principal.design;

import principal.design.paineis.cadastro.PainelCadastroVagaEmpresa;
import principal.design.paineis.principal.PainelPrincipalEmpresa;
import principal.usuario.Empresa;

import javax.swing.*;

public class DesignPaginaPrincipalEmpresa {
    public static JFrame getDesignPaginaPrincipalEmpresa(Empresa empresa) {
        JFrame janelaPrincipalEmpresa = new JFrame("Principal");
        janelaPrincipalEmpresa.setSize(850, 480);
        janelaPrincipalEmpresa.setLocationRelativeTo(null);
        janelaPrincipalEmpresa.setResizable(false);

        JTabbedPane telaDaEmpresa = new JTabbedPane();
        telaDaEmpresa.add("Principal", PainelPrincipalEmpresa.getPainelPrincipalEmpresa(empresa));
        telaDaEmpresa.add("Criar Vaga", PainelCadastroVagaEmpresa.getPainelCadastroVagaEmpresa());

        janelaPrincipalEmpresa.add(telaDaEmpresa);
        janelaPrincipalEmpresa.setVisible(true);

        return janelaPrincipalEmpresa;
    }
}
