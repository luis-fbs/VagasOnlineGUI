package principal.design;

import principal.design.paineis.cadastro.PainelCadastroEmpresa;
import principal.design.paineis.cadastro.PainelCadastroPessoa;

import javax.swing.*;

public class DesignCadastroUsuario {
    public static JFrame getDesignCadastroUsuario(){
        JFrame janelaCadastro = new JFrame("Cadastro");
        janelaCadastro.setSize(850, 480);
        janelaCadastro.setLocationRelativeTo(null);
        janelaCadastro.setResizable(false);

        JTabbedPane telasCadastro = new JTabbedPane();
        telasCadastro.add("Pessoa", PainelCadastroPessoa.getPainelCadastroPessoa());
        telasCadastro.add("Empresa", PainelCadastroEmpresa.getPainelCadastroEmpresa());

        janelaCadastro.add(telasCadastro);
        janelaCadastro.setVisible(true);

        return  janelaCadastro;
    }

}
