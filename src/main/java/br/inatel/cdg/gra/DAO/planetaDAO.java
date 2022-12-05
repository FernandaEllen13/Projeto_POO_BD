package br.inatel.cdg.gra.DAO;

import br.inatel.cdg.gra.MODEL.planeta;

import java.sql.SQLException;
import java.util.ArrayList;

    public class planetaDAO extends ConnectionDAO {
        boolean sucesso = false;

        public boolean  inserirPlaneta(planeta planeta) {
            connectToDB();

            String sql = "INSERT INTO planeta (idPlaneta, galaxia, estrela, nome) values(?, ?, ?, ? )";
            try{
                pst = con.prepareStatement(sql);
                pst.setInt(1, planeta.getIdplaneta());
                pst.setString(2, planeta.getGalaxia());
                pst.setString(3, planeta.getEstrela());
                pst.setString(4, planeta.getnome());
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

        // ATUALIZAR PLANETA
        public boolean atualizarPlaneta(int id, planeta planeta) {
            connectToDB();
            String sql = "UPDATE planeta SET tipo = ? where idPlaneta = ?";

            try {
                pst = con.prepareStatement(sql);
                pst.setString(1, planeta.getnome());
                pst.setInt(2, planeta.getIdplaneta());
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
        public ArrayList<planeta> buscaPlanetas(){

            ArrayList<planeta> listaPlaneta = new ArrayList<>();
            connectToDB();
            String sql = "SELECT * FROM planeta";

            try{
                st = con.createStatement();
                rs = st.executeQuery(sql);
                System.out.println("Planetas");
                while(rs.next()){
                    planeta plaux = new planeta();
                    plaux.setIdplaneta(rs.getInt("idPlaneta"));
                    plaux.setGalaxia(rs.getString("Galaxia"));
                    plaux.setEstrela(rs.getString("Estrela"));
                    plaux.setnome(rs.getString("Nome"));

                    System.out.println("IdPlaneta: " + plaux.getIdplaneta());
                    System.out.println("Galaxia: " + plaux.getGalaxia());
                    System.out.println("Estrela: " + plaux.getEstrela());
                    System.out.println("Nome: " + plaux.getnome());
                    System.out.println(" ");
                    listaPlaneta.add(plaux);
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
            return listaPlaneta;
        }

        //Deletar um planeta

        public boolean deletarPlaneta(int id){
            connectToDB();
            String sql = "DELETE FROM planeta where idplaneta=?";

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
