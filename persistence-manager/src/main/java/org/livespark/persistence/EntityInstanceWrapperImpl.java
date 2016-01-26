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

import java.lang.reflect.Method;

public class EntityInstanceWrapperImpl implements EntityInstanceWrapper {

    EntityDef entityDef;

    Object object;

    Class<?> clazz;

    public EntityInstanceWrapperImpl( EntityDef entityDef, Object object ) {
        this.entityDef = entityDef;
        this.object = object;
        this.clazz = object.getClass();
    }

    public LiveSparkEntity getFieldValue( String fieldName ) throws Exception {
        Method method = buildGetter( fieldName );
        return (LiveSparkEntity) method.invoke( object );
    }

    public void setFieldValue( String fieldName, Object value ) throws Exception {
        Method method = buildSetter( fieldName );
        method.invoke( object, value );
    }

    protected Method buildGetter( String fieldName ) throws Exception {
        return clazz.getDeclaredMethod( "get" + fieldName );
    }

    protected Method buildSetter( String fieldName ) throws Exception {
        return clazz.getDeclaredMethod( "set" + fieldName );
    }
}
