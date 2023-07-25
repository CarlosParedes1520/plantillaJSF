/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.tws2.tcs.contfiables.model;

import java.io.Serializable;

/**
 *
 * @author juanc
 */
public class PersonDemo implements Serializable{
    
    String name;
    String age;
    String email;

    public PersonDemo() {
    }
    

    public PersonDemo(String name, String age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
