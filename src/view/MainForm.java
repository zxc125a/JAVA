/*
 * MainForm.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import java.util.Iterator;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import info.Contacts;
import info.User;

/**
 *
 * @author  __USER__
 */
public class MainForm extends javax.swing.JFrame {

	/**
	 * 登录成功后，将用户信息封装成对象，保存到user中
	 */
	private User user = new User();

	/** Creates new form MainForm */
	public MainForm() {
		initComponents();
		this.setLocationRelativeTo(null);
	}

	public MainForm(User user) {
		initComponents();
		this.setLocationRelativeTo(null);
		this.user = user;
		paintTable();
	}
    
	/**
	 *渲染联系人表格
	 */
	public void paintTable(){
		DefaultTableModel tableModule = (DefaultTableModel)this.mainFormTable.getModel();
		tableModule.setRowCount(0);
		Iterator<Contacts> it = user.getContactsGrounp().iterator();
		while(it.hasNext()){
			Vector v = new Vector();
			Contacts contacts = it.next();
			v.add(contacts.getGroupName());
			v.add(contacts.getName());
			v.add(contacts.getPhone());
			v.add(contacts.getSex());
			v.add(contacts.getBirthday());
			v.add(contacts.getAddress());
			v.add(contacts.getPostcode());
			v.add(contacts.getWorkplace());
			v.add(contacts.getWorkphone());
			tableModule.addRow(v);
		}
		
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jToolBar1 = new javax.swing.JToolBar();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jButton7 = new javax.swing.JButton();
		jButton8 = new javax.swing.JButton();
		jPanel1 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTree1 = new javax.swing.JTree();
		jScrollPane1 = new javax.swing.JScrollPane();
		mainFormTable = new javax.swing.JTable();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenu2 = new javax.swing.JMenu();
		jMenu3 = new javax.swing.JMenu();
		jMenu4 = new javax.swing.JMenu();
		jMenu5 = new javax.swing.JMenu();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u4e2a\u4eba\u901a\u8baf\u5f55");
		setResizable(false);

		jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		jToolBar1.setRollover(true);

		jButton1.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jButton1.setText("\u6dfb\u52a0\u7ec4");
		jButton1.setFocusable(false);
		jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton1.setMaximumSize(new java.awt.Dimension(83, 50));
		jButton1.setMinimumSize(new java.awt.Dimension(83, 50));
		jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(jButton1);

		jButton2.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jButton2.setText("\u5220\u9664\u7ec4");
		jButton2.setFocusable(false);
		jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton2.setMaximumSize(new java.awt.Dimension(83, 50));
		jButton2.setMinimumSize(new java.awt.Dimension(83, 50));
		jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(jButton2);

		jButton3.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jButton3.setText("\u6dfb\u52a0");
		jButton3.setFocusable(false);
		jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton3.setMaximumSize(new java.awt.Dimension(81, 50));
		jButton3.setMinimumSize(new java.awt.Dimension(81, 50));
		jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(jButton3);

		jButton4.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jButton4.setText("\u5220\u9664");
		jButton4.setFocusable(false);
		jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton4.setMaximumSize(new java.awt.Dimension(81, 50));
		jButton4.setMinimumSize(new java.awt.Dimension(81, 50));
		jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(jButton4);

		jButton5.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jButton5.setText("\u4fee\u6539");
		jButton5.setFocusable(false);
		jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton5.setMaximumSize(new java.awt.Dimension(81, 50));
		jButton5.setMinimumSize(new java.awt.Dimension(81, 50));
		jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(jButton5);

		jButton6.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jButton6.setText("\u67e5\u8be2");
		jButton6.setFocusable(false);
		jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton6.setMaximumSize(new java.awt.Dimension(81, 50));
		jButton6.setMinimumSize(new java.awt.Dimension(81, 50));
		jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(jButton6);

		jButton7.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jButton7.setText("\u663e\u793a\u5168\u90e8");
		jButton7.setFocusable(false);
		jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton7.setMaximumSize(new java.awt.Dimension(85, 50));
		jButton7.setMinimumSize(new java.awt.Dimension(85, 50));
		jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(jButton7);

		jButton8.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jButton8.setText("\u9000\u51fa");
		jButton8.setFocusable(false);
		jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton8.setMaximumSize(new java.awt.Dimension(81, 50));
		jButton8.setMinimumSize(new java.awt.Dimension(81, 50));
		jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(jButton8);

		jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

		jScrollPane2.setViewportView(jTree1);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 209,
				Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 466,
				Short.MAX_VALUE));

		jScrollPane1.setAutoscrolls(true);
		jScrollPane1.setMaximumSize(new java.awt.Dimension(50, 50));

		mainFormTable
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] {
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null } }, new String[] { "用 户 组",
								" 姓 名", " 手 机", " 性 别", " 生 日", " 地 址", " 邮 编",
								"单位名称", "单位电话" }));
		mainFormTable.setMinimumSize(new java.awt.Dimension(1000, 32));
		mainFormTable.setRowHeight(20);
		jScrollPane1.setViewportView(mainFormTable);

		jMenu1.setText("\u7cfb  \u7edf");
		jMenu1.setPreferredSize(new java.awt.Dimension(51, 19));
		jMenuBar1.add(jMenu1);

		jMenu2.setText("\u8054\u7cfb\u4eba\u5206\u7ec4");
		jMenu2.setPreferredSize(new java.awt.Dimension(79, 19));
		jMenuBar1.add(jMenu2);

		jMenu3.setText("\u8054\u7cfb\u4eba\uff08C\uff09");
		jMenu3.setPreferredSize(new java.awt.Dimension(87, 19));
		jMenuBar1.add(jMenu3);

		jMenu4.setText("\u5de5\u5177\uff08T\uff09");
		jMenu4.setPreferredSize(new java.awt.Dimension(73, 19));
		jMenuBar1.add(jMenu4);

		jMenu5.setText("\u5e2e\u52a9\uff08H\uff09");
		jMenu5.setPreferredSize(new java.awt.Dimension(75, 19));
		jMenuBar1.add(jMenu5);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jPanel1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				18,
																				18,
																				18)
																		.addComponent(
																				jScrollPane1,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				683,
																				Short.MAX_VALUE))
														.addComponent(
																jToolBar1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																924,
																Short.MAX_VALUE))
										.addContainerGap()));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout
										.createSequentialGroup()
										.addComponent(
												jToolBar1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												46,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jScrollPane1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																468,
																Short.MAX_VALUE)
														.addComponent(
																jPanel1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainForm().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton8;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JMenu jMenu5;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JToolBar jToolBar1;
	private javax.swing.JTree jTree1;
	private javax.swing.JTable mainFormTable;
	// End of variables declaration//GEN-END:variables

}