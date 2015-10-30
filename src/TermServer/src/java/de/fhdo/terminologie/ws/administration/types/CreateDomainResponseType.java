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
package de.fhdo.terminologie.ws.administration.types;

import de.fhdo.terminologie.ws.types.ReturnType;
import de.fhdo.terminologie.db.hibernate.Domain;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Die Xml-Annotationen am Anfang bestimmen die Reihenfolge der
 * XML-Elemente in der Response - returnInfos sollten immer zuerst erscheinen
 *
 * @author Bernhard Rimatzki
 */
@XmlRootElement
@XmlType(name = "", propOrder = { "returnInfos", "domain"} )
public class CreateDomainResponseType 
{
    private ReturnType returnInfos;
    private Domain domain;
    
    /**
     * @return the returnInfos
     */
    public ReturnType getReturnInfos() {
        return returnInfos;
    }

    /**
     * @param returnInfos the returnInfos to set
     */
    public void setReturnInfos(ReturnType returnInfos) {
        this.returnInfos = returnInfos;
    }

    /**
     * @return the domain
     */
    public Domain getDomain() {
        return domain;
    }

    /**
     * @param domain the domain to set
     */
    public void setDomain(Domain domain) {
        this.domain = domain;
    }
    
}
