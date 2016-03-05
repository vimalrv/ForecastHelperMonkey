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
package org.apache.olingo.client.core.uri;

import org.apache.commons.lang3.StringUtils;
import org.apache.olingo.client.api.uri.FilterArg;

public class FilterFunction implements FilterArg {

  private final String function;

  private final FilterArg[] params;

  public FilterFunction(final String function, final FilterArg... params) {
    this.function = function;
    this.params = params;
  }

  @Override
  public String build() {
    final String[] strParams = params == null || params.length == 0 ? new String[0] : new String[params.length];
    for (int i = 0; i < strParams.length; i++) {
      strParams[i] = params[i].build();
    }

    return new StringBuilder(function).
            append('(').
            append(strParams.length == 0 ? StringUtils.EMPTY : StringUtils.join(strParams, ',')).
            append(')').
            toString();
  }
}
