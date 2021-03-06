/* 
 * CTS2 based Terminology Server and Terminology Browser
 * Copyright (C) 2014 FH Dortmund: Peter Haas, Robert Muetzner
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.fhdo.collaboration.db.classes;
// Generated 15.05.2013 18:02:38 by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SysParam generated by hbm2java
 */
@Entity
@Table(name="sys_param"
    
)
public class SysParam  implements java.io.Serializable {


     private Long id;
     private DomainValue domainValueByValidityDomain;
     private DomainValue domainValueByModifyLevel;
     private String name;
     private Long objectId;
     private String javaDatatype;
     private String value;
     private String description;

    public SysParam() {
    }

	
    public SysParam(String name) {
        this.name = name;
    }
    public SysParam(DomainValue domainValueByValidityDomain, DomainValue domainValueByModifyLevel, String name, Long objectId, String javaDatatype, String value, String description) {
       this.domainValueByValidityDomain = domainValueByValidityDomain;
       this.domainValueByModifyLevel = domainValueByModifyLevel;
       this.name = name;
       this.objectId = objectId;
       this.javaDatatype = javaDatatype;
       this.value = value;
       this.description = description;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="validity_domain")
    public DomainValue getDomainValueByValidityDomain() {
        return this.domainValueByValidityDomain;
    }
    
    public void setDomainValueByValidityDomain(DomainValue domainValueByValidityDomain) {
        this.domainValueByValidityDomain = domainValueByValidityDomain;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="modify_level")
    public DomainValue getDomainValueByModifyLevel() {
        return this.domainValueByModifyLevel;
    }
    
    public void setDomainValueByModifyLevel(DomainValue domainValueByModifyLevel) {
        this.domainValueByModifyLevel = domainValueByModifyLevel;
    }
    
    @Column(name="name", nullable=false, length=65535)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="object_id")
    public Long getObjectId() {
        return this.objectId;
    }
    
    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }
    
    @Column(name="java_datatype", length=65535)
    public String getJavaDatatype() {
        return this.javaDatatype;
    }
    
    public void setJavaDatatype(String javaDatatype) {
        this.javaDatatype = javaDatatype;
    }
    
    @Column(name="value", length=65535)
    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    @Column(name="description", length=65535)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }




}


