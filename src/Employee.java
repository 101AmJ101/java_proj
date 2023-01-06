import java.util.Date;

public class Employee {
  private int id;
  private String fname;
  private String lname;
  private int age;
  private Date registered;
  private String post;

  public Employee() {
    // empty constructor
  }

  public Employee(int id, String fname, String lname, int age, Date registered, String post) {
    this.id = id;
    this.fname = fname;
    this.lname = lname;
    this.age = age;
    this.registered = registered;
    this.post = post;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFname() {
    return fname;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }

  public String getLname() {
    return lname;
  }

  public void setLname(String lname) {
    this.lname = lname;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Date getRegistered() {
    return registered;
  }

  public void setRegistered(Date registered) {
    this.registered = registered;
  }

  public String getPost() {
    return post;
  }

  public void setPost(String post) {
    this.post = post;
  }
  
}