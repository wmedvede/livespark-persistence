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

package org.livespark.unidirectional.manytomany;

import javax.persistence.CascadeType;

@javax.persistence.Entity
@javax.persistence.Table( name = "EMPLOYEE4" )
public class Employee4 implements java.io.Serializable {

    static final long serialVersionUID = 1L;

    @javax.persistence.GeneratedValue( generator = "EMPLOYEE4_ID_GENERATOR", strategy = javax.persistence.GenerationType.AUTO )
    @javax.persistence.Id
    @javax.persistence.SequenceGenerator( sequenceName = "EMPLOYEE4_ID_SEQ", name = "EMPLOYEE4_ID_GENERATOR" )
    private Long id;

    /* owning side */
    @javax.persistence.ManyToMany( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = javax.persistence.FetchType.EAGER )
    private java.util.List<Project4> assignedProjects;

    private String name;

    public Employee4() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public java.util.List<Project4> getAssignedProjects() {
        return this.assignedProjects;
    }

    public void setAssignedProjects(
            java.util.List<Project4> assignedProjects ) {
        this.assignedProjects = assignedProjects;
    }

}