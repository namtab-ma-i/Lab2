
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;


public class Proga extends javax.swing.JFrame {
	
    private javax.swing.JButton jButtonADD;
    private javax.swing.JButton jButtonSAVE;
    private javax.swing.JLabel jLabelGroup;
    private javax.swing.JLabel jLabelProduct;
    private javax.swing.JPanel jPanelGroups;
    private javax.swing.JPanel jPanelProduct;
    private javax.swing.JScrollPane jScrollPane2;
    protected static  javax.swing.JTree jTreeOfGroups; 
    protected static ArrayList<String> database = new ArrayList<String>();
    private javax.swing.JTextField jTextFieldGroup;

    public Proga() {
    	super("База продуктів");
        initComponents();
    }

    @SuppressWarnings("unchecked")                     
    private void initComponents() {

        jPanelGroups = new javax.swing.JPanel();
        jButtonADD = new javax.swing.JButton();
        jButtonSAVE = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTreeOfGroups = new javax.swing.JTree();
        jPanelProduct = new javax.swing.JPanel();
        jLabelGroup = new javax.swing.JLabel();
        jLabelProduct = new javax.swing.JLabel();
        jTextFieldGroup = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        

        jPanelGroups.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Групи товарів", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); 
        jPanelGroups.setName("Групи Товарів"); 

        jButtonADD.setText("Додати групу");
        
        jButtonADD.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				AddGroup g = new AddGroup();
				g.setVisible(true);
			}
        	
        });

        jButtonSAVE.setText("Зберегти");
        //
        jTreeOfGroups.setModel(new FileSystemModel(new File("D:\\GroupsOfGoods")));
        jScrollPane2.setViewportView(jTreeOfGroups);
        jTreeOfGroups.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        jTreeOfGroups.addTreeSelectionListener(new TreeSelectionListener() {
        	@Override
			public void valueChanged(TreeSelectionEvent e) {
        		File fileSelected = (File) jTreeOfGroups.getLastSelectedPathComponent();
        		
        		if (fileSelected.isDirectory()){
        			jLabelGroup.setText("Група товарів");
        			jLabelProduct.setText("Назва групи: " + fileSelected.getName());
        		}else{
        		
        		jLabelGroup.setText("Група товарів: " + fileSelected.getParent().replace("D:\\GroupsOfGoods\\", ""));
        		jLabelProduct.setText("Назва товару: " + fileSelected.getName());
        		}
        		// SOME OLD CODE
        		/*JTree tree = (JTree) e.getSource(); // Getting the tree on click
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent(); // get selected node
			if(node==null) return; // if node wasn't selected, return void
			//File selectedFile = (File) node.getUserObject(); // get file from node
			String selectedNodeName = node.toString(); // get selected node name
			    if (node.isLeaf()) { // if node is a leaf(not a directory), print its name
			      System.out.println(selectedNodeName);
			      //JOptionPane.showMessageDialog(Proga.this,"Filepath", selectedFile.getName(), JOptionPane.INFORMATION_MESSAGE);
			}*/
		}});
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanelGroups);
        jPanelGroups.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonADD, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
            .addComponent(jButtonSAVE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonADD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSAVE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelProduct.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Товар", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabelGroup.setText("Група товарів:");

        jLabelProduct.setText("Назва товару:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanelProduct);
        jPanelProduct.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(284, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelGroup)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProduct)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelGroups, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelGroups, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }                       

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Proga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proga().setVisible(true);
            }
        });
    }                    
              
}