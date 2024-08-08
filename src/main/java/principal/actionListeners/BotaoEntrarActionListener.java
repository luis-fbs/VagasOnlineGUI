package principal.actionListeners;

import principal.design.paineis.DesignPaginaPrincipalEmpresa;
import principal.design.paineis.DesignPaginaPrincipalPessoa;
import principal.util.Conversor;
import principal.util.ReferenciaURL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BotaoEntrarActionListener implements ActionListener {
    JRadioButton pessoa, empresa;
    JTextField credencial;
    JPasswordField senha;

    public BotaoEntrarActionListener(JTextField credencial, JRadioButton empresa, JRadioButton pessoa, JPasswordField senha) {
        this.credencial = credencial;
        this.empresa = empresa;
        this.pessoa = pessoa;
        this.senha = senha;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (pessoa.isSelected()){
            try {
                String json = """
                    {
                    "cpf": "%s",
                    "senha": "%s"
                    }
                    """.formatted(credencial.getText(), senha.getText());

                String url = ReferenciaURL.getReferenciaURL() + "/usuario/pessoa/autenticar";
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder(new URI(url))
                        .method("POST", HttpRequest.BodyPublishers.ofString(json))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                if (!response.body().isBlank()){

                    DesignPaginaPrincipalPessoa
                            .getDesignPaginaPrincipalPessoa(Conversor.jsonParaPessoa(response.body()));
                } else{
                    JOptionPane.showMessageDialog(null, "Credenciais não batem", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (Exception exception){}

        } else if (empresa.isSelected()) {
            try {
                String json = """
                    {
                    "cnpj": "%s",
                    "senha": "%s"
                    }
                    """.formatted(credencial.getText(), senha.getText());

                String url = ReferenciaURL.getReferenciaURL() + "/usuario/empresa/autenticar";
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder(new URI(url))
                        .method("POST", HttpRequest.BodyPublishers.ofString(json))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                if (!response.body().isBlank()){
                    DesignPaginaPrincipalEmpresa.getDesignPaginaPrincipalEmpresa(Conversor.jsonParaEmpresa(response.body()));
                } else{
                    JOptionPane.showMessageDialog(null, "Credenciais não batem", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (Exception exception){}

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um tipo de usuario!",
                    "ATENÇÃO",JOptionPane.WARNING_MESSAGE);
        }
    }
}
