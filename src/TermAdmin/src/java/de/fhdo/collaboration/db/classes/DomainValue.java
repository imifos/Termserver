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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * DomainValue generated by hbm2java
 */
@Entity
@Table(name="domain_value"
    
)
public class DomainValue  implements java.io.Serializable {


     private Long id;
     private Domain domain;
     private DomainValue domainValue;
     private String code;
     private String displayText;
     private String description;
     private String attrib1;
     private String attrib2;
     private String attrib3;
     private Integer orderNo;
     private String imageFile;
     private Set<DomainValue> domainValues = new HashSet<DomainValue>(0);
     private Set<DomainValue> domainValuesForDomainValueIdParent = new HashSet<DomainValue>(0);
     private Set<DomainValue> domainValuesForDomainValueIdChild = new HashSet<DomainValue>(0);
     private Set<SysParam> sysParamsForValidityDomain = new HashSet<SysParam>(0);
     private Set<Domain> domainsForDisplayOrder = new HashSet<Domain>(0);
     private Set<Domain> domainsForDefaultValueId = new HashSet<Domain>(0);
     private Set<SysParam> sysParamsForModifyLevel = new HashSet<SysParam>(0);

    public DomainValue() {
    }

	
    public DomainValue(Domain domain, DomainValue domainValue, String code) {
        this.domain = domain;
        this.domainValue = domainValue;
        this.code = code;
    }
    public DomainValue(Domain domain, DomainValue domainValue, String code, String displayText, String description, String attrib1, String attrib2, String attrib3, Integer orderNo, String imageFile, Set<DomainValue> domainValues, Set<DomainValue> domainValuesForDomainValueIdParent, Set<DomainValue> domainValuesForDomainValueIdChild, Set<SysParam> sysParamsForValidityDomain, Set<Domain> domainsForDisplayOrder, Set<Domain> domainsForDefaultValueId, Set<SysParam> sysParamsForModifyLevel) {
       this.domain = domain;
       this.domainValue = domainValue;
       this.code = code;
       this.displayText = displayText;
       this.description = description;
       this.attrib1 = attrib1;
       this.attrib2 = attrib2;
       this.attrib3 = attrib3;
       this.orderNo = orderNo;
       this.imageFile = imageFile;
       this.domainValues = domainValues;
       this.domainValuesForDomainValueIdParent = domainValuesForDomainValueIdParent;
       this.domainValuesForDomainValueIdChild = domainValuesForDomainValueIdChild;
       this.sysParamsForValidityDomain = sysParamsForValidityDomain;
       this.domainsForDisplayOrder = domainsForDisplayOrder;
       this.domainsForDefaultValueId = domainsForDefaultValueId;
       this.sysParamsForModifyLevel = sysParamsForModifyLevel;
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
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="language_id", nullable=false)
    public DomainValue getDomainValue() {
        return this.domainValue;
    }
    
    public void setDomainValue(DomainValue domainValue) {
        this.domainValue = domainValue;
    }
    
    @Column(name="code", nullable=false, length=30)
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    @Column(name="display_text", length=65535)
    public String getDisplayText() {
        return this.displayText;
    }
    
    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }
    
    @Column(name="description", length=65535)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="attrib1", length=60)
    public String getAttrib1() {
        return this.attrib1;
    }
    
    public void setAttrib1(String attrib1) {
        this.attrib1 = attrib1;
    }
    
    @Column(name="attrib2", length=60)
    public String getAttrib2() {
        return this.attrib2;
    }
    
    public void setAttrib2(String attrib2) {
        this.attrib2 = attrib2;
    }
    
    @Column(name="attrib3", length=60)
    public String getAttrib3() {
        return this.attrib3;
    }
    
    public void setAttrib3(String attrib3) {
        this.attrib3 = attrib3;
    }
    
    @Column(name="order_no")
    public Integer getOrderNo() {
        return this.orderNo;
    }
    
    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
    
    @Column(name="image_file", length=65535)
    public String getImageFile() {
        return this.imageFile;
    }
    
    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="domainValue")
    public Set<DomainValue> getDomainValues() {
        return this.domainValues;
    }
    
    public void setDomainValues(Set<DomainValue> domainValues) {
        this.domainValues = domainValues;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="domainvalue2domainvalue", joinColumns = { 
        @JoinColumn(name="domain_value_id_child", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="domain_value_id_parent", nullable=false, updatable=false) })
    public Set<DomainValue> getDomainValuesForDomainValueIdParent() {
        return this.domainValuesForDomainValueIdParent;
    }
    
    public void setDomainValuesForDomainValueIdParent(Set<DomainValue> domainValuesForDomainValueIdParent) {
        this.domainValuesForDomainValueIdParent = domainValuesForDomainValueIdParent;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="domainvalue2domainvalue", joinColumns = { 
        @JoinColumn(name="domain_value_id_parent", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="domain_value_id_child", nullable=false, updatable=false) })
    public Set<DomainValue> getDomainValuesForDomainValueIdChild() {
        return this.domainValuesForDomainValueIdChild;
    }
    
    public void setDomainValuesForDomainValueIdChild(Set<DomainValue> domainValuesForDomainValueIdChild) {
        this.domainValuesForDomainValueIdChild = domainValuesForDomainValueIdChild;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="domainValueByValidityDomain")
    public Set<SysParam> getSysParamsForValidityDomain() {
        return this.sysParamsForValidityDomain;
    }
    
    public void setSysParamsForValidityDomain(Set<SysParam> sysParamsForValidityDomain) {
        this.sysParamsForValidityDomain = sysParamsForValidityDomain;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="domainValueByDisplayOrder")
    public Set<Domain> getDomainsForDisplayOrder() {
        return this.domainsForDisplayOrder;
    }
    
    public void setDomainsForDisplayOrder(Set<Domain> domainsForDisplayOrder) {
        this.domainsForDisplayOrder = domainsForDisplayOrder;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="domainValueByDefaultValueId")
    public Set<Domain> getDomainsForDefaultValueId() {
        return this.domainsForDefaultValueId;
    }
    
    public void setDomainsForDefaultValueId(Set<Domain> domainsForDefaultValueId) {
        this.domainsForDefaultValueId = domainsForDefaultValueId;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="domainValueByModifyLevel")
    public Set<SysParam> getSysParamsForModifyLevel() {
        return this.sysParamsForModifyLevel;
    }
    
    public void setSysParamsForModifyLevel(Set<SysParam> sysParamsForModifyLevel) {
        this.sysParamsForModifyLevel = sysParamsForModifyLevel;
    }




}


