/*
 * MainForm.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dbTool.DbCon;
import dbTool.LoginCon;
import dbTool.UpdateDb;

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
	public void paintTable() {
		DefaultTableModel tableModule = (DefaultTableModel) this.mainFormTable
				.getModel();
		tableModule.setRowCount(0);
		try {
			user.setContactsGrounp(LoginCon.getContacts(DbCon.getCon(), user));
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showConfirmDialog(null, "联系人信息刷新失败");
		}

		Iterator<Contacts> it = user.getContactsGrounp().iterator();
		while (it.hasNext()) {
			Vector v = new Vector();
			Contacts contacts = it.next();
			v.add(contacts.getGroupName());
			v.add(contacts.getName());
			v.add(contacts.getPhone());
			v.add(contacts.getSex());
			v.add(contacts.getBirthday());
			v.add(contacts.getAddress());
			v.add(contacts.getEmail());
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
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenu2 = new javax.swing.JMenu();
		jMenu3 = new javax.swing.JMenu();
		jMenu4 = new javax.swing.JMenu();
		jMenu5 = new javax.swing.JMenu();
		jMenuBar2 = new javax.swing.JMenuBar();
		jMenu6 = new javax.swing.JMenu();
		jMenu7 = new javax.swing.JMenu();
		jMenu8 = new javax.swing.JMenu();
		jMenu9 = new javax.swing.JMenu();
		jMenu10 = new javax.swing.JMenu();
		MainTable = new javax.swing.JDesktopPane();
		jPanel1 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTree1 = new javax.swing.JTree();
		jPanel2 = new javax.swing.JPanel();
		MainFormInfoPane = new javax.swing.JScrollPane();
		mainFormTable = new javax.swing.JTable();
		jMenuBar3 = new javax.swing.JMenuBar();
		jMenu11 = new javax.swing.JMenu();
		jMenu12 = new javax.swing.JMenu();
		jMenu13 = new javax.swing.JMenu();
		jMenu14 = new javax.swing.JMenu();
		jMenu15 = new javax.swing.JMenu();

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
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		jToolBar1.add(jButton3);

		jButton4.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jButton4.setText("\u5220\u9664");
		jButton4.setFocusable(false);
		jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton4.setMaximumSize(new java.awt.Dimension(81, 50));
		jButton4.setMinimumSize(new java.awt.Dimension(81, 50));
		jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});
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

		jMenu6.setText("\u7cfb  \u7edf");
		jMenu6.setPreferredSize(new java.awt.Dimension(51, 19));
		jMenuBar2.add(jMenu6);

		jMenu7.setText("\u8054\u7cfb\u4eba\u5206\u7ec4");
		jMenu7.setPreferredSize(new java.awt.Dimension(79, 19));
		jMenuBar2.add(jMenu7);

		jMenu8.setText("\u8054\u7cfb\u4eba\uff08C\uff09");
		jMenu8.setPreferredSize(new java.awt.Dimension(87, 19));
		jMenuBar2.add(jMenu8);

		jMenu9.setText("\u5de5\u5177\uff08T\uff09");
		jMenu9.setPreferredSize(new java.awt.Dimension(73, 19));
		jMenuBar2.add(jMenu9);

		jMenu10.setText("\u5e2e\u52a9\uff08H\uff09");
		jMenu10.setPreferredSize(new java.awt.Dimension(75, 19));
		jMenuBar2.add(jMenu10);

		jScrollPane2.setViewportView(jTree1);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING,
				javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 470,
				Short.MAX_VALUE));

		jPanel1.setBounds(10, 10, 200, 470);
		MainTable.add(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		MainFormInfoPane.setAutoscrolls(true);
		MainFormInfoPane.setMaximumSize(new java.awt.Dimension(50, 50));

		mainFormTable
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] {
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null } }, new String[] { "用 户 组",
								" 姓 名", " 手 机", " 性 别", " 生 日", " 地 址", " 邮 箱",
								"单位名称", "单位电话" }));
		mainFormTable.setMinimumSize(new java.awt.Dimension(1000, 32));
		mainFormTable.setRowHeight(20);
		MainFormInfoPane.setViewportView(mainFormTable);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel2Layout.createSequentialGroup().addContainerGap()
						.addComponent(MainFormInfoPane,
								javax.swing.GroupLayout.DEFAULT_SIZE, 658,
								Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel2Layout.createSequentialGroup().addContainerGap()
						.addComponent(MainFormInfoPane,
								javax.swing.GroupLayout.DEFAULT_SIZE, 442,
								Short.MAX_VALUE).addContainerGap()));

		jPanel2.setBounds(220, 10, 670, 470);
		MainTable.add(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jMenu11.setText("\u7cfb  \u7edf");
		jMenu11.setPreferredSize(new java.awt.Dimension(51, 19));
		jMenuBar3.add(jMenu11);

		jMenu12.setText("\u8054\u7cfb\u4eba\u5206\u7ec4");
		jMenu12.setPreferredSize(new java.awt.Dimension(79, 19));
		jMenuBar3.add(jMenu12);

		jMenu13.setText("\u8054\u7cfb\u4eba\uff08C\uff09");
		jMenu13.setPreferredSize(new java.awt.Dimension(87, 19));
		jMenuBar3.add(jMenu13);

		jMenu14.setText("\u5de5\u5177\uff08T\uff09");
		jMenu14.setPreferredSize(new java.awt.Dimension(73, 19));
		jMenuBar3.add(jMenu14);

		jMenu15.setText("\u5e2e\u52a9\uff08H\uff09");
		jMenu15.setPreferredSize(new java.awt.Dimension(75, 19));
		jMenuBar3.add(jMenu15);

		setJMenuBar(jMenuBar3);

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
														.addComponent(
																jToolBar1,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																924,
																Short.MAX_VALUE)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																layout
																		.createSequentialGroup()
																		.addGap(
																				27,
																				27,
																				27)
																		.addComponent(
																				MainTable,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				897,
																				Short.MAX_VALUE)))
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
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												MainTable,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												496,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(8, 8, 8)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	/**
	 *主界面删除按钮，点击删除按钮后，表被选中的相应记录被删除
	 */
	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		int n = this.mainFormTable.getSelectedRow();
		DefaultTableModel tableModel = (DefaultTableModel) this.mainFormTable
				.getModel();
	    tableModel.removeRow(n);
	    Contacts contact = (Contacts)user.getContactsGrounp().get(n);
     	int uid = contact.getUid();
     	try{
     		UpdateDb.deleContactFromDb(uid);
     		JOptionPane.showConfirmDialog(null, "删除成功");
     	}catch (Exception e) {
			// TODO: handle exception
     		JOptionPane.showConfirmDialog(null, "删除记录失败");
     	}
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		AddContact addContact = new AddContact(this.user);
		this.MainTable.add(addContact);
		addContact.setVisible(true);
	}

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
	private javax.swing.JScrollPane MainFormInfoPane;
	private javax.swing.JDesktopPane MainTable;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton8;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu10;
	private javax.swing.JMenu jMenu11;
	private javax.swing.JMenu jMenu12;
	private javax.swing.JMenu jMenu13;
	private javax.swing.JMenu jMenu14;
	private javax.swing.JMenu jMenu15;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JMenu jMenu5;
	private javax.swing.JMenu jMenu6;
	private javax.swing.JMenu jMenu7;
	private javax.swing.JMenu jMenu8;
	private javax.swing.JMenu jMenu9;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuBar jMenuBar2;
	private javax.swing.JMenuBar jMenuBar3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JToolBar jToolBar1;
	private javax.swing.JTree jTree1;
	private javax.swing.JTable mainFormTable;
	// End of variables declaration//GEN-END:variables

}