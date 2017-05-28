/*
 * MainForm.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import util.CVSUtile;
import util.PinyinComparator;

import dbTool.DbCon;
import dbTool.GetDataFromDb;
import dbTool.LoginCon;
import dbTool.UpdateDb;

import info.Contacts;
import info.PageController;
import info.User;

/**
 *
 * @author  __USER__
 */
public class MainForm extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ��¼�ɹ��󣬽��û���Ϣ��װ�ɶ��󣬱��浽user��
	 */
	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private PageController pageController;
	private int counter = 0; //����б�ͷ������Ĵ���

	/** Creates new form MainForm */
	public MainForm() {
		initComponents();
	}

	public void paintP() {
		this.setLocationRelativeTo(null);
		this.pageController = new PageController(user);
		paintTable();
		paintJTree();
		addTableHeaderEvent();
		Image img = new ImageIcon("image/R1.png").getImage();
		this.setIconImage(img);
	}

	public MainForm(User user) {
		initComponents();
		this.setLocationRelativeTo(null);
		this.user = user;
		this.pageController = new PageController(user);
		paintTable();
		paintJTree();
		addTableHeaderEvent();
		Image img = new ImageIcon("image/R1.png").getImage();
		this.setIconImage(img);
	}

	/**
	 *��¼�ɹ�����Ⱦ��ϵ�˱��
	 */
	public void paintTable() {
		DefaultTableModel tableModule = (DefaultTableModel) this.mainFormTable
				.getModel();
		tableModule.setRowCount(0);
		try {
			//����������ϵ���б�
			user.setContactsGrounp(LoginCon.getContacts(DbCon.getCon(), user));
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "��ϵ����Ϣˢ��ʧ��");
		}
		try {
			//������ϵ�˷����б�
			user.setAllGroupName(GetDataFromDb.getGroupName(this.user));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<Contacts> it = this.pageController.initList().iterator();
		while (it.hasNext()) {
			Vector<String> v = new Vector<String>();
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
		tableModule.setRowCount(19);
	}

	/**
	 * ��Ⱦ��ѯ�����Ϣ�������	
	 */
	public void paintQueryTable() {
		try {
			user.setAllGroupName(GetDataFromDb.getGroupName(this.user));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DefaultTableModel tableModule = (DefaultTableModel) this.mainFormTable
				.getModel();
		tableModule.setRowCount(0);
		Iterator<Contacts> it = this.pageController.initList().iterator();
		while (it.hasNext()) {
			Vector<String> v = new Vector<String>();
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
		tableModule.setRowCount(19);
	}

	/**
	 * ��ȾJTtee��Ϣ
	 */
	public void paintJTree() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("������ϵ�˷���");
		try {
			user.setAllGroupName(GetDataFromDb.getGroupName(this.user));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<String> it = user.getAllGroupName().iterator();
		while (it.hasNext()) {
			String groupname = (String) it.next();
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(groupname);
			root.add(node);
		}
		DefaultTreeModel model = new DefaultTreeModel(root);
		this.MainFormjTree.setModel(model);
	}

	/**
	 * �������Ϣ�еı�ͷ�󶨵���¼�����ȡĳһ�б�ͷ��ֵ
	 */
	public void addTableHeaderEvent() {

		this.mainFormTable.getTableHeader().addMouseListener(
				new MouseAdapter() {
					//��ȡ��ͷָ�����
					public void mouseClicked(MouseEvent evt) {
						if (evt.getSource() instanceof JTableHeader) {
							int column = mainFormTable.columnAtPoint(evt
									.getPoint());
							//��ȡ�еı�ͷ
							mainFormTable.setColumnSelectionAllowed(true);
							mainFormTable.setRowSelectionAllowed(false);
							mainFormTable.setColumnSelectionInterval(column,
									column);
							/*String columnName = mainFormTable
									.getColumnName(column);*/
							sortContacts(column);
						}
					}
				});

		/**
		 * �����ӵ���¼�
		 */
		this.mainFormTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mainFormTable.setRowSelectionAllowed(true); //�����Ƿ����ѡ���ģ���е���
				mainFormTable.setColumnSelectionAllowed(false);
			}
		});
	}

	/**
	 * ���ݱ�ͷ�ֶΣ��Ա��е���Ϣ��������
	 */
	public void sortContacts(int column) {
		this.counter++;
		this.counter %= 2;
		PinyinComparator pinyinComparator = new PinyinComparator(counter);
		if (0 == column) {
			pinyinComparator.setSign(0);
			Collections.sort(this.user.getContactsGrounp(), pinyinComparator);
			this.paintQueryTable();
			return;
		}
		if (1 == column) {
			pinyinComparator.setSign(1);
			Collections.sort(this.user.getContactsGrounp(), pinyinComparator);
			this.paintQueryTable();
			return;
		}
		if (2 == column) {
			pinyinComparator.setSign(2);
			Collections.sort(this.user.getContactsGrounp(), pinyinComparator);
			this.paintQueryTable();
			return;
		}
		if (3 == column) {
			pinyinComparator.setSign(3);
			Collections.sort(this.user.getContactsGrounp(), pinyinComparator);
			this.paintQueryTable();
			return;
		}
		if (4 == column) {
			pinyinComparator.setSign(4);
			Collections.sort(this.user.getContactsGrounp(), pinyinComparator);
			this.paintQueryTable();
			return;
		}
		if (5 == column) {
			pinyinComparator.setSign(5);
			Collections.sort(this.user.getContactsGrounp(), pinyinComparator);
			this.paintQueryTable();
			return;
		}
		if (6 == column) {
			pinyinComparator.setSign(6);
			Collections.sort(this.user.getContactsGrounp(), pinyinComparator);
			this.paintQueryTable();
			return;
		}
		if (7 == column) {
			pinyinComparator.setSign(7);
			Collections.sort(this.user.getContactsGrounp(), pinyinComparator);
			this.paintQueryTable();
			return;
		}

	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		MainTable = new javax.swing.JDesktopPane();
		jPanel1 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		MainFormjTree = new javax.swing.JTree();
		jPanel2 = new javax.swing.JPanel();
		MainFormInfoPane = new javax.swing.JScrollPane();
		mainFormTable = new javax.swing.JTable();
		mainFormTableFirstBtn = new javax.swing.JButton();
		mainFormTablePreBtn = new javax.swing.JButton();
		mainFormTableNextBtn = new javax.swing.JButton();
		mainFormTableLastBtn = new javax.swing.JButton();
		jToolBar1 = new javax.swing.JToolBar();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jButton7 = new javax.swing.JButton();
		jButton9 = new javax.swing.JButton();
		jButton10 = new javax.swing.JButton();
		jButton8 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u4e2a\u4eba\u901a\u8baf\u5f55");
		setResizable(false);

		MainFormjTree.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				MainFormjTreeMouseClicked(evt);
			}
		});
		jScrollPane2.setViewportView(MainFormjTree);

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
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				mainFormTableMouseClicked(evt);
			}
		});
		mainFormTable.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				mainFormTableKeyPressed(evt);
			}
		});
		MainFormInfoPane.setViewportView(mainFormTable);

		mainFormTableFirstBtn.setText("\u7b2c \u4e00 \u9875");
		mainFormTableFirstBtn
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						mainFormTableFirstBtnActionPerformed(evt);
					}
				});

		mainFormTablePreBtn.setText("\u4e0a \u4e00 \u9875");
		mainFormTablePreBtn
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						mainFormTablePreBtnActionPerformed(evt);
					}
				});

		mainFormTableNextBtn.setText("\u4e0b \u4e00 \u9875");
		mainFormTableNextBtn
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						mainFormTableNextBtnActionPerformed(evt);
					}
				});

		mainFormTableLastBtn.setText("\u6700\u540e\u4e00\u9875 ");
		mainFormTableLastBtn
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						mainFormTableLastBtnActionPerformed(evt);
					}
				});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				MainFormInfoPane,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				666,
																				Short.MAX_VALUE))
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addGap(
																				126,
																				126,
																				126)
																		.addComponent(
																				mainFormTableFirstBtn)
																		.addGap(
																				37,
																				37,
																				37)
																		.addComponent(
																				mainFormTablePreBtn)
																		.addGap(
																				46,
																				46,
																				46)
																		.addComponent(
																				mainFormTableNextBtn)
																		.addGap(
																				39,
																				39,
																				39)
																		.addComponent(
																				mainFormTableLastBtn)))
										.addContainerGap()));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												MainFormInfoPane,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												403,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																mainFormTablePreBtn)
														.addComponent(
																mainFormTableNextBtn)
														.addComponent(
																mainFormTableFirstBtn)
														.addComponent(
																mainFormTableLastBtn))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		jPanel2.setBounds(220, 60, 690, 470);
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
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jToolBar1.add(jButton1);

		jButton2.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jButton2.setText("\u5220\u9664\u7ec4");
		jButton2.setFocusable(false);
		jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton2.setMaximumSize(new java.awt.Dimension(83, 50));
		jButton2.setMinimumSize(new java.awt.Dimension(83, 50));
		jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
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
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});
		jToolBar1.add(jButton5);

		jButton6.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jButton6.setText("\u67e5\u8be2");
		jButton6.setFocusable(false);
		jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton6.setMaximumSize(new java.awt.Dimension(81, 40));
		jButton6.setMinimumSize(new java.awt.Dimension(81, 40));
		jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});
		jToolBar1.add(jButton6);

		jButton7.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jButton7.setText("\u663e\u793a\u5168\u90e8");
		jButton7.setFocusable(false);
		jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton7.setMaximumSize(new java.awt.Dimension(85, 50));
		jButton7.setMinimumSize(new java.awt.Dimension(85, 50));
		jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});
		jToolBar1.add(jButton7);

		jButton9.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jButton9.setText("\u5bfc\u51fa");
		jButton9.setFocusable(false);
		jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton9.setMaximumSize(new java.awt.Dimension(81, 40));
		jButton9.setMinimumSize(new java.awt.Dimension(81, 40));
		jButton9.setPreferredSize(new java.awt.Dimension(43, 25));
		jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jButton9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton9ActionPerformed(evt);
			}
		});
		jToolBar1.add(jButton9);

		jButton10.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jButton10.setText("\u5bfc\u5165");
		jButton10.setFocusable(false);
		jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton10.setMaximumSize(new java.awt.Dimension(81, 40));
		jButton10.setMinimumSize(new java.awt.Dimension(81, 40));
		jButton10.setPreferredSize(new java.awt.Dimension(43, 25));
		jButton10.setRequestFocusEnabled(false);
		jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jButton10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton10ActionPerformed(evt);
			}
		});
		jToolBar1.add(jButton10);

		jButton8.setFont(new java.awt.Font("΢���ź�", 0, 18));
		jButton8.setText("\u9000\u51fa");
		jButton8.setFocusable(false);
		jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton8.setMaximumSize(new java.awt.Dimension(81, 40));
		jButton8.setMinimumSize(new java.awt.Dimension(81, 40));
		jButton8.setOpaque(false);
		jButton8.setPreferredSize(new java.awt.Dimension(40, 31));
		jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		jButton8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton8ActionPerformed(evt);
			}
		});
		jToolBar1.add(jButton8);

		jToolBar1.setBounds(0, 0, 910, 46);
		MainTable.add(jToolBar1, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
						.addContainerGap(51, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		this.dispose();
	}

	/**
	 * ������csv��ʽ����
	 */
	private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		jfc.showDialog(new JLabel(), "��ѡ��Ҫ������ļ�");
		File file = jfc.getSelectedFile();
		if (file == null) {
			return;
		}
		/*	        if(file.isDirectory()){  
		 System.out.println("�ļ���:"+file.getAbsolutePath());  
		 }else if(file.isFile()){  
		 System.out.println("�ļ�:"+file.getAbsolutePath());  
		 }  */
		System.out.println(jfc.getSelectedFile().getName());
		if (!file.getAbsolutePath().endsWith(".csv")) {
			JOptionPane.showMessageDialog(null, "�ļ���ʽ����������ѡ��");
			return;
		}
		try {
			CVSUtile.importCSV(file.getAbsolutePath(), this.user);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.paintTable();
	}

	/**
	 * ɾ����ϵ����
	 */
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		TreePath treePath = this.MainFormjTree.getSelectionPath();
		if (treePath == null) {
			JOptionPane.showMessageDialog(null, "����ѡ��Ҫɾ���ķ���!");
			return;
		}
		TreeNode treeNode = (TreeNode) treePath.getLastPathComponent();
		Vector<Contacts> contacts = null;
		try {
			contacts = GetDataFromDb.getContactsOfGroup(treeNode.toString());
			this.user.setContactsGrounp(contacts);
			if (contacts.size() > 0) {
				JOptionPane.showMessageDialog(null, "�뽫��ǰ������ϵ�������");
				this.paintTable();
			} else {
				int flag = UpdateDb.deteGroup(this.user, treeNode.toString());
				if (flag > 0) {
					this.paintJTree();
					JOptionPane.showMessageDialog(null, "ɾ������ɹ�");
				} else {
					JOptionPane.showMessageDialog(null, "ɾ������ʧ��");

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��������csv��ʽ����
	 * @param evt
	 */
	private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jfc.showDialog(new JLabel(), "��ѡ��Ҫ������Ŀ¼");
		File file = jfc.getSelectedFile();
		if (file == null)
			return;
		/*        if(file.isDirectory()){  
		 System.out.println("�ļ���:"+file.getAbsolutePath());  
		 }else if(file.isFile()){  
		 System.out.println("�ļ�:"+file.getAbsolutePath());  
		 }  */
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName = sdf.format(date);
		try {
			CVSUtile.exportCVS(fileName, file.getAbsolutePath(), this.user
					.getContactsGrounp());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ���һҳ��ť
	 */
	private void mainFormTableLastBtnActionPerformed(
			java.awt.event.ActionEvent evt) {
		this.pageController.setLastPage();
		paintTable();
	}

	/**
	 * ��һҳ��ť
	 */
	private void mainFormTableNextBtnActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		this.pageController.setNextPage();
		paintTable();
	}

	/**
	 * ��һҳ��ť
	 */
	private void mainFormTablePreBtnActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		this.pageController.setFirstPrevious();
		paintTable();
	}

	/**
	 * ��һҳ��ť
	 */
	private void mainFormTableFirstBtnActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		this.pageController.setFirstPrevious();
		paintTable();
	}

	private void mainFormTableMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:

	}

	/**
	 * �����ϵ���飬��ʾ���÷����������ϵ��
	 * @param evt
	 */
	private void MainFormjTreeMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		/**
		 * 1.��ȡ�������·��
		 * 2.�ӱ������·���и�������ѡ����Ӧ�ڵ�
		 */
		if (evt.getClickCount() == 2) {
			TreePath treePath = this.MainFormjTree.getSelectionPath();
			TreeNode treeNode = (TreeNode) treePath.getLastPathComponent();
			Vector<Contacts> contacts = null;
			try {
				contacts = GetDataFromDb
						.getContactsOfGroup(treeNode.toString());
				this.user.setContactsGrounp(contacts);
				if (contacts.size() > 0) {
					this.paintQueryTable();
				} else {
					JOptionPane.showMessageDialog(null, "��ǰ����û�з�����ϵ��");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * ��ʾ�����ϵ����
	 * @param evt
	 */
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		AddGroup addGroup = new AddGroup(this.user);
		this.MainTable.add(addGroup);
		addGroup.setVisible(true);
	}

	/**
	 * ��ʾȫ����ϵ����Ϣ
	 * @param evt
	 */
	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		this.user.getMainForm().paintTable();
	}

	/**
	 * ��ʾ��ѯ��Ϣ��
	 * @param evt
	 */
	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		QueryInfo mainFormqueryInfoFrm = new QueryInfo(user);
		this.MainTable.add(mainFormqueryInfoFrm);
		mainFormqueryInfoFrm.setVisible(true);
	}

	/**
	 * ɾ����ϵ�˰�ť
	 * @param evt
	 */
	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:

		int row = this.mainFormTable.getSelectedRow();
		if (row > -1 && row < this.user.getContactsGrounp().size()) {
			Contacts contact = this.user.getContactsGrounp().get(row);
			ContactInfo contactInfo = new ContactInfo(contact, user);
			this.MainTable.add(contactInfo);
			contactInfo.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "����ѡ��Ҫɾ������ϵ��");
		}

	}

	/**
	 * ����ϵ����Ϣ����У����»س����󣬵�����ϵ����Ϣ����
	 * @param evt
	 */
	private void mainFormTableKeyPressed(java.awt.event.KeyEvent evt) {
		// TODO add your handling code here:

		if (evt.getKeyCode() == 10) {
			int row = this.mainFormTable.getSelectedRow();
			if (row < this.user.getContactsGrounp().size()) {
				Contacts contact = this.user.getContactsGrounp().get(row);
				ContactInfo contactInfo = new ContactInfo(contact, user);
				this.MainTable.add(contactInfo);
				contactInfo.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "����ѡ��Ҫ�޸ĵ���ϵ��");
			}
		}
	}

	/**
	 *������ɾ����ť�����ɾ����ť�󣬱�ѡ�е���Ӧ��¼��ɾ��
	 */
	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		int n = this.mainFormTable.getSelectedRow();
		if (n > -1 && n < user.getContactsGrounp().size()) {
			DefaultTableModel tableModel = (DefaultTableModel) this.mainFormTable
					.getModel();
			tableModel.removeRow(n);
			Contacts contact = (Contacts) user.getContactsGrounp().get(n);
			int uid = contact.getUid();
			try {
				UpdateDb.deleContactFromDb(uid);
				JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "ɾ����¼ʧ��");
			}
		} else {
			JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ������ϵ��");
		}
	}

	/**
	 * �����������ϵ�˰�ť������󣬻���ʾ�������ϵ�����
	 * @param evt
	 */
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
				//new MainForm().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JScrollPane MainFormInfoPane;
	private javax.swing.JTree MainFormjTree;
	private javax.swing.JDesktopPane MainTable;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton10;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton8;
	private javax.swing.JButton jButton9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JToolBar jToolBar1;
	private javax.swing.JTable mainFormTable;
	private javax.swing.JButton mainFormTableFirstBtn;
	private javax.swing.JButton mainFormTableLastBtn;
	private javax.swing.JButton mainFormTableNextBtn;
	private javax.swing.JButton mainFormTablePreBtn;
	// End of variables declaration//GEN-END:variables

}