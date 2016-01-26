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

package org.livespark.persistence;

import javax.persistence.EntityManager;

public class PersistenceManager {

    protected String persistenceUnit;

    protected EntityManagerFactory entityManagerFactory;

    protected EntityDefManager entityDefManager;

    public PersistenceManager( String persistenceUnit ) {
        this.persistenceUnit = persistenceUnit;
        entityManagerFactory = new EntityManagerFactory( "LivesparkPersistenceUnit" );
    }

    public void persist( Object entity ) {

  /*
        Stack<EntityCommand> commands = new Stack<EntityCommand>();

        EntityManager em = createEntityManager( true );
        EntityDef entityDef = entityDefManager.getEntityDef( entity.getClass() );

        EntityInstanceWrapper instanceWrapper = new EntityInstanceWrapperImpl( entityDef, entity );
        Set<String> relationFields = entityDef.getRelationFields();

        for ( String fieldName : relationFields ) {

            FieldDef fieldDef = entityDef.getFieldDef( fieldName );
            if ( !fieldDef.isMultiple() ) {
                LiveSparkEntity value = instanceWrapper.getFieldValue( fieldDef.getName() );
                if ( value.getId() != null && em.contains( value ) ) {
                    //we have an association to a persistent value but is currently not
                    //attached to the context
                    commands.push( new MergeEntityCommand( ) )
                }
            }
        }

        em.persist( entity );
        em.getTransaction().commit();
        */
    }

    public Object merge( Object entity ) {
        EntityManager em = createEntityManager( true );
        return em.merge( entity );
    }

    protected EntityManager createEntityManager( boolean beginTransaction ) {
        return entityManagerFactory.createEntityManager( beginTransaction );
    }



}
