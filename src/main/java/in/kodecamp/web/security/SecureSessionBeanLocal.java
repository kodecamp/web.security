/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.kodecamp.web.security;

import javax.ejb.Local;

/**
 *
 * @author kcamp
 */
@Local
public interface SecureSessionBeanLocal {

  /**
   * sample method.
   *
   * @return message
   */
  String from();
}
