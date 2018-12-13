/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.CategoriaDAO;
import dao.ProdutosDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Produto;
import model.Produto;

/**
 *
 * @author 181720019
 */
public class FrmProdutos extends javax.swing.JInternalFrame {
    
    private Produto produto;
    private ListProdutos telaListProdutos;
    

    /**
     * Creates new form FrmProdutos
     */
    public FrmProdutos() {
        initComponents();
        produto = null;
        carregarCategorias(); 
        
        
    }
    
    public FrmProdutos(int codigo, ListProdutos telaListProdutos){
        initComponents();
        carregarCategorias();
        this.telaListProdutos = telaListProdutos;
        produto = ProdutosDAO.getProdutosByCodigo(codigo);
        carregarFormulario();
        
    }
  
    
    public void carregarFormulario(){ 
        lblCodigo.setText( String.valueOf(produto.getCodigo()) );
        txtNome.setText(produto.getNome());
        txtPreco.setText(String.valueOf(produto.getPreco()));
        txtQuantidade.setText(String.valueOf(produto.getQuantidade()));
        
        int codCategoria = produto.getCategoria().getCodigo();
        
        List<Produto> categorias = CategoriaDAO.getCategorias();
        for (int i =0; i< categorias.size(); i++){
            if(categorias.get(i).getCodigo() == codCategoria){
                int posicao = i + 1;
                cmbCategoria.setSelectedIndex(posicao);
                break;
            }
        }
       
    }
    
    private void carregarCategorias(){
        List<Produto> lista = CategoriaDAO.getCategorias();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        Produto fake = new Produto(0, "Selecione...");
        model.addElement(fake);
        for( Produto categoria : lista ){
            model.addElement( categoria);
        }
        cmbCategoria.setModel(model);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        FrmProdutos = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtQuantidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        lblCodigo = new javax.swing.JLabel();
        txtPreco = new javax.swing.JFormattedTextField();

        jLabel2.setText("jLabel2");

        setBackground(new java.awt.Color(153, 153, 153));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastrar Produtos");

        FrmProdutos.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        FrmProdutos.setText("Cadastrar Produtos");

        btnLimpar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Código:");

        lblNome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblNome.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Preço: ");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Quantidade: ");

        txtQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantidadeActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Categoria:");

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });

        lblCodigo.setText("0");

        txtPreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(343, 343, 343)
                        .addComponent(FrmProdutos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(btnSalvar)
                        .addGap(72, 72, 72)
                        .addComponent(btnLimpar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtPreco))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblNome)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(FrmProdutos)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblCodigo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(149, 149, 149)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnLimpar))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparFormulario();
    }//GEN-LAST:event_btnLimparActionPerformed
 private void limparFormulario(){
     txtNome.setText("");
        txtPreco.setText("");
        txtQuantidade.setText("");
        cmbCategoria.setSelectedIndex(0);
 }
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
       String nome = txtNome.getText();
       String preco = txtPreco.getText();
       String qtd = txtQuantidade.getText();
       Produto categoria = (Produto) cmbCategoria.getSelectedItem();
       
       if(nome.isEmpty() || preco.isEmpty() || categoria.getCodigo() == 0 ){
           JOptionPane.showMessageDialog(this, "O campos nome, preço e categoria são obrigatórios!");
       }else{
           
           boolean novo = false;
           if(produto == null ){
               produto = new Produto();
               novo = true;
           }else{
             
              novo = false; 
              
           }
           
          produto.setNome(txtNome.getText());
          preco = preco.replace(",", ".");
          produto.setPreco( Double.valueOf( preco ));
          
          if(qtd.isEmpty()){
              produto.setQuantidade(0);
          }else{
              qtd = qtd.replace(",", ".");
              produto.setQuantidade( Double.valueOf(qtd));
          }
          
          produto.setCategoria(categoria);
          if(novo){
           ProdutosDAO.inserir(produto);
           limparFormulario();
          
          }else{
              ProdutosDAO.editar(produto);
              telaListProdutos.carregarTabela();
              this.dispose();
          }
           
          
       }
       
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCategoriaActionPerformed

    private void txtQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidadeActionPerformed

    private void txtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FrmProdutos;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtPreco;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
