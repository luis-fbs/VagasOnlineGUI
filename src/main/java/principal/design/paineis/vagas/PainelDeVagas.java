package principal.design.paineis.vagas;

import principal.vaga.Vaga;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PainelDeVagas {
    public static JScrollPane getPainelDeVagas(ArrayList<Vaga> vagas){
        JPanel painelVagas = new JPanel(new GridLayout(vagas.size(), 1));

        for (Vaga vaga : vagas){
            JPanel painelDaVaga = new JPanel(new GridLayout(3,1));
            JLabel empresa = new JLabel(vaga.getEmpresa(), JLabel.CENTER);
            empresa.setFont(new Font(Font.SERIF, Font.BOLD, 16));
            JLabel cargo = new JLabel(vaga.getCargo());
            JLabel descricao = new JLabel(vaga.getDescricao());
            descricao.setFont(new Font(Font.SERIF, Font.BOLD, 16));
            JScrollPane descricaoJScrollPane = new JScrollPane(descricao, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

            painelDaVaga.add(empresa);
            painelDaVaga.add(cargo);
            painelDaVaga.add(descricaoJScrollPane);

            painelVagas.add(painelDaVaga);
        }

        JScrollPane vagasJScrollPane = new JScrollPane(painelVagas, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        return vagasJScrollPane;
    }
}
