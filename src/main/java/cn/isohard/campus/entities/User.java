package cn.isohard.campus.entities;

public class User {

    private Integer userid;

    private String username;

    private String password;

    private String phone;

    private String realname;

    private String studentid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public User(Integer userid, String username, String password, String phone, String realname, String studentid) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.realname = realname;
        this.studentid = studentid;
    }
}
