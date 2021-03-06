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
package de.fhdo.terminologie.db.hibernate;
// Generated 10.10.2012 15:20:29 by Hibernate Tools 3.2.1.GA

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * CodeSystemVersionEntityMembership generated by hbm2java
 */
@XmlRootElement
@XmlType(namespace = "de.fhdo.termserver.types")
@Entity
@Table(name = "code_system_version_entity_membership"
)
public class CodeSystemVersionEntityMembership implements java.io.Serializable
{

  private CodeSystemVersionEntityMembershipId id;
  private CodeSystemVersion codeSystemVersion;
  private CodeSystemEntity codeSystemEntity;
  private Boolean isAxis;
  private Boolean isMainClass;
  private Long orderNr;

  public CodeSystemVersionEntityMembership()
  {
  }

  public CodeSystemVersionEntityMembership(CodeSystemVersionEntityMembershipId id, CodeSystemVersion codeSystemVersion, CodeSystemEntity codeSystemEntity)
  {
    this.id = id;
    this.codeSystemVersion = codeSystemVersion;
    this.codeSystemEntity = codeSystemEntity;
  }

  public CodeSystemVersionEntityMembership(CodeSystemVersionEntityMembershipId id, CodeSystemVersion codeSystemVersion, CodeSystemEntity codeSystemEntity, Boolean isAxis, Boolean isMainClass)
  {
    this.id = id;
    this.codeSystemVersion = codeSystemVersion;
    this.codeSystemEntity = codeSystemEntity;
    this.isAxis = isAxis;
    this.isMainClass = isMainClass;
  }

  public CodeSystemVersionEntityMembership(Boolean isAxis, Boolean isMainClass, Long orderNr)
  {
    this.isAxis = isAxis;
    this.isMainClass = isMainClass;
    this.orderNr = orderNr;
  }
  
  
  
  public CodeSystemVersionEntityMembership copyObject()
  {
    return new CodeSystemVersionEntityMembership(isAxis, isMainClass, orderNr);
  }

  @EmbeddedId

  @AttributeOverrides(
          {
            @AttributeOverride(name = "codeSystemVersionId", column = @Column(name = "codeSystemVersionId", nullable = false)),
            @AttributeOverride(name = "codeSystemEntityId", column = @Column(name = "codeSystemEntityId", nullable = false))
          })
  public CodeSystemVersionEntityMembershipId getId()
  {
    return this.id;
  }

  public void setId(CodeSystemVersionEntityMembershipId id)
  {
    this.id = id;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "codeSystemVersionId", nullable = false, insertable = false, updatable = false)
  public CodeSystemVersion getCodeSystemVersion()
  {
    return this.codeSystemVersion;
  }

  public void setCodeSystemVersion(CodeSystemVersion codeSystemVersion)
  {
    this.codeSystemVersion = codeSystemVersion;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "codeSystemEntityId", nullable = false, insertable = false, updatable = false)
  public CodeSystemEntity getCodeSystemEntity()
  {
    return this.codeSystemEntity;
  }

  public void setCodeSystemEntity(CodeSystemEntity codeSystemEntity)
  {
    this.codeSystemEntity = codeSystemEntity;
  }

  @Column(name = "isAxis")
  public Boolean getIsAxis()
  {
    return this.isAxis;
  }

  public void setIsAxis(Boolean isAxis)
  {
    this.isAxis = isAxis;
  }

  @Column(name = "isMainClass")
  public Boolean getIsMainClass()
  {
    return this.isMainClass;
  }

  public void setIsMainClass(Boolean isMainClass)
  {
    this.isMainClass = isMainClass;
  }

  @Column(name = "orderNr")
  public Long getOrderNr()
  {
    return orderNr;
  }

  public void setOrderNr(Long orderNr)
  {
    this.orderNr = orderNr;
  }

}
