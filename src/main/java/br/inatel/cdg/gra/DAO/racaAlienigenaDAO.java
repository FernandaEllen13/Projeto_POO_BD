package br.inatel.cdg.gra.DAO;

import br.inatel.cdg.gra.MODEL.racaAlienigena;
import br.inatel.cdg.gra.MODEL.planeta;

import java.sql.SQLException;
import java.util.ArrayList;


    public class racaAlienigenaDAO extends ConnectionDAO {

        //DAO - Data Access Object
        boolean sucesso = false; //Para saber se funcionou

        public boolean inserirRaca(racaAlienigena racaAlienigena) {
            connectToDB();

            String sql = "INSERT INTO racaAlienigena (idRacaAlienigena, nome, pacifica, planeta_idplaneta) values(?, ?, ?, ?)";
            try{
                pst = con.prepareStatement(sql);
                pst.setInt(1, racaAlienigena.getIdRacaAlienigena());
                pst.setString(2, racaAlienigena.getNome());
                pst.setBoolean(3, racaAlienigena.isPacifica());
                pst.setInt(4, racaAlienigena.getPlaneta_idplaneta());
                pst.execute();
                sucesso = true;
            }catch (SQLException exc){
                System.out.println("Erro: " + exc.getMessage());
                sucesso = false;
            }finally {
                try{
                    con.close();
                    pst.close();
                }catch (SQLException exc){
                    System.out.println("Erro: " + exc.getMessage());
                }
            }
            return sucesso;
        }

        // ATUALIZAR RAÇA
        public boolean atualizarRaca(int id, racaAlienigena racaAlienigena) {
            connectToDB();
            String sql = "UPDATE racaAlienigena SET nome = ?, idRacaAlienigena=?, pacifica=?, Planeta_idplaneta=?   where idRacaAlienigena = ?";

            try {
                pst = con.prepareStatement(sql);
                pst.setString(1, racaAlienigena.getNome());
                pst.setInt(2, racaAlienigena.getIdRacaAlienigena());
                pst.setBoolean(3,racaAlienigena.isPacifica());
                pst.setInt(4,racaAlienigena.getPlaneta_idplaneta());
                pst.execute();
                sucesso = true;

            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
                sucesso = false;
            }finally {
                try{
                    con.close();
                    pst.close();
                }catch (SQLException ex){
                    System.out.println("Erro: " + ex.getMessage());
                }
            }
            return sucesso;
        }            

        // METODO MOSTRA INFO
        public ArrayList<racaAlienigena> buscaRacaAlienigena(){

            ArrayList<racaAlienigena> listaRaca = new ArrayList<>();
            connectToDB();
            String sql = "SELECT * FROM racaAlienigena";

            try{
                st = con.createStatement();
                rs = st.executeQuery(sql);
                System.out.println("Lista de racas cadastradas");
                while(rs.next()){
                    racaAlienigena racaux = new racaAlienigena();
                    racaux.setIdRacaAlienigena(rs.getInt("idRacaAlienigena"));
                    racaux.setNome(rs.getString("Nome"));
                    racaux.setPacifica(rs.getBoolean("Pacifica"));
                    racaux.setPlaneta_idplaneta(rs.getInt("planeta_idplaneta"));

                    System.out.println("IdRacaAlienigena: " + racaux.getIdRacaAlienigena());
                    System.out.println("Nome: " + racaux.getNome());
                    System.out.println("Pacifica: " + racaux.isPacifica());
                    System.out.println("IdPlaneta: " + racaux.getPlaneta_idplaneta());
                    System.out.println(" ");
                    listaRaca.add(racaux);
                }
                sucesso = true;
            }
            catch (SQLException e){
                System.out.println("Erro: " + e.getMessage());
                sucesso = false;
            } finally {
                try{
                    con.close();
                    st.close();
                }catch (SQLException e){
                    System.out.println("Erro: " + e.getMessage());
                }
            }
            return listaRaca;
        }

        //Deletar uma raça

        public boolean deletarRaca(int id){
            connectToDB();
            String sql = "DELETE FROM racaAlienigena where IdRacaAlienigena=?";

            try{
               pst = con.prepareStatement(sql);
               pst.setInt(1, id);
               pst.execute();
               sucesso = true;
            }catch(SQLException ex){
                System.out.println("Erro = " + ex.getMessage());
                sucesso = false;
            }finally {
                try{
                    con.close();
                    pst.close();
                }catch (SQLException exc){
                    System.out.println("Erro: " + exc.getMessage());
                }
            }
            return sucesso;
        }

        }


