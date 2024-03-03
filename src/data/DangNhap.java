package data;

//asm1

public enum DangNhap {
    User1("hoangnmps26822", "123456", "Nguyễn Minh Hoàng");
    
    private String username;
    private String password;
    private String fullname;

    private DangNhap() {
    }

    private DangNhap(String username, String password, String fullname) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
    public static String login(String username, String password) {
        for (DangNhap tk : DangNhap.values()) {
            if (tk.getUsername().equals(username) && tk.getPassword().equals(password))
                return tk.getFullname();
        }
        return null;
    }
}
