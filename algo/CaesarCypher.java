package algo;

public class CaesarCypher
{
	public static StringBuffer encrypt(String text, int k)
	{
		int key=5;
		StringBuffer result= new StringBuffer();
        for (int i=0;i<text.length();i++)
		{
			if(Character.isUpperCase(text.charAt(i)))
			{
				char ch = (char)(((int)text.charAt(i)+key-65)%26+65);
				result.append(ch);
			}
			else
			{
				char ch = (char)(((int)text.charAt(i)+key-97)%26+97);
				result.append(ch);
			}
		}
		return result;
	}
}