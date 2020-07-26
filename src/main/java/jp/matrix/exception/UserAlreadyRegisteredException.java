package jp.matrix.exception;

public class UserAlreadyRegisteredException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 100L;

	public UserAlreadyRegisteredException()
	{
		new Exception("ユーザーが既に登録されています");
	}
}
