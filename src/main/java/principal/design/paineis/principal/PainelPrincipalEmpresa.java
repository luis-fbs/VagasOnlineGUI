package principal.design.paineis.principal;

import principal.usuario.Empresa;

import javax.swing.*;
import java.awt.*;

public class PainelPrincipalEmpresa {
    public static JPanel getPainelPrincipalEmpresa(Empresa empresa){
        JPanel painelPricipalEmpresa = new JPanel(new GridLayout(2,1));
        JLabel nome = new JLabel(empresa.getNome(), JLabel.CENTER);
        nome.setFont(new Font(Font.SERIF, Font.BOLD, 20));

        painelPricipalEmpresa.add(nome);

        return painelPricipalEmpresa;
    }
}
