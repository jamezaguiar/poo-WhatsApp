package model;

import java.util.ArrayList;

public class Chat {

    private String nomeDoChat;
    protected ArrayList<Usuario> usuarios;
    private String mensagens = "";

    public Chat(String nomeDoChat) {
        this.nomeDoChat = nomeDoChat;
        this.usuarios = new ArrayList();
    }

    public String getNomeDoChat() {
        return nomeDoChat;
    }

    public void setNomeDoChat(String nomeDoChat) {
        this.nomeDoChat = nomeDoChat;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getMensagens() {
        return mensagens;
    }

    public void setMensagens(String mensagens) {
        this.mensagens = mensagens;
    }

    @Override
    public String toString() {
        return this.nomeDoChat;
    }
    
    

}
