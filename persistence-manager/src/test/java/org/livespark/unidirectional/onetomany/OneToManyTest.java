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

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.livespark.PersistenceBaseTest;


public class OneToManyTest extends PersistenceBaseTest {

    /**
     * Creates a new PO from scratch, all elements in the objects graph will be also
     * created from scratch.
     */
    //@Test
    public void createUsingPersistAllNewInstancesTest1() {

        PurchaseOrder po = new PurchaseOrder(  );
        po.setPurchaseOrderNumber( "po number 1" );

        PurchaseOrderHeader header = new PurchaseOrderHeader(  );
        header.setName( "header 1" );

        Client client = new Client(  );
        client.setName( "client 1" );

        po.setHeader( header );
        header.setClient( client );

        List<PurchaseOrderLine> pols = new ArrayList<PurchaseOrderLine>(  );
        PurchaseOrderLine pol = new PurchaseOrderLine(  );
        pol.setLineInfo( "line1.1" );
        pols.add( pol );

        pol = new PurchaseOrderLine(  );
        pol.setLineInfo( "line1.2" );
        pols.add( pol );

        po.setLines( pols );

        em = createEntityManager( true );
        em.persist( po );
        em.getTransaction().commit();

    }

    //@Test
    public void createUsingMergeAllNewInstancesTest1_1() {

        PurchaseOrder po = new PurchaseOrder(  );
        po.setPurchaseOrderNumber( "po number 1" );

        PurchaseOrderHeader header = new PurchaseOrderHeader(  );
        header.setName( "header 1" );

        Client client = new Client(  );
        client.setName( "client 1" );

        po.setHeader( header );
        header.setClient( client );

        List<PurchaseOrderLine> pols = new ArrayList<PurchaseOrderLine>(  );
        PurchaseOrderLine pol = new PurchaseOrderLine(  );
        pol.setLineInfo( "line1.1" );
        pols.add( pol );

        pol = new PurchaseOrderLine(  );
        pol.setLineInfo( "line1.2" );
        pols.add( pol );

        po.setLines( pols );

        em = createEntityManager( true );
        em.merge( po );
        em.getTransaction().commit();

    }

    /**
     * Creates a new PO reusing an already existing Client, and modifying this
     * Client. It means that in the objects graph we do some changes in the client.
     */
    @Test
    public void createReusingClientTest2() {
        PurchaseOrder po = new PurchaseOrder();
        po.setPurchaseOrderNumber( "po number 2" );

        PurchaseOrderHeader header = new PurchaseOrderHeader();
        header.setName( "header 2" );

        Client client = new Client();
        client.setName( "client 1 modified" );
        client.setId( (long)1 );

        po.setHeader( header );
        header.setClient( client );

        List<PurchaseOrderLine> pols = new ArrayList<PurchaseOrderLine>();
        PurchaseOrderLine pol = new PurchaseOrderLine();
        pol.setLineInfo( "line2.1" );
        pols.add( pol );

        pol = new PurchaseOrderLine();
        pol.setLineInfo( "line2.2" );
        pols.add( pol );

        po.setLines( pols );

        em = createEntityManager( true );
        em.merge( po );
        em.getTransaction().commit();
    }

    /**
     * Creates a new PO reusing an already existing Client, but we leave exactly the same
     * values for the Client. (emulating for example that the client was selected from a selector)
     */
    //@Test
    public void createReusingClientTest3() {
        PurchaseOrder po = new PurchaseOrder();
        po.setPurchaseOrderNumber( "po number 3" );

        PurchaseOrderHeader header = new PurchaseOrderHeader();
        header.setName( "header 3" );

        Client client = new Client();
        client.setName( "client 1" );
        client.setId( (long)1 );

        po.setHeader( header );
        header.setClient( client );

        List<PurchaseOrderLine> pols = new ArrayList<PurchaseOrderLine>();
        PurchaseOrderLine pol = new PurchaseOrderLine();
        pol.setLineInfo( "line3.1" );
        pols.add( pol );

        pol = new PurchaseOrderLine();
        pol.setLineInfo( "line3.2" );
        pols.add( pol );

        po.setLines( pols );

        em = createEntityManager( true );
        em.merge( po );
        em.getTransaction().commit();
    }

    //@Test
    public void createReusingClientTest4() {
        PurchaseOrder po = new PurchaseOrder();
        po.setPurchaseOrderNumber( "po number 3" );

        PurchaseOrderHeader header = new PurchaseOrderHeader();
        header.setName( "header 1 cambiado efecto colateral" );
        header.setId( (long) 1  );
        //header.setVersion( 3 );

        Client client = new Client();
        client.setName( "client 1" );
        client.setId( ( long ) 1 );
        //client.setVersion( 1 );

        po.setHeader( header );
        header.setClient( client );

        List<PurchaseOrderLine> pols = new ArrayList<PurchaseOrderLine>();
        PurchaseOrderLine pol = new PurchaseOrderLine();
        pol.setLineInfo( "line3.1" );
        pols.add( pol );

        pol = new PurchaseOrderLine();
        pol.setLineInfo( "line3.2" );
        pols.add( pol );

        po.setLines( pols );

        em = createEntityManager( true );
        em.merge( po );
        em.getTransaction().commit();
    }

    //@Test
    public void createUsingMergeWithAllInstancesNew() {
        PurchaseOrder po = new PurchaseOrder();
        po.setPurchaseOrderNumber( "po number 100" );

        PurchaseOrderHeader header = new PurchaseOrderHeader();
        header.setName( "header 100" );

        Client client = new Client();
        client.setName( "client 100" );
        client.setId( ( long ) 34 );

        po.setHeader( header );
        header.setClient( client );

        List<PurchaseOrderLine> pols = new ArrayList<PurchaseOrderLine>();
        PurchaseOrderLine pol = new PurchaseOrderLine();
        pol.setLineInfo( "line100.1" );
        pols.add( pol );

        pol = new PurchaseOrderLine();
        pol.setLineInfo( "line100.2" );
        pols.add( pol );

        po.setLines( pols );

        em = createEntityManager( true );
        em.merge( po );
        em.getTransaction().commit();
    }

    //@Test
    public void readPurchaseOrderUpdateLinesAndSave() {

        em = createEntityManager();

        PurchaseOrder po = em.find( PurchaseOrder.class, new Long( "1" ) );

        em.detach( po );
        em.close();

        po.getLines().remove( 1 );

        PurchaseOrderLine pol = new PurchaseOrderLine();
        pol.setLineInfo( "Line added 2" );
        po.getLines().add( pol );

        pol = new PurchaseOrderLine();
        pol.setLineInfo( "Line added 3" );
        po.getLines().add( pol );

        em = createEntityManager( true );
        em.merge( po );
        em.getTransaction().commit();
        em.close();

    }

    //@Test
    public void readPurchaseOrderSetHeaderEmptyAndSave() {


        em = createEntityManager();

        PurchaseOrder po = em.find( PurchaseOrder.class, new Long( "1" ) );

        em.detach( po );
        em.close();

        po.setHeader( null );

        em = createEntityManager( true );
        em.merge( po );
        em.getTransaction().commit();
        em.close();

    }

    //@Test
    public void deletePurchaseOrderTest() {

        em = createEntityManager( true );

        PurchaseOrder po = em.find( PurchaseOrder.class, new Long( "1" ) );

        em.remove( po );

        em.getTransaction().commit();
        em.close();

    }


    //@Test
    public void createUsingMergeReusingWithAllInstancesNew() {
        PurchaseOrder po = new PurchaseOrder();

        po.setPurchaseOrderNumber( "po number 1" );
        po.setId( (long)1 );

        PurchaseOrderHeader header = new PurchaseOrderHeader();
        header.setName( "header 101111111111111111110" );
        header.setId( (long) 1 );

        Client client = new Client();
        client.setName( "client 11111111111111" );
        client.setId( (long)1 );

        po.setHeader( header );
        header.setClient( client );

        List<PurchaseOrderLine> pols = new ArrayList<PurchaseOrderLine>();
        PurchaseOrderLine pol = new PurchaseOrderLine();
        pol.setLineInfo( "lineOOOOOOO100.1.new" );
        pols.add( pol );

        pol = new PurchaseOrderLine();
        pol.setLineInfo( "line00000000100.2" );
        pols.add( pol );

        po.setLines( pols );

        em = createEntityManager( true );
        em.merge( po );
        em.getTransaction().commit();
    }


    @Ignore
    public void case1Test() {

        PurchaseOrder po = new PurchaseOrder(  );
        PurchaseOrderHeader header = new PurchaseOrderHeader(  );
        header.setId( ( long ) 1 );
        header.setName( "Header13333" );

        po.setPurchaseOrderNumber( "NUMERO1" );

        //po.setHeader( header );

        em = createEntityManager( true );
        //header = em.merge( header );
        //po.setHeader( header );
        //em.persist( header );
        em.persist( po );

        po.setPurchaseOrderNumber( "BLABLA" );
        em.persist( po );
        em.getTransaction().commit();

    }

}
