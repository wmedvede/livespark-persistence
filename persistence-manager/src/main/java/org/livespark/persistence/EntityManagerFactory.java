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
import javax.persistence.Persistence;

public class EntityManagerFactory {

    public String persistenceUnit;

    public EntityManagerFactory( String persistenceUnit ) {
        this.persistenceUnit = persistenceUnit;
    }

    public EntityManager createEntityManager() {
        return createEntityManager( false );
    }

    public EntityManager createEntityManager( boolean beginTransaction ) {
        javax.persistence.EntityManagerFactory emf = Persistence.createEntityManagerFactory( persistenceUnit );
        EntityManager em = emf.createEntityManager();
        if ( beginTransaction ) {
            em.getTransaction().begin();
        }
        return em;
    }
}

