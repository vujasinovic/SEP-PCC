package rs.ac.ftn.uns.sep.pcc.bom;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String pan;

    private Integer securityCode;

    private String holderName;

    private Date validTo;

    private String acquirerName;

    private String acquirerOrderId;

    private String acquirerTimestamp;

}
