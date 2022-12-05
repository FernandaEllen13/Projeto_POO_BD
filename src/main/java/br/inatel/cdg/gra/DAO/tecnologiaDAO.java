package br.inatel.cdg.gra.DAO;

import br.inatel.cdg.gra.MODEL.objetivo;
import br.inatel.cdg.gra.MODEL.tecnologia;


import java.sql.SQLException;
import java.util.ArrayList;


    public class tecnologiaDAO extends ConnectionDAO {

        boolean sucesso = false;

        public boolean inserirTecnologia(tecnologia tecnologia) {
            connectToDB();

            String sql = "INSERT INTO tecnologia (idTecnologia, nome, funcao, tempo_criacao) values(?, ?, ?, ?)";
            try{
                pst = con.prepareStatement(sql);
                pst.setInt(1, tecnologia.getIdTecnologia());
                pst.setString(2, tecnologia.getNome());
                pst.setString(3, tecnologia.getFuncao());
                pst.setString(4, tecnologia.getTempo_criacao());
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

        // ATUALIZAR TECNOLOGIA
        public boolean atualizarTecnologia(int id,tecnologia tecnologia) {
            connectToDB();
            String sql = "UPDATE tecnologia SET nome = ?, funcao = ?, tempo_criacao = ? where idTecnologia = ?";

            try {
                pst = con.prepareStatement(sql);
                pst.setString(1, tecnologia.getNome());
                pst.setInt(2,tecnologia.getIdTecnologia());
                pst.setString(3,tecnologia.getFuncao());
                pst.setString(4,tecnologia.getTempo_criacao());
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
        public ArrayList<tecnologia> buscaTecnologia(){

            ArrayList<tecnologia> listaTecnologia = new ArrayList<>();
            connectToDB();
            String sql = "SELECT * FROM tecnologia";

            try{
                st = con.createStatement();
                rs = st.executeQuery(sql);
                System.out.println("Tecnologias");
                while(rs.next()){
                    tecnologia tecaux = new tecnologia();
                    tecaux.setIdTecnologia(rs.getInt("idTecnologia"));
                    tecaux.setNome(rs.getString("Nome"));
                    tecaux.setFuncao(rs.getString("Funcao"));
                    tecaux.setTempo_criacao(rs.getString("Tempo criacao"));

                    System.out.println("IdTecnologia: " + tecaux.getIdTecnologia());
                    System.out.println("Nome: " + tecaux.getNome());
                    System.out.println("Funcao: " + tecaux.getFuncao());
                    System.out.println("Tempo criacao: " + tecaux.getTempo_criacao());
                    System.out.println(" ");
                    listaTecnologia.add(tecaux);
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
            return listaTecnologia;
        }

        public boolean deletarTecnologia(int id){
            connectToDB();
            String sql = "DELETE FROM tecnologia where idTecnologia =?";

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
