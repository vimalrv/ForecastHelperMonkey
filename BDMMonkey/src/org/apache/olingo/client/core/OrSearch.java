/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.olingo.client.core;

import org.apache.olingo.client.api.uri.URISearch;

public class OrSearch implements URISearch {

  private final URISearch left;

  private final URISearch right;

  OrSearch(final URISearch left, final URISearch right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public String build() {
    return new StringBuilder().
            append('(').append(left.build()).
            append(" OR ").
            append(right.build()).append(')').
            toString();
  }
}
