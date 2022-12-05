package br.inatel.cdg.gra.DAO;

import br.inatel.cdg.gra.MODEL.objetivo;

import java.sql.SQLException;
import java.util.ArrayList;

public class objetivoDAO extends ConnectionDAO{
        boolean sucesso = false;

    public boolean inserirObjetivo(objetivo objetivo) {
        connectToDB();

        String sql = "INSERT INTO objetivo (idObjetivo, objetivo, racaAlienigena_idRacaAlienigena) values(?, ?, ?)";
        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1, objetivo.getIdObjetivo());
            pst.setString(2, objetivo.getObjetivo());
            pst.setInt(3, objetivo.getRacaAlienigena_idRacaAlienigena());
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

    // ATUALIZAR OBJETIVO
    public boolean atualizarObjetivo(int id, objetivo objetivo) {
        connectToDB();
        String sql = "UPDATE objetivo SET objetivo = ? where idObjetivo = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, objetivo.getObjetivo());
            pst.setInt(2, objetivo.getIdObjetivo());
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
    public ArrayList<objetivo> buscaObjetivo(){

        ArrayList<objetivo> listaObjetivo = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM objetivo";

        try{
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Objetivos");
            while(rs.next()){
                objetivo objaux = new objetivo();
                objaux.setIdObjetivo(rs.getInt("idObjetivo"));
                objaux.setObjetivo(rs.getString("Objetivo"));
                objaux.setRacaAlienigena_idRacaAlienigena(rs.getInt("idRacaAlienigena"));

                System.out.println("IdObjetivo: " + objaux.getIdObjetivo());
                System.out.println("Objetivo: " + objaux.getObjetivo());
                System.out.println("idRacaAlienigena: " + objaux.getRacaAlienigena_idRacaAlienigena());
                System.out.println(" ");
                listaObjetivo.add(objaux);
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
        return listaObjetivo;
    }

    //DELETE UM OBJETIVO

    public boolean deletarObjetivo(int id){
        connectToDB();
        String sql = "DELETE FROM objetivo where idObjetivo =?";

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
