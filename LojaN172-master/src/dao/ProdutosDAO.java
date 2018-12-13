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
import model.Produto;
import model.Produto;

/**
 *
 * @author 181720019
 */
public class ProdutosDAO {
    public static void inserir(Produto produtos) {
        String sql = "INSERT INTO produtos "
                + "(nome, preco, quantidade, codCategoria)"
                + " VALUES('" + produtos.getNome() + "' , "
                + " " + produtos.getPreco() + " , "
                + " " + produtos.getQuantidade() + " , "
                + " " + produtos.getCategoria().getCodigo()
                + " ) ";
                
        boolean retorno = Conexao.executar(sql);
        if (!retorno) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao inserir o produto");
        }
    }
  
    public static void editar(Produto produtos) {
        String sql = "UPDATE produtos SET "
                + " nome = '" + produtos.getNome() + "' , "
                + " preco = " + produtos.getPreco() + " , "
                + " quantidade = " + produtos.getQuantidade() + " , "
                + " codCategoria = " + produtos.getCategoria().getCodigo()
                + " WHERE codigo = " + produtos.getCodigo(); 
                
        
        boolean retorno = Conexao.executar(sql);
        if (!retorno) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao inserir o produto");
        }
    }
    
  public static void excluir(Produto produtos) {
        String sql = "DELETE FROM produtos "
                + " WHERE codigo = " + produtos.getCodigo();

        Conexao.executar(sql);
    }
    
    public static List<Produto> getProdutos() {
        List<Produto> lista = new ArrayList<>();
        
        String sql = "SELECT p.codigo, p.nome, p.preco, p.quantidade, p.codCategoria, c.nome "
        + " FROM produtos p "
        + " INNER JOIN categorias c ON p.codCategoria = c.codigo "
        + " ORDER BY p.nome"; 
        
        
        
        
        ResultSet rs = Conexao.consultar(sql);
        
        if (rs != null) {
            
            try{
                while(rs.next() ){
                   Produto pro = new Produto();
                   pro.setCodigo(rs.getInt(1));
                   pro.setNome(rs.getString(2));
                   pro.setPreco(rs.getDouble(3));
                   pro.setQuantidade(rs.getDouble(4));
                   
                   Produto cat = new Produto();
                   cat.setCodigo(rs.getInt(5));
                   cat.setNome(rs.getString(6));
                   
                   pro.setCategoria(cat);
                   lista.add(pro);
                }
            }catch (Exception e) {
                
            }
        }
        return lista;
    }
    public static Produto getProdutosByCodigo(int codigo) {
        String sql = "SELECT p.codigo, p.nome, p.preco, p.quantidade, p.codCategoria, c.nome "
                + " FROM produtos p "
                + " INNER JOIN categorias c ON  p.codCategoria = c.codigo "
                + " WHERE p.codigo = " + codigo;

        ResultSet rs = Conexao.consultar(sql);

        if (rs != null) {
            try{
                rs.next();
                   Produto pro = new Produto();
                   pro.setCodigo(rs.getInt(1));
                   pro.setNome(rs.getString(2));
                   pro.setPreco(rs.getDouble(3));
                   pro.setQuantidade(rs.getDouble(4));
                   
                   Produto cat = new Produto();
                   cat.setCodigo(rs.getInt(5));
                   cat.setNome(rs.getString(6));
                   
                   pro.setCategoria(cat);
                   
                   return pro;
                
            }catch (Exception e) {
                return null;
            }
         
        }else{
            return null;
        }
    }

  
    
    
}
