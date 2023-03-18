import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;



class MyWindowAdapter extends WindowAdapter 
{
	public void windowClosing(WindowEvent e) 
	{
		Window w = e.getWindow();
		w.dispose();
	}
}

class AppDesk extends JFrame implements ActionListener 
{
	public String toEncrypt="";
	public String toDecrypt="";
	public String Encrypted="";
	public String Decrypted="";
	
	public AppDesk() 
	{
		//Headng for the tool
		super("Cryptography Tool");

		MyWindowAdapter wa = new MyWindowAdapter();
		super.addWindowListener(wa);
		super.setSize(1080, 550);
		super.setVisible(true);
		super.setLayout(null);
		
		
		
		//Label for choosing the Encryption Algorithm
		Label lbl = new Label("Choose Algorithm :");
		lbl.setBounds(30,50,200,80);
		lbl.setFont(new Font("Georgia", Font.BOLD, 20));
		this.add(lbl);
		
		//Label for displaying Algorithm Description
		Label ld = new Label("Algorithm Description :");
		ld.setBounds(450,0,230,80);
		ld.setFont(new Font("Georgia", Font.BOLD, 20));
		this.add(ld);
		
		//TextArea for description
		TextArea ta = new TextArea();
		ta.setBounds(450,80,600,400);
		this.add(ta);
		
		//code to create a listing space
		Choice ch = new Choice();
		ch.setBounds(230,80,200,80);
		ch.setFont(new Font("Arial", Font.BOLD, 16));
		this.add(ch);

		//Button for Encryption Option
		Button b1 = new Button("Encrypt");
		b1.setBounds(130, 150, 120, 50);
		b1.setFont(new Font("Arial", Font.BOLD, 18));
		b1.setBackground(Color.RED);
		this.add(b1);
		b1.addActionListener(this);

		//Button for Decryption Option
		Button b2 = new Button("Decrypt");
		b2.setBounds(280, 150, 120, 50);
		b2.setFont(new Font("Arial", Font.BOLD, 18));
		b2.setBackground(Color.GREEN);
		this.add(b2);
		b2.addActionListener(this);
		
		//MenuBar for Selecting Algorithms
		MenuBar mb = new MenuBar();
		this.setMenuBar(mb);
		
		Menu m1=new Menu("Menu");
		mb.add(m1);
		
		//Items in the Operations Menu
		String arr[] = {"File","Save","Save As"};
		for(int i=0;i<arr.length;i++)
		{
			MenuItem mi = new MenuItem(arr[i]);
			m1.add(mi);
			mi.addActionListener(this);
		}
		
		//code to add algorithm names into the choices
		String[] item = {"Ceaser Cypher","Modified Ceaser Cypher"};
		for(int i=0;i<item.length;i++)
			ch.addItem(item[i]);
	}

	public void actionPerformed(ActionEvent e)
	{
		//Code to get Operation Command
		String cap = e.getActionCommand();
			
			//code to call Encryption Process
			if(cap.equals("Encrypt"))
			{
				try
				{
					FileDialog fd = new FileDialog(this,"Select Payload File",FileDialog.LOAD);
					fd.show();
					if(fd.getFile()!=null)
					{
						//code to select the Payload Image
						toEncrypt=fd.getDirectory()+fd.getFile();
						setTitle(toEncrypt);
						FileInputStream fin = new FileInputStream(toEncrypt);
						byte data[]=new byte[fin.available()];
						fin.read(data);
					
						int i = 0;
					
						//code to get the key value
						int key = Integer.parseInt(JOptionPane.showInputDialog("Enter the PassKey: "));
					
						FileDialog fd1 = new FileDialog(this,"Select Carrier File",FileDialog.LOAD);
						fd1.show();
						if(fd.getFile()!=null)
						{
							//code to select carrier Image and hide The payload in it
							Encrypted=fd1.getDirectory()+fd1.getFile();
							FileOutputStream fout = new FileOutputStream(Encrypted);
					
							fout.write(data);
					
							//closing file
							fout.close();
						}
						fin.close();
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
			
			
			//code to call Decryption Process
			if(cap.equals("Decrypt"))
			{
				//
			}
	}
}

class Crypto_Tool 
{
	public static void main(String[] args) throws IOException
	{
		//Initializing the Constructor for starting the Tool.
		AppDesk a = new AppDesk();
	}
}