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

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class PurchaseOrder implements java.io.Serializable {

    static final long serialVersionUID = 1L;

    @GeneratedValue( strategy = javax.persistence.GenerationType.AUTO, generator = "PURCHASEORDER_ID_GENERATOR")
    @Id
    @SequenceGenerator(sequenceName = "PURCHASEORDER_ID_SEQ", name = "PURCHASEORDER_ID_GENERATOR")
    private Long id;

    private String purchaseOrderNumber;

    @OneToMany( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = javax.persistence.FetchType.EAGER , orphanRemoval = true )
    private List<PurchaseOrderLine> lines;

    @OneToOne ( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER , orphanRemoval = true )
    private PurchaseOrderHeader header;

    //@Version
    private Integer version;

    public PurchaseOrder() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber( String purchaseOrderNumber ) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public PurchaseOrderHeader getHeader() {
        return header;
    }

    public void setHeader( PurchaseOrderHeader header ) {
        this.header = header;
    }

    public List<PurchaseOrderLine> getLines() {
        return lines;
    }

    public void setLines( List<PurchaseOrderLine> lines ) {
        this.lines = lines;
    }



}
