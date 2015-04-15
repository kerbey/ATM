
public class authentication
{
	private static String Password= "2323";
	public static boolean Authentication(String userPassword)
	{
		return (userPassword.equals(Password));	
	}
}