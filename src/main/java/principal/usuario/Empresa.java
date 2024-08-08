package principal.usuario;

import principal.vaga.Vaga;

import java.util.ArrayList;

public class Empresa {
    String nome, foto;
    ArrayList<Vaga> vagasCadastradas;

    public String getFoto() {
        return foto;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Vaga> getVagasCadastradas() {
        return vagasCadastradas;
    }
}
