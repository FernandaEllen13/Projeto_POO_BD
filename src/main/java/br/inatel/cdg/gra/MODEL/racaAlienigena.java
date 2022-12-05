package br.inatel.cdg.gra.MODEL;

    public class racaAlienigena {
      protected int idRacaAlienigena;
      protected String nome;
      protected boolean pacifica;
      protected int planeta_idplaneta;
      protected int tecnologia_idTecnlogia;

        public int getIdRacaAlienigena() {
            return idRacaAlienigena;
        }

        public void setIdRacaAlienigena(int idRacaAlienigena) {
            this.idRacaAlienigena = idRacaAlienigena;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public boolean isPacifica() {
            return pacifica;
        }

        public void setPacifica(boolean pacifica) {
            this.pacifica = pacifica;
        }

        public int getPlaneta_idplaneta() {
            return planeta_idplaneta;
        }

        public void setPlaneta_idplaneta(int planeta_idplaneta) {
            this.planeta_idplaneta = planeta_idplaneta;
        }

        public int getTecnologia_idTecnlogia() {
            return tecnologia_idTecnlogia;
        }

        public void setTecnologia_idTecnlogia(int tecnologia_idTecnlogia) {
            this.tecnologia_idTecnlogia = tecnologia_idTecnlogia;
        }
    }
