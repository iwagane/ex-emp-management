package jp.co.sample.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class InsertAdministratorForm {
	@NotBlank(message = "名前が未入力です")
	@Size(min = 1, max = 20, message = "名前は1文字以上20文字以内で入力してください")
	private String name;

	@NotBlank(message = "メールアドレスが未入力です")
	@Email(message = "Eメールの形式が不正です")
	private String mailAddress;

	@NotBlank(message = "パスワードが未入力です")
	@Size(min = 8, max = 127, message = "パスワードは英数字8文字以上で入力してください")
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
				+ "]";
	}
}
