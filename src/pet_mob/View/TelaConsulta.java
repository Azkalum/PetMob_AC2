/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pet_mob.View;
import java.awt.HeadlessException;
import java.sql.SQLException;
import pet_mob.Conexao.*;
import javax.swing.JOptionPane;
import pet_mob.Classes.Usuario;

/**
 *
 * @author thiag
 */
public class TelaConsulta extends javax.swing.JFrame {
    MySQL conectar = new MySQL();
    Usuario user = new Usuario();
    /**
     * Creates new form TelaConsulta
     */
    public TelaConsulta() {
        initComponents();
    }
    public void Consulta(Usuario user1){
       this.conectar.conectaBanco();
       
       String consultaCpf = this.campoBuscaCpf.getText();
       
          try {
            this.conectar.executarSQL(
                   "SELECT "
                    + "nome_user,"                    
                    + "sobrenome_user,"
                    + "idade,"
                    + "sexo,"
                    + "rua_usuario,"
                    + "estado_user,"   
                    + "cep_usuario," 
                    + "numero_casa," //não tem estado
                    + "cidade_usuario,"  
                    + "complemento_user,"
                    + "email_usuario,"
                    + "telefone_usuario,"
                    + "celular_user"       
                 + " FROM"
                     + " Usuario"
                 + " WHERE"
                     + " cpf_user = '" + consultaCpf + "'"
                + ";"
            );
            while(this.conectar.getResultSet().next()){
                       user.setNome(this.conectar.getResultSet().getString(1));        
                       user.setSobrenome(this.conectar.getResultSet().getString(2));
                       user.setIdade(this.conectar.getResultSet().getString(3));
                       user.setSexo(this.conectar.getResultSet().getString(4));       
                       user.setRua(this.conectar.getResultSet().getString(5));
                       user.setEstado(this.conectar.getResultSet().getString(6));
                       user.setCep(this.conectar.getResultSet().getString(7));
                       user.setNumeroCasa(this.conectar.getResultSet().getString(8));
                       user.setCidade(this.conectar.getResultSet().getString(9));
                       user.setComplemento(this.conectar.getResultSet().getString(10));
                       user.setEmail(this.conectar.getResultSet().getString(11));
                       user.setTelefone(this.conectar.getResultSet().getString(12));
                       user.setCelular(this.conectar.getResultSet().getString(13));
           } if("".equals(user.getNome())){
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
           }
            } catch (HeadlessException | SQLException e) {            
            System.out.println("Erro ao consultar cliente " +  e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente");
            
        }finally{
            campoNomeU.setText(user.getNome());
            campoSobrenomeU.setText(user.getSobrenome());
            campoIdadeU.setText(user.getIdade());
            campoSexoU.setText(user.getSexo());
            campoRuaU.setText(user.getRua());
            campoEstadoU.setText(user.getEstado());
            campoCidadeU.setText(user.getCidade());
            campoCpfU.setText(this.campoBuscaCpf.getText());
            campoNumeroCasaU.setText(this.user.getNumeroCasa());
            campoCepU.setText(this.user.getCep());
            campoComplementoU.setText(user.getComplemento());
            campoEmailU.setText(user.getEmail());
            campoCelularU.setText(user.getCelular());
            campoTelefoneU.setText(user.getTelefone());
            //campoemail
            //campoCep
           //campoBairro
           //telefone
            //consultaEstado.setText(novoCliente.getEstado());
            this.conectar.fechaBanco();   
        }    
     limpaObjeto();
            
    }
    
    public void excluiUsuario(Usuario user){
        this.conectar.conectaBanco();
        String consultaCpf = this.campoBuscaCpf.getText();
        
        try {
            this.conectar.updateSQL(
                    "DELETE" 
                    +" FROM" 
                    +" Usuario"
                    + " WHERE"
                    +" cpf_user = '" + consultaCpf + "'"
                    +";"
            );
        } catch (Exception e) {
            System.out.println("Erro ao deletar cliente " +  e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao deletar cliente");
        } finally {
              this.conectar.fechaBanco();
            limparCamposBusca();
            JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso");
        }
        limpaObjeto();
        
    }
    
    public void limparCamposBusca(){
        campoCelularU.setText("");
        campoBuscaCpf.setText("");
        campoCepU.setText("");
        campoCidadeU.setText("");
        campoComplementoU.setText("");
        campoCpfU.setText("");
        campoEmailU.setText("");
        campoEstadoU.setText("");
        campoIdadeU.setText("");
        campoNomeU.setText("");
        campoNumeroCasaU.setText("");
        campoRuaU.setText("");
        campoSexoU.setText("");
        campoSobrenomeU.setText("");
        campoTelefoneU.setText("");
    }
    public void limpaObjeto(){
        user.setNome("");        
        user.setSobrenome("");
        user.setIdade("");
        user.setSexo("");       
        user.setRua("");
        user.setEstado("");
        user.setCep("");
        user.setNumeroCasa("");
        user.setCidade("");
        user.setComplemento("");
        user.setEmail("");
        user.setTelefone("");
        user.setCelular("");
    }
    
    public void atualizarTelefone(Usuario user){
        this.conectar.conectaBanco();
        String consultaCpf = this.campoBuscaCpf.getText();
            try {
                this.conectar.updateSQL(
                        "UPDATE Usuario SET "
                        + "telefone_usuario = '" + campoTelefoneU.getText() + "'"
                        +" WHERE "
                        + "cpf_user = '" + consultaCpf+"'"
                        +";"
                );
                 this.conectar.fechaBanco();
                
                limpaObjeto();
                JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar cliente " +  e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente");
        }
    }
        public void atualizaCelular(Usuario user){
        this.conectar.conectaBanco();
        String consultaCpf = this.campoBuscaCpf.getText();
            try {
                this.conectar.updateSQL(
                        "UPDATE Usuario SET "
                        + "celular_user = '" + campoCelularU.getText() + "'"
                        +" WHERE "
                        + "cpf_user = '" + consultaCpf+"'"
                        +";"
                );
                 this.conectar.fechaBanco();
                
                limpaObjeto();
                JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar cliente " +  e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente");
        }
    }
        
        public void atualizaEmail(Usuario user){
        this.conectar.conectaBanco();
        String consultaCpf = this.campoBuscaCpf.getText();
            try {
                this.conectar.updateSQL(
                        "UPDATE Usuario SET "
                        + "email_usuario = '" + campoEmailU.getText() + "'"
                        +" WHERE "
                        + "cpf_user = '" + consultaCpf+"'"
                        +";"
                );
                 this.conectar.fechaBanco();
               
                limpaObjeto();
                JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar cliente " +  e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente");
        }
    }
        public void atualizaEstado(Usuario user){
        this.conectar.conectaBanco();
        String consultaCpf = this.campoBuscaCpf.getText();
            try {
                this.conectar.updateSQL(
                        "UPDATE Usuario SET "
                        + "estado_user = '" + campoEstadoU.getText() + "'"
                        +" WHERE "
                        + "cpf_user = '" + consultaCpf+"'"
                        +";"
                );
                 this.conectar.fechaBanco();
               
                limpaObjeto();
                JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar cliente " +  e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente");
        }
    }
        public void atualizaCidade(Usuario user){
        this.conectar.conectaBanco();
        String consultaCpf = this.campoBuscaCpf.getText();
            try {
                this.conectar.updateSQL(
                        "UPDATE Usuario SET "
                        + "cidade_usuario = '" + campoCidadeU.getText() + "'"
                        +" WHERE "
                        + "cpf_user = '" + consultaCpf+"'"
                        +";"
                );
                 this.conectar.fechaBanco();
               
                limpaObjeto();
                JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar cliente " +  e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente");
        }
    }
        public void atualizaRua(Usuario user){
        this.conectar.conectaBanco();
        String consultaCpf = this.campoBuscaCpf.getText();
            try {
                this.conectar.updateSQL(
                        "UPDATE Usuario SET "
                        + "rua_usuario = '" + campoRuaU.getText() + "'"
                        +" WHERE "
                        + "cpf_user = '" + consultaCpf+"'"
                        +";"
                );
                 this.conectar.fechaBanco();
                
                limpaObjeto();
                JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar cliente " +  e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente");
        }
    }
        public void atualizaCep(Usuario user){
        this.conectar.conectaBanco();
        String consultaCpf = this.campoBuscaCpf.getText();
            try {
                this.conectar.updateSQL(
                        "UPDATE Usuario SET "
                        + "cep_usuario = '" + campoCepU.getText() + "'"
                        +" WHERE "
                        + "cpf_user = '" + consultaCpf+"'"
                        +";"
                );
                 this.conectar.fechaBanco();
                
                limpaObjeto();
                JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar cliente " +  e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente");
        }
    }
        
        public void atualizaNumeroCasa(Usuario user){
        this.conectar.conectaBanco();
        String consultaCpf = this.campoBuscaCpf.getText();
            try {
                this.conectar.updateSQL(
                        "UPDATE Usuario SET "
                        + "numero_casa = '" + campoNumeroCasaU.getText() + "'"
                        +" WHERE "
                        + "cpf_user = '" + consultaCpf+"'"
                        +";"
                );
                 this.conectar.fechaBanco();
                
                limpaObjeto();
                JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar cliente " +  e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente");
        }
    }
        
        public void atualizaComplemento(Usuario user){
        this.conectar.conectaBanco();
        String consultaCpf = this.campoBuscaCpf.getText();
            try {
                this.conectar.updateSQL(
                        "UPDATE Usuario SET "
                        + "complemento_user = '" + campoComplementoU.getText() + "'"
                        +" WHERE "
                        + "cpf_user = '" + consultaCpf+"'"
                        +";"
                );
                 this.conectar.fechaBanco();
                
                limpaObjeto();
                JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar cliente " +  e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente");
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoBuscaCpf = new javax.swing.JFormattedTextField();
        botaoConsultaCpf = new javax.swing.JButton();
        editaCep = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        campoNumeroCasaU = new javax.swing.JTextField();
        campoComplementoU = new javax.swing.JTextField();
        campoRuaU = new javax.swing.JTextField();
        campoCidadeU = new javax.swing.JTextField();
        campoCpfU = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campoCepU = new javax.swing.JTextField();
        campoEstadoU = new javax.swing.JTextField();
        campoSexoU = new javax.swing.JTextField();
        campoIdadeU = new javax.swing.JTextField();
        campoSobrenomeU = new javax.swing.JTextField();
        campoNomeU = new javax.swing.JTextField();
        editaCEP = new javax.swing.JButton();
        editaEstado = new javax.swing.JButton();
        editaCidade = new javax.swing.JButton();
        editaRua = new javax.swing.JButton();
        editaNumCasa = new javax.swing.JButton();
        editaComplemento = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        campoTelefoneU = new javax.swing.JTextField();
        campoCelularU = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        campoEmailU = new javax.swing.JTextField();
        editaCelular = new javax.swing.JButton();
        editaTelefone = new javax.swing.JButton();
        editaEmail = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        botaoExlcuir = new javax.swing.JButton();
        botaoVoltar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados / CPF", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        jLabel1.setText("CPF : ");

        try {
            campoBuscaCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoBuscaCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBuscaCpfActionPerformed(evt);
            }
        });

        botaoConsultaCpf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        botaoConsultaCpf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pet_mob/View/busca.png"))); // NOI18N
        botaoConsultaCpf.setText("Consultar");
        botaoConsultaCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConsultaCpfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(campoBuscaCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoConsultaCpf)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoBuscaCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoConsultaCpf)
                .addContainerGap())
        );

        editaCep.setBackground(new java.awt.Color(204, 204, 255));
        editaCep.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        jLabel3.setText("Nome : ");

        jLabel4.setText("Sobrenome : ");

        jLabel5.setText("Idade : ");

        jLabel6.setText("Sexo : ");

        jLabel8.setText("Estado : ");

        jLabel9.setText("Cidade : ");

        jLabel10.setText("Rua : ");

        jLabel11.setText("Número da Casa : ");

        jLabel12.setText("Complemento : ");

        jLabel13.setText("CPF : ");

        campoCpfU.setEnabled(false);
        campoCpfU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCpfUActionPerformed(evt);
            }
        });

        jLabel2.setText("CEP :");

        campoSexoU.setEnabled(false);

        campoIdadeU.setEnabled(false);

        campoSobrenomeU.setEnabled(false);

        campoNomeU.setEnabled(false);

        editaCEP.setText("Alterar");
        editaCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editaCEPActionPerformed(evt);
            }
        });

        editaEstado.setText("Alterar");
        editaEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editaEstadoActionPerformed(evt);
            }
        });

        editaCidade.setText("Alterar");
        editaCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editaCidadeActionPerformed(evt);
            }
        });

        editaRua.setText("Alterar");
        editaRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editaRuaActionPerformed(evt);
            }
        });

        editaNumCasa.setText("Alterar");
        editaNumCasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editaNumCasaActionPerformed(evt);
            }
        });

        editaComplemento.setText("Alterar");
        editaComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editaComplementoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editaCepLayout = new javax.swing.GroupLayout(editaCep);
        editaCep.setLayout(editaCepLayout);
        editaCepLayout.setHorizontalGroup(
            editaCepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editaCepLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editaCepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editaCepLayout.createSequentialGroup()
                        .addGroup(editaCepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(42, 42, 42)
                        .addGroup(editaCepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editaCepLayout.createSequentialGroup()
                                .addComponent(campoNomeU, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
                            .addGroup(editaCepLayout.createSequentialGroup()
                                .addGroup(editaCepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoCepU, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoCidadeU, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoEstadoU, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoSexoU, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoIdadeU, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoSobrenomeU, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                                .addGroup(editaCepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(editaEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                    .addComponent(editaCEP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(editaCidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())))
                    .addGroup(editaCepLayout.createSequentialGroup()
                        .addGroup(editaCepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(editaCepLayout.createSequentialGroup()
                                .addGroup(editaCepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addGap(18, 18, 18)
                                .addGroup(editaCepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoCpfU, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoRuaU, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoNumeroCasaU, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoComplementoU, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(editaCepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editaRua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(editaNumCasa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editaComplemento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        editaCepLayout.setVerticalGroup(
            editaCepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editaCepLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editaCepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNomeU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(9, 9, 9)
                .addGroup(editaCepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoSobrenomeU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(editaCepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoIdadeU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(editaCepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(campoSexoU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editaCepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addGroup(editaCepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoEstadoU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editaEstado)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editaCepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoCepU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editaCEP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editaCepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(campoCidadeU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editaCidade))
                .addGap(9, 9, 9)
                .addGroup(editaCepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(campoRuaU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editaRua))
                .addGap(9, 9, 9)
                .addGroup(editaCepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(campoNumeroCasaU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editaNumCasa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editaCepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editaCepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoComplementoU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editaComplemento)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editaCepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(campoCpfU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        jLabel7.setText("Telefone :");

        jLabel14.setText("Celular :");

        jLabel15.setText("E-mail :");

        editaCelular.setText("Alterar");
        editaCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editaCelularActionPerformed(evt);
            }
        });

        editaTelefone.setText("Alterar");
        editaTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editaTelefoneActionPerformed(evt);
            }
        });

        editaEmail.setText("Alterar");
        editaEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editaEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(campoEmailU, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(editaEmail))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoTelefoneU, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(campoCelularU))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editaTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editaCelular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoTelefoneU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editaTelefone)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(campoCelularU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editaCelular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoEmailU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editaEmail)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opções", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cantarell", 1, 18))); // NOI18N

        botaoExlcuir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        botaoExlcuir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pet_mob/View/apagar.png"))); // NOI18N
        botaoExlcuir.setText("Excluir Usuário");
        botaoExlcuir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botaoExlcuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExlcuirActionPerformed(evt);
            }
        });

        botaoVoltar1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        botaoVoltar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pet_mob/View/seta esquerda.png"))); // NOI18N
        botaoVoltar1.setText("Voltar");
        botaoVoltar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botaoVoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoExlcuir, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoVoltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(botaoVoltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoExlcuir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(editaCep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(editaCep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void campoBuscaCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBuscaCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBuscaCpfActionPerformed

    private void botaoConsultaCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConsultaCpfActionPerformed
        Consulta(user);
    }//GEN-LAST:event_botaoConsultaCpfActionPerformed

    private void botaoExlcuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExlcuirActionPerformed
        excluiUsuario(user);
        
    }//GEN-LAST:event_botaoExlcuirActionPerformed

    private void botaoVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltar1ActionPerformed
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_botaoVoltar1ActionPerformed

    private void campoCpfUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCpfUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCpfUActionPerformed

    private void editaEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editaEstadoActionPerformed
        atualizaEstado(user);        
    }//GEN-LAST:event_editaEstadoActionPerformed

    private void editaCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editaCEPActionPerformed
        atualizaCep(user);
    }//GEN-LAST:event_editaCEPActionPerformed

    private void editaCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editaCelularActionPerformed
            atualizaCelular(user);
    }//GEN-LAST:event_editaCelularActionPerformed

    private void editaTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editaTelefoneActionPerformed
        atualizarTelefone(user);
    }//GEN-LAST:event_editaTelefoneActionPerformed

    private void editaEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editaEmailActionPerformed
           atualizaEmail(user);
    }//GEN-LAST:event_editaEmailActionPerformed

    private void editaCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editaCidadeActionPerformed
        atualizaCidade(user);
    }//GEN-LAST:event_editaCidadeActionPerformed

    private void editaRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editaRuaActionPerformed
        atualizaRua(user);
    }//GEN-LAST:event_editaRuaActionPerformed

    private void editaNumCasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editaNumCasaActionPerformed
        atualizaNumeroCasa(user);
    }//GEN-LAST:event_editaNumCasaActionPerformed

    private void editaComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editaComplementoActionPerformed
        atualizaComplemento(user);
    }//GEN-LAST:event_editaComplementoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoConsultaCpf;
    private javax.swing.JButton botaoExlcuir;
    private javax.swing.JButton botaoVoltar1;
    private javax.swing.JFormattedTextField campoBuscaCpf;
    private javax.swing.JTextField campoCelularU;
    private javax.swing.JTextField campoCepU;
    private javax.swing.JTextField campoCidadeU;
    private javax.swing.JTextField campoComplementoU;
    private javax.swing.JTextField campoCpfU;
    private javax.swing.JTextField campoEmailU;
    private javax.swing.JTextField campoEstadoU;
    private javax.swing.JTextField campoIdadeU;
    private javax.swing.JTextField campoNomeU;
    private javax.swing.JTextField campoNumeroCasaU;
    private javax.swing.JTextField campoRuaU;
    private javax.swing.JTextField campoSexoU;
    private javax.swing.JTextField campoSobrenomeU;
    private javax.swing.JTextField campoTelefoneU;
    private javax.swing.JButton editaCEP;
    private javax.swing.JButton editaCelular;
    private javax.swing.JPanel editaCep;
    private javax.swing.JButton editaCidade;
    private javax.swing.JButton editaComplemento;
    private javax.swing.JButton editaEmail;
    private javax.swing.JButton editaEstado;
    private javax.swing.JButton editaNumCasa;
    private javax.swing.JButton editaRua;
    private javax.swing.JButton editaTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
