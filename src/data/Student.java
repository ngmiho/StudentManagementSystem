package data;

/**
 *
 * @author TinDev
 */
public class Student {
    String maSV;
    String hoTen;
    String email;
    String SDT;
    boolean GT;
    String DiaChi;
    String hinh;

    public Student(String maSV, String hoTen, String email, String SDT, String DiaChi, boolean GT, String hinh) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.email = email;
        this.SDT = SDT;
        this.GT = GT;
        this.DiaChi = DiaChi;
        this.hinh = hinh;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public boolean isGT() {
        return GT;
    }

    public void setGT(boolean GT) {
        this.GT = GT;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    @Override
    public String toString() {
        return "Student{" + "maSV=" + maSV + ", hoTen=" + hoTen + ", email=" + email + ", SDT=" + SDT + ", GT=" + GT + ", DiaChi=" + DiaChi + ", hinh=" + hinh + '}';
    }
    
}
