/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.core.rewrite.sql.token.generator.optional.impl;

import org.apache.shardingsphere.core.optimize.statement.SQLStatementContext;
import org.apache.shardingsphere.core.optimize.statement.impl.SelectSQLStatementContext;
import org.apache.shardingsphere.core.rewrite.sql.token.generator.IgnoreForSingleRoute;
import org.apache.shardingsphere.core.rewrite.sql.token.generator.optional.OptionalSQLTokenGenerator;
import org.apache.shardingsphere.core.rewrite.sql.token.pojo.impl.ProjectionPrefixToken;

/**
 * Select item prefix token generator.
 *
 * @author panjuan
 */
public final class SelectItemPrefixTokenGenerator implements OptionalSQLTokenGenerator, IgnoreForSingleRoute {
    
    @Override
    public boolean isGenerateSQLToken(final SQLStatementContext sqlStatementContext) {
        return sqlStatementContext instanceof SelectSQLStatementContext && !((SelectSQLStatementContext) sqlStatementContext).getProjectionsContext().getAggregationDistinctProjections().isEmpty();
    }
    
    @Override
    public ProjectionPrefixToken generateSQLToken(final SQLStatementContext sqlStatementContext) {
        return new ProjectionPrefixToken(((SelectSQLStatementContext) sqlStatementContext).getProjectionsContext().getStartIndex());
    }
}
