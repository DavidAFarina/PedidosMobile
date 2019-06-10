package com.example.davidalexfarina.pedidosmobile.modulo_pedido_produto.data;

public class PedidosMobileContract {

    public static final String TABLE_PRODUTO_PEDIDO = "produto";//tabela teferente aos pedidos de produtos
   /* public static final String TABLE_USUARIO = "usuario";*/

    //colunas da tabela produto
    public static final class Columns {
        public static final String _ID_PRODUTO_PEDIDO = "_id";
        public static final String MESA = "mesa";
        public static final String GARCOM = "garcom";
        public static final String NOME = "nome";
        public static final String VALOR = "valor";
        public static final String QUANTIDADE = "quantidade";
        public static final String VALOR_TOTAL = "valorTotal";
        public static final String OBSERVACAO = "observacao";

   /* //colunas da tabela usuario
        public static final String _ID_USUARIO = "_id_usuario";
        public static final String NOME_USUARIO = "nome_usuario";
        public static final String SENHA_USUARIO = "senha_usuario";*/
    }
}
