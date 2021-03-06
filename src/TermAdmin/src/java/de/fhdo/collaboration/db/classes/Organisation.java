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


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Organisation generated by hbm2java
 */
@Entity
@Table(name="organisation"
    
)
public class Organisation  implements java.io.Serializable {


     private Long id;
     private String organisation;
     private String organisationAbbr;
     private String organisationLink;
     private Set<Collaborationuser> collaborationusers = new HashSet<Collaborationuser>(0);

    public Organisation() {
    }

	
    public Organisation(String organisation) {
        this.organisation = organisation;
    }
    public Organisation(String organisation, String organisationAbbr, String organisationLink, Set<Collaborationuser> collaborationusers) {
       this.organisation = organisation;
       this.organisationAbbr = organisationAbbr;
       this.organisationLink = organisationLink;
       this.collaborationusers = collaborationusers;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="organisation", nullable=false, length=65535)
    public String getOrganisation() {
        return this.organisation;
    }
    
    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }
    
    @Column(name="organisationAbbr", length=65535)
    public String getOrganisationAbbr() {
        return this.organisationAbbr;
    }
    
    public void setOrganisationAbbr(String organisationAbbr) {
        this.organisationAbbr = organisationAbbr;
    }
    
    @Column(name="organisationLink", length=65535)
    public String getOrganisationLink() {
        return this.organisationLink;
    }
    
    public void setOrganisationLink(String organisationLink) {
        this.organisationLink = organisationLink;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="organisation")
    public Set<Collaborationuser> getCollaborationusers() {
        return this.collaborationusers;
    }
    
    public void setCollaborationusers(Set<Collaborationuser> collaborationusers) {
        this.collaborationusers = collaborationusers;
    }




}


