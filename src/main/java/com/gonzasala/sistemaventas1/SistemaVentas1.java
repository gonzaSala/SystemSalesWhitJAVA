
package com.gonzasala.sistemaventas1;

import interfaz.LoginIG;

/**
 *
 * @author Gonzalo
 */
public class SistemaVentas1 {

    public static void main(String[] args) {
        LoginIG login = new LoginIG();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }
}
