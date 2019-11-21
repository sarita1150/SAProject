package project;

public class Order {
    private int orderid;
    private String cusname;
    private String proname;
    private String status;
    private int quan;

    public Order(int productid, String cusname, String proname, String status, int quan) {
        this.orderid = productid;
        this.cusname = cusname;
        this.proname = proname;
        this.status = status;
        this.quan = quan;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getCusname() {
        return cusname;
    }

    public void setCusname(String cusname) {
        this.cusname = cusname;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuan() {
        return quan;
    }

    public void setQuan(int quan) {
        this.quan = quan;
    }
}


