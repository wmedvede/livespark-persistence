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

import java.util.ArrayList;
import javax.persistence.EntityManager;

import org.livespark.unidirectional.onetomany.Client;
import org.livespark.PersistenceBaseTest;

public class Test extends PersistenceBaseTest{

    public static void main( String[] args ) {

        Test test = new Test();

        //test.case1();

        Client client = new Client(  );
        client.setName( "client name" );
        EntityManager em = test.createEntityManager();
        em.getTransaction().begin();
        em.persist( client  );
        em.getTransaction().commit();

    }

    void case1() {

        Project3 project = new Project3(  );
        project.setName( "project1" );

        Employee3 employee = new Employee3(  );
        employee.setName( "employee1" );

        project.setEmployees( new ArrayList<Employee3>(  ) );
        project.getEmployees().add( employee );

        EntityManager em = createEntityManager();
        em.getTransaction().begin();

        em.persist( project );

        em.getTransaction().commit();
        em.close();

    }

}
