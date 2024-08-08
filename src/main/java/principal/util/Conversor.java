package principal.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import principal.usuario.Empresa;
import principal.usuario.Pessoa;
import principal.vaga.Vaga;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Conversor {
    public static Pessoa jsonParaPessoa(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, Pessoa.class);
    }

    public static Empresa jsonParaEmpresa(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, Empresa.class);
    }

    public static ArrayList<Vaga> jsonParaListaDeVagas(String json) {
        Gson gson = new Gson();
        Type vagaListType = new TypeToken<ArrayList<Vaga>>() {}.getType();
        return gson.fromJson(json, vagaListType);
    }
}
