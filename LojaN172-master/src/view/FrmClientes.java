/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.CidadeDAO;
import dao.ClienteDAO;
import dao.EstadoDAO;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Cidade;
import model.Cliente;
import model.Estado;

/**
 *
 * @author 181720019
 */
public class FrmClientes extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmClientes
     */
    private Cliente cliente;
     private ListClientes telaListClientes;

    public FrmClientes() {
        initComponents();
        carregarEstados();
        carregarCidades(0);
        cliente = null;
        lblCodigo.setVisible(false);
        lblCodigoValor.setVisible(false);
    }

    public FrmClientes(int codigo, ListClientes telaListClientes) {
        this.telaListClientes = telaListClientes;
        initComponents();
        carregarEstados();
        carregarCidades(0);
        cliente = ClienteDAO.getClienteByCodigo(codigo);
        carregarFormulario();
        lblCodigo.setVisible(true);
        lblCodigoValor.setVisible(true);
        
    }

    private void carregarFormulario() {
        txtNome.setText(cliente.getNome());
        lblCodigoValor.setText(String.valueOf(cliente.getCodigo()));
        txtCPF.setText(cliente.getCpf());
        txtTelefone.setText(cliente.getTelefone());
        txtSalario.setText(String.valueOf(cliente.getSalario()));

        String data = "";

        int dia = cliente.getNascimento().get(Calendar.DAY_OF_MONTH);
        int mes = cliente.getNascimento().get(Calendar.MONTH) + 1;
        int ano = cliente.getNascimento().get(Calendar.YEAR);
        if (dia < 10) {
            data += "0";
        }
        data += dia + "/";
        if (dia < 10) {
            data += "0";
        }
        data += mes + "/" + ano;
        txtNascimento.setText(data);
        if (cliente.getSexo().equals(cliente.FEMININO)) {
            rbFeminino.setSelected(true);
        }

        if (cliente.getSexo().equals(cliente.MASCULINO)) {
            rbMasculino.setSelected(true);
        }

        cbTemFilhos.setSelected(cliente.isTemfilhos());
        cbCasados.setSelected(cliente.isCasado());

        int codEstado = cliente.getCidade().getEstado().getCodigo();

        List<Estado> estados = EstadoDAO.getEstado();
        for (int i = 0; i < estados.size(); i++) {
            if (estados.get(i).getCodigo() == codEstado) {
                int posicao = i + 1;
                cmbEstado.setSelectedIndex(posicao);
                break;
            }
        }
        List<Cidade> cidades = CidadeDAO.getCidades(codEstado);
        int codCidade = cliente.getCidade().getCodigo();
        for (int i = 0; i < cidades.size(); i++) {
            if (cidades.get(i).getCodigo() == codCidade) {
                int posicao = i + 1;
                cmbCidade.setSelectedIndex(posicao);
                break;
            }
        }
    }

    private void carregarEstados() {
        List<Estado> lista = EstadoDAO.getEstado();
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        Estado fake = new Estado("Selecione...");
        fake.setCodigo(0);
        model.addElement(fake);
        for (Estado estado : lista) {
            model.addElement(estado);
        }
        cmbEstado.setModel(model);
    }

    private void carregarCidades(int codEstado) {

        DefaultComboBoxModel model = new DefaultComboBoxModel();

        Cidade fake = new Cidade();
        fake.setCodigo(0);

        if (codEstado == 0) {
            fake.setNome("Selecione um estado...");
            model.addElement(fake);
            cmbCidade.setEnabled(false);

        } else {
            List<Cidade> lista = CidadeDAO.getCidades(codEstado);
            fake.setNome("Selecione...");
            model.addElement(fake);
            for (Cidade cidade : lista) {
                model.addElement(cidade);
            }
            cmbCidade.setEnabled(true);
        }
        cmbCidade.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupSexo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCodigoValor = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCPF = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        rbFeminino = new javax.swing.JRadioButton();
        rbMasculino = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        cbTemFilhos = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        txtNascimento = new javax.swing.JFormattedTextField();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        cmbCidade = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        lblSalario = new javax.swing.JLabel();
        txtSalario = new javax.swing.JFormattedTextField();
        cbCasados = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(153, 153, 153));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Formulário de Cliente");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cadastrar Cliente");
        jLabel1.setToolTipText("");

        lblCodigo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblCodigo.setText("Codigo:");
        lblCodigo.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Nome: ");
        jLabel3.setToolTipText("");

        lblCodigoValor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblCodigoValor.setText("0");
        lblCodigoValor.setToolTipText("");

        txtNome.setToolTipText("");
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPF.setToolTipText("");
        txtCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("CPF:");
        jLabel5.setToolTipText("");

        buttonGroupSexo.add(rbFeminino);
        rbFeminino.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        rbFeminino.setText("Feminino");
        rbFeminino.setToolTipText("");
        rbFeminino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFemininoActionPerformed(evt);
            }
        });

        buttonGroupSexo.add(rbMasculino);
        rbMasculino.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        rbMasculino.setText("Masculino");
        rbMasculino.setToolTipText("");
        rbMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMasculinoActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(153, 153, 153));
        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Sexo:");
        jLabel6.setToolTipText("");

        cbTemFilhos.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbTemFilhos.setText("Tem Filhos");
        cbTemFilhos.setToolTipText("");
        cbTemFilhos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTemFilhosActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Data de Nascimento: ");
        jLabel7.setToolTipText("");

        txtNascimento.setBackground(new java.awt.Color(240, 240, 240));
        try {
            txtNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNascimento.setToolTipText("");
        txtNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNascimentoActionPerformed(evt);
            }
        });

        cmbEstado.setBackground(new java.awt.Color(153, 153, 153));
        cmbEstado.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEstado.setToolTipText("");
        cmbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEstadoItemStateChanged(evt);
            }
        });
        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("Estado: ");
        jLabel8.setToolTipText("");

        lblCidade.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblCidade.setText("Cidade:");
        lblCidade.setToolTipText("");

        cmbCidade.setBackground(new java.awt.Color(153, 153, 153));
        cmbCidade.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cmbCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCidade.setToolTipText("");
        cmbCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCidadeActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setText("Telefone:");
        jLabel10.setToolTipText("");

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setToolTipText("");

        btnSalvar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setToolTipText("");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.setToolTipText("");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        lblSalario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblSalario.setText("Salário:");

        txtSalario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalarioActionPerformed(evt);
            }
        });

        cbCasados.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbCasados.setText("Casado");
        cbCasados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCasadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(lblCodigo))
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome)
                            .addComponent(txtCPF)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCodigoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtTelefone)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbFeminino)
                                .addGap(18, 18, 18)
                                .addComponent(rbMasculino))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSalario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTemFilhos)
                    .addComponent(cbCasados, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCodigo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCodigoValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(rbFeminino)
                            .addComponent(rbMasculino))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSalario)
                            .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCidade)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(cbTemFilhos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCasados)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void rbFemininoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFemininoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbFemininoActionPerformed

    private void rbMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMasculinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbMasculinoActionPerformed

    private void cbTemFilhosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTemFilhosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTemFilhosActionPerformed

    private void txtNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNascimentoActionPerformed

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstadoActionPerformed

    private void cmbCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCidadeActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String nome = txtNome.getText();
        String cpf = txtCPF.getText();
        Cidade cidade = (Cidade) cmbCidade.getSelectedItem();
        boolean cpfOk = true;
        try {
            String ultimoNumero = cpf.substring(13);
            Integer.valueOf(ultimoNumero);

        } catch (Exception e) {
            cpfOk = false;
        }

        if (nome.isEmpty() || !cpfOk || cidade.getCodigo() == 0) {
            JOptionPane.showMessageDialog(this, "Os campos Nome, CPF e Cidade são obrigatórios");
        } else {
            
            boolean novo = false;
            if(cidade == null){
                cliente = new Cliente();
                novo = true;
            }
            
         //   Cliente cliente = new Cliente();
            cliente.setNome(txtNome.getText());
            cliente.setTelefone(txtTelefone.getText());
            cliente.setCpf(cpf);

            String salario = txtSalario.getText();
            if (!salario.isEmpty()) {
                salario = salario.replace(",", ".");
                cliente.setSalario(Double.valueOf(salario));
            } else {
                cliente.setSalario(0);
            }

            cliente.setTemfilhos(cbTemFilhos.isSelected());
            cliente.setCasado(cbCasados.isSelected());

            if (rbFeminino.isSelected()) {
                cliente.setSexo("f");
            } else if (rbMasculino.isSelected()) {
                cliente.setSexo("m");
            } else {
                cliente.setSexo("");
            }

            String data = txtNascimento.getText();
            int dia = Integer.valueOf(data.substring(0, 2));
            int mes = Integer.valueOf(data.substring(3, 5)) - 1;
            int ano = Integer.valueOf(data.substring(6));
            Calendar nascimento = Calendar.getInstance();
            nascimento.set(ano, mes, dia);
            cliente.setNascimento(nascimento);
            cliente.setCidade(cidade);
            
            if(novo){
              ClienteDAO.inserir(cliente);
              limparFoemulario();
        }else{
              ClienteDAO.editar(cliente);
              telaListClientes.carregarTabela();
              this.dispose();
              
        }
            
            
    }//GEN-LAST:event_btnSalvarActionPerformed
    }
    private void cbCasadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCasadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCasadosActionPerformed

    private void cmbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstadoItemStateChanged
        Estado estado = (Estado) cmbEstado.getSelectedItem();
        carregarCidades(estado.getCodigo());
    }//GEN-LAST:event_cmbEstadoItemStateChanged

    private void txtSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalarioActionPerformed

    private void limparFoemulario(){
        txtNome.setText("");
        txtTelefone.setText("");
        txtCPF.setText("");
        txtNascimento.setText("");
        lblSalario.setText("");
        buttonGroupSexo.clearSelection();
        cbCasados.setSelected(false);
        cbTemFilhos.setSelected(false);
        cmbEstado.setSelectedIndex(0);
    }
    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txtNome.setText("");
        txtTelefone.setText("");
        txtCPF.setText("");
        txtNascimento.setText("");
        lblSalario.setText("");
        buttonGroupSexo.clearSelection();
        cbCasados.setSelected(false);
        cbTemFilhos.setSelected(false);
        cmbEstado.setSelectedIndex(0);
    }//GEN-LAST:event_btnLimparActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroupSexo;
    private javax.swing.JCheckBox cbCasados;
    private javax.swing.JCheckBox cbTemFilhos;
    private javax.swing.JComboBox<String> cmbCidade;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigoValor;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JRadioButton rbFeminino;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JFormattedTextField txtNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtSalario;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
