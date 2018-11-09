package model;

import java.util.ArrayList;

public class Usuario {

    private String nomeDoUsuario;
    protected ArrayList<Chat> chats;

    public Usuario(String nomeDoUsuario) {
        this.nomeDoUsuario = nomeDoUsuario;
        this.chats = new ArrayList();
    }

    public String getNomeDoUsuario() {
        return nomeDoUsuario;
    }

    public void setNomeDoUsuario(String nomeDoUsuario) {
        this.nomeDoUsuario = nomeDoUsuario;
    }

    public ArrayList<Chat> getChats() {
        return chats;
    }

    public void setChats(ArrayList<Chat> chats) {
        this.chats = chats;
    }

    @Override
    public String toString() {
        return this.nomeDoUsuario;
    }

}
