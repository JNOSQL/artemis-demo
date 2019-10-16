/*
 * Copyright (c) 2017 Otávio Santana and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 * You may elect to redistribute this code under either of these licenses.
 *
 * Contributors:
 *
 * Otavio Santana
 */
package org.jnosql.artemis.demo.se;

import org.jnosql.artemis.arangodb.document.AQL;
import org.jnosql.artemis.arangodb.document.ArangoDBRepository;
import org.jnosql.artemis.arangodb.document.Param;

import java.util.List;

public interface HeroRepository extends ArangoDBRepository<Hero, String> {

    Stream<Hero> findByName(String name);

    @AQL("FOR hero in  Hero FILTER hero.realName == @realName return hero")
    Stream<Hero> find(@Param("realName") String realName);

}
