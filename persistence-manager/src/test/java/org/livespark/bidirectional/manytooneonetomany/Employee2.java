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

@javax.persistence.Entity
@javax.persistence.Table( name = "BD_EMPLOYEE2" )
public class Employee2 implements java.io.Serializable {

    static final long serialVersionUID = 1L;

    @javax.persistence.GeneratedValue( generator = "BD_EMPLOYEE2_ID_GENERATOR", strategy = javax.persistence.GenerationType.AUTO )
    @javax.persistence.Id
    @javax.persistence.SequenceGenerator( sequenceName = "BD_EMPLOYEE2_ID_SEQ", name = "BD_EMPLOYEE2_ID_GENERATOR" )
    private Long id;

    /* owning side */
    @javax.persistence.ManyToOne( fetch = javax.persistence.FetchType.EAGER )
    private Department2 department;

    private String name;

    public Employee2() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Department2 getDepartment() {
        return this.department;
    }

    public void setDepartment( Department2 department ) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Employee2(
            Long id,
            Department2 department ) {
        this.id = id;
        this.department = department;
    }

}
