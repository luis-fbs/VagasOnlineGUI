package principal.design.paineis.principal;

import principal.design.paineis.vagas.PainelDeVagas;
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

                painelPrincipalVagas.add(PainelDeVagas.getPainelDeVagas(vagas));

            } else{
                painelPrincipalVagas.add(new JLabel("Nenhuma vaga disponível"));
            }
        } catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Erro ao pegar vagas", "Erro", JOptionPane.WARNING_MESSAGE);
        }

        return painelPrincipalVagas;
    }
}
