/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Categoria;


/**
 *
 * @author 181720019
 */
public class CategoriaDAO {
    
    public static void inserir(Categoria categoria) {
        String sql = "INSERT INTO categorias (nome)"
                + " VALUES('" + categoria.getNome() + "' )";
        boolean retorno = Conexao.executar(sql);
        if (!retorno) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao inserir a categoria");
        }
    }
     public static void editar(Categoria categoria) {
        String sql = "UPDATE categorias SET "
                + " nome = '" + categoria.getNome() + "' "
                + " WHERE codigo = " + categoria.getCodigo();
        boolean retorno = Conexao.executar(sql);
        if (!retorno) {
            JOptionPane.showMessageDialog(null, "Erro ao editar a categoria");
        }
    }
     
     public static void excluir(Categoria categoria) {
        String sql = "DELETE FROM categorias  "
                + " WHERE codigo = " + categoria.getCodigo();
        boolean retorno = Conexao.executar(sql);
        if (!retorno) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir a categoria");
        }
    }
    
    public static List<Categoria> getCategorias() {
        String sql = "SELECT codigo, nome "
        + " FROM categorias  "
        + " ORDER BY nome";
        
        List<Categoria> lista = new ArrayList<>();
        
        ResultSet rs = Conexao.consultar(sql);
        
        if (rs != null) {
            
            try{
                while(rs.next() ){
                   Categoria cat = new Categoria();
                   cat.setCodigo(rs.getInt(1));
                   cat.setNome(rs.getString(2));
                   
                   lista.add(cat);
                }
            }catch (Exception e) {
                
            }
           
        }
        return lista;
    }
    public static Categoria getCategoriaByCodigo(int codigo) {
        String sql = "SELECT codigo, nome "
                + " FROM categorias "
                + " WHERE codigo = " + codigo;
     

        ResultSet rs = Conexao.consultar(sql);

        if (rs != null) {
            try{
                
                rs.next();
                   Categoria cat = new Categoria();
                   cat.setCodigo(rs.getInt(1));
                   cat.setNome(rs.getString(2));
                   
                   return cat;
                
            }catch (Exception e) {
                return null;
            }
         
        }else{
            return null;
        }
    }
    
    
}
