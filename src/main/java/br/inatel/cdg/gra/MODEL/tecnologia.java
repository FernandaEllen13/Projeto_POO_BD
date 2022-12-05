package br.inatel.cdg.gra.MODEL;

    public class tecnologia {
       protected int idTecnologia;
       protected String nome;
       protected String funcao;
       protected String tempo_criacao;
       protected int racaAlienigena_idRacaAlienigena;

        public int getIdTecnologia() {
            return idTecnologia;
        }

        public void setIdTecnologia(int idTecnologia) {
            this.idTecnologia = idTecnologia;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getFuncao() {
            return funcao;
        }

        public void setFuncao(String funcao) {
            this.funcao = funcao;
        }

        public String getTempo_criacao() {
            return tempo_criacao;
        }

        public void setTempo_criacao(String tempo_criacao) {
            this.tempo_criacao = tempo_criacao;
        }

        public int getRacaAlienigena_idRacaAlienigena() {
            return racaAlienigena_idRacaAlienigena;
        }

        public void setRacaAlienigena_idRacaAlienigena(int racaAlienigena_idRacaAlienigena) {
            this.racaAlienigena_idRacaAlienigena = racaAlienigena_idRacaAlienigena;
        }
    }
