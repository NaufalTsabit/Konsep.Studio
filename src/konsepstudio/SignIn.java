/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konsepstudio;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
//Menambahkan reminder 3 jam sebelum menyewa
/**
 *
 * @author Athma Farhan
 */
public final class SignIn extends javax.swing.JFrame {

    /**
     * Creates new form SignIn
     */
    public SignIn() {
        initComponents();
        checkEnter();
        //txtusername.requestFocus();
        
    }
    void signIn() {
        String username;
        txtusername.requestFocus();
        username = txtusername.getText();
        String input = txtpassword.getText();
        

        if (username.compareTo("admin") == 0 && input.equals("AdminKonsep123")) {
            java.awt.EventQueue.invokeLater(() -> {
                new Menu().setVisible(true);
            });
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Kombinasi Username dan Password salah");
        }
    }
    
    public void checkEnter(){
        txtpassword.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e)
      {
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
        {
          signIn();
        }
      }
    });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlkiri = new javax.swing.JPanel();
        lblkonsepkiri = new javax.swing.JLabel();
        lbldeskripsi = new javax.swing.JLabel();
        sprkonsepstudio = new javax.swing.JSeparator();
        kamera = new javax.swing.JLabel();
        flash = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pnlkanan = new javax.swing.JPanel();
        sprpassword = new javax.swing.JSeparator();
        txtpassword = new javax.swing.JPasswordField();
        lblpassword = new javax.swing.JLabel();
        sprusername = new javax.swing.JSeparator();
        txtusername = new javax.swing.JTextField();
        lblusername = new javax.swing.JLabel();
        lblkonsepstudio = new javax.swing.JLabel();
        lblsisfor = new javax.swing.JLabel();
        pnlsignin = new javax.swing.JPanel();
        lblsignin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlkiri.setBackground(new java.awt.Color(51, 102, 255));
        pnlkiri.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblkonsepkiri.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        lblkonsepkiri.setForeground(new java.awt.Color(255, 255, 255));
        lblkonsepkiri.setText("Konsep Studio");
        pnlkiri.add(lblkonsepkiri, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, -1, -1));

        lbldeskripsi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbldeskripsi.setForeground(new java.awt.Color(255, 255, 255));
        lbldeskripsi.setText("Studio Foto, Rental Kamera, Photobooth");
        pnlkiri.add(lbldeskripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, -1, -1));

        sprkonsepstudio.setForeground(new java.awt.Color(255, 255, 255));
        pnlkiri.add(sprkonsepstudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 510, 15));

        kamera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/konsepstudio/kamera.png"))); // NOI18N
        pnlkiri.add(kamera, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        flash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/konsepstudio/flash.png"))); // NOI18N
        pnlkiri.add(flash, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, -1));

        jPanel2.setBackground(new java.awt.Color(245, 255, 255));

        pnlkanan.setBackground(new java.awt.Color(245, 255, 255));

        sprpassword.setBackground(new java.awt.Color(0, 0, 0));
        sprpassword.setForeground(new java.awt.Color(0, 0, 0));

        txtpassword.setBackground(new java.awt.Color(240, 240, 240));
        txtpassword.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtpassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtpasswordMouseClicked(evt);
            }
        });
        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });
        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpasswordKeyPressed(evt);
            }
        });

        lblpassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblpassword.setText("Password");

        sprusername.setBackground(new java.awt.Color(0, 0, 0));
        sprusername.setForeground(new java.awt.Color(0, 0, 0));

        txtusername.setBackground(new java.awt.Color(240, 240, 240));
        txtusername.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtusername.setText("Masukkan Username anda");
        txtusername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtusernameMouseClicked(evt);
            }
        });
        txtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameActionPerformed(evt);
            }
        });

        lblusername.setBackground(new java.awt.Color(53, 235, 202));
        lblusername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblusername.setText("Username");

        lblkonsepstudio.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblkonsepstudio.setText("konsep.studio");

        lblsisfor.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        lblsisfor.setText("Sistem Informasi");

        pnlsignin.setBackground(new java.awt.Color(51, 102, 255));
        pnlsignin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlsigninMouseClicked(evt);
            }
        });

        lblsignin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblsignin.setForeground(new java.awt.Color(255, 255, 255));
        lblsignin.setText("Sign In");

        javax.swing.GroupLayout pnlsigninLayout = new javax.swing.GroupLayout(pnlsignin);
        pnlsignin.setLayout(pnlsigninLayout);
        pnlsigninLayout.setHorizontalGroup(
            pnlsigninLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlsigninLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblsignin)
                .addContainerGap())
        );
        pnlsigninLayout.setVerticalGroup(
            pnlsigninLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblsignin, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlkananLayout = new javax.swing.GroupLayout(pnlkanan);
        pnlkanan.setLayout(pnlkananLayout);
        pnlkananLayout.setHorizontalGroup(
            pnlkananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlkananLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlkananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlkananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblkonsepstudio)
                        .addComponent(lblsisfor)
                        .addComponent(lblpassword)
                        .addComponent(lblusername)
                        .addGroup(pnlkananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sprpassword)
                            .addComponent(sprusername)
                            .addComponent(txtusername)
                            .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pnlsignin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        pnlkananLayout.setVerticalGroup(
            pnlkananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlkananLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(lblsisfor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblkonsepstudio)
                .addGap(18, 18, 18)
                .addComponent(lblusername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(sprusername, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblpassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(sprpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlsignin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlkanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(pnlkanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlkiri, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlkiri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameActionPerformed
        requestFocus();
    }//GEN-LAST:event_txtusernameActionPerformed

    private void pnlsigninMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlsigninMouseClicked
        signIn();
    }//GEN-LAST:event_pnlsigninMouseClicked

    private void txtusernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtusernameMouseClicked
       txtusername.setText("");
       
    }//GEN-LAST:event_txtusernameMouseClicked

    private void txtpasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtpasswordMouseClicked
        txtpassword.setText("");
    }//GEN-LAST:event_txtpasswordMouseClicked

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        requestFocus();
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void txtpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordKeyPressed

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
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel flash;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel kamera;
    private javax.swing.JLabel lbldeskripsi;
    private javax.swing.JLabel lblkonsepkiri;
    private javax.swing.JLabel lblkonsepstudio;
    private javax.swing.JLabel lblpassword;
    private javax.swing.JLabel lblsignin;
    private javax.swing.JLabel lblsisfor;
    private javax.swing.JLabel lblusername;
    private javax.swing.JPanel pnlkanan;
    private javax.swing.JPanel pnlkiri;
    private javax.swing.JPanel pnlsignin;
    private javax.swing.JSeparator sprkonsepstudio;
    private javax.swing.JSeparator sprpassword;
    private javax.swing.JSeparator sprusername;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
