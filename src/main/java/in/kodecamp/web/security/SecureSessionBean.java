/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.kodecamp.web.security;

import javax.ejb.Stateless;

/**
 *
 * @author kcamp
 */
@Stateless
public class SecureSessionBean implements SecureSessionBeanLocal {

  @Override
  public final String from() {
    return "Stateless Session Bean";
  }

}
