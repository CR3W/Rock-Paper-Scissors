package rockpaperscissors.GUI;

/**
 * GUI designed to display a help message to the user
 * @author Eric
 */
public class HelpGUI extends javax.swing.JFrame {

    /**
     * Creates new form HelpGUI
     */
    public HelpGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        creditVersionLabel = new javax.swing.JLabel();
        headerLabel = new javax.swing.JLabel();
        line_1 = new javax.swing.JLabel();
        line_2 = new javax.swing.JLabel();
        line_3 = new javax.swing.JLabel();
        line_4 = new javax.swing.JLabel();
        line_5 = new javax.swing.JLabel();
        line_6 = new javax.swing.JLabel();
        winHierarchyHeader = new javax.swing.JLabel();
        rockBeatsScissorsHeader = new javax.swing.JLabel();
        scissorsBeatsPaperHeader = new javax.swing.JLabel();
        paperBeatsRockHeader = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Help");
        setResizable(false);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        creditVersionLabel.setText("CR3W v 1.0.0");

        headerLabel.setText("Instructions");

        line_1.setText("Welcome to Rock Paper Scissors by the CR3W! This is program is ");

        line_2.setText("designed to play a simple game of rock paper scissors. To play");

        line_3.setText("firsts enter how long you want your match to run, then select");

        line_4.setText("the type of AI you want to play against. The Smart AI will try");

        line_5.setText("to figure out patterns in the way you play, while the Random AI");

        line_6.setText("will simply make random throws.");

        winHierarchyHeader.setText("What beats what:");

        rockBeatsScissorsHeader.setText("Rock beats Scissors");

        scissorsBeatsPaperHeader.setText("Scissors beats Paper");

        paperBeatsRockHeader.setText("Paper beats Rock");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(headerLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(winHierarchyHeader)
                                .addComponent(scissorsBeatsPaperHeader)
                                .addComponent(rockBeatsScissorsHeader)
                                .addComponent(paperBeatsRockHeader)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(12, 12, 12)
                                            .addComponent(okButton))
                                        .addComponent(creditVersionLabel))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(line_2)
                            .addComponent(line_1)
                            .addComponent(line_3)
                            .addComponent(line_4)
                            .addComponent(line_5)
                            .addComponent(line_6))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(headerLabel)
                .addGap(7, 7, 7)
                .addComponent(line_1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line_2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line_3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line_4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line_5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line_6)
                .addGap(18, 18, 18)
                .addComponent(winHierarchyHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rockBeatsScissorsHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scissorsBeatsPaperHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paperBeatsRockHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(creditVersionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(okButton)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HelpGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HelpGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HelpGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HelpGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new HelpGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel creditVersionLabel;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JLabel line_1;
    private javax.swing.JLabel line_2;
    private javax.swing.JLabel line_3;
    private javax.swing.JLabel line_4;
    private javax.swing.JLabel line_5;
    private javax.swing.JLabel line_6;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel paperBeatsRockHeader;
    private javax.swing.JLabel rockBeatsScissorsHeader;
    private javax.swing.JLabel scissorsBeatsPaperHeader;
    private javax.swing.JLabel winHierarchyHeader;
    // End of variables declaration//GEN-END:variables
}
