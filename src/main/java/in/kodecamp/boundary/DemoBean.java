package in.kodecamp.boundary;

import javax.ejb.EJBAccessException;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.kodecamp.common.User;
import in.kodecamp.services.DemoService;

@Named
@RequestScoped
public class DemoBean {

  private String message;

  @Inject
  private DemoService service;

  @Inject
  private User user;

  public DemoBean() {
    System.out.println("Constructor : DemoBean");
  }

  /**
   * 
   */
  public void userAction() {
    try {
      this.message = service.publicMethod();
    } catch (EJBAccessException ejbAccessEx) {
      this.message = "This operation is not accessible for " + this.user.getName()
          + "Having role : " + this.user.getRole();
    }
  }

  /**
   * 
   */
  public void adminAction() {
    try {

      this.message = service.securedMethod();
    } catch (EJBAccessException ejbAccessEx) {
      this.message = "This operation is not accessible for " + this.user.getName()
          + "Having role : " + this.user.getRole();
    }
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String messsage) {
    this.message = messsage;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String logOut() throws ServletException {
    ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
    HttpServletResponse response = (HttpServletResponse)ectx.getResponse();
    HttpSession session = (HttpSession)ectx.getSession(false);
    session.invalidate();
    
    // These response headers tell the browser to clear the cache 
    // back button will not show the page after logout.
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0); // Proxies.
    return "login";
  }

}
