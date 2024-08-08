package principal.design.paineis.principal;

import principal.util.Conversor;
import principal.util.ReferenciaURL;
import principal.vaga.Vaga;

import javax.swing.*;
import java.awt.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class PainelPrincipalVagas {
    public static JPanel getPainelPrincipalVagas(){
        JPanel painelPrincipalVagas = new JPanel(new GridLayout(2,1));
        JLabel vagasLabel = new JLabel("Vagas disponíveis", JLabel.CENTER);
        vagasLabel.setFont(new Font(Font.SERIF, Font.BOLD, 20));

        painelPrincipalVagas.add(vagasLabel);

        try {
            String url = ReferenciaURL.getReferenciaURL() + "/vagas";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(new URI(url))
                                             .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (!response.body().isBlank()){
                ArrayList<Vaga> vagas = Conversor.jsonParaListaDeVagas(response.body());
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

                painelPrincipalVagas.add(vagasJScrollPane);

            } else{
                painelPrincipalVagas.add(new JLabel("Nenhuma vaga disponível"));
            }
        } catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Erro ao pegar vagas", "Erro", JOptionPane.WARNING_MESSAGE);
        }

        return painelPrincipalVagas;
    }
}
