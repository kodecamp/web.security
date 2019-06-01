package in.kodecamp.services;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

@Stateless
@DeclareRoles({"users","admin"})
public class DemoService {

  public DemoService() {
    System.out.println("DemoService : Constructor");
  }
  
  @RolesAllowed({"users","admin"})
  public String publicMethod() {
   return "I am public method"; 
  }
  
  @RolesAllowed({"admin"})
  public String securedMethod() {
    return "I am secured method";
  }
}
