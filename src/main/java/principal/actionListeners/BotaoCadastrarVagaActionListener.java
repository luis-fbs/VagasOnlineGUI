package principal.actionListeners;

import principal.design.DesignPaginaPrincipalPessoa;
import principal.usuario.UltimoLoginUsado;
import principal.util.Conversor;
import principal.util.ReferenciaURL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BotaoCadastrarVagaActionListener implements ActionListener {
    JTextField cargo;
    JTextArea descricao;

    public BotaoCadastrarVagaActionListener(JTextField cargo, JTextArea descricao) {
        this.cargo = cargo;
        this.descricao = descricao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String json = """
                    {
                    "empresa": {"cnpj": "%s"},
                    "cargo": "%s",
                    "descricao": "%s"
                    }
                    """.formatted(UltimoLoginUsado.identificacao, cargo.getText(), descricao.getText());

            String url = ReferenciaURL.getReferenciaURL() + "/vaga/cadastrar";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(new URI(url))
                    .method("POST", HttpRequest.BodyPublishers.ofString(json))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (!response.body().isBlank()){
                JOptionPane.showMessageDialog(null, "Vaga criada com sucesso!", "Confirmação", JOptionPane.PLAIN_MESSAGE);
            } else{
                JOptionPane.showMessageDialog(null, "Não foi possível criar a vaga", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Não foi possível criar a vaga", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
