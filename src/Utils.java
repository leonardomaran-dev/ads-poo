import java.util.List;
import java.util.Scanner;

public class Utils {

    public static String formatarCPF(String cpf) {
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
    }

    public static String formatarTelefone(String tel) {
        return "(" + tel.substring(0, 2) + ")" + tel.substring(2, 7) + "-" + tel.substring(7);
    }

    public static String lerCampoObrigatorio(Scanner leitor, String mensagem) {
        return lerCampo(leitor, mensagem, 1, null);
    }

    public static String lerCampo(Scanner leitor, String mensagem, int minLen) {
        return lerCampo(leitor, mensagem, minLen, null);
    }

    public static String lerCampo(Scanner leitor, String mensagem, int minLen, String regex) {
        String valor;
        do {
            System.out.print(mensagem);
            valor = leitor.nextLine();
            if (valor.isBlank()) {
                System.out.println("Este campo é obrigatório!");
            } else if (valor.length() < minLen) {
                System.out.println("Este campo deve ter pelo menos " + minLen + " caracteres!");
            } else if (regex != null && !valor.matches(regex)) {
                System.out.println("Formato invalido!");
            }
        } while (valor.isBlank() || valor.length() < minLen || (regex != null && !valor.matches(regex)));
        return valor;
    }

    public static String confirmarSenha(Scanner leitor) {
        String senha;
        String confirmacao;
        do {
            senha = lerCampo(leitor, "Senha: ", 8, ".{8,}");
            System.out.print("Confirme a senha: ");
            confirmacao = leitor.nextLine();
            if (!senha.equals(confirmacao)) {
                System.out.println("Senhas nao coincidem! Tente novamente.");
            }
        } while (!senha.equals(confirmacao));
        return senha;
    }

    public static boolean emailExistente(String email) {
        for (Morador m : Morador.getMoradores()) {
            if (m.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public static boolean telefoneExistente(String telefone) {
        String telefoneFormatado = formatarTelefone(telefone);
        for (Morador m : Morador.getMoradores()) {
            if (m.getTelefone().equals(telefoneFormatado)) {
                return true;
            }
        }
        return false;
    }

    public static boolean documentoExistente(List<? extends Pessoa> lista, String documento) {
        String documentoFormatado = formatarCPF(documento);
        for (Pessoa p : lista) {
            if (p.getDocumento().equals(documentoFormatado)) {
                return true;
            }
        }
        return false;
    }
}
