package com.spocle.domain.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.AuthorityUtils;

import com.spocle.domain.model.entity.User;

public class LoginUser extends org.springframework.security.core.userdetails.User {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  /**
   * ログインユーザー
   */
  private final User user;

  @Getter
  @Setter
  private int teamId;

  /*
   * コンストラクタ
   * 
   * @param user
   */
  public LoginUser(User user) {
    // スーパークラスのユーザーID、パスワードに値をセットする
    // 実際の認証はスーパークラスのユーザーID、パスワードで行われる
    super(user.getMailAddress(), user.getPassword(),
        AuthorityUtils.createAuthorityList("ROLE_USER"));
    this.user = user;
  }

  /**
   *
   * @return
   */
  public User getUser() {
    return user;
  }
}
