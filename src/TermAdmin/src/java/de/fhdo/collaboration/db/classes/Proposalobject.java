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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Proposalobject generated by hbm2java
 */
@Entity
@Table(name="proposalobject"
    
)
public class Proposalobject  implements java.io.Serializable {


     private Long id;
     private Proposal proposal;
     private Integer changeType;
     private Long classId;
     private Long classId2;
     private String classname;
     private String name;
     private Set<Discussion> discussions = new HashSet<Discussion>(0);

    public Proposalobject() {
    }

	
    public Proposalobject(Proposal proposal) {
        this.proposal = proposal;
    }
    public Proposalobject(Proposal proposal, Integer changeType, Long classId, Long classId2, String classname, String name, Set<Discussion> discussions) {
       this.proposal = proposal;
       this.changeType = changeType;
       this.classId = classId;
       this.classId2 = classId2;
       this.classname = classname;
       this.name = name;
       this.discussions = discussions;
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
    @JoinColumn(name="proposalId", nullable=false)
    public Proposal getProposal() {
        return this.proposal;
    }
    
    public void setProposal(Proposal proposal) {
        this.proposal = proposal;
    }
    
    @Column(name="changeType")
    public Integer getChangeType() {
        return this.changeType;
    }
    
    public void setChangeType(Integer changeType) {
        this.changeType = changeType;
    }
    
    @Column(name="classId")
    public Long getClassId() {
        return this.classId;
    }
    
    public void setClassId(Long classId) {
        this.classId = classId;
    }
    
    @Column(name="classId2")
    public Long getClassId2() {
        return this.classId2;
    }
    
    public void setClassId2(Long classId2) {
        this.classId2 = classId2;
    }
    
    @Column(name="classname", length=65535)
    public String getClassname() {
        return this.classname;
    }
    
    public void setClassname(String classname) {
        this.classname = classname;
    }
    
    @Column(name="name", length=65535)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="proposalobject")
    public Set<Discussion> getDiscussions() {
        return this.discussions;
    }
    
    public void setDiscussions(Set<Discussion> discussions) {
        this.discussions = discussions;
    }




}


