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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Client implements java.io.Serializable {

    static final long serialVersionUID = 1L;

    @GeneratedValue( generator = "CLIENT_ID_GENERATOR", strategy = javax.persistence.GenerationType.AUTO )
    @Id
    @SequenceGenerator( sequenceName = "CLIENT_ID_SEQ", name = "CLIENT_ID_GENERATOR" )
    private Long id;

    private String name;

    private String surname;

    private String clientNumber;

    //@Version
    private Integer version;

    public Client() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname( String surname ) {
        this.surname = surname;
    }

    public String getClientNumber() {
        return this.clientNumber;
    }

    public void setClientNumber( String clientNumber ) {
        this.clientNumber = clientNumber;
    }

    public Integer getVersion() {
        return version;
    }
    public void setVersion( Integer version ) {
        this.version = version;
    }
}