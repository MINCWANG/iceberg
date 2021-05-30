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

package org.apache.iceberg.flink;


import org.apache.flink.configuration.ConfigOption;
import org.apache.flink.configuration.ConfigOptions;

public class FlinkConfigOptions {

  private FlinkConfigOptions() {
  }

  public static final ConfigOption<Boolean> TABLE_EXEC_ICEBERG_INFER_SOURCE_PARALLELISM =
      ConfigOptions.key("table.exec.iceberg.infer-source-parallelism")
          .booleanType()
          .defaultValue(true)
          .withDescription("If is false, parallelism of source are set by config.\n" +
              "If is true, source parallelism is inferred according to splits number.\n");

  public static final ConfigOption<Integer> TABLE_EXEC_ICEBERG_INFER_SOURCE_PARALLELISM_MAX =
      ConfigOptions.key("table.exec.iceberg.infer-source-parallelism.max")
          .intType()
          .defaultValue(100)
          .withDescription("Sets max infer parallelism for source operator.");

  public static final ConfigOption<Boolean> TABLE_WRITE_ICEBERG_V2_FORMAT_ENABLE =
          ConfigOptions.key("table.write.iceberg.v2.format.enable")
                  .booleanType()
                  .defaultValue(false)
                  .withDescription("If is true, iceberg write will support cdc mode.");

  public static final ConfigOption<Boolean> TABLE_WRITE_ICEBERG_UPSERT_ENABLE =
          ConfigOptions.key("table.write.iceberg.upsert.enable")
                  .booleanType()
                  .defaultValue(false)
                  .withDescription("If is true, iceberg write mode will is upsert." +
                          "The Transform all INSERT/UPDATE_AFTER to be UPSERT, which means DELETE + INSERT the key.");
}
