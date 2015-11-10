package edu.br.impacta.ads.aps.model;

import java.io.Serializable;

public class User implements Serializable{

    public User() {
    }
        
    private String username;
    private String password;
    private String id_session = new String();

    public String getId_session() {
        return id_session;
    }

    public void setId_session(String id_session) {
        this.id_session = id_session;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
