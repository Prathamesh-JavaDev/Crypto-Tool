package algo;

import javax.swing.JOptionPane;

public class ModifiedCaesarCypher
{
	public static StringBuffer encrypt(String text)
	{
		
		//code to get the key value
		int key = Integer.parseInt(JOptionPane.showInputDialog("Enter the Key: "));
		
		StringBuffer result= new StringBuffer();
        for (int i=0;i<text.length();i++)
		{
			char ch = ' ';
			if(Character.isUpperCase(text.charAt(i)))
			{
				/*if condition to skip spaces between alphabest*/
				if(text.charAt(i)==' '){
					result.append(ch);
				}
				else{
				ch = (char)(((int)text.charAt(i)+key-65)%26+65);
				result.append(ch);
				}
			}
			else
			{
				/*if condition to skip spaces between alphabest*/
				if(text.charAt(i)==' '){
					result.append(ch);
				}
				else{
				ch = (char)(((int)text.charAt(i)+key-97)%26+97);
				result.append(ch);
				}
			}
		}
		return result;
	}
	
	public static StringBuffer decrypt(String text)
	{
		//code to get the key value
		int key = Integer.parseInt(JOptionPane.showInputDialog("Enter the Key: "));
		
		StringBuffer result= new StringBuffer();
        for (int i=0;i<text.length();i++)
		{
			char ch = ' ';
			if(Character.isUpperCase(text.charAt(i)))
			{
				/*if condition to skip spaces between alphabest*/
				if(text.charAt(i)==' '){
					result.append(ch);
				}
				else{
				ch = (char)(((int)text.charAt(i)+key-65)%26+65);
				result.append(ch);
				}
			}
			else
			{
				/*if condition to skip spaces between alphabest*/
				if(text.charAt(i)==' '){
					result.append(ch);
				}
				else{
				ch = (char)(((int)text.charAt(i)+key-97)%26+97);
				result.append(ch);
				}
			}
		}
		return result;
	}
}