package de.fhdo.collaboration.db.classes;
// Generated 30.06.2015 09:32:45 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Status generated by hbm2java
 */
@Entity
@Table(name="status"
    
)
public class Status  implements java.io.Serializable {


     private Long id;
     private Boolean isPublic;
     private Boolean isDeleted;
     private String status;
     private Set<Statusrel> statusrelsForStatusIdTo = new HashSet<Statusrel>(0);
     private Set<Statusrel> statusrelsForStatusIdFrom = new HashSet<Statusrel>(0);
     private Set<Role> roles = new HashSet<Role>(0);

    public Status() {
    }

    public Status(Boolean isPublic, Boolean isDeleted, String status, Set<Statusrel> statusrelsForStatusIdTo, Set<Statusrel> statusrelsForStatusIdFrom, Set<Role> roles) {
       this.isPublic = isPublic;
       this.isDeleted = isDeleted;
       this.status = status;
       this.statusrelsForStatusIdTo = statusrelsForStatusIdTo;
       this.statusrelsForStatusIdFrom = statusrelsForStatusIdFrom;
       this.roles = roles;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    
    @Column(name="isPublic")
    public Boolean getIsPublic() {
        return this.isPublic;
    }
    
    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    
    @Column(name="isDeleted")
    public Boolean getIsDeleted() {
        return this.isDeleted;
    }
    
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    
    @Column(name="status", length=65535)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="statusByStatusIdTo")
    public Set<Statusrel> getStatusrelsForStatusIdTo() {
        return this.statusrelsForStatusIdTo;
    }
    
    public void setStatusrelsForStatusIdTo(Set<Statusrel> statusrelsForStatusIdTo) {
        this.statusrelsForStatusIdTo = statusrelsForStatusIdTo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="statusByStatusIdFrom")
    public Set<Statusrel> getStatusrelsForStatusIdFrom() {
        return this.statusrelsForStatusIdFrom;
    }
    
    public void setStatusrelsForStatusIdFrom(Set<Statusrel> statusrelsForStatusIdFrom) {
        this.statusrelsForStatusIdFrom = statusrelsForStatusIdFrom;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="role2status", joinColumns = { 
        @JoinColumn(name="statusId", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="roleId", nullable=false, updatable=false) })
    public Set<Role> getRoles() {
        return this.roles;
    }
    
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }




}


