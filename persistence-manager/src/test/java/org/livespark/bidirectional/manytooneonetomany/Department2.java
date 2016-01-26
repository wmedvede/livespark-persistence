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

package org.livespark.bidirectional.manytooneonetomany;

import java.util.List;

@javax.persistence.Entity
@javax.persistence.Table( name = "BD_DEPARTMENT2" )
public class Department2 implements java.io.Serializable {

    static final long serialVersionUID = 1L;

    @javax.persistence.GeneratedValue( generator = "BD_DEPARTMENT2_ID_GENERATOR", strategy = javax.persistence.GenerationType.AUTO )
    @javax.persistence.Id
    @javax.persistence.SequenceGenerator( sequenceName = "BD_DEPARTMENT2_ID_SEQ", name = "BD_DEPARTMENT2_ID_GENERATOR" )
    private Long id;

    String name;

    /* non-owning side */
    @javax.persistence.OneToMany( mappedBy = "department", fetch = javax.persistence.FetchType.EAGER )
    private List<org.livespark.bidirectional.manytooneonetomany.Employee2> employees;

    public Department2() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public List<org.livespark.bidirectional.manytooneonetomany.Employee2> getEmployees() {
        return this.employees;
    }

    public void setEmployees(
            List<org.livespark.bidirectional.manytooneonetomany.Employee2> employees ) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Department2(
            Long id,
            List<org.livespark.bidirectional.manytooneonetomany.Employee2> employees ) {
        this.id = id;
        this.employees = employees;
    }

}