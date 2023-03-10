package e.docs.service.buildectt;

public interface CTTDocBuilder {

    void reset();

    void setMessageHeader(String orgId, String receiverId);
    void setSecurityShipper();
}
