package com.example.davidalexfarina.pedidosmobile.modulo_autenticacao_usuario;

public class ControllerUsuario {
    //METODO LOGAR
    public int logar(Usuario dados) throws Exception {
        int i = 0;
        String login = dados.getLogin();
        String senha = dados.getSenha();
        String chamada = "http://localhost:8080/WebServiceOf/rest/servicosUsuario/autenticar/"+login+"/"+senha;
        HttpExemplo http = new HttpExemplo();

        String json = http.sendGet(chamada);

        //Gson gson = new Gson();
        //gson.toJson(resposta);
        if(json.equals("Usuario logado com sucesso.")) {
            System.out.print(json);
            i = 1;
        }else {
            i = 0;
            System.out.print("Usuario invalido");
        }
        String msg= "";
        try {
            if(json.equals(true)) {
                System.out.print(json);
            }

        } catch (Exception e) {

        }
        return i;
    }

}
