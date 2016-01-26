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

package org.livespark.bidirectional.onetoone;

import javax.persistence.CascadeType;

@javax.persistence.Entity
@javax.persistence.Table(name = "BD_EMPLOYEE")
public class Employee implements java.io.Serializable
{

    static final long serialVersionUID = 1L;

    @javax.persistence.GeneratedValue(generator = "BD_EMPLOYEE_ID_GENERATOR", strategy = javax.persistence.GenerationType.AUTO)
    @javax.persistence.Id
    @javax.persistence.SequenceGenerator(sequenceName = "BD_EMPLOYEE_ID_SEQ", name = "BD_EMPLOYEE_ID_GENERATOR")
    private Long id;

    private String name;

    /* owning side */
    @javax.persistence.OneToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private org.livespark.bidirectional.onetoone.Cubicle assignedCubicle;

    public Employee()
    {
    }

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public org.livespark.bidirectional.onetoone.Cubicle getAssignedCubicle()
    {
        return this.assignedCubicle;
    }

    public void setAssignedCubicle( org.livespark.bidirectional.onetoone.Cubicle assignedCubicle)
    {
        this.assignedCubicle = assignedCubicle;
    }

    public Employee(
            Long id,
            String name,
            org.livespark.bidirectional.onetoone.Cubicle assignedCubicle)
    {
        this.id = id;
        this.name = name;
        this.assignedCubicle = assignedCubicle;
    }

}