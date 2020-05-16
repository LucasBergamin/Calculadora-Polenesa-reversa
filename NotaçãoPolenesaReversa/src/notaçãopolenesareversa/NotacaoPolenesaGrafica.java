package notaçãopolenesareversa;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Bergamin
 */
public class NotacaoPolenesaGrafica extends javax.swing.JFrame {
    Expressao ex = new Expressao();
    public NotacaoPolenesaGrafica() {
        initComponents();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtResultado = new javax.swing.JLabel();
        textooo = new javax.swing.JLabel();
        TxtPosFixa = new javax.swing.JLabel();
        Posfixa = new javax.swing.JLabel();
        BtnOk = new javax.swing.JButton();
        TxtExpressao = new javax.swing.JTextField();
        txtEx = new javax.swing.JLabel();
        Texto = new javax.swing.JLabel();
        Imagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtResultado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtResultado.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));

        textooo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textooo.setForeground(new java.awt.Color(255, 255, 255));
        textooo.setText("Resultado:");
        getContentPane().add(textooo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        TxtPosFixa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TxtPosFixa.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(TxtPosFixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));

        Posfixa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Posfixa.setForeground(new java.awt.Color(255, 255, 255));
        Posfixa.setText("Pósfixa:");
        getContentPane().add(Posfixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        BtnOk.setBackground(new java.awt.Color(204, 204, 204));
        BtnOk.setText("OK");
        BtnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOkActionPerformed(evt);
            }
        });
        getContentPane().add(BtnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 80, -1));
        getContentPane().add(TxtExpressao, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 250, 30));

        txtEx.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEx.setForeground(new java.awt.Color(255, 255, 255));
        txtEx.setText("Expressão: ");
        getContentPane().add(txtEx, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        Texto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Texto.setForeground(new java.awt.Color(255, 255, 255));
        Texto.setText("Notação Polenesa Reversa");
        getContentPane().add(Texto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 270, 40));

        Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/matematica.jpg"))); // NOI18N
        getContentPane().add(Imagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnOkActionPerformed
        try{
            ex.setExpressao(TxtExpressao.getText());      
            ex.converte();
            TxtPosFixa.setText(ex.MostraFila());
            ex.Resolucao();
            txtResultado.setText("");
            txtResultado.setText(ex.MostraPilha());
            ex.setSla("");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na montagem da expressão");
        
        }
    }//GEN-LAST:event_BtnOkActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NotacaoPolenesaGrafica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnOk;
    private javax.swing.JLabel Imagem;
    private javax.swing.JLabel Posfixa;
    private javax.swing.JLabel Texto;
    private javax.swing.JTextField TxtExpressao;
    private javax.swing.JLabel TxtPosFixa;
    private javax.swing.JLabel textooo;
    private javax.swing.JLabel txtEx;
    private javax.swing.JLabel txtResultado;
    // End of variables declaration//GEN-END:variables
}
