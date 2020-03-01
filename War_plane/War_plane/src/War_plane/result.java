package War_plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JPanel;

public class result{
	public String str[]= new String[11];
	public String str1[]= new String[11];
	public String str2[]= new String[11];

	public String str3[]= new String[11];
	public int y=100;
	public int index;
	String name,grade,degree,position;
	public Image im=Toolkit.getDefaultToolkit().getImage(result.class.getResource("bg1.png"));
	public void update(String name,String grade,String degree,String position){  
		  this.degree=degree;
		  this.grade=grade;
		  this.name=name;
		  this.position=position;
	}
	public void pocess()
	{
		try {
			//分数读写
			BufferedReader bf = new BufferedReader(new FileReader("D://360Downloads//MyEclipse 10//War_plane//src//War_plane//rank.txt"));
			for (int i = 1; i < 11; i++) {
				str[i]=bf.readLine();
			}
			
				str[0]=grade;
				
				for (int j = 1; j < 11; j++) {
					if(str[0].length() > str[j].length()){

						for (int i = 10; i >j; i--) {
							str[i]=str[i-1];
						}
						str[j] =  str[0];
						index=j;
						break;
					}
					else if(str[0].length() == str[j].length())
					{
						if(str[0].compareTo(str[j]) >0)
						{
							for (int i = 10; i >j; i--) {
								str[i]=str[i-1];
							}
							str[j] =  str[0];
							index=j;
							break;
						}
					}
				
			}
			bf.close();
		
			
			
			
			
			
			
			File file = new File("D://360Downloads//MyEclipse 10//War_plane//src//War_plane//rank.txt");
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			BufferedWriter bfw = new BufferedWriter(fw);
			for (int j = 1; j < 11; j++) {
				bfw.write(str[j]+"\r");
			}
			bfw.close();
			
			//名字读写
			BufferedReader bfn = new BufferedReader(new FileReader("D://360Downloads//MyEclipse 10//War_plane//src//War_plane//name.txt"));
			for (int i = 1; i < 11; i++) {
				str1[i]=bfn.readLine();
			}
			
			str1[0]=name;
				for (int i = 10; i>index; i--) {
					str1[i]=str1[i-1];
				}
				str1[index]=str1[0];
			bfn.close();
		
			
			
			File file1 = new File("D://360Downloads//MyEclipse 10//War_plane//src//War_plane//name.txt");
			if(!file1.exists()){
				file1.createNewFile();
			}
			FileWriter fw1 = new FileWriter(file1);
			BufferedWriter bfw1 = new BufferedWriter(fw1);
			for (int j = 1; j < 11; j++) {
				bfw1.write(str1[j]+"\r");
			}
			bfw1.close();
			
			
			//等级读写
			BufferedReader bflv = new BufferedReader(new FileReader("D://360Downloads//MyEclipse 10//War_plane//src//War_plane//lv.txt"));
			for (int i = 1; i < 11; i++) {
				str2[i]=bflv.readLine();
			}
			
			str2[0]=degree;
				
				
				for (int i = 10; i>index; i--) {
					str2[i]=str2[i-1];
				}
				str2[index]=str2[0];
			bflv.close();
		
			
			
			File file2 = new File("D://360Downloads//MyEclipse 10//War_plane//src//War_plane//lv.txt");
			if(!file2.exists()){
				file2.createNewFile();
			}
			FileWriter fw2 = new FileWriter(file2);
			BufferedWriter bfw2 = new BufferedWriter(fw2);
			for (int j = 1; j < 11; j++) {
				bfw2.write(str2[j]+"\r");
			}
			bfw2.close();
			
			
			
			BufferedReader bflv1 = new BufferedReader(new FileReader("D://360Downloads//MyEclipse 10//War_plane//src//War_plane//lv1.txt"));
			for (int i = 1; i < 11; i++) {
				str3[i]=bflv1.readLine();
			}
			
			str3[0]=position;
				for (int i = 10; i>index; i--) {
					str3[i]=str3[i-1];
				}
				str3[index]=str3[0];
			bflv1.close();
		
			
			
			File file3 = new File("D://360Downloads//MyEclipse 10//War_plane//src//War_plane//lv1.txt");
			if(!file3.exists()){
				file3.createNewFile();
			}
			FileWriter fw3 = new FileWriter(file3);
			BufferedWriter bfw3 = new BufferedWriter(fw3);
			for (int j = 1; j < 11; j++) {
				bfw3.write(str3[j]+"\r");
			}
			bfw3.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	
	public void paint(Graphics g,JPanel l) {
		g.drawImage(im, 100, 100, 300, 500,(ImageObserver)l);
		g.setColor(Color.white);
		g.setFont(new Font("宋体",Font.BOLD,12));
		g.drawString(str1[1]+"     "+str2[1]+"    "+str3[1]+"   "+str[1], 150,200);
		g.drawString(str1[2]+"     "+str2[2]+"    "+str3[2]+"   "+str[2], 150,235);
		g.drawString(str1[3]+"     "+str2[3]+"    "+str3[3]+"   "+str[3], 150,270);
		g.drawString(str1[4]+"     "+str2[4]+"    "+str3[4]+"   "+str[4], 150,305);
		g.drawString(str1[5]+"     "+str2[5]+"    "+str3[5]+"   "+str[5], 150,340);
		g.drawString(str1[6]+"     "+str2[6]+"    "+str3[6]+"   "+str[6], 150,375);
		g.drawString(str1[7]+"     "+str2[7]+"    "+str3[7]+"   "+str[7], 150,410);
		g.drawString(str1[8]+"     "+str2[8]+"    "+str3[8]+"   "+str[8], 150,445);
		g.drawString(str1[9]+"     "+str2[9]+"    "+str3[9]+"   "+str[9], 150,475);
		g.drawString(str1[10]+"     "+str2[10]+"    "+str3[10]+"   "+str[10], 150,510);
		g.setColor(Color.ORANGE);
		g.setFont(new Font("宋体",Font.BOLD,24));
	
		
		
		}
		

}
