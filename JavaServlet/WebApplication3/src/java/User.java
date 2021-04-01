public class User {
 private String firstname;
 private String surname;
 private String username;
 private String password;
 
 public User(String firstname, String surname, String username,
 String password) {
 super();
 this.firstname = firstname;
 this.surname = surname;
 this.username = username;
 this.password = password;
 }
 public String getFirstname() {
 return firstname;
 }
 public void setFirstname(String firstname) {
 this.firstname = firstname;
 }
 public String getSurname() {
 return surname;
 }
 public void setSurname(String surname) {
 this.surname = surname;
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