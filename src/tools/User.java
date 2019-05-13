package tools;  
/*
 * 暂时存储找回密码员工信息
 * */
public class User {  

    // 用户名  
    private String userName;  
    // 密码  
    private String password;  
    // email  
    private String email;  
    // 是否激活  

    public String getUserName() {  
        return userName;  
    }  
    public void setUserName(String userName) {  
        this.userName = userName;  
    }  
    public String getPassword() {  
        return password;  
    }  
    public void setPassword(String password) {  
        this.password = password;  
    }  


    public String getEmail() {  
        return email;  
    }  
    public void setEmail(String email) {  
        this.email = email;  
    }  

}  
