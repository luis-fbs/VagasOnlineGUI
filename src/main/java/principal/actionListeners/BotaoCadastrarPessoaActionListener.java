package principal.actionListeners;

import principal.util.ReferenciaURL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BotaoCadastrarPessoaActionListener implements ActionListener {
    JTextField cpf, senha, nome;
    JTextArea curriculo;

    public BotaoCadastrarPessoaActionListener(JTextField cpf, JTextArea curriculo, JTextField nome, JTextField senha) {
        this.cpf = cpf;
        this.curriculo = curriculo;
        this.nome = nome;
        this.senha = senha;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String json = """
                    {
                    "cpf": "%s",
                    "senha": "%s",
                    "nome": "%s",
                    "foto": "sf",
                    "curriculo": "%s"
                    }
                    """.formatted(cpf.getText(), senha.getText(), nome.getText(), curriculo.getText());

            String url = ReferenciaURL.getReferenciaURL() + "/usuario/cadastrar";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(new URI(url))
                                             .method("POST", HttpRequest.BodyPublishers.ofString(json))
                                             .build();
            client.send(request, HttpResponse.BodyHandlers.discarding());

        }catch (Exception exception){}
    }
}
