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
 * 制造验证码
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
		//创建一个图片缓存对象，相当于一张画布
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		//获取图片缓存对象的绘制环境，相当于画笔
		Graphics gs = image.getGraphics();
		if("".equals(validCode)) {
			validCode = "";
		}
		//设置画笔的字体
		Font font = new Font("黑体", Font.BOLD, 20);
		gs.setFont(font);
		//绘制一个矩形
		gs.fillRect(0, 0, WIDTH, HEIGHT);
		Image img = null;
		try{
			img = ImageIO.read(new File("image/paintBg.jpg"));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//用画笔绘制图片
		image.getGraphics().drawImage(img, 0, 0, WIDTH, HEIGHT, null);
		for(int i = 0; i < 4; i++) {
			char cmp = (char)(random.nextInt(26) + 65);
			validCode += cmp;
			Color color = new Color(20 + random.nextInt(20), 20 + random.nextInt(20),20 + random.nextInt(20));
			//设置画笔的颜色
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
