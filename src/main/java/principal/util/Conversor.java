package principal.util;

import com.google.gson.Gson;
import principal.usuario.Empresa;
import principal.usuario.Pessoa;

public class Conversor {
    public static Pessoa jsonParaPessoa(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, Pessoa.class);
    }

    public static Empresa jsonParaEmpresa(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, Empresa.class);
    }
}
