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

package org.livespark.bidirectional.manytomany;

@javax.persistence.Entity
@javax.persistence.Table( name = "BD_EMPLOYEE3" )
public class Employee3 implements java.io.Serializable {

    static final long serialVersionUID = 1L;

    @javax.persistence.GeneratedValue( generator = "BD_EMPLOYEE3_ID_GENERATOR", strategy = javax.persistence.GenerationType.AUTO )
    @javax.persistence.Id
    @javax.persistence.SequenceGenerator( sequenceName = "BD_EMPLOYEE3_ID_SEQ", name = "BD_EMPLOYEE3_ID_GENERATOR" )
    private Long id;

    /* non-owning side */
    @javax.persistence.ManyToMany( cascade = { javax.persistence.CascadeType.ALL }, mappedBy = "employees", fetch = javax.persistence.FetchType.EAGER )
    private java.util.List<org.livespark.bidirectional.manytomany.Project3> projects;

    private String name;

    public Employee3() {
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

    public java.util.List<org.livespark.bidirectional.manytomany.Project3> getProjects() {
        return this.projects;
    }

    public void setProjects(
            java.util.List<org.livespark.bidirectional.manytomany.Project3> projects ) {
        this.projects = projects;
    }

    public Employee3(
            Long id,
            java.util.List<org.livespark.bidirectional.manytomany.Project3> projects ) {
        this.id = id;
        this.projects = projects;
    }

}