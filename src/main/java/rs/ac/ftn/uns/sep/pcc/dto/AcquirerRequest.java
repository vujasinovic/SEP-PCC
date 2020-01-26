package rs.ac.ftn.uns.sep.pcc.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class AcquirerRequest {
    private String pan;

    private Integer securityCode;

    private String holderName;

    private Date validTo;

    private String acquirerOrderId;

    private String acquirerTimestamp;
}
