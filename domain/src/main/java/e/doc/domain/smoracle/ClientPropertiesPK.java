package e.doc.domain.smoracle;

import java.io.Serializable;

public class ClientPropertiesPK implements Serializable {
    protected Long clientId;
    protected String propId;

    public ClientPropertiesPK() {
    }

    public ClientPropertiesPK(Long clientId, String propId) {
        this.clientId = clientId;
        this.propId = propId;
    }
    // equals, hashCode
}
