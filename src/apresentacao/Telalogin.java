
package apresentacao;

//import static filtros.EscaladeCinza.imageToGray;
//import filtros.Histograma;
import filtros.PDI;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import modelo.Validacao;

/**
 *
 * @author dudy
 */
public class Telalogin extends javax.swing.JDialog
{

    /**
     * Creates new form Telalogin
     */
    public Telalogin(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        btnlogin = new javax.swing.JToggleButton();
        btncadastro = new javax.swing.JToggleButton();
        jDigital = new javax.swing.JLabel();
        txtCaminho = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnlogin.setText("login");
        btnlogin.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnloginActionPerformed(evt);
            }
        });

        btncadastro.setText("cadastro");
        btncadastro.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btncadastroActionPerformed(evt);
            }
        });

        jDigital.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apresentacao/digital.png"))); // NOI18N

        txtCaminho.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtCaminhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtCaminho))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btncadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addComponent(jDigital, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jDigital, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnloginActionPerformed
    {//GEN-HEADEREND:event_btnloginActionPerformed
        JFileChooser fc = new JFileChooser();
        int res = fc.showOpenDialog(null);
        BufferedImage Digitalteste = null;
        BufferedImage Digital = null;
                 
        if (res == JFileChooser.APPROVE_OPTION)
        {
            File arquivo = fc.getSelectedFile();
            try
            {
                Digitalteste = ImageIO.read(arquivo.getAbsoluteFile());
                String caminho = arquivo.getPath();
                txtCaminho.setText(caminho);
                int w = Digitalteste.getWidth();  
                int h = Digitalteste.getHeight();  
                int rgba[] = new int[w * h];  
                //obtem pixels do bufferedImage  
                // escreve nova imagem no disco  
                 filtros.PDI equalisa = new PDI();
                 Digitalteste = (PDI.escalaDeCinza(Digitalteste));
                 Digitalteste = PDI.negativo(PDI.threshold(Digitalteste, 170));
            }
            
            catch (IOException ex)
            {
                System.out.println("Deu Ruim "+ ex);
            }
            
            try
            {
                String registro = "src/digital_cadastrada/registro.jpg";
                Digital = ImageIO.read(new File(registro));
                modelo.Validacao valida = new Validacao();
                valida.Validaracesso(Digitalteste,Digital);
                JOptionPane.showMessageDialog(null, valida.Mensagem);
                String cor = valida.cor;
                ImageIcon icon = new ImageIcon(cor);
                jDigital.setIcon(icon);
            }
            catch (HeadlessException | IOException e)
            {
                System.out.println("Agora Lasco "+ e);
            }
        }
    else
        {
            JOptionPane.showMessageDialog(null, "Erro ao capturar Digital");
        }

    }//GEN-LAST:event_btnloginActionPerformed

    private void btncadastroActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btncadastroActionPerformed
    {//GEN-HEADEREND:event_btncadastroActionPerformed
        JFileChooser fc = new JFileChooser();
        int res = fc.showOpenDialog(null);
                 
        if (res == JFileChooser.APPROVE_OPTION)
        {
            File arquivo = fc.getSelectedFile();
                        
            try
            {
                BufferedImage Digital = ImageIO.read(arquivo.getAbsoluteFile());
                
                int w = Digital.getWidth();  
                int h = Digital.getHeight();  
                int rgba[] = new int[w * h];  
                //obtem pixels do bufferedImage  
 
                    // escreve nova imagem no disco  
                    filtros.PDI equalisa = new PDI();
                    Digital = (PDI.escalaDeCinza(Digital));
                    Digital = PDI.negativo(PDI.threshold(Digital, 170));
                    ImageIO.write (Digital, "JPG", new File("src/"
                            + "digital_cadastrada/registro.jpg"));
            }
            
            catch (IOException ex)
            {
                System.out.println("Deu Ruim "+ ex);
            }
        }
    else
        {
            JOptionPane.showMessageDialog(null, "Erro ao capturar Digital");
        }
        
    }//GEN-LAST:event_btncadastroActionPerformed

    private void txtCaminhoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtCaminhoActionPerformed
    {//GEN-HEADEREND:event_txtCaminhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCaminhoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Telalogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Telalogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Telalogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Telalogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                Telalogin dialog = new Telalogin(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter()
                {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e)
                    {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btncadastro;
    private javax.swing.JToggleButton btnlogin;
    private javax.swing.JLabel jDigital;
    private javax.swing.JTextField txtCaminho;
    // End of variables declaration//GEN-END:variables


}
