/*
 * ContactInfo.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import info.Contacts;
import info.User;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import util.ChooseDateDialog;
import util.Tool;
import dbTool.GetDataFromDb;
import dbTool.UpdateDb;

import util.Check;

/**
 *
 * @author  __USER__
 */
public class ContactInfo extends javax.swing.JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Contacts contact;
	private User user;
	String path = "";
	String oldPath = "";
	String imgFormat = "";

	/** Creates new form ContactInfo */
	public ContactInfo() {
		initComponents();
	}

	public ContactInfo(Contacts contact, User user) {

		this.contact = contact;
		this.user = user;
		initComponents();
		this.jImgPanel.setSize(133, 140);
		Paint();
		Image img = new ImageIcon("image/R1.png").getImage();
		Icon icon = Tool.createIcon(img, 15, 15);// 读取图标
		this.setFrameIcon(icon); // 设置图标
		this.setLocation(130, 30);
	}

	/**
	 * 渲染联系人信息界面
	 */
	public void Paint() {

		this.contactInfoNameTxt.setText(contact.getName());
		this.contactInfoMailTxt.setText(contact.getEmail());
		this.contactInfoPhoneTxt.setText(contact.getPhone());
		this.contactInfoTelePhoneTxt.setText(contact.getTelephone());
		this.contactInfoBirthdayTxt.setText(contact.getBirthday());
		this.contactInfoWorkPlaceTxt.setText(contact.getWorkplace());
		this.contactInfoAddressTxt.setText(contact.getAddress());
		path = contact.getImgPath();
		System.out.println(contact.getSex());
		if ("男".equals(contact.getSex())) {
			this.contactInfoSexCb.setSelectedIndex(0);
		} else {
			this.contactInfoSexCb.setSelectedIndex(1);
		}
		this.contactInfoGroupCb.removeAllItems();
		java.util.Iterator<String> it = user.getAllGroupName().iterator();
		while (it.hasNext()) {
			String str = it.next();
			this.contactInfoGroupCb.addItem(str);
		}
		this.contactInfoGroupCb.setSelectedItem(contact.getGroupName());
		this.contactInfoRemarkTxt.setText(contact.getRemark());
		paintImg(path);


	}

	/**
	 * 渲染图片头像
	 * @param path  头像图片所在的路径
	 */
	public void paintImg(String path) {

		//根据新目录的路径，获取图片
		if (Check.isEmpty(path))
			return;
		JLabel label = new JLabel();
		ImageIcon img = new ImageIcon(path);//创建图片对象
		img.setImage(img.getImage().getScaledInstance(
				this.jImgPanel.getWidth(), this.jImgPanel.getWidth(),
				Image.SCALE_DEFAULT));
		label.setIcon(img);
		label.setSize(this.jImgPanel.getWidth(), this.jImgPanel.getHeight());
		this.jImgPanel.removeAll();
		this.jImgPanel.add(label);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jDialog1 = new javax.swing.JDialog();
		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		contactInfoNameTxt = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		contactInfoSexCb = new javax.swing.JComboBox();
		jLabel3 = new javax.swing.JLabel();
		contactInfoBirthdayTxt = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		contactInfoPhoneTxt = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		contactInfoTelePhoneTxt = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		contactInfoMailTxt = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		contactInfoGroupCb = new javax.swing.JComboBox();
		jImgPanel = new javax.swing.JPanel();
		jPanel4 = new javax.swing.JPanel();
		jLabel7 = new javax.swing.JLabel();
		contactInfoAddressTxt = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		contactInfoWorkPlaceTxt = new javax.swing.JTextField();
		jPanel5 = new javax.swing.JPanel();
		jLabel9 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		contactInfoRemarkTxt = new javax.swing.JTextArea();
		contactInfoSaveBtn = new javax.swing.JButton();
		contactInfoCancelBtn = new javax.swing.JButton();

		javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(
				jDialog1.getContentPane());
		jDialog1.getContentPane().setLayout(jDialog1Layout);
		jDialog1Layout.setHorizontalGroup(jDialog1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400,
				Short.MAX_VALUE));
		jDialog1Layout.setVerticalGroup(jDialog1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300,
				Short.MAX_VALUE));

		setClosable(true);

		jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jLabel1.setText("\u59d3    \u540d\uff1a");

		jLabel2.setText("\u6027  \u522b :");

		contactInfoSexCb.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "男", "女" }));

		jLabel3.setText("\u751f  \u65e5\uff1a");

		contactInfoBirthdayTxt.setEditable(false);
		contactInfoBirthdayTxt
				.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent evt) {
						contactInfoBirthdayTxtMouseClicked(evt);
					}
				});

		jLabel4.setText("\u624b\u673a\u53f7\u7801\uff1a");

		jLabel5.setText("\u8054\u7cfb\u7535\u8bdd\uff1a");

		jLabel6.setText("\u90ae  \u7bb1\uff1a");

		jLabel10.setText("\u8054\u7cfb\u4eba\u5206\u7ec4\uff1a");

		contactInfoGroupCb.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
										.addContainerGap()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				56,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				contactInfoNameTxt,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				132,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				18,
																				18,
																				18)
																		.addComponent(
																				jLabel2))
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel4)
																						.addComponent(
																								jLabel6))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel2Layout
																										.createSequentialGroup()
																										.addComponent(
																												contactInfoMailTxt,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												202,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED))
																						.addComponent(
																								contactInfoPhoneTxt,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								185,
																								Short.MAX_VALUE))))
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel2Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel5)
																		.addGap(
																				27,
																				27,
																				27))
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jLabel10,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								82,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								jPanel2Layout
																										.createSequentialGroup()
																										.addGap(
																												6,
																												6,
																												6)
																										.addComponent(
																												contactInfoSexCb,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																										.addComponent(
																												jLabel3)))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel2Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																		.addComponent(
																				contactInfoTelePhoneTxt)
																		.addComponent(
																				contactInfoBirthdayTxt,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				161,
																				Short.MAX_VALUE))
														.addComponent(
																contactInfoGroupCb,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																121,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel1)
														.addComponent(jLabel2)
														.addComponent(jLabel3)
														.addComponent(
																contactInfoSexCb,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																contactInfoNameTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																contactInfoBirthdayTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel4)
														.addComponent(jLabel5)
														.addComponent(
																contactInfoPhoneTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																contactInfoTelePhoneTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel6)
														.addComponent(
																contactInfoMailTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel10)
														.addComponent(
																contactInfoGroupCb,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(20, Short.MAX_VALUE)));

		jImgPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		jImgPanel.setPreferredSize(new java.awt.Dimension(135, 143));
		jImgPanel.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jImgPanelMouseClicked(evt);
			}
		});

		javax.swing.GroupLayout jImgPanelLayout = new javax.swing.GroupLayout(
				jImgPanel);
		jImgPanel.setLayout(jImgPanelLayout);
		jImgPanelLayout.setHorizontalGroup(jImgPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 126,
				Short.MAX_VALUE));
		jImgPanelLayout.setVerticalGroup(jImgPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 139,
				Short.MAX_VALUE));

		jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jLabel7.setText("\u8054\u7cfb\u5730\u5740\uff1a");

		jLabel8.setText("\u5de5\u4f5c\u5355\u4f4d\uff1a");

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
				jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout
				.setHorizontalGroup(jPanel4Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel4Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addGroup(
																jPanel4Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel7)
																		.addGap(
																				18,
																				18,
																				18)
																		.addComponent(
																				contactInfoAddressTxt,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				490,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel4Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel8)
																		.addGap(
																				18,
																				18,
																				18)
																		.addComponent(
																				contactInfoWorkPlaceTxt)))
										.addContainerGap(118, Short.MAX_VALUE)));
		jPanel4Layout
				.setVerticalGroup(jPanel4Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel4Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel7)
														.addComponent(
																contactInfoAddressTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel8)
														.addComponent(
																contactInfoWorkPlaceTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(24, Short.MAX_VALUE)));

		jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		jPanel5
				.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
					public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
						jPanel5AncestorMoved(evt);
					}

					public void ancestorResized(
							java.awt.event.HierarchyEvent evt) {
					}
				});

		jLabel9.setText("\u5907    \u6ce8 \uff1a");

		contactInfoRemarkTxt.setColumns(20);
		contactInfoRemarkTxt.setLineWrap(true);
		contactInfoRemarkTxt.setRows(5);
		jScrollPane1.setViewportView(contactInfoRemarkTxt);

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
				jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout
				.setHorizontalGroup(jPanel5Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel5Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jLabel9,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												81,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												576,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(24, Short.MAX_VALUE)));
		jPanel5Layout
				.setVerticalGroup(jPanel5Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel5Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel5Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jScrollPane1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																138,
																Short.MAX_VALUE)
														.addComponent(jLabel9))
										.addContainerGap()));

		contactInfoSaveBtn.setText("\u4fdd  \u5b58");
		contactInfoSaveBtn
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						contactInfoSaveBtnActionPerformed(evt);
					}
				});

		contactInfoCancelBtn.setText("\u8fd4  \u56de");
		contactInfoCancelBtn
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						contactInfoCancelBtnActionPerformed(evt);
					}
				});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jPanel2,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jImgPanel,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												130,
																												Short.MAX_VALUE))
																						.addComponent(
																								jPanel4,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jPanel5,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))
																		.addContainerGap())
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				contactInfoSaveBtn)
																		.addGap(
																				113,
																				113,
																				113)
																		.addComponent(
																				contactInfoCancelBtn)
																		.addGap(
																				234,
																				234,
																				234)))));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																jPanel2,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jImgPanel,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addGap(18, 18, 18)
										.addComponent(
												jPanel4,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jPanel5,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												18, Short.MAX_VALUE)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																contactInfoSaveBtn)
														.addComponent(
																contactInfoCancelBtn))
										.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addComponent(
						jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addComponent(jPanel1,
						javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(50, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	/**
	 * 个人信息头像处理
	 */
	private void jImgPanelMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		jfc.showDialog(new JLabel(), "请选择图片");
		File file = jfc.getSelectedFile();

		if (file == null)
			return;
		String[] str = file.getName().split("\\.");
		boolean flag = Check.judformat(str[1]);
		if (!flag) {
			JOptionPane.showMessageDialog(null, "图片格式错误，请重新选择!");
			return;
		}
		//将图片转移到新目录，并获取新目录的路径，保存到path中
		oldPath = file.getAbsolutePath();
		imgFormat = str[1];
		paintImg(oldPath);

	}

	/**
	 * 生日所在文本框添加点击事件获取时间
	 */
	private void contactInfoBirthdayTxtMouseClicked(
			java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		ChooseDateDialog chooseDate = new ChooseDateDialog(
				this.contactInfoBirthdayTxt);
		chooseDate.setVisible(true);
	}

	/**
	 * 修改个人信息列表中的保存按钮事件
	 */
	private void contactInfoSaveBtnActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Contacts contact = new Contacts();
		contact.setName(this.contactInfoNameTxt.getText());
		if (!Check.isName(contact.getName())) {
			JOptionPane.showConfirmDialog(null, "姓名格式有误，请重新检查！");
			return;
		}
		if (this.contactInfoSexCb.getSelectedIndex() == 0) {
			contact.setSex("男");
		} else {
			contact.setSex("女");
		}
		contact.setBirthday(this.contactInfoBirthdayTxt.getText());
		if (!Check.isBirthday(contact.getBirthday())) {
			JOptionPane.showMessageDialog(null, "生日格式有误，请重新检查！");
			return;
		}
		contact.setPhone(this.contactInfoPhoneTxt.getText());
		if (!Check.isPhone(contact.getPhone())) {
			JOptionPane.showMessageDialog(null, "手机格式有误，请重新检查");
			return;
		}
		contact.setTelephone(this.contactInfoTelePhoneTxt.getText());
		contact.setEmail(this.contactInfoMailTxt.getText());
		if (!Check.isEmail(contact.getEmail())) {
			JOptionPane.showMessageDialog(null, "邮箱格式有误，请重新检查！");
			return;
		}
		String groupName = (String) this.contactInfoGroupCb.getSelectedItem();
		contact.setGroupName(groupName);
		int gid = 1;
		try {
			gid = GetDataFromDb.getGid(contact, user);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		contact.setGid(gid);
		contact.setUid(this.contact.getUid());
		contact.setAddress(this.contactInfoAddressTxt.getText());
		contact.setWorkplace(this.contactInfoWorkPlaceTxt.getText());
		contact.setRemark(this.contactInfoRemarkTxt.getText());
		if(!Check.isEmpty(oldPath)){
			try {
				path = Tool.copyImage(oldPath, contact, imgFormat);
				Tool.deleFile(contact.getImgPath());
				contact.setImgPath(path);
				oldPath = "";
			} catch (IOException e) {
				
			}
		}
		int flag = 0;
		try {
			flag = UpdateDb.updateContactToDb(user, contact);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (flag != 0) {
			JOptionPane.showMessageDialog(null, "联系人信息更新成功");
			this.user.getMainForm().paintTable();
		} else {
			JOptionPane.showMessageDialog(null, "联系人信息更新失败");
		}
	}

	private void jPanel5AncestorMoved(java.awt.event.HierarchyEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * 返回主界面按钮事件
	 * @param evt
	 */
	private void contactInfoCancelBtnActionPerformed(
			java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		int flag = JOptionPane.showConfirmDialog(null, "是否要返回主界面？");
		if (flag == 0) {
			user.getMainForm().paintTable();
			this.dispose();
		}
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTextField contactInfoAddressTxt;
	private javax.swing.JTextField contactInfoBirthdayTxt;
	private javax.swing.JButton contactInfoCancelBtn;
	private javax.swing.JComboBox contactInfoGroupCb;
	private javax.swing.JTextField contactInfoMailTxt;
	private javax.swing.JTextField contactInfoNameTxt;
	private javax.swing.JTextField contactInfoPhoneTxt;
	private javax.swing.JTextArea contactInfoRemarkTxt;
	private javax.swing.JButton contactInfoSaveBtn;
	private javax.swing.JComboBox contactInfoSexCb;
	private javax.swing.JTextField contactInfoTelePhoneTxt;
	private javax.swing.JTextField contactInfoWorkPlaceTxt;
	private javax.swing.JDialog jDialog1;
	private javax.swing.JPanel jImgPanel;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
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
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JScrollPane jScrollPane1;
	// End of variables declaration//GEN-END:variables

}