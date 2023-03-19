package algo;

public class CaesarCypher
{
	public static StringBuffer encrypt(String text, int k)
	{
		StringBuffer result= new StringBuffer();
        for (int i=0;i<text.length();i++)
		{
			if(Character.isUpperCase(text.charAt(i)))
			{
				char ch = (char)(((int)text.charAt(i)+k-65)%26+65);
				result.append(ch);
			}
			else
			{
				char ch = (char)(((int)text.charAt(i)+k-97)%26+97);
				result.append(ch);
			}
		}
		return result;
	}
}
