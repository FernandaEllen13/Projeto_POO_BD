package br.inatel.cdg.gra.MODEL;

    public class planeta {
        protected int idplaneta;
        protected String galaxia;
        protected String estrela;
        protected String nome;

        public int getIdplaneta() {
            return idplaneta;
        }

        public void setIdplaneta(int idplaneta) {
            this.idplaneta = idplaneta;
        }

        public String getGalaxia() {
            return galaxia;
        }

        public void setGalaxia(String galaxia) {
            this.galaxia = galaxia;
        }

        public String getEstrela() {
            return estrela;
        }

        public void setEstrela(String estrela) {
            this.estrela = estrela;
        }

        public String getnome() {
            return nome;
        }

        public void setnome(String tipo) {
            this.nome = tipo;
        }
    }
