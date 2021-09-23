package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity // Jpa가 이건 내가 관리해야되겠다
public class Member {

    @Id
    private Long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;
    //Getter, Setter…

}
