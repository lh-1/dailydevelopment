package info.mjy.boottest.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseModel implements Serializable {

    private static final long serialVersionUID = -5679526454523539595L;

    protected Long id;
}
