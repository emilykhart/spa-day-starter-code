package org.launchcode.spaday.models;

import javax.validation.constraints.*;

public class User {
    @NotBlank
    @Size(min = 5, max = 15)
    private String username;
    @Email
    private String email;
    @NotBlank
    @Size(min = 6)
    private String password;

    @NotNull(message = "Passwords do not match.")
    @NotBlank
    private String verify;

    public User() {

    }

    public User(String username, String email, String password, String verify) {
            this();
            this.username = username;
            this.email = email;
            this.password = password;
            this.verify = verify;
        }

        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
            checkPassword(password, this.verify);
        }

        public String getVerify() {
            return verify;
        }

        public void setVerify(String verify) {
            this.verify = verify;
            checkPassword(this.password, verify);
        }

        private void checkPassword(String password, String verify){
            if(password != null && verify != null && !password.equals(verify)){
                this.verify = null;
            }
        }
    }

