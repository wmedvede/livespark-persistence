/*
 * Copyright 2016 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.livespark.unidirectional.onetomany;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

@javax.persistence.Entity
public class PurchaseOrderHeader implements java.io.Serializable {

    static final long serialVersionUID = 1L;

    @javax.persistence.GeneratedValue( generator = "PURCHASEORDERHEADER_ID_GENERATOR", strategy = javax.persistence.GenerationType.AUTO )
    @javax.persistence.Id
    @javax.persistence.SequenceGenerator( sequenceName = "PURCHASEORDERHEADER_ID_SEQ", name = "PURCHASEORDERHEADER_ID_GENERATOR" )
    private java.lang.Long id;

    private java.lang.String name;

    private java.util.Date created;

    @ManyToOne(fetch = javax.persistence.FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Client client;

    //@Version
    private Integer version;

    public PurchaseOrderHeader() {
    }

    public java.lang.Long getId() {
        return this.id;
    }

    public void setId( java.lang.Long id ) {
        this.id = id;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName( java.lang.String name ) {
        this.name = name;
    }

    public java.util.Date getCreated() {
        return this.created;
    }

    public void setCreated( java.util.Date created ) {
        this.created = created;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion( Integer version ) {
        this.version = version;
    }

    public Client getClient() {
        return client;
    }

    public void setClient( Client client ) {
        this.client = client;
    }

}