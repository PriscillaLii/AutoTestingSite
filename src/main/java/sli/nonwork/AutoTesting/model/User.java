package sli.nonwork.AutoTesting.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    private Long id;
    private String username;
    private String password;
    private String passwordConfirm;
    private Set<Testing> testings;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @OneToMany
    @JoinTable(name = "user_testing", joinColumns = @JoinColumn(name = "user_name"), inverseJoinColumns = @JoinColumn(name = "testing_id"))
    public Set<Testing> getRoles() {
        return testings;
    }

    public void setRoles(Set<Testing> testings) {
        this.testings = testings;
    }
}
