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

@javax.persistence.Entity
public class PurchaseOrderLine implements java.io.Serializable {

    static final long serialVersionUID = 1L;

    @javax.persistence.GeneratedValue( strategy = javax.persistence.GenerationType.AUTO, generator = "PURCHASEORDERLINE_ID_GENERATOR" )
    @javax.persistence.Id
    @javax.persistence.SequenceGenerator( sequenceName = "PURCHASEORDERLINE_ID_SEQ", name = "PURCHASEORDERLINE_ID_GENERATOR" )
    private Long id;

    private Integer quantity;

    private Double price;

    private String lineInfo;

    //@Version
    private Integer version;

    public PurchaseOrderLine() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice( Double price ) {
        this.price = price;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity( Integer quantity ) {
        this.quantity = quantity;
    }

    public String getLineInfo() {
        return lineInfo;
    }

    public void setLineInfo( String lineInfo ) {
        this.lineInfo = lineInfo;
    }
}