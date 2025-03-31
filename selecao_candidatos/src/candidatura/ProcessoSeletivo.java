package candidatura;

import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        selecaoCandidtatos();
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

