package in.kodecamp.common;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@SessionScoped
public class User implements Serializable {
  private static final long serialVersionUID = 1L;
  private String role;
  private String name;

  private static final String ALL_ROLES[] = { "users", "admin" };

  @PostConstruct
  public void init() {
    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
        .getExternalContext().getRequest();
    final List<String> roles = Arrays.asList(ALL_ROLES);
    this.role = roles.stream().filter(request::isUserInRole).findFirst().get();
  
  }
 
  public boolean isAdmin() {
    return this.role == "admin";
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getRole() {
    return this.role;
  }

}
