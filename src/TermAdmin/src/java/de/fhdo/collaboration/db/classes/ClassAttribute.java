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
 * ClassAttribute generated by hbm2java
 */
@Entity
@Table(name="class_attribute"
    
)
public class ClassAttribute  implements java.io.Serializable {


     private Long id;
     private Domain domain;
     private String className;
     private String attribute;

    public ClassAttribute() {
    }

    public ClassAttribute(Domain domain, String className, String attribute) {
       this.domain = domain;
       this.className = className;
       this.attribute = attribute;
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
    @JoinColumn(name="domain_id", nullable=false)
    public Domain getDomain() {
        return this.domain;
    }
    
    public void setDomain(Domain domain) {
        this.domain = domain;
    }
    
    @Column(name="class_name", nullable=false, length=100)
    public String getClassName() {
        return this.className;
    }
    
    public void setClassName(String className) {
        this.className = className;
    }
    
    @Column(name="attribute", nullable=false, length=100)
    public String getAttribute() {
        return this.attribute;
    }
    
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }




}


