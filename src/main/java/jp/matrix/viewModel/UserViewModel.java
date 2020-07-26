package jp.matrix.viewModel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;


@Data
public class UserViewModel {
	/*
	 * User ID
	 */
	@NotEmpty(message = "ユーザIDは必須項目です")
	@Size(min = 4, max = 10, message = "ユーザIDは文字4桁～10桁ではありません")
	private String userId;
	/*
	 * raw password
	 */
	@NotEmpty(message = "パスワードは必須項目です")
	@Size(min = 8, max = 20, message = "パスワードは文字8桁～20桁ではありません")
	private String newPassword;
	/*
	 * raw password2
	 */
	@NotEmpty(message = "パスワードは必須項目です")
	@Size(min = 8, max = 20, message = "パスワードは文字8桁～20桁ではありません")
	private String retryPassword;

}
