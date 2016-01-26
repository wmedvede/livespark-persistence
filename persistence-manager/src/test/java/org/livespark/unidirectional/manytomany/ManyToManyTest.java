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

import java.util.ArrayList;

import org.junit.Test;
import org.livespark.PersistenceBaseTest;

public class ManyToManyTest extends PersistenceBaseTest {

    @Test
    public void createSomeProjects() {

        em = createEntityManager( true );

        Project4 p = new Project4();
        p.setName( "Project1" );
        em.persist( p );

        p = new Project4();
        p.setName( "Project2" );
        em.persist( p );

        p = new Project4();
        p.setName( "Project3" );
        em.persist( p );

        em.getTransaction().commit();

    }

    //@Test
    public void createEmployeeWithNewProjects() {
        em = createEntityManager();
        em.getTransaction().begin();
        Employee4 emp = new Employee4();
        emp.setName( "Employee1" );

        emp.setAssignedProjects( new ArrayList<Project4>() );

        Project4 p = new Project4();
        p.setName( "Employee1.Project1" );

        emp.getAssignedProjects().add( p );

        p =  new Project4();
        p.setName( "Employee1.Project2" );

        emp.getAssignedProjects().add( p );

        em.merge( emp );

        em.getTransaction().commit();

    }

    //@Test
    public void createEmployeeWithExistingProjects() {
        em = createEntityManager();
        em.getTransaction().begin();
        Employee4 emp = new Employee4();
        emp.setName( "Employee1 with existing projects" );

        emp.setAssignedProjects( new ArrayList<Project4>() );

        Project4 p = new Project4();
        p.setId( (long) 2 );
        p.setName( "Project2" );

        emp.getAssignedProjects().add( p );

        p =  new Project4();
        p.setId( (long) 3 );
        p.setName( "Project3 updated" );

        emp.getAssignedProjects().add( p );

        em.merge( emp );

        em.getTransaction().commit();

    }

    //@Test
    public void updateExistingEmployee() {
        em = createEntityManager( true );

        Employee4 emp = new Employee4();
        emp.setId( ( long ) 1 );
        emp.setName( "Employee1 updated" );

        emp.setAssignedProjects( new ArrayList<Project4>() );

        Project4 p = new Project4();
        p.setId( ( long ) 1 );
        p.setName( "Project1" );

        //emp.getAssignedProjects().add( p );

        p =  new Project4();
        p.setId( (long)2 );
        p.setName( "Project2" );

        emp.getAssignedProjects().add( p );

        em.merge( emp );

        em.getTransaction().commit();

    }


}
