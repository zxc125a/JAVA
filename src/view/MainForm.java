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
	 * ��¼�ɹ��󣬽��û���Ϣ��װ�ɶ��󣬱��浽user��
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
	 *��Ⱦ��ϵ�˱��
	 */
	public void paintTable() {
		DefaultTableModel tableModule = (DefaultTableModel) this.mainFormTable
				.getModel();
		tableModule.setRowCount(0);
		try {
			user.setContactsGrounp(LoginCon.getContacts(DbCon.getCon(), user));
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showConfirmDialog(null, "��ϵ����Ϣˢ��ʧ��");
		}

		Iterator<Contacts> it = user.getContactsGrounp().iterator();
		while (it.hasNext()) {
			Vector v = new Vector();
			Contacts contacts = it.next();
			v.add(contacts.getGroupName());
			v.add(contacts.getName());
			v.add(contacts.getSex());
			v.add(contacts.getPhone());
			v.add(contacts.getBirthday());
			v.add(contacts.getAddress());
			v.add(contacts.getEmail());
			v.add(contacts.getWorkplace());
			v.add(contacts.getTelephone());
			tableModule.addRow(v);
		}

	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

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
		jToolBar1 = new javax.swing.JToolBar();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jButton7 = new javax.swing.JButton();
		jButton8 = new javax.swing.JButton();
		jMenuBar3 = new javax.swing.JMenuBar();
		jMenu11 = new javax.swing.JMenu();
		jMenu12 = new javax.swing.JMenu();
		jMenu13 = new javax.swing.JMenu();
		jMenu14 = new javax.swing.JMenu();
		jMenu15 = new javax.swing.JMenu();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u4e2a\u4eba\u901a\u8baf\u5f55");
		setResizable(false);

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
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout.createSequentialGroup().addComponent(
						jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE,
						458, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		jPanel1.setBounds(10, 60, 200, 460);
		MainTable.add(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		MainFormInfoPane.setAutoscrolls(true);
		MainFormInfoPane.setMaximumSize(new java.awt.Dimension(50, 50));
		MainFormInfoPane.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				MainFormInfoPaneMousePressed(evt);
			}
		});

		mainFormTable
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] {
								{ null, null, null, null, null, null, null,
										null, null },
								{ null, null, null, null, null, null, null,
										null, null } }, new String[] { "�� �� ��",
								" �� ��", " �� ��", " �� ��", " �� ��", " �� ַ", " �� ��",
								"������λ", "��ϵ�绰" }));
		mainFormTable.setMinimumSize(new java.awt.Dimension(1000, 32));
		mainFormTable.setRowHeight(20);
		mainFormTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				mainFormTableMousePressed(evt);
			}
		});
		MainFormInfoPane.setViewportView(mainFormTable);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				jPanel2Layout.createSequentialGroup().addContainerGap()
						.addComponent(MainFormInfoPane,
								javax.swing.GroupLayout.DEFAULT_SIZE, 666,
								Short.MAX_VALUE).addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel2Layout.createSequentialGroup().addContainerGap()
						.addComponent(MainFormInfoPane,
								javax.swing.GroupLayout.DEFAULT_SIZE, 432,
								Short.MAX_VALUE).addContainerGap()));

		jPanel2.setBounds(220, 60, 690, 460);
		MainTable.add(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		jToolBar1.setRollover(true);

		jButton1.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jButton1.setText("\u6dfb\u52a0\u7ec4");
		jButton1.setFocusable(false);
		jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton1.setMaximumSize(new java.awt.Dimension(83, 50));
		jButton1.setMinimumSize(new java.awt.Dimension(83, 50));
		jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(jButton1);

		jButton2.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jButton2.setText("\u5220\u9664\u7ec4");
		jButton2.setFocusable(false);
		jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton2.setMaximumSize(new java.awt.Dimension(83, 50));
		jButton2.setMinimumSize(new java.awt.Dimension(83, 50));
		jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(jButton2);

		jButton3.setFont(new java.awt.Font("΢���ź�", 0, 18));
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

		jButton4.setFont(new java.awt.Font("΢���ź�", 0, 18));
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

		jButton5.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jButton5.setText("\u4fee\u6539");
		jButton5.setFocusable(false);
		jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton5.setMaximumSize(new java.awt.Dimension(81, 50));
		jButton5.setMinimumSize(new java.awt.Dimension(81, 50));
		jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(jButton5);

		jButton6.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jButton6.setText("\u67e5\u8be2");
		jButton6.setFocusable(false);
		jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton6.setMaximumSize(new java.awt.Dimension(81, 50));
		jButton6.setMinimumSize(new java.awt.Dimension(81, 50));
		jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(jButton6);

		jButton7.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jButton7.setText("\u663e\u793a\u5168\u90e8");
		jButton7.setFocusable(false);
		jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton7.setMaximumSize(new java.awt.Dimension(85, 50));
		jButton7.setMinimumSize(new java.awt.Dimension(85, 50));
		jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(jButton7);

		jButton8.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jButton8.setText("\u9000\u51fa");
		jButton8.setFocusable(false);
		jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton8.setMaximumSize(new java.awt.Dimension(81, 50));
		jButton8.setMinimumSize(new java.awt.Dimension(81, 50));
		jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jToolBar1.add(jButton8);

		jToolBar1.setBounds(0, 0, 910, 46);
		MainTable.add(jToolBar1, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addComponent(
						MainTable, javax.swing.GroupLayout.DEFAULT_SIZE, 912,
						Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addComponent(MainTable,
						javax.swing.GroupLayout.PREFERRED_SIZE, 540,
						javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(30, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void mainFormTableMousePressed(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		int row = this.mainFormTable.getSelectedRow();
		Contacts contact = this.user.getContactsGrounp().get(row);
		ContactInfo contactInfo = new ContactInfo(contact, user);
		this.MainTable.add(contactInfo);
		contactInfo.setVisible(true);
	}

	private void MainFormInfoPaneMousePressed(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 *������ɾ����ť�����ɾ����ť�󣬱�ѡ�е���Ӧ��¼��ɾ��
	 */
	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		int n = this.mainFormTable.getSelectedRow();
		DefaultTableModel tableModel = (DefaultTableModel) this.mainFormTable
				.getModel();
		tableModel.removeRow(n);
		Contacts contact = (Contacts) user.getContactsGrounp().get(n);
		int uid = contact.getUid();
		try {
			UpdateDb.deleContactFromDb(uid);
			JOptionPane.showConfirmDialog(null, "ɾ���ɹ�");
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showConfirmDialog(null, "ɾ����¼ʧ��");
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