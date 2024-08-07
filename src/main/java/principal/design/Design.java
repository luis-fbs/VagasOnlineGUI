package principal.design;

import javax.swing.*;

public class Design {
    public Design() {
        JFrame janela = new JFrame("Vagas online");
        janela.setSize(850, 480);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setResizable(false);

        JTabbedPane telas = new JTabbedPane();
        telas.add("Login", PainelLogin.getPainelDeLogin());

        janela.add(telas);
        janela.setVisible(true);
    }
}
