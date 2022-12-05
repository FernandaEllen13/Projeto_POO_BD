import br.inatel.cdg.gra.DAO.*;
import br.inatel.cdg.gra.MODEL.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Entrada de dados + Interação com o usuario
        Scanner entrada = new Scanner (System.in);

        // Variaveis auxiliares para entrada de dados
        int x,aux;
        int y;

        racaAlienigenaDAO AddracaAlienigena = new racaAlienigenaDAO();
        racaAlienigena raca1 = new racaAlienigena();

        planetaDAO Addplaneta = new planetaDAO();
        planeta planeta1 = new planeta();

        objetivoDAO Addobjetivo = new objetivoDAO();
        objetivo objetivo1 = new objetivo();

        tecnologiaDAO Addtecnlogia = new tecnologiaDAO();
        tecnologia tecno1 = new tecnologia();


        //Loop CRUD
        do{
            System.out.println("Bem vindo de volta explorador!");
            System.out.println("Digite o que deseja: ");
            System.out.println("1 - Inserir novas informacoes no banco de dados");
            System.out.println("2 - Alterar informacoes no banco de dados");
            System.out.println("3 - Deletar informacos no banco de dados");
            System.out.println("0 - Sair\n");
            x = entrada.nextInt();

            switch (x){
                case 1:

                    // MENU DAS TABELAS
                    System.out.println("Qual tipo de informação voce deseja inserir ?");

                    System.out.println("1 - Planeta");
                    System.out.println("2 - Raça");
                    System.out.println("3 - Objetivo");
                    System.out.println("4 - Tecnologia");
                    System.out.println(" ");
                    aux = entrada.nextInt();

                    if(aux == 1){
                        System.out.println("Entre com o ID do planeta: ");
                        planeta1.setIdplaneta(entrada.nextInt());
                        entrada.nextLine();
                        System.out.println("Informe que galaxia que esse planeta reside: ");
                        planeta1.setGalaxia(entrada.nextLine());
                        System.out.println("Informe a estrela mais proxima desse planeta: ");
                        planeta1.setEstrela(entrada.nextLine());
                        System.out.println("Qual seria o nome desse planeta? ");
                        planeta1.setnome(entrada.nextLine());

                        Addplaneta.inserirPlaneta(planeta1);


                    }else if(aux == 2){

                        System.out.println("Informe o ID da raça alienigena");
                        raca1.setIdRacaAlienigena(entrada.nextInt());
                        entrada.nextLine();
                        System.out.println("Informe o nome dessa especie: ");
                        raca1.setNome(entrada.nextLine());
                        System.out.println("A especie é pacifista?");
                        raca1.setPacifica(entrada.nextBoolean());
                        System.out.println("Informe o ID do planeta que essa especie reside: ");
                        raca1.setPlaneta_idplaneta(entrada.nextInt());
                        entrada.nextLine();

                        AddracaAlienigena.inserirRaca(raca1);

                    }else if(aux == 3){
                        System.out.println("Entre com o id do objetivo");
                        objetivo1.setIdObjetivo(entrada.nextInt());
                        entrada.nextLine();
                        System.out.println("Qual o objetivo desta especie? ");
                        objetivo1.setObjetivo(entrada.nextLine());
                        System.out.println("raça alienigina id : ");
                        objetivo1.setRacaAlienigena_idRacaAlienigena(entrada.nextInt());

                        Addobjetivo.inserirObjetivo(objetivo1);

                    } else if (aux == 4) {
                        System.out.println("Entre com o id da tecnologia");
                        tecno1.setIdTecnologia(entrada.nextInt());
                        entrada.nextLine();
                        System.out.println("Qual tecnologia esse especie possui? ");
                        tecno1.setNome(entrada.nextLine());
                        System.out.println("Qual a funcao desta tecnologia ?");
                        tecno1.setFuncao(entrada.nextLine());
                        System.out.println("Informe a diferença tecnologica dessa raça referente aos humanos");
                        tecno1.setTempo_criacao(entrada.nextLine());

                        Addtecnlogia.inserirTecnologia(tecno1);

                    }else{
                        System.out.println("Opção Invalida");
                    }break;

                case 2:
                    if(x == 2){
                        // MENU DAS TABELAS
                        System.out.println("Qual tabela deseja alterar?");
                        System.out.println("1 - Planeta");
                        System.out.println("2 - Raça");
                        System.out.println("3 - Objetivo");
                        System.out.println("4 - Tecnologia");

                        aux = entrada.nextInt();

                        if(aux == 1){
                            Addplaneta.buscaPlanetas();
                            System.out.println("------------------");

                            System.out.println("Entre com o id do planeta: ");
                            planeta1.setIdplaneta(entrada.nextInt());
                            entrada.nextLine();
                            System.out.println("Entre com o tipo do planeta: ");
                            planeta1.setnome(entrada.nextLine());

                            Addplaneta.atualizarPlaneta(planeta1.getIdplaneta(), planeta1);
                        }

                        else if(aux == 2){
                            AddracaAlienigena.buscaRacaAlienigena();
                            System.out.println("------------------");

                            System.out.println("Informe o ID");
                            raca1.setIdRacaAlienigena(entrada.nextInt());
                            entrada.nextLine();
                            System.out.println("Informe o nome dessa especie: ");
                            raca1.setNome(entrada.nextLine());
                            System.out.println("A especie é pacifista?");
                            raca1.setPacifica(entrada.nextBoolean());
                            System.out.println("Informe o ID do planeta que essa especie reside: ");
                            raca1.setPlaneta_idplaneta(entrada.nextInt());
                            entrada.nextLine();

                            AddracaAlienigena.atualizarRaca(raca1.getIdRacaAlienigena(), raca1);
                        }
                        else if(aux == 3){
                            Addobjetivo.buscaObjetivo();
                            System.out.println("------------------");

                            System.out.println("Informe o ID");
                            objetivo1.setIdObjetivo(entrada.nextInt());
                            entrada.nextLine();
                            System.out.println("Qual o objetivo desta especie? ");
                            objetivo1.setObjetivo(entrada.nextLine());

                            Addobjetivo.atualizarObjetivo(objetivo1.getIdObjetivo(), objetivo1);

                        }
                        else if(aux == 4){
                            System.out.println("Informe o ID");
                            tecno1.setIdTecnologia(entrada.nextInt());
                            entrada.nextLine();
                            System.out.println("Qual tecnologia esse especie possui? ");
                            tecno1.setNome(entrada.nextLine());
                            System.out.println("Qual a funcao desta tecnologia ?");
                            tecno1.setFuncao(entrada.nextLine());
                            System.out.println("Informe a diferença tecnologica dessa raça referente aos humanos");
                            tecno1.setTempo_criacao(entrada.nextLine());

                            Addtecnlogia.atualizarTecnologia(tecno1.getIdTecnologia(), tecno1);
                        }
                    }break;

                case 3:

                    System.out.println("O que deseja deletar?\n");

                    System.out.println("1 - Planeta");
                    System.out.println("2 - Raça");
                    System.out.println("3 - Objetivo");
                    System.out.println("4 - Tecnologia\n");
                    aux = entrada.nextInt();

                    if(aux == 1){
                        Addplaneta.buscaPlanetas();
                        System.out.println("------------------");

                        System.out.println("Digite o ID do Planeta que deseja apagar: ");
                        Addplaneta.deletarPlaneta(entrada.nextInt());
                    }else if(aux == 2 ){
                        AddracaAlienigena.buscaRacaAlienigena();
                        System.out.println("------------------");

                        System.out.println("Digite o ID da raça que deseja apagar");
                        AddracaAlienigena.deletarRaca(entrada.nextInt());
                    }else if(aux == 3){
                        Addobjetivo.buscaObjetivo();
                        System.out.println("------------------");

                        System.out.println("Digite o ID do Objetivo que deseja apagar: ");
                        Addobjetivo.deletarObjetivo(entrada.nextInt());
                    } else if (aux == 4) {
                        Addtecnlogia.buscaTecnologia();
                        System.out.println("------------------");

                        System.out.println("Digite o ID da Tecnologia que deseje apagar: ");
                        Addtecnlogia.deletarTecnologia(entrada.nextInt());
                    }


                default:
                    //System.out.println("Valor invalido");
                    break;

            }

            System.out.println("-----------------------------------");
            System.out.println("Se deseja sair digite 0\n" + "Se deseja continuar digite 1");
            y = entrada.nextInt();
            System.out.println("-----------------------------------");

        }while(y != 0);

        // Fechando entrada de dados
        entrada.close();
    }

}
