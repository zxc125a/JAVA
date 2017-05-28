/*
 * Register_.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import util.Check;
import util.ImageCodePanel;

/**
 *
 * @author  __USER__
 */
public class Register_ extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageCodePanel changeImg = new ImageCodePanel();

	/** Creates new form Register_ */
	public Register_() {
		initComponents();
		this.add(changeImg);
		this.changeImg.setLocation(this.regChangePicBtn.getX() - 115,
				this.regChangePicBtn.getY() - 15);
		this.setLocationRelativeTo(null);
		Image img = new ImageIcon("image/R1.png").getImage();
		this.setIconImage(img);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		regUsernameConfirmLab = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		regUsernameTxt = new javax.swing.JTextField();
		RegPswConfirmTxt = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		regAckPswConfirmLab = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		regEmailConfirmLab = new javax.swing.JLabel();
		regEmailTxt = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		regValidCodeLab = new javax.swing.JLabel();
		regVarificationCodeTxt = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		regChangePicBtn = new javax.swing.JButton();
		regBtn = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		RegPswTxt = new javax.swing.JPasswordField();
		RegAckPswTxt = new javax.swing.JPasswordField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u7528\u6237\u6ce8\u518c");

		regUsernameConfirmLab.setText("  ");

		jLabel2.setText("\u7528 \u6237 \u540d:");

		regUsernameTxt.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				regUsernameTxtFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				regUsernameTxtFocusLost(evt);
			}
		});

		RegPswConfirmTxt.setText("  ");

		jLabel4.setText("\u5bc6    \u7801 :");

/*		regAckPswConfirmLab.setText("  ");
		regAckPswConfirmLab.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent evt) {
				regAckPswConfirmLabFocusLost(evt);
			}
		});*/

		jLabel6.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");

		regEmailConfirmLab.setText("  ");

		regEmailTxt.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				regEmailTxtFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				regEmailTxtFocusLost(evt);
			}
		});

		jLabel8.setText("\u90ae   \u7bb1 \uff1a");

		regValidCodeLab.setText("  ");

		regVarificationCodeTxt
				.addFocusListener(new java.awt.event.FocusAdapter() {
					public void focusGained(java.awt.event.FocusEvent evt) {
						regVarificationCodeTxtFocusGained(evt);
					}

					public void focusLost(java.awt.event.FocusEvent evt) {
						regVarificationCodeTxtFocusLost(evt);
					}
				});

		jLabel10.setText("\u9a8c\u8bc1\u7801 :");

		regChangePicBtn.setText("\u66f4 \u6362");
		regChangePicBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				regChangePicBtnActionPerformed(evt);
			}
		});

		regBtn.setText("\u6ce8  \u518c");
		regBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				regBtnActionPerformed(evt);
			}
		});

		jButton3.setText("\u8fd4  \u56de");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		RegPswTxt.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				RegPswTxtFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				RegPswTxtFocusLost(evt);
			}
		});

		RegAckPswTxt.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent evt) {
				RegAckPswTxtFocusLost(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout.createSequentialGroup().addGap(138, 138,
										138).addComponent(regBtn).addGap(83,
										83, 83).addComponent(jButton3)
										.addContainerGap(173, Short.MAX_VALUE))
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(68, 68, 68)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addComponent(
																jLabel2,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																62,
																Short.MAX_VALUE)
														.addComponent(
																jLabel4,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jLabel6,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																78,
																Short.MAX_VALUE)
														.addComponent(
																jLabel8,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jLabel10,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				regEmailConfirmLab,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				166,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addContainerGap())
														.addGroup(
																layout
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
																												regValidCodeLab,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												116,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addGroup(
																												layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING,
																																false)
																														.addComponent(
																																regUsernameConfirmLab,
																																javax.swing.GroupLayout.Alignment.TRAILING,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																RegPswConfirmTxt,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																193,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																regUsernameTxt,
																																javax.swing.GroupLayout.Alignment.TRAILING,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																253,
																																Short.MAX_VALUE)
																														.addComponent(
																																regEmailTxt)
																														.addComponent(
																																RegPswTxt)
																														.addComponent(
																																RegAckPswTxt)
																														.addComponent(
																																regAckPswConfirmLab,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)))
																						.addContainerGap(
																								113,
																								Short.MAX_VALUE))
																		.addGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING,
																				layout
																						.createSequentialGroup()
																						.addComponent(
																								regVarificationCodeTxt,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								106,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																								142,
																								Short.MAX_VALUE)
																						.addComponent(
																								regChangePicBtn)
																						.addGap(
																								57,
																								57,
																								57))))));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(48, 48, 48)
										.addComponent(regUsernameConfirmLab)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																regUsernameTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel2))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(RegPswConfirmTxt)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel4)
														.addComponent(
																RegPswTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(regAckPswConfirmLab)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel6)
														.addComponent(
																RegAckPswTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												regEmailConfirmLab,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												17,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																regEmailTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel8))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(regValidCodeLab)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																regChangePicBtn)
														.addComponent(jLabel10)
														.addComponent(
																regVarificationCodeTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(35, 35, 35)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(regBtn)
														.addComponent(jButton3))
										.addContainerGap(31, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	/**
	 * 返回登录界面按钮
	 */
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		int num = JOptionPane.showConfirmDialog(null, "是否要返回登录界面");
		if (num == 0) {
			this.dispose();
			Login_ login = new Login_();
			login.setVisible(true);
			return;
		}
	}

	private void RegAckPswTxtFocusLost(java.awt.event.FocusEvent evt) {
		// TODO add your handling code here:
		String pwd = new String(this.RegPswTxt.getPassword());
		String ackPwd = new String(this.RegAckPswTxt.getPassword());
		if (!Check.isEmpty(pwd) && pwd.equals(ackPwd)) {
			this.regAckPswConfirmLab.setText(" ");
		} else {
			this.regAckPswConfirmLab.setText("前后密码不一致");
		}
	}

	/**
	 * 验证码校验
	 * @param evt
	 */
	private void regVarificationCodeTxtFocusLost(java.awt.event.FocusEvent evt) {
		// TODO add your handling code here:
		String validCode = this.changeImg.getValidCode();
		String str = this.regVarificationCodeTxt.getText();
		if (validCode.equals(str)) {
			this.regValidCodeLab.setText(" ");
		} else {
			this.regValidCodeLab.setText("验证码错误");
		}
	}

	private void regVarificationCodeTxtFocusGained(java.awt.event.FocusEvent evt) {
		// TODO add your handling code here:
		String str = String.valueOf(this.regVarificationCodeTxt.getText());
		if ("".equals(str) || str == null) {
			this.regValidCodeLab.setText("请输入验证码");
			return;
		}
	}

	/**
	 * 校验密码强度
	 */
	private void RegPswTxtFocusLost(java.awt.event.FocusEvent evt) {
		// TODO add your handling code here:
		String str = String.valueOf(this.RegPswTxt.getPassword());
		if (!str.matches("^[a-zA-Z]\\w{5,17}$")) {
			this.RegPswConfirmTxt.setText("密码必须是6-16位");
		} else {
			this.RegPswConfirmTxt.setText("");
		}
	}

	private void RegPswTxtFocusGained(java.awt.event.FocusEvent evt) {
		// TODO add your handling code here:
		String str = String.valueOf(this.RegPswTxt.getPassword());
		if ("".equals(str) || str == null) {
			this.RegPswConfirmTxt.setText("请输入密码");
			return;
		}
	}

	/**
	 * 用户名信息校验
	 */
	private void regUsernameTxtFocusLost(java.awt.event.FocusEvent evt) {
		// TODO add your handling code here:
		String str = this.regUsernameTxt.getText();
		if (!str.matches("^[a-zA-z][a-zA-Z0-9_]{5,16}$")) {
			this.regUsernameConfirmLab.setText("用户名格式错误，请重新输入");
		} else {
			this.regUsernameConfirmLab.setText(" ");
		}
	}

	private void regUsernameTxtFocusGained(java.awt.event.FocusEvent evt) {
		// TODO add your handling code here:
		String str = this.regUsernameTxt.getText();
		if ("".equals(str) || str == null) {
			this.regUsernameConfirmLab.setText("请输入正确的用户名");
			return;
		}
	}

	/**
	 * 邮箱验证部分
	 */
	private void regEmailTxtFocusLost(java.awt.event.FocusEvent evt) {
		// TODO add your handling code here:
		String str = this.regEmailTxt.getText();
		if (!str
				.matches("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?")) {
			this.regEmailConfirmLab.setText("邮箱格式错误，请重新输入");
		} else {
			this.regEmailConfirmLab.setText(" ");
		}
	}

	private void regEmailTxtFocusGained(java.awt.event.FocusEvent evt) {
		// TODO add your handling code here:
		String str = this.regEmailTxt.getText();
		if ("".equals(str) || str == null) {
			this.regEmailConfirmLab.setText("请输入正确的邮箱");
			return;
		}
	}

	/**
	 * 信息提交验证
	 * @param evt
	 */
	private void regBtnActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		if (Check.isEmpty(this.regUsernameTxt.getText())) {
			JOptionPane.showConfirmDialog(null, "用户名不能为空！");
			return;
		}
		if (Check.isEmpty(new String(RegPswTxt.getPassword()))) {
			JOptionPane.showConfirmDialog(null, "用户密码不能为空");
			return;
		}
		if (!new String(this.RegPswTxt.getPassword()).equals(new String(
				this.RegAckPswTxt.getPassword()))) {
			JOptionPane.showConfirmDialog(null, "两次密码不一致,请重新输入！");
			return;
		}
		if (Check.isEmpty(this.regEmailTxt.getText())) {
			JOptionPane.showConfirmDialog(null, "邮箱不能为空");
			return;
		}
		if (Check.isEmpty(this.regVarificationCodeTxt.getText())) {
			JOptionPane.showConfirmDialog(null, "验证码不能为空");
			return;
		}
		String validCode = changeImg.getValidCode();
		if (Check.isEmpty(validCode)) {
			JOptionPane.showConfirmDialog(null, "验证码不能为空");
			return;
		}
		if (!validCode.equals(this.regVarificationCodeTxt.getText())) {
			JOptionPane.showMessageDialog(null, "验证码错误，请重新输入！");
			return;
		}

	}

	/**
	 * 重新绘制验证码
	 * @param evt
	 */
	private void regChangePicBtnActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		changeImg.repaint();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Register_().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JPasswordField RegAckPswTxt;
	private javax.swing.JLabel RegPswConfirmTxt;
	private javax.swing.JPasswordField RegPswTxt;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel regAckPswConfirmLab;
	private javax.swing.JButton regBtn;
	private javax.swing.JButton regChangePicBtn;
	private javax.swing.JLabel regEmailConfirmLab;
	private javax.swing.JTextField regEmailTxt;
	private javax.swing.JLabel regUsernameConfirmLab;
	private javax.swing.JTextField regUsernameTxt;
	private javax.swing.JLabel regValidCodeLab;
	private javax.swing.JTextField regVarificationCodeTxt;
	// End of variables declaration//GEN-END:variables

}