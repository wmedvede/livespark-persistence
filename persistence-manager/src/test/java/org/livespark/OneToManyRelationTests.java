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

package org.livespark;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.livespark.unidirectional.onetomany.Client;
import org.livespark.unidirectional.onetomany.PurchaseOrder;
import org.livespark.unidirectional.onetomany.PurchaseOrderLine;

public class OneToManyRelationTests extends org.livespark.PersistenceBaseTest {

    public static void main( String[] args ) {

        OneToManyRelationTests test = new OneToManyRelationTests();

        Client client = new Client(  );
        client.setClientNumber( "client1" );
        client.setName( "nameClient1" );
        client.setSurname( "surnameClient1" );

        Client client2 = test.createClient( "client2", "name2", "surname2" );

        //client.setId( (long) 1 );

        /*
        PurchaseOrder po = test.createPurchaseOrder( "Order1", 4, client );

//        Client client2 = test.createClient( "client2", "name2", "surname2" );

  //      po.setClient( client2 );

        Client clientkaka = new Client(  );
        clientkaka.setId( (long) 1 );
        clientkaka.setSurname( "MEDDDDDD" );

        po = new PurchaseOrder(  );
        po.setId( (long)1 );
        po.setPurchaseOrderNumber( "Modificada" );
        po.setClient( clientkaka );

        test.removePurchaseOrder( (long) 1 );

    //    po.setPurchaseOrderNumber( "Purchase order updated" );
        po = test.updatePurchaseOrder( po );

        //test.clearPurchaseOrderLines( ( long ) 1, false );

        //test.removePurchaseOrderLines( (long) 1, 2, 3 );
       //test.removePurchaseOrder( ( long ) 1 );

        //test.removeAllPurchaseOrderLines();
        */
        System.exit( 0 );

    }

    Client createClient( String clientNumber, String name, String surname ) {
        Client client = new Client(  );
        client.setClientNumber( clientNumber );
        client.setName( name );
        client.setSurname( surname );

        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        em.persist( client );
        em.getTransaction().commit();
        return client;

    }

    PurchaseOrder createPurchaseOrder( String orderNumber, int linesSize, Client client ) {

        EntityManager em = createEntityManager();

        em.getTransaction().begin();

        PurchaseOrder po = new PurchaseOrder();
        po.setPurchaseOrderNumber( orderNumber );

        List<PurchaseOrderLine> lines = new ArrayList<PurchaseOrderLine>();
        PurchaseOrderLine line;

        for ( int i = 0; i < linesSize; i++ ) {
            line = new PurchaseOrderLine();
            line.setQuantity( i );
            line.setPrice( ( double ) i );
            line.setLineInfo( orderNumber + ".line " + i );
            lines.add( line );
        }

        po.setLines( lines );

        if ( client != null ) {
            if ( client.getId() != null ) {
                client = em.find( client.getClass(), client.getId() );
            } else {

                //quitar
                em.persist( client );
            }
            //po.setClient( client );
        }

        em.persist( po );
        em.getTransaction().commit();

        return po;
    }

    PurchaseOrder updatePurchaseOrder( PurchaseOrder purchaseOrder ) {

        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        PurchaseOrder attachedPO = em.merge( purchaseOrder );
        em.getTransaction().commit();
        return attachedPO;
    }

    void clearPurchaseOrderLines( Long id, boolean hardClear ) {

        EntityManager em = createEntityManager();

        em.getTransaction().begin();
        PurchaseOrder po = em.find( PurchaseOrder.class, id  );
        if ( po != null ) {
            if ( hardClear ) {
                po.setLines( null );
            } else if ( po.getLines() != null ) {
                po.getLines().clear();
            }
            em.persist( po );
        }
        em.getTransaction().commit();
    }

    void setPurchaseOrderLines( Long id, List<PurchaseOrderLine> lines, boolean hardSet ) {
        EntityManager em = createEntityManager();

        em.getTransaction().begin();
        PurchaseOrder po = em.find( PurchaseOrder.class, id  );
        if ( po != null ) {
            if ( hardSet ) {
                po.setLines( lines );
            } else if ( po.getLines() != null ) {
                po.getLines().clear();
                po.getLines().addAll( lines );
            } else {
                po.setLines( lines );
            }
            em.persist( po );
        }
        em.getTransaction().commit();
    }

    void removePurchaseOrderLines( Long id, int... indexes ) {
        EntityManager em = createEntityManager();

        em.getTransaction().begin();
        PurchaseOrder po = em.find( PurchaseOrder.class, id  );
        if ( po != null && indexes.length > 0 && po.getLines() != null ) {

            List<PurchaseOrderLine> linesToRemove = new ArrayList<PurchaseOrderLine>();

            for ( int index : indexes ) {
                if ( index >= 0 && index < po.getLines().size() ) {
                    linesToRemove.add( po.getLines().get( index ) );
                }
            }

            for ( PurchaseOrderLine line : linesToRemove ) {
                po.getLines().remove( line );
            }

            em.persist( po );
        }
        em.getTransaction().commit();

    }

    void removePurchaseOrder( Long id ) {

        EntityManager em = createEntityManager();

        em.getTransaction().begin();

        PurchaseOrder po = em.find( PurchaseOrder.class, id );

        if ( po != null ) {
            em.remove( po );
        }
        em.getTransaction().commit();

    }


    void removePurchaseOrderLines( Long... ids) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "LivesparkPersistenceUnit" );
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        PurchaseOrder po = em.find( PurchaseOrder.class, ( long ) 6 );

        po.setLines( null );

        em.persist( po );

        em.getTransaction().commit();
        int i = 0;

    }

    void removeAllPurchaseOrders() {

        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery( "delete from livespark.PurchaseOrder" );
        query.executeUpdate();
        em.getTransaction().commit();
    }

    void removeAllPurchaseOrderLines() {

        EntityManager em = createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery( "delete from livespark.PurchaseOrderLine" );
        query.executeUpdate();
        em.getTransaction().commit();
    }


}
