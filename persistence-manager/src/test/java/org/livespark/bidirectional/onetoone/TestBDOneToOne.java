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

import javax.persistence.EntityManager;

import org.livespark.PersistenceBaseTest;
import org.livespark.persistence.PersistenceManager;

public class TestBDOneToOne extends PersistenceBaseTest {

    PersistenceManager persistenceManager = new PersistenceManager( "LivesparkPersistenceUnit" );

    public static void main( String[] args ) {

        TestBDOneToOne test = new TestBDOneToOne();
        //test.createEmployee();

        //test.createEmployee1();

        //test.updateEmployee2();

        //test.updateEmployee4();

        //test.createCubicle();

        //test.readCubicle( 1 );

        test.test8();

        /*
        Cubicle cubicle = new Cubicle( (long) 1, "kaka", null );
        Employee e1 = new Employee( (long)1, "aaa", cubicle );

        test.updateEmployee( e1 );

*/

        System.exit( 0 );

    }

    void createEmployee() {
        org.livespark.bidirectional.onetoone.Employee employee = new org.livespark.bidirectional.onetoone.Employee(  );
        employee.setName( "Employee2" );
        //employee.setId( (long) 1 );

        org.livespark.bidirectional.onetoone.Cubicle cubicle = new org.livespark.bidirectional.onetoone.Cubicle(  );
        cubicle.setName( "Cubicle1" );
        //cubicle.setId( (long) 1 );

        //persistenceManager.persist( cubicle );

        employee.setAssignedCubicle( cubicle );

        persistenceManager.persist( employee );

        //persistenceManager.merge( employee );
        /*
        EntityManager em = createEntityManager( true );
        em.persist( employee );
        em.getTransaction().commit();
        */
    }

    void createEmployee1() {
        org.livespark.bidirectional.onetoone.Employee employee = new org.livespark.bidirectional.onetoone.Employee(  );
        employee.setName( "Employee1" );
        //employee.setId( (long) 1 );

        EntityManager em = createEntityManager();
        em.getTransaction().begin();

        org.livespark.bidirectional.onetoone.Cubicle cubicle = new org.livespark.bidirectional.onetoone.Cubicle(  );
        cubicle.setName( "Cubicle1" );
        //em.persist( cubicle );

        employee.setAssignedCubicle( cubicle );

        em.persist( employee );
        em.getTransaction().commit();

        int i = 0;

    }

    void updateEmployee1() {
        org.livespark.bidirectional.onetoone.Employee emp = new org.livespark.bidirectional.onetoone.Employee(  );
        emp.setId( ( long ) 1 );
        emp.setName( "employee 1 modifided" );

        updateEmployee( emp );

    }

    void updateCubicle1() {

        EntityManager em = createEntityManager();

        org.livespark.bidirectional.onetoone.Cubicle cubicle = em.find( org.livespark.bidirectional.onetoone.Cubicle.class, (long) 1 );
        em.getTransaction().begin();

        cubicle.setResidentEmployee( null );

        em.getTransaction().commit();

        org.livespark.bidirectional.onetoone.Employee employee = em.find( org.livespark.bidirectional.onetoone.Employee.class, (long) 1 );

    }


    void updateEmployee2() {
        org.livespark.bidirectional.onetoone.Employee emp = new org.livespark.bidirectional.onetoone.Employee(  );
        emp.setId( ( long ) 1 );
        emp.setName( "employee 1 modifided" );

        org.livespark.bidirectional.onetoone.Cubicle cubicle = new org.livespark.bidirectional.onetoone.Cubicle(  );
        cubicle.setId( (long)1 );
        cubicle.setName( "cubicle 1 modified" );

        emp.setAssignedCubicle( cubicle );


        updateEmployee( emp );


    }

    void updateEmployee3() {
        EntityManager em = createEntityManager();
        org.livespark.bidirectional.onetoone.Employee emp = em.find( org.livespark.bidirectional.onetoone.Employee.class, (long)1 );

        emp.setAssignedCubicle( null );

        em.getTransaction().begin();
        em.merge( emp );
        em.getTransaction().commit();

        org.livespark.bidirectional.onetoone.Cubicle cubicle = em.find( org.livespark.bidirectional.onetoone.Cubicle.class, (long)1 );
        int i = 0;

    }



    void updateEmployee4() {
        org.livespark.bidirectional.onetoone.Employee emp = new org.livespark.bidirectional.onetoone.Employee(  );
        emp.setId( ( long ) 1 );
        emp.setName( "employee 1 modifided" );

        org.livespark.bidirectional.onetoone.Cubicle cubicle = new org.livespark.bidirectional.onetoone.Cubicle(  );
        cubicle.setId( ( long ) 2 );
        cubicle.setName( "cubicle 2 modified" );

        emp.setAssignedCubicle( cubicle );


        updateEmployee( emp );


    }
    void updateEmployee( org.livespark.bidirectional.onetoone.Employee employee ) {
        EntityManager em = createEntityManager( true );
        org.livespark.bidirectional.onetoone.Employee attachedEmployee = em.merge( employee );
        em.getTransaction().commit();
    }

    void test8() {
        org.livespark.bidirectional.onetoone.Employee employee = new org.livespark.bidirectional.onetoone.Employee(  );
        employee.setName( "Employee1" );
        //employee.setId( (long) 1 );

        org.livespark.bidirectional.onetoone.Cubicle cubicle = new org.livespark.bidirectional.onetoone.Cubicle();
        cubicle.setName( "Cubicle 11" );


        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        em.persist( cubicle );
        em.getTransaction().commit();

        em.close();

        em = createEntityManager();

        cubicle = new org.livespark.bidirectional.onetoone.Cubicle(  );
        cubicle.setId( (long)1 );
        cubicle.setName( "HOHO" );
        employee.setAssignedCubicle( cubicle );

        em.getTransaction().begin();
        em.persist( employee );
        em.getTransaction().commit();

        em.close();

    }

    void createCubicle() {
        org.livespark.bidirectional.onetoone.Cubicle cubicle = new org.livespark.bidirectional.onetoone.Cubicle(  );
        cubicle.setName( "Cubicle1" );

        EntityManager em = createEntityManager( true );
        em.persist( cubicle );
        em.getTransaction().commit();
    }

    void readCubicle( long id ) {
        EntityManager em = createEntityManager();
        org.livespark.bidirectional.onetoone.Cubicle cubicle = em.find( Cubicle.class, id );

        int i = 0;

    }
}
