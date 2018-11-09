package model;

import java.util.ArrayList;

public class Service {

    ArrayList<Chat> chats = new ArrayList();
    ArrayList<Usuario> usuarios = new ArrayList();

    public boolean addUser(String nomeDoUsuario) {
        Usuario u = new Usuario(nomeDoUsuario);
        for (Usuario x : this.usuarios) {
            if (x.getNomeDoUsuario().equals(u.getNomeDoUsuario())) {
                return false;
            }
        }
        this.usuarios.add(u);
        return true;
    }

    public boolean newChat(String nomeDoUsuario, String nome) {
        for (Chat x : this.chats) {
            if (x.getNomeDoChat().equals(nome)) {
                return false;
            }
        }
        for (Usuario u : this.usuarios) {
            if (u.getNomeDoUsuario().equals(nomeDoUsuario)) {
                Chat c = new Chat(nome);
                this.chats.add(c);
                u.chats.add(c);
                this.usuarios.add(u);
                c.usuarios.add(u);
                return true;
            }
        }
        Usuario u = new Usuario(nomeDoUsuario);
        Chat c = new Chat(nome);
        this.chats.add(c);
        u.chats.add(c);
        this.usuarios.add(u);
        c.usuarios.add(u);
        return true;
    }

    public boolean invite(String convida, String convidado, String nomeDoChat) {
        for (Usuario a : this.usuarios) {
            if (a.getNomeDoUsuario().equals(convida)) {
                for (Usuario b : this.usuarios) {
                    if (b.getNomeDoUsuario().equals(convidado)) {
                        for (Chat c : this.chats) {
                            if (c.getNomeDoChat().equals(nomeDoChat)) {
                                c.usuarios.add(b);
                                this.usuarios.add(b);
                                b.chats.add(c);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public String users(String nomeDoChat) {
        String users = "";

        for (Chat c : this.chats) {
            if (nomeDoChat.equals(c.getNomeDoChat())) {
                users += c.getUsuarios() + " ";
                break;
            } else {
                System.out.println("Chat não existe");
                break;
            }
        }
        return users;
    }

    public String allUsers() {
        String s = "[ ";
        
        for (Usuario u : this.usuarios) {
            s += u.getNomeDoUsuario() + " ";
        }
        
        return s + "]";
    }

    public String chats(String nomeDoUsuario) {
        String chatss = "";
        for (Usuario u : this.usuarios) {
            if (nomeDoUsuario.equals(u.getNomeDoUsuario())) {
                chatss += u.getChats() + " ";
                break;
            } else {
                System.out.println("Usuário não existe");
                break;
            }
        }
        return chatss;
    }

    public boolean leave(String nomeDoUsuario, String nomeDoChat) {
        for (Chat c : this.chats) {
            if (nomeDoChat.equals(c.getNomeDoChat())) {
                for (Usuario u : c.usuarios) {
                    if (nomeDoUsuario.equals(u.getNomeDoUsuario())) {
                        c.usuarios.remove(u);
                        this.usuarios.remove(u);
                        u.chats.remove(c);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean zap(String nomeDoUsuario, String nomeDoChat, String mensagem) {
        for (Chat c : this.chats) {
            if (nomeDoChat.equals(c.getNomeDoChat())) {
                for (Usuario u : c.usuarios) {
                    if (nomeDoUsuario.equals(u.getNomeDoUsuario())) {
                        c.setMensagens(c.getMensagens() + nomeDoUsuario + ": " + mensagem + "\n");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean ler(String nomeDoUsuario, String nomeDoChat) {
        for (Chat c : this.chats) {
            if (nomeDoChat.equals(c.getNomeDoChat())) {
                for (Usuario u : c.usuarios) {
                    if (nomeDoUsuario.equals(u.getNomeDoUsuario())) {
                        System.out.println(c.getMensagens());
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
