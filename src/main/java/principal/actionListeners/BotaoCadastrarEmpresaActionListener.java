package principal.actionListeners;

import principal.util.ReferenciaURL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BotaoCadastrarEmpresaActionListener implements ActionListener {
    JTextField cnpj, senha, nome;

    public BotaoCadastrarEmpresaActionListener(JTextField cnpj, JTextField nome, JTextField senha) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.senha = senha;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String json = """
                    {
                    "cnpj": "%s",
                    "senha": "%s",
                    "nome": "%s",
                    "foto": "sf"
                    }
                    """.formatted(cnpj.getText(), senha.getText(), nome.getText());

            String url = ReferenciaURL.getReferenciaURL() + "/usuario/cadastrar";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(new URI(url))
                    .method("POST", HttpRequest.BodyPublishers.ofString(json))
                    .build();
            client.send(request, HttpResponse.BodyHandlers.discarding());

        } catch (Exception exception){}
    }
}
