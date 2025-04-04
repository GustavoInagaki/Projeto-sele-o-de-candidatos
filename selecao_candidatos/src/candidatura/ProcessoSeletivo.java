package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        String [] candidatos = {"Felipe", "Julia", "Marcelo", "Laryssa", "joão"};

        for(String candidato : candidatos){
            entrarEmContato(candidato);
        }

    }

    static void entrarEmContato(String candidato){
        int tentativasLigacao = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do{
            atendeu = atender();
            continuarTentando = !atendeu;

            if(continuarTentando){
                tentativasLigacao++;
                
            }else{
                System.out.println("Ligação realizada com sucesso.");
            }


        }while(continuarTentando && tentativasLigacao<3);
            if (atendeu) {
                System.out.println("Conseguimos o contato com o canditado " + candidato + " na tentativa " + tentativasLigacao);
            }else{
                System.out.println("Não conseguimos o contato com o candidato " + candidato);
            }
        
    }

    //metodo auxiliar
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }


    static void imprimirSelecionados(){
        String [] candidatos = {"Felipe", "Julia", "Marcelo", "Laryssa", "joão"};

        for(int indice = 0; indice < candidatos.length ; indice++){

            System.out.println("O candidato "+ candidatos[indice] + " foi selecionado na posição: " + (indice + 1)+"º");
        }

        for(String selecionados: candidatos ){
            System.out.println("O candidato selecionado foi: " + selecionados);
        }

    }

    static void selecaoCandidtatos(){
        String [] candidatos = {"Felipe", "Julia", "Marcelo", "Laryssa", "joão", "Marcus", "Rafaela"};

        int candidatosAtual = 0;
        int candidatosSelecionados = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.printf("O candidato %s Solicitou este valor de salário: %.2f \n" ,candidato , salarioPretendido );
            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }


    static void analiseProposta(double salarioPretendido){
        double salarioBase = 2000.0;
    
        if(salarioBase > salarioPretendido){
            System.out.println("Ligar para o candidato");
        }else if(salarioBase == salarioPretendido){
            System.out.println("Ligar para o candidato com contra proposta");
        }else{
            System.out.println("Aguardando o resultado dos outros candidatos");
        }
    }
}

