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

@javax.persistence.Entity
@javax.persistence.Table(name = "BD_CUBICLE")
public class Cubicle implements java.io.Serializable
{

    static final long serialVersionUID = 1L;

    @javax.persistence.GeneratedValue(generator = "BD_CUBICLE_ID_GENERATOR", strategy = javax.persistence.GenerationType.AUTO)
    @javax.persistence.Id
    @javax.persistence.SequenceGenerator(sequenceName = "BD_CUBICLE_ID_SEQ", name = "BD_CUBICLE_ID_GENERATOR")
    private Long id;

    private String name;

    /* non-owning side */
    @javax.persistence.OneToOne( mappedBy = "assignedCubicle" )
    private Employee residentEmployee;

    public Cubicle()
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

    public Employee getResidentEmployee()
    {
        return this.residentEmployee;
    }

    public void setResidentEmployee( Employee residentEmployee)
    {
        this.residentEmployee = residentEmployee;
    }

    public Cubicle(
            Long id,
            String name,
            Employee residentEmployee)
    {
        this.id = id;
        this.name = name;
        this.residentEmployee = residentEmployee;
    }

}