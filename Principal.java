package exec;

import java.util.Scanner;
import model.Service;
import model.Usuario;
import model.Chat;

public class Principal {

    public static void main(String args[]) {
        Service s = new Service();
        Scanner input = new Scanner(System.in);
        System.out.println("WhatsApp");
        String comandos = "============================================================COMANDOS============================================================\n"
                + "allUsers: Mostra todos os usuários do sistema\n"
                + "addUser (nome do usuário): Adiciona usuário\n"
                + "newChat (nome do usuário) (nome do chat): Cria novo chat\n"
                + "chats (nome do usuário): Mostra os chats em que o usuário está\n"
                + "invite (usuário que já está no grupo) (usuário convidado) (nome do grupo): Adiciona pessoa a um grupo existente\n"
                + "users (nome do grupo): Mostra usuários de um grupo\n"
                + "leave (nome do usuário) (nome do grupo)\n"
                + "zap (nome do usuário) (nome do grupo) (mensagem): Envia mensagens para um grupo\n"
                + "ler (nome do usuário) (nome do grupo): Mostra mensagens de um grupo\n"
                + "fechar: Fecha WhatsApp\n";
        System.out.println(comandos);
        System.out.print("Digite um comando: ");

        String c[], c2[];
        while (true) {
            comandos = input.nextLine();
            if (comandos.equals("fechar")) {
                System.out.println("Fechando WhatsApp...");
                break;
            } else {
                c = comandos.split(" ");
                c2 = comandos.split(" ");
                switch (c[0]) {
                    case "addUser":
                        if (s.addUser(c[1])) {
                            System.out.println("done");
                        } else {
                            System.out.println("Usuário já existe");
                        }
                        break;
                    case "newChat":
                        if (s.newChat(c[1], c[2])) {
                            System.out.println("done");
                        } else {
                            System.out.println("Chat já existe");
                        }
                        break;
                    case "chats":
                        System.out.println(s.chats(c[1]));
                        break;
                    case "invite":
                        if (s.invite(c[1], c[2], c[3])) {
                            System.out.println("done");
                        } else {
                            System.out.println("Usuário que convida não está no chat ou convidado não existe!");
                        }
                        break;
                    case "users":
                        System.out.println(s.users(c[1]));
                        break;
                    case "leave":
                        if (s.leave(c[1], c[2])) {
                            System.out.println("done");
                        } else {
                            System.out.println("Usuário não está no grupo");
                        }
                        break;
                    case "zap":
                        String aux = "";
                        for (int i = 3; i < c2.length; i++) {
                            aux += " " + c2[i];
                        }

                        if (s.zap(c[1], c[2], aux)) {
                            System.out.println("done");
                        } else {
                            System.out.println("Ocorreu um erro, tente novamente");
                        }
                        break;
                    case "ler":
                        if (s.ler(c[1], c[2])) {
                        } else {
                            System.out.println("Ocorreu um erro, tente novamente");
                        }
                        break;
                    case "allUsers":
                        System.out.println(s.allUsers());
                        break;
                    default:
                        System.out.println("Comando Inválido, Tenta Novamente!");
                        break;
                }
            }
        }
    }

}
