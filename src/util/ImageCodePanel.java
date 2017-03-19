package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * ������֤��
 * @author john
 *
 */
public class ImageCodePanel extends JPanel{
	public final static int WIDTH = 100;
	public final static int HEIGHT = 50;
	private String validCode = "";
	
	
	public ImageCodePanel(){
		this.setBounds(265, 240, 100, 50);
		this.setVisible(true);
	}
	
	public void paint(Graphics g){
		Random random = new Random();
		//����һ��ͼƬ��������൱��һ�Ż���
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		//��ȡͼƬ�������Ļ��ƻ������൱�ڻ���
		Graphics gs = image.getGraphics();
		if("".equals(validCode)) {
			validCode = "";
		}
		//���û��ʵ�����
		Font font = new Font("����", Font.BOLD, 20);
		gs.setFont(font);
		//����һ������
		gs.fillRect(0, 0, WIDTH, HEIGHT);
		Image img = null;
		try{
			img = ImageIO.read(new File("image/paintBg.jpg"));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//�û��ʻ���ͼƬ
		image.getGraphics().drawImage(img, 0, 0, WIDTH, HEIGHT, null);
		for(int i = 0; i < 4; i++) {
			char cmp = (char)(random.nextInt(26) + 65);
			validCode += cmp;
			Color color = new Color(20 + random.nextInt(20), 20 + random.nextInt(20),20 + random.nextInt(20));
			//���û��ʵ���ɫ
			gs.setColor(color);
			Graphics2D gs2dGraphics2d = (Graphics2D)gs;
			AffineTransform trans = new AffineTransform();
			trans.rotate(random.nextInt(45)*3.14/180, 22 * i + 8, 7);
			float scaleSize = random.nextFloat() + 0.8f;
			if(scaleSize > 1f){
				scaleSize = 1f;
			}
			trans.scale(scaleSize, scaleSize);
			gs2dGraphics2d.setTransform(trans);
			gs.drawString(String.valueOf(cmp), WIDTH/6 *i + 28, HEIGHT/2);
			g.drawImage(image, 0, 0, null);
			
		}
	}

	public String getValidCode() {
		return validCode;
	}

	public void setValidCode(String getValidCode) {
		this.validCode = validCode;
	}	
	
}
